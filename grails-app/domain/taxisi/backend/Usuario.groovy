package taxisi.backend

class Usuario  {
    static expose = 'usuario'

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