package taxisi.backend

import org.springframework.dao.DataIntegrityViolationException

class ReporteEvaluacionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [reporteEvaluacionInstanceList: ReporteEvaluacion.list(params), reporteEvaluacionInstanceTotal: ReporteEvaluacion.count()]
    }

    def create() {
        [reporteEvaluacionInstance: new ReporteEvaluacion(params)]
    }

    def save() {
        def reporteEvaluacionInstance = new ReporteEvaluacion(params)
        if (!reporteEvaluacionInstance.save(flush: true)) {
            render(view: "create", model: [reporteEvaluacionInstance: reporteEvaluacionInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'reporteEvaluacion.label', default: 'ReporteEvaluacion'), reporteEvaluacionInstance.id])
        redirect(action: "show", id: reporteEvaluacionInstance.id)
    }

    def show(Long id) {
        def reporteEvaluacionInstance = ReporteEvaluacion.get(id)
        if (!reporteEvaluacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reporteEvaluacion.label', default: 'ReporteEvaluacion'), id])
            redirect(action: "list")
            return
        }

        [reporteEvaluacionInstance: reporteEvaluacionInstance]
    }

    def edit(Long id) {
        def reporteEvaluacionInstance = ReporteEvaluacion.get(id)
        if (!reporteEvaluacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reporteEvaluacion.label', default: 'ReporteEvaluacion'), id])
            redirect(action: "list")
            return
        }

        [reporteEvaluacionInstance: reporteEvaluacionInstance]
    }

    def update(Long id, Long version) {
        def reporteEvaluacionInstance = ReporteEvaluacion.get(id)
        if (!reporteEvaluacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reporteEvaluacion.label', default: 'ReporteEvaluacion'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (reporteEvaluacionInstance.version > version) {
                reporteEvaluacionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'reporteEvaluacion.label', default: 'ReporteEvaluacion')] as Object[],
                          "Another user has updated this ReporteEvaluacion while you were editing")
                render(view: "edit", model: [reporteEvaluacionInstance: reporteEvaluacionInstance])
                return
            }
        }

        reporteEvaluacionInstance.properties = params

        if (!reporteEvaluacionInstance.save(flush: true)) {
            render(view: "edit", model: [reporteEvaluacionInstance: reporteEvaluacionInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'reporteEvaluacion.label', default: 'ReporteEvaluacion'), reporteEvaluacionInstance.id])
        redirect(action: "show", id: reporteEvaluacionInstance.id)
    }

    def delete(Long id) {
        def reporteEvaluacionInstance = ReporteEvaluacion.get(id)
        if (!reporteEvaluacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reporteEvaluacion.label', default: 'ReporteEvaluacion'), id])
            redirect(action: "list")
            return
        }

        try {
            reporteEvaluacionInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'reporteEvaluacion.label', default: 'ReporteEvaluacion'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'reporteEvaluacion.label', default: 'ReporteEvaluacion'), id])
            redirect(action: "show", id: id)
        }
    }
}
