package taxisi.backend

class Taxi {

	String latitude
	String longitude
	String tipo
	String placas	
	static belongsTo = [sitioTaxi:SitioTaxi]

    static constraints = {
    	latitude blank:false
    	longitude blank:false
    	placas blank:false
    	
    }

    String toString(){
        return "${placas} ${sitioTaxi}"
    }
}