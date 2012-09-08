package taxisi.backend



import org.junit.*
import grails.test.mixin.*

@TestFor(TaxiController)
@Mock(Taxi)
class TaxiControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/taxi/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.taxiInstanceList.size() == 0
        assert model.taxiInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.taxiInstance != null
    }

    void testSave() {
        controller.save()

        assert model.taxiInstance != null
        assert view == '/taxi/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/taxi/show/1'
        assert controller.flash.message != null
        assert Taxi.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/taxi/list'

        populateValidParams(params)
        def taxi = new Taxi(params)

        assert taxi.save() != null

        params.id = taxi.id

        def model = controller.show()

        assert model.taxiInstance == taxi
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/taxi/list'

        populateValidParams(params)
        def taxi = new Taxi(params)

        assert taxi.save() != null

        params.id = taxi.id

        def model = controller.edit()

        assert model.taxiInstance == taxi
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/taxi/list'

        response.reset()

        populateValidParams(params)
        def taxi = new Taxi(params)

        assert taxi.save() != null

        // test invalid parameters in update
        params.id = taxi.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/taxi/edit"
        assert model.taxiInstance != null

        taxi.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/taxi/show/$taxi.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        taxi.clearErrors()

        populateValidParams(params)
        params.id = taxi.id
        params.version = -1
        controller.update()

        assert view == "/taxi/edit"
        assert model.taxiInstance != null
        assert model.taxiInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/taxi/list'

        response.reset()

        populateValidParams(params)
        def taxi = new Taxi(params)

        assert taxi.save() != null
        assert Taxi.count() == 1

        params.id = taxi.id

        controller.delete()

        assert Taxi.count() == 0
        assert Taxi.get(taxi.id) == null
        assert response.redirectedUrl == '/taxi/list'
    }
}
