package taxisi.backend

class Tarjeton {

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