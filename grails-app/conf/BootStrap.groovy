import taxisi.backend.Obras
import taxisi.backend.IncidenteVial
import taxisi.backend.SitioTaxi
import kml.KmlParser
import taxisi.backend.Usuario
import taxisi.backend.Taxi

class BootStrap {

    def init = { servletContext ->

        def file = '/Users/israel/Downloads/ALESTRA-LCE.kml'
        //def file = '/Users/israel/Downloads/CABLEVISION-LCE.kml'

        KmlParser parser = new KmlParser()
        def points = parser.parse(file)

        points.each {point ->

            Obras obra = new Obras(latitude:point.latitude.toString(),longitude: point.longitude.toString())
            obra.save()
        }

        file = '/Users/israel/Downloads/CABLEVISION-LCE.kml'
        parser = new KmlParser()
        points = parser.parse(file)

        points.each {point ->

            IncidenteVial incidente = new IncidenteVial(latitude:point.latitude.toString(),longitude: point.longitude.toString())
            incidente.save()
        }

        file = '/Users/israel/Downloads/INFRAESTRUCTURAURBANA-EscuelasPublicas-Cuauhtemoc.kml'
        parser = new KmlParser()
        points = parser.parse(file)

        points.each {point ->

            Taxi taxi = new Taxi(latitude:point.latitude.toString(),longitude: point.longitude.toString())
            taxi.save()
        }


        SitioTaxi sitio = new SitioTaxi(latitude:"50",longitude: "60", telefono:"5555-4444",nombre: "Super Taxis")
        sitio.save()

        sitio = new SitioTaxi(latitude:"60",longitude: "860", telefono:"5555-4444",nombre: "Mis taxis de siempre")
        sitio.save()

        Usuario usuario = new Usuario(nick:'israel',password: 'xyz',role: 'USUARIO')
        usuario.save()

        usuario = new Usuario(nick:'adan',password: 'xyz',role: 'CHOFER')
        usuario.save()


    }
    def destroy = {
    }
}
