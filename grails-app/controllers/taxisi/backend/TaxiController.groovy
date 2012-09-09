package taxisi.backend

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class TaxiController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [taxiInstanceList: Taxi.list(params), taxiInstanceTotal: Taxi.count()]
    }

    def create() {
        [taxiInstance: new Taxi(params)]
    }

    def save() {
        def taxiInstance = new Taxi(params)
        if (!taxiInstance.save(flush: true)) {
            render(view: "create", model: [taxiInstance: taxiInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'taxi.label', default: 'Taxi'), taxiInstance.id])
        redirect(action: "show", id: taxiInstance.id)
    }

    def show(Long id) {
        def taxiInstance = Taxi.get(id)
        if (!taxiInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'taxi.label', default: 'Taxi'), id])
            redirect(action: "list")
            return
        }

        [taxiInstance: taxiInstance]
    }

    def edit(Long id) {
        def taxiInstance = Taxi.get(id)
        if (!taxiInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'taxi.label', default: 'Taxi'), id])
            redirect(action: "list")
            return
        }

        [taxiInstance: taxiInstance]
    }

    def update(Long id, Long version) {
        def taxiInstance = Taxi.get(id)
        if (!taxiInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'taxi.label', default: 'Taxi'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (taxiInstance.version > version) {
                taxiInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'taxi.label', default: 'Taxi')] as Object[],
                          "Another user has updated this Taxi while you were editing")
                render(view: "edit", model: [taxiInstance: taxiInstance])
                return
            }
        }

        taxiInstance.properties = params

        if (!taxiInstance.save(flush: true)) {
            render(view: "edit", model: [taxiInstance: taxiInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'taxi.label', default: 'Taxi'), taxiInstance.id])
        redirect(action: "show", id: taxiInstance.id)
    }

    def delete(Long id) {
        def taxiInstance = Taxi.get(id)
        if (!taxiInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'taxi.label', default: 'Taxi'), id])
            redirect(action: "list")
            return
        }

        try {
            taxiInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'taxi.label', default: 'Taxi'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'taxi.label', default: 'Taxi'), id])
            redirect(action: "show", id: id)
        }
    }

    private retrieveRecord() {
        def result = [ success: true ]
        def status = 200

        def obj = Taxi.findAll()

        result.data = obj
        result.message = null
        [ result: result, status: status ]
    }

    def ubicacion = {
        def data = retrieveRecord()
        render text: data.result as JSON, contentType: 'application/json', status: data.status
    }
}
