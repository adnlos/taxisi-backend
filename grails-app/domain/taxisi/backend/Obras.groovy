package taxisi.backend

class Obras {
    static expose = 'obras'

    String messageType = "OBRAS";

    static transients = ['messageType']

	String latitude
	String longitude

    static constraints = {
    	latitude blank:false
    	longitude blank:false
    }
}
