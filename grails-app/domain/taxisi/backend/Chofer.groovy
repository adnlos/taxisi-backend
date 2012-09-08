package taxisi.backend

class Chofer extends Usuario{

	String nombre
	String apellido
	String licencia
	String celular
	String email
	Taxi taxi
	Tarjeton tarjeton



    static constraints = {
    	nombre blank:false
    	apellido blank:false
    	licencia blank:false
    	celular blank:false
    	email email:true

    }

    String toString(){
        return "${nombre} ${apellido}"
    }
}