package taxisi.backend

class IncidenteVial {
    static expose = 'incidenteVial'

    String messageType = "INCIDENTE_VIAL";

    static transients = ['messageType']

	String latitude
	String longitude

    static constraints = {
    	latitude blank:false
    	longitude blank:false
    }
}
