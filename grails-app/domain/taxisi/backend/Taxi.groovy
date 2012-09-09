package taxisi.backend

class Taxi {
    static expose = 'taxi'

	String latitude
	String longitude
	String tipo = 'SITIO'
	String placas = 'XYZ123'
    String vehiculo = 'CHEVY'
	static belongsTo = [sitioTaxi:SitioTaxi]

    static constraints = {
    	latitude blank:false
    	longitude blank:false
    	placas blank:false
        sitioTaxi nullable: true
    	
    }

    String toString(){
        return "${placas} ${sitioTaxi}"
    }
}