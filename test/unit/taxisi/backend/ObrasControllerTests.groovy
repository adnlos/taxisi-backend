package taxisi.backend



import org.junit.*
import grails.test.mixin.*

@TestFor(ObrasController)
@Mock(Obras)
class ObrasControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/obras/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.obrasInstanceList.size() == 0
        assert model.obrasInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.obrasInstance != null
    }

    void testSave() {
        controller.save()

        assert model.obrasInstance != null
        assert view == '/obras/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/obras/show/1'
        assert controller.flash.message != null
        assert Obras.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/obras/list'

        populateValidParams(params)
        def obras = new Obras(params)

        assert obras.save() != null

        params.id = obras.id

        def model = controller.show()

        assert model.obrasInstance == obras
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/obras/list'

        populateValidParams(params)
        def obras = new Obras(params)

        assert obras.save() != null

        params.id = obras.id

        def model = controller.edit()

        assert model.obrasInstance == obras
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/obras/list'

        response.reset()

        populateValidParams(params)
        def obras = new Obras(params)

        assert obras.save() != null

        // test invalid parameters in update
        params.id = obras.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/obras/edit"
        assert model.obrasInstance != null

        obras.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/obras/show/$obras.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        obras.clearErrors()

        populateValidParams(params)
        params.id = obras.id
        params.version = -1
        controller.update()

        assert view == "/obras/edit"
        assert model.obrasInstance != null
        assert model.obrasInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/obras/list'

        response.reset()

        populateValidParams(params)
        def obras = new Obras(params)

        assert obras.save() != null
        assert Obras.count() == 1

        params.id = obras.id

        controller.delete()

        assert Obras.count() == 0
        assert Obras.get(obras.id) == null
        assert response.redirectedUrl == '/obras/list'
    }
}
