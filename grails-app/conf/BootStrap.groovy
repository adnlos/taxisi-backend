import taxisi.backend.Obras
import taxisi.backend.IncidenteVial
import taxisi.backend.SitioTaxi
import kml.KmlParser

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


        SitioTaxi sitio = new SitioTaxi(latitude:"50",longitude: "60", telefono:"5555-4444",nombre: "Super Taxis")
        sitio.save()

        sitio = new SitioTaxi(latitude:"60",longitude: "860", telefono:"5555-4444",nombre: "Mis taxis de siempre")
        sitio.save()
    }
    def destroy = {
    }
}
