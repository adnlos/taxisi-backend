package taxisi.backend



import org.junit.*
import grails.test.mixin.*

@TestFor(SitioTaxiController)
@Mock(SitioTaxi)
class SitioTaxiControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/sitioTaxi/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.sitioTaxiInstanceList.size() == 0
        assert model.sitioTaxiInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.sitioTaxiInstance != null
    }

    void testSave() {
        controller.save()

        assert model.sitioTaxiInstance != null
        assert view == '/sitioTaxi/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/sitioTaxi/show/1'
        assert controller.flash.message != null
        assert SitioTaxi.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/sitioTaxi/list'

        populateValidParams(params)
        def sitioTaxi = new SitioTaxi(params)

        assert sitioTaxi.save() != null

        params.id = sitioTaxi.id

        def model = controller.show()

        assert model.sitioTaxiInstance == sitioTaxi
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/sitioTaxi/list'

        populateValidParams(params)
        def sitioTaxi = new SitioTaxi(params)

        assert sitioTaxi.save() != null

        params.id = sitioTaxi.id

        def model = controller.edit()

        assert model.sitioTaxiInstance == sitioTaxi
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/sitioTaxi/list'

        response.reset()

        populateValidParams(params)
        def sitioTaxi = new SitioTaxi(params)

        assert sitioTaxi.save() != null

        // test invalid parameters in update
        params.id = sitioTaxi.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/sitioTaxi/edit"
        assert model.sitioTaxiInstance != null

        sitioTaxi.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/sitioTaxi/show/$sitioTaxi.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        sitioTaxi.clearErrors()

        populateValidParams(params)
        params.id = sitioTaxi.id
        params.version = -1
        controller.update()

        assert view == "/sitioTaxi/edit"
        assert model.sitioTaxiInstance != null
        assert model.sitioTaxiInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/sitioTaxi/list'

        response.reset()

        populateValidParams(params)
        def sitioTaxi = new SitioTaxi(params)

        assert sitioTaxi.save() != null
        assert SitioTaxi.count() == 1

        params.id = sitioTaxi.id

        controller.delete()

        assert SitioTaxi.count() == 0
        assert SitioTaxi.get(sitioTaxi.id) == null
        assert response.redirectedUrl == '/sitioTaxi/list'
    }
}
