package taxisi.backend

class Tarjeton {

    String messageType = "TARJETON";

    static transients = ['messageType']

	String numeroSerie
	String tipoTargeton
	static belongsTo = [chofer:Chofer]

    static constraints = {
    	numeroSerie blank:false
    }

    String toString(){
        return "${numeroSerie} ${chofer}"
    }
}