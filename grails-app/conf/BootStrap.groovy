import taxisi.backend.Obras
import taxisi.backend.IncidenteVial
import taxisi.backend.SitioTaxi
import kml.KmlParser
import taxisi.backend.Usuario
import taxisi.backend.Taxi

class BootStrap {

    def init = { servletContext ->
        def baseDir ='/Users/israel/development/grails/CiudadMovil/data/'

<<<<<<< HEAD
        def file = '/Users/adnlos/Documents/grails/taxisi-backend/data/ALESTRA-LCE.kml'
=======
        def file = baseDir+ 'ALESTRA-LCE.kml'
>>>>>>> 990c9c29496bbc235926b42ec2bae15b79f306e3
        //def file = '/Users/israel/Downloads/CABLEVISION-LCE.kml'

        KmlParser parser = new KmlParser()
        def points = parser.parse(file)

        points.each {point ->

            Obras obra = new Obras(latitude:point.latitude.toString(),longitude: point.longitude.toString())
            obra.save()
        }

<<<<<<< HEAD
        file = '/Users/adnlos/Documents/grails/taxisi-backend/data/CABLEVISION-LCE.kml'
=======
        file = baseDir+ 'CABLEVISION-LCE.kml'
>>>>>>> 990c9c29496bbc235926b42ec2bae15b79f306e3
        parser = new KmlParser()
        points = parser.parse(file)

        points.each {point ->

            IncidenteVial incidente = new IncidenteVial(latitude:point.latitude.toString(),longitude: point.longitude.toString())
            incidente.save()
        }

<<<<<<< HEAD
        file = '/Users/adnlos/Documents/grails/taxisi-backend/data/INFRAESTRUCTURAURBANA-EscuelasPublicas-Cuauhtemoc.kml'
=======
        file = baseDir+ 'INFRAESTRUCTURAURBANA-EscuelasPublicas-Cuauhtemoc.kml'
>>>>>>> 990c9c29496bbc235926b42ec2bae15b79f306e3
        parser = new KmlParser()
        points = parser.parse(file)

        int i=0
        points.each {point ->
            i++
            Taxi taxi = new Taxi(latitude:point.latitude.toString(),longitude: point.longitude.toString())

            if (i  <10)
                taxi.save()
        }


        SitioTaxi sitio = new SitioTaxi(latitude:"19.41841899999204",longitude: "-99.17086400005815", telefono:"5555-4444",nombre: "Super Taxis")
        sitio.save()

        sitio = new SitioTaxi(latitude:"19.439546",longitude: "-99.136686", telefono:"5555-4444",nombre: "Mis taxis de siempre")
        sitio.save()

        Usuario usuario = new Usuario(nick:'israel',password: 'xyz',role: 'USUARIO')
        usuario.save()

        usuario = new Usuario(nick:'adan',password: 'xyz',role: 'CHOFER')
        usuario.save()


    }
    def destroy = {
    }
}
