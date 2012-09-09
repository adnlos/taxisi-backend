import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.grails.plugins.rest.JSONApiRegistry

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')

        def config = ConfigurationHolder.config.grails.'json-rest-api'
        def root = config.root ? config.root : '/api'

        "${root}/usuario/login/$usr/$pass" (controller: 'usuario') {
            entity = { JSONApiRegistry.registry[params.domain] }
            action = [ GET: 'login']
        }

        "${root}/taxi/ubicacion/$latitude/$longitude" (controller: 'taxi') {
            entity = { JSONApiRegistry.registry[params.domain] }
            action = [ GET: 'ubicacion']
        }

        "${root}/pasajero/ubicacion/$latitude/$longitude" (controller: 'pasajero') {
            entity = { JSONApiRegistry.registry[params.domain] }
            action = [ GET: 'ubicacion']
        }

        "${root}/pasajero/compartir/$latitude/$longitude" (controller: 'pasajero') {
            entity = { JSONApiRegistry.registry[params.domain] }
            action = [ GET: 'ubicacion']
        }

        "${root}/sitioTaxi/ubicacion/$latitude/$longitude" (controller: 'sitioTaxi') {
            entity = { JSONApiRegistry.registry[params.domain] }
            action = [ GET: 'ubicacion']
        }

        "${root}/obras/ubicacion/$latitude/$longitude" (controller: 'obras') {
            entity = { JSONApiRegistry.registry[params.domain] }
            action = [ GET: 'ubicacion']
        }

        "${root}/incidenteVial/ubicacion/$latitude/$longitude" (controller: 'incidenteVial') {
            entity = { JSONApiRegistry.registry[params.domain] }
            action = [ GET: 'ubicacion']
        }
	}
}
