package taxisi.backend

import org.springframework.dao.DataIntegrityViolationException

class IncidenteVialController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [incidenteVialInstanceList: IncidenteVial.list(params), incidenteVialInstanceTotal: IncidenteVial.count()]
    }

    def create() {
        [incidenteVialInstance: new IncidenteVial(params)]
    }

    def save() {
        def incidenteVialInstance = new IncidenteVial(params)
        if (!incidenteVialInstance.save(flush: true)) {
            render(view: "create", model: [incidenteVialInstance: incidenteVialInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'incidenteVial.label', default: 'IncidenteVial'), incidenteVialInstance.id])
        redirect(action: "show", id: incidenteVialInstance.id)
    }

    def show(Long id) {
        def incidenteVialInstance = IncidenteVial.get(id)
        if (!incidenteVialInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'incidenteVial.label', default: 'IncidenteVial'), id])
            redirect(action: "list")
            return
        }

        [incidenteVialInstance: incidenteVialInstance]
    }

    def edit(Long id) {
        def incidenteVialInstance = IncidenteVial.get(id)
        if (!incidenteVialInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'incidenteVial.label', default: 'IncidenteVial'), id])
            redirect(action: "list")
            return
        }

        [incidenteVialInstance: incidenteVialInstance]
    }

    def update(Long id, Long version) {
        def incidenteVialInstance = IncidenteVial.get(id)
        if (!incidenteVialInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'incidenteVial.label', default: 'IncidenteVial'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (incidenteVialInstance.version > version) {
                incidenteVialInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'incidenteVial.label', default: 'IncidenteVial')] as Object[],
                          "Another user has updated this IncidenteVial while you were editing")
                render(view: "edit", model: [incidenteVialInstance: incidenteVialInstance])
                return
            }
        }

        incidenteVialInstance.properties = params

        if (!incidenteVialInstance.save(flush: true)) {
            render(view: "edit", model: [incidenteVialInstance: incidenteVialInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'incidenteVial.label', default: 'IncidenteVial'), incidenteVialInstance.id])
        redirect(action: "show", id: incidenteVialInstance.id)
    }

    def delete(Long id) {
        def incidenteVialInstance = IncidenteVial.get(id)
        if (!incidenteVialInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'incidenteVial.label', default: 'IncidenteVial'), id])
            redirect(action: "list")
            return
        }

        try {
            incidenteVialInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'incidenteVial.label', default: 'IncidenteVial'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'incidenteVial.label', default: 'IncidenteVial'), id])
            redirect(action: "show", id: id)
        }
    }
}
