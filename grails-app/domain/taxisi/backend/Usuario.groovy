package taxisi.backend

class Usuario  {

	String nick
	String password
	
	static constraints = {
    	nick blank:false
    	password blank:false 
    }

    String toString(){
        return "${nick}"
    }
}