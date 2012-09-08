import taxisi.backend.Obras
import taxisi.backend.IncidenteVial
import taxisi.backend.SitioTaxi

class BootStrap {

    def init = { servletContext ->

        Obras obra = new Obras(latitude:"10",longitude: "20")
        obra.save()

        obra = new Obras(latitude:"10",longitude: "20")
        obra.save()

        obra = new Obras(latitude:"10",longitude: "20")
        obra.save()

        obra = new Obras(latitude:"10",longitude: "20")
        obra.save()

        obra = new Obras(latitude:"10",longitude: "20")
        obra.save()

        obra = new Obras(latitude:"10",longitude: "20")
        obra.save()

        IncidenteVial incidente = new IncidenteVial(latitude:"20",longitude: "40")
        incidente.save()

        incidente = new IncidenteVial(latitude:"20",longitude: "40")
        incidente.save()

        incidente = new IncidenteVial(latitude:"20",longitude: "40")
        incidente.save()

        incidente = new IncidenteVial(latitude:"20",longitude: "40")
        incidente.save()

        SitioTaxi sitio = new SitioTaxi(latitude:"50",longitude: "60", telefono:"5555-4444",nombre: "Super Taxis")
        sitio.save()

        sitio = new SitioTaxi(latitude:"60",longitude: "860", telefono:"5555-4444",nombre: "Mis taxis de siempre")
        sitio.save()
    }
    def destroy = {
    }
}
