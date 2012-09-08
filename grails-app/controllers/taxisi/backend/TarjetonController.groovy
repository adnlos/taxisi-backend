package taxisi.backend

import org.springframework.dao.DataIntegrityViolationException

class TarjetonController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [tarjetonInstanceList: Tarjeton.list(params), tarjetonInstanceTotal: Tarjeton.count()]
    }

    def create() {
        [tarjetonInstance: new Tarjeton(params)]
    }

    def save() {
        def tarjetonInstance = new Tarjeton(params)
        if (!tarjetonInstance.save(flush: true)) {
            render(view: "create", model: [tarjetonInstance: tarjetonInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'tarjeton.label', default: 'Tarjeton'), tarjetonInstance.id])
        redirect(action: "show", id: tarjetonInstance.id)
    }

    def show(Long id) {
        def tarjetonInstance = Tarjeton.get(id)
        if (!tarjetonInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tarjeton.label', default: 'Tarjeton'), id])
            redirect(action: "list")
            return
        }

        [tarjetonInstance: tarjetonInstance]
    }

    def edit(Long id) {
        def tarjetonInstance = Tarjeton.get(id)
        if (!tarjetonInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tarjeton.label', default: 'Tarjeton'), id])
            redirect(action: "list")
            return
        }

        [tarjetonInstance: tarjetonInstance]
    }

    def update(Long id, Long version) {
        def tarjetonInstance = Tarjeton.get(id)
        if (!tarjetonInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tarjeton.label', default: 'Tarjeton'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (tarjetonInstance.version > version) {
                tarjetonInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'tarjeton.label', default: 'Tarjeton')] as Object[],
                          "Another user has updated this Tarjeton while you were editing")
                render(view: "edit", model: [tarjetonInstance: tarjetonInstance])
                return
            }
        }

        tarjetonInstance.properties = params

        if (!tarjetonInstance.save(flush: true)) {
            render(view: "edit", model: [tarjetonInstance: tarjetonInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'tarjeton.label', default: 'Tarjeton'), tarjetonInstance.id])
        redirect(action: "show", id: tarjetonInstance.id)
    }

    def delete(Long id) {
        def tarjetonInstance = Tarjeton.get(id)
        if (!tarjetonInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tarjeton.label', default: 'Tarjeton'), id])
            redirect(action: "list")
            return
        }

        try {
            tarjetonInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'tarjeton.label', default: 'Tarjeton'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'tarjeton.label', default: 'Tarjeton'), id])
            redirect(action: "show", id: id)
        }
    }
}
