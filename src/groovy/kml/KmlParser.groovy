package kml

/**
 * User: israel
 * Date: 9/8/12
 * Time: 11:43 AM
 */
class KmlParser {
    static ns = new groovy.xml.Namespace("http://www.opengis.net/kml/2.2", 'ns')
    List parse( Object input ) {


        def xml = new XmlSlurper().parse(input)
        def x = xml.depthFirst().findAll { it.name() == 'Point' }

        x.each {point ->
            println "*Point: "+point
        }

        x = xml.depthFirst().findAll { it.name() == 'LineString' }

        x.each {point ->
            println "*LineString: "+point
        }

        def points = []

        def kml = new groovy.util.XmlParser().parse( input );
        def coords = kml[ ns.Document ][ns.Folder][ ns.Placemark ][ ns.Point ][ns.coordinates]

        //def placemarks = kml[ ns.Document ][ns.Folder][ ns.Placemark ]
        //placemarks = kml[ ns.Document ][ns.Folder][ ns.Folder ][ ns.Placemark ]


        coords.each {point ->
            points << new Point( point.text() )
            println "Point: "+point
        }

        coords = kml[ ns.Document ][ns.Folder][ ns.Placemark ][ ns.LineString ][ns.coordinates]

        coords.each {point ->
            points << new Point( point.text() )
            println "LineString: "+point
        }

        coords = kml[ ns.Document ][ns.Folder][ ns.Folder ][ ns.Placemark ][ ns.Point ][ns.coordinates]
        coords.each {point ->
            points << new Point( point.text() )
            println "Point: "+point
        }

        coords = kml[ ns.Document ][ns.Folder][ ns.Folder ][ ns.Placemark ][ ns.LineString ][ns.coordinates]

        coords.each {point ->
            points << new Point( point.text() )
            println "LineString: "+point
        }

        return points;
    }
}