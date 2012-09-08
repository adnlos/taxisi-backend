package kml

/**
 * User: israel
 * Date: 9/8/12
 * Time: 12:28 PM
 */
class Point {

    Double latitude
    Double longitude

    public Point(){}

    public Point(String gps) {
        def xyz = gps.tokenize(',');
        latitude = Double.parseDouble( xyz[1] )
        longitude = Double.parseDouble( xyz[0] )
    }
    public String toString() {
        return "latitude: ${latitude} longitude: ${longitude}"
    }
}
