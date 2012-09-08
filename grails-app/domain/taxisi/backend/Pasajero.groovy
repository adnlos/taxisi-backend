package taxisi.backend

class Pasajero extends Usuario {

	String latitude
	String longitude
	String nombre
	String apellido
	String email
	String celular



    static constraints = {
    	latitude blank:false
    	longitude blank:false
    	nombre blank:false
    	apellido blank:false
    	celular blank:false, size:10..13
    	email email:true, blank:true
    	
    }

    String toString(){
        return "${nombre} ${apellido}"
    }
}
