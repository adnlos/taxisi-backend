package taxisi.backend



import org.junit.*
import grails.test.mixin.*

@TestFor(ReporteEvaluacionController)
@Mock(ReporteEvaluacion)
class ReporteEvaluacionControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/reporteEvaluacion/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.reporteEvaluacionInstanceList.size() == 0
        assert model.reporteEvaluacionInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.reporteEvaluacionInstance != null
    }

    void testSave() {
        controller.save()

        assert model.reporteEvaluacionInstance != null
        assert view == '/reporteEvaluacion/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/reporteEvaluacion/show/1'
        assert controller.flash.message != null
        assert ReporteEvaluacion.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/reporteEvaluacion/list'

        populateValidParams(params)
        def reporteEvaluacion = new ReporteEvaluacion(params)

        assert reporteEvaluacion.save() != null

        params.id = reporteEvaluacion.id

        def model = controller.show()

        assert model.reporteEvaluacionInstance == reporteEvaluacion
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/reporteEvaluacion/list'

        populateValidParams(params)
        def reporteEvaluacion = new ReporteEvaluacion(params)

        assert reporteEvaluacion.save() != null

        params.id = reporteEvaluacion.id

        def model = controller.edit()

        assert model.reporteEvaluacionInstance == reporteEvaluacion
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/reporteEvaluacion/list'

        response.reset()

        populateValidParams(params)
        def reporteEvaluacion = new ReporteEvaluacion(params)

        assert reporteEvaluacion.save() != null

        // test invalid parameters in update
        params.id = reporteEvaluacion.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/reporteEvaluacion/edit"
        assert model.reporteEvaluacionInstance != null

        reporteEvaluacion.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/reporteEvaluacion/show/$reporteEvaluacion.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        reporteEvaluacion.clearErrors()

        populateValidParams(params)
        params.id = reporteEvaluacion.id
        params.version = -1
        controller.update()

        assert view == "/reporteEvaluacion/edit"
        assert model.reporteEvaluacionInstance != null
        assert model.reporteEvaluacionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/reporteEvaluacion/list'

        response.reset()

        populateValidParams(params)
        def reporteEvaluacion = new ReporteEvaluacion(params)

        assert reporteEvaluacion.save() != null
        assert ReporteEvaluacion.count() == 1

        params.id = reporteEvaluacion.id

        controller.delete()

        assert ReporteEvaluacion.count() == 0
        assert ReporteEvaluacion.get(reporteEvaluacion.id) == null
        assert response.redirectedUrl == '/reporteEvaluacion/list'
    }
}
