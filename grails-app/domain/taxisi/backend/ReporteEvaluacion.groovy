package taxisi.backend

class ReporteEvaluacion {

	Chofer chofer
	Pasajero pasajero
	String tipoReporte
	String evaluacion
	String foto

    static belongsTo = [chofer:Chofer]

    static constraints = {
    	pasajero blank:false
    	tipoReporte blank:false
    	evaluacion blank:false
    }

    String toString(){
        return "${chofer} ${tipoReporte}"
    }
}
