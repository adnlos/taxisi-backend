package taxisi.backend

class Obras {

	String latitude
	String longitude

    static constraints = {
    	latitude blank:false
    	longitude blank:false
    }
}
