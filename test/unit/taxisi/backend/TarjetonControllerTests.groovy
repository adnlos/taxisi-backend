package taxisi.backend



import org.junit.*
import grails.test.mixin.*

@TestFor(TarjetonController)
@Mock(Tarjeton)
class TarjetonControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/tarjeton/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.tarjetonInstanceList.size() == 0
        assert model.tarjetonInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.tarjetonInstance != null
    }

    void testSave() {
        controller.save()

        assert model.tarjetonInstance != null
        assert view == '/tarjeton/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/tarjeton/show/1'
        assert controller.flash.message != null
        assert Tarjeton.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/tarjeton/list'

        populateValidParams(params)
        def tarjeton = new Tarjeton(params)

        assert tarjeton.save() != null

        params.id = tarjeton.id

        def model = controller.show()

        assert model.tarjetonInstance == tarjeton
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/tarjeton/list'

        populateValidParams(params)
        def tarjeton = new Tarjeton(params)

        assert tarjeton.save() != null

        params.id = tarjeton.id

        def model = controller.edit()

        assert model.tarjetonInstance == tarjeton
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/tarjeton/list'

        response.reset()

        populateValidParams(params)
        def tarjeton = new Tarjeton(params)

        assert tarjeton.save() != null

        // test invalid parameters in update
        params.id = tarjeton.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/tarjeton/edit"
        assert model.tarjetonInstance != null

        tarjeton.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/tarjeton/show/$tarjeton.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        tarjeton.clearErrors()

        populateValidParams(params)
        params.id = tarjeton.id
        params.version = -1
        controller.update()

        assert view == "/tarjeton/edit"
        assert model.tarjetonInstance != null
        assert model.tarjetonInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/tarjeton/list'

        response.reset()

        populateValidParams(params)
        def tarjeton = new Tarjeton(params)

        assert tarjeton.save() != null
        assert Tarjeton.count() == 1

        params.id = tarjeton.id

        controller.delete()

        assert Tarjeton.count() == 0
        assert Tarjeton.get(tarjeton.id) == null
        assert response.redirectedUrl == '/tarjeton/list'
    }
}
