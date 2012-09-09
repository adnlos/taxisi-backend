package taxisi.backend

class Usuario  {
    static expose = 'usuario'

    String messageType = "USUARIO";

    static transients = ['messageType']

	String nick
	String password

    String role
	
	static constraints = {
    	nick blank:false
    	password blank:false
        role inList: ['CHOFER','USUARIO']
    }

    String toString(){
        return "${nick}"
    }
}