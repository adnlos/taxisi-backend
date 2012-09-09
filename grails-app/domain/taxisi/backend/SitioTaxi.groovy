package taxisi.backend

class SitioTaxi {
    static expose = 'sitioTaxi'

    String messageType = "SITIO_TAXI";

    static transients = ['messageType']

	String latitude
	String longitude
	String telefono
	String nombre

    static constraints = {
    	latitude blank:false
    	longitude blank:false
    	telefono blank:false
    	nombre blank:false
    }

    String toString(){
        return "${nombre} ${telefono}"
    }
}
