package taxisi.backend

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class SitioTaxiController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [sitioTaxiInstanceList: SitioTaxi.list(params), sitioTaxiInstanceTotal: SitioTaxi.count()]
    }

    def create() {
        [sitioTaxiInstance: new SitioTaxi(params)]
    }

    def save() {
        def sitioTaxiInstance = new SitioTaxi(params)
        if (!sitioTaxiInstance.save(flush: true)) {
            render(view: "create", model: [sitioTaxiInstance: sitioTaxiInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'sitioTaxi.label', default: 'SitioTaxi'), sitioTaxiInstance.id])
        redirect(action: "show", id: sitioTaxiInstance.id)
    }

    def show(Long id) {
        def sitioTaxiInstance = SitioTaxi.get(id)
        if (!sitioTaxiInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sitioTaxi.label', default: 'SitioTaxi'), id])
            redirect(action: "list")
            return
        }

        [sitioTaxiInstance: sitioTaxiInstance]
    }

    def edit(Long id) {
        def sitioTaxiInstance = SitioTaxi.get(id)
        if (!sitioTaxiInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sitioTaxi.label', default: 'SitioTaxi'), id])
            redirect(action: "list")
            return
        }

        [sitioTaxiInstance: sitioTaxiInstance]
    }

    def update(Long id, Long version) {
        def sitioTaxiInstance = SitioTaxi.get(id)
        if (!sitioTaxiInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sitioTaxi.label', default: 'SitioTaxi'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (sitioTaxiInstance.version > version) {
                sitioTaxiInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'sitioTaxi.label', default: 'SitioTaxi')] as Object[],
                          "Another user has updated this SitioTaxi while you were editing")
                render(view: "edit", model: [sitioTaxiInstance: sitioTaxiInstance])
                return
            }
        }

        sitioTaxiInstance.properties = params

        if (!sitioTaxiInstance.save(flush: true)) {
            render(view: "edit", model: [sitioTaxiInstance: sitioTaxiInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'sitioTaxi.label', default: 'SitioTaxi'), sitioTaxiInstance.id])
        redirect(action: "show", id: sitioTaxiInstance.id)
    }

    def delete(Long id) {
        def sitioTaxiInstance = SitioTaxi.get(id)
        if (!sitioTaxiInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sitioTaxi.label', default: 'SitioTaxi'), id])
            redirect(action: "list")
            return
        }

        try {
            sitioTaxiInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'sitioTaxi.label', default: 'SitioTaxi'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'sitioTaxi.label', default: 'SitioTaxi'), id])
            redirect(action: "show", id: id)
        }
    }

    private retrieveRecord() {
        def result = [ success: true ]
        def status = 200

        def obj = SitioTaxi.findAll()

        result.data = obj
        result.message = null
        [ result: result, status: status ]
    }

    def ubicacion = {
        def data = retrieveRecord()
        render text: data.result as JSON, contentType: 'application/json', status: data.status
    }
}
