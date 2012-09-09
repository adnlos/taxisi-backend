package taxisi.backend

import org.springframework.dao.DataIntegrityViolationException
import kml.KmlParser
import kml.Point
import grails.converters.JSON

class ObrasController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [obrasInstanceList: Obras.list(params), obrasInstanceTotal: Obras.count()]
    }

    def create() {
        [obrasInstance: new Obras(params)]
    }

    def save() {
        def obrasInstance = new Obras(params)
        if (!obrasInstance.save(flush: true)) {
            render(view: "create", model: [obrasInstance: obrasInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'obras.label', default: 'Obras'), obrasInstance.id])
        redirect(action: "show", id: obrasInstance.id)
    }

    def show(Long id) {
        def obrasInstance = Obras.get(id)
        if (!obrasInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'obras.label', default: 'Obras'), id])
            redirect(action: "list")
            return
        }

        [obrasInstance: obrasInstance]
    }

    def edit(Long id) {
        def obrasInstance = Obras.get(id)
        if (!obrasInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'obras.label', default: 'Obras'), id])
            redirect(action: "list")
            return
        }

        [obrasInstance: obrasInstance]
    }

    def update(Long id, Long version) {
        def obrasInstance = Obras.get(id)
        if (!obrasInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'obras.label', default: 'Obras'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (obrasInstance.version > version) {
                obrasInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'obras.label', default: 'Obras')] as Object[],
                          "Another user has updated this Obras while you were editing")
                render(view: "edit", model: [obrasInstance: obrasInstance])
                return
            }
        }

        obrasInstance.properties = params

        if (!obrasInstance.save(flush: true)) {
            render(view: "edit", model: [obrasInstance: obrasInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'obras.label', default: 'Obras'), obrasInstance.id])
        redirect(action: "show", id: obrasInstance.id)
    }

    def delete(Long id) {
        def obrasInstance = Obras.get(id)
        if (!obrasInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'obras.label', default: 'Obras'), id])
            redirect(action: "list")
            return
        }

        try {
            obrasInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'obras.label', default: 'Obras'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'obras.label', default: 'Obras'), id])
            redirect(action: "show", id: id)
        }
    }

    def load(){
        def file = '/Users/israel/Downloads/ALESTRA-LCE.kml'
        //def file = '/Users/israel/Downloads/CABLEVISION-LCE.kml'

        KmlParser parser = new KmlParser()
        def points = parser.parse(file)

        points.each {point ->

            render point.toString()+"<br>"
        }
    }

    private retrieveRecord() {
        def result = [ success: true ]
        def status = 200

        def obj = Obras.findAll()

        result.data = obj
        result.message = null
        [ result: result, status: status ]
    }

    def ubicacion = {
        def data = retrieveRecord()
        render text: data.result as JSON, contentType: 'application/json', status: data.status
    }
}
