package kml

/**
 * User: israel
 * Date: 9/8/12
 * Time: 11:43 AM
 */
class KmlParser {
    static ns = new groovy.xml.Namespace("http://www.opengis.net/kml/2.2", 'ns')
    List parse( Object input ) {
        def points = []

        def xml = new XmlSlurper().parse(input)
        def coordinates = xml.depthFirst().findAll { it.name() == 'coordinates' }

        coordinates.each {point ->
            points << new Point( point.text() )
            println "*coordinates: "+point
        }

        return points;
    }
}