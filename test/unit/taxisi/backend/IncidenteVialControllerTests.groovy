package taxisi.backend



import org.junit.*
import grails.test.mixin.*

@TestFor(IncidenteVialController)
@Mock(IncidenteVial)
class IncidenteVialControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/incidenteVial/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.incidenteVialInstanceList.size() == 0
        assert model.incidenteVialInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.incidenteVialInstance != null
    }

    void testSave() {
        controller.save()

        assert model.incidenteVialInstance != null
        assert view == '/incidenteVial/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/incidenteVial/show/1'
        assert controller.flash.message != null
        assert IncidenteVial.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/incidenteVial/list'

        populateValidParams(params)
        def incidenteVial = new IncidenteVial(params)

        assert incidenteVial.save() != null

        params.id = incidenteVial.id

        def model = controller.show()

        assert model.incidenteVialInstance == incidenteVial
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/incidenteVial/list'

        populateValidParams(params)
        def incidenteVial = new IncidenteVial(params)

        assert incidenteVial.save() != null

        params.id = incidenteVial.id

        def model = controller.edit()

        assert model.incidenteVialInstance == incidenteVial
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/incidenteVial/list'

        response.reset()

        populateValidParams(params)
        def incidenteVial = new IncidenteVial(params)

        assert incidenteVial.save() != null

        // test invalid parameters in update
        params.id = incidenteVial.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/incidenteVial/edit"
        assert model.incidenteVialInstance != null

        incidenteVial.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/incidenteVial/show/$incidenteVial.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        incidenteVial.clearErrors()

        populateValidParams(params)
        params.id = incidenteVial.id
        params.version = -1
        controller.update()

        assert view == "/incidenteVial/edit"
        assert model.incidenteVialInstance != null
        assert model.incidenteVialInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/incidenteVial/list'

        response.reset()

        populateValidParams(params)
        def incidenteVial = new IncidenteVial(params)

        assert incidenteVial.save() != null
        assert IncidenteVial.count() == 1

        params.id = incidenteVial.id

        controller.delete()

        assert IncidenteVial.count() == 0
        assert IncidenteVial.get(incidenteVial.id) == null
        assert response.redirectedUrl == '/incidenteVial/list'
    }
}
