package taxisi.backend



import org.junit.*
import grails.test.mixin.*

@TestFor(PasajeroController)
@Mock(Pasajero)
class PasajeroControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/pasajero/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.pasajeroInstanceList.size() == 0
        assert model.pasajeroInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.pasajeroInstance != null
    }

    void testSave() {
        controller.save()

        assert model.pasajeroInstance != null
        assert view == '/pasajero/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/pasajero/show/1'
        assert controller.flash.message != null
        assert Pasajero.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/pasajero/list'

        populateValidParams(params)
        def pasajero = new Pasajero(params)

        assert pasajero.save() != null

        params.id = pasajero.id

        def model = controller.show()

        assert model.pasajeroInstance == pasajero
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/pasajero/list'

        populateValidParams(params)
        def pasajero = new Pasajero(params)

        assert pasajero.save() != null

        params.id = pasajero.id

        def model = controller.edit()

        assert model.pasajeroInstance == pasajero
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/pasajero/list'

        response.reset()

        populateValidParams(params)
        def pasajero = new Pasajero(params)

        assert pasajero.save() != null

        // test invalid parameters in update
        params.id = pasajero.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/pasajero/edit"
        assert model.pasajeroInstance != null

        pasajero.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/pasajero/show/$pasajero.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        pasajero.clearErrors()

        populateValidParams(params)
        params.id = pasajero.id
        params.version = -1
        controller.update()

        assert view == "/pasajero/edit"
        assert model.pasajeroInstance != null
        assert model.pasajeroInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/pasajero/list'

        response.reset()

        populateValidParams(params)
        def pasajero = new Pasajero(params)

        assert pasajero.save() != null
        assert Pasajero.count() == 1

        params.id = pasajero.id

        controller.delete()

        assert Pasajero.count() == 0
        assert Pasajero.get(pasajero.id) == null
        assert response.redirectedUrl == '/pasajero/list'
    }
}
