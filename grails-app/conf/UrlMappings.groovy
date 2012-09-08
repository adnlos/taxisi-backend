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
	}
}
