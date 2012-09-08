package taxisi.backend

class IncidenteVial {
    static expose = 'incidenteVial'

	String latitude
	String longitude

    static constraints = {
    	latitude blank:false
    	longitude blank:false
    }
}
