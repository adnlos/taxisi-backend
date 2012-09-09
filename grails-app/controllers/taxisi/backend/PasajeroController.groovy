package taxisi.backend

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class PasajeroController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [pasajeroInstanceList: Pasajero.list(params), pasajeroInstanceTotal: Pasajero.count()]
    }

    def create() {
        [pasajeroInstance: new Pasajero(params)]
    }

    def save() {
        def pasajeroInstance = new Pasajero(params)
        if (!pasajeroInstance.save(flush: true)) {
            render(view: "create", model: [pasajeroInstance: pasajeroInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'pasajero.label', default: 'Pasajero'), pasajeroInstance.id])
        redirect(action: "show", id: pasajeroInstance.id)
    }

    def show(Long id) {
        def pasajeroInstance = Pasajero.get(id)
        if (!pasajeroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pasajero.label', default: 'Pasajero'), id])
            redirect(action: "list")
            return
        }

        [pasajeroInstance: pasajeroInstance]
    }

    def edit(Long id) {
        def pasajeroInstance = Pasajero.get(id)
        if (!pasajeroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pasajero.label', default: 'Pasajero'), id])
            redirect(action: "list")
            return
        }

        [pasajeroInstance: pasajeroInstance]
    }

    def update(Long id, Long version) {
        def pasajeroInstance = Pasajero.get(id)
        if (!pasajeroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pasajero.label', default: 'Pasajero'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (pasajeroInstance.version > version) {
                pasajeroInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'pasajero.label', default: 'Pasajero')] as Object[],
                          "Another user has updated this Pasajero while you were editing")
                render(view: "edit", model: [pasajeroInstance: pasajeroInstance])
                return
            }
        }

        pasajeroInstance.properties = params

        if (!pasajeroInstance.save(flush: true)) {
            render(view: "edit", model: [pasajeroInstance: pasajeroInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'pasajero.label', default: 'Pasajero'), pasajeroInstance.id])
        redirect(action: "show", id: pasajeroInstance.id)
    }

    def delete(Long id) {
        def pasajeroInstance = Pasajero.get(id)
        if (!pasajeroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pasajero.label', default: 'Pasajero'), id])
            redirect(action: "list")
            return
        }

        try {
            pasajeroInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'pasajero.label', default: 'Pasajero'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'pasajero.label', default: 'Pasajero'), id])
            redirect(action: "show", id: id)
        }
    }

    private retrieveRecord() {
        def result = [ success: true ]
        def status = 200

        def obj = Pasajero.findAll()

        result.data = obj
        result.message = null
        [ result: result, status: status ]
    }

    def ubicacion = {
        def data = retrieveRecord()
        render text: data.result as JSON, contentType: 'application/json', status: data.status
    }

    def compartir = {
        def data = retrieveRecord()
        render text: data.result as JSON, contentType: 'application/json', status: data.status
    }
}
