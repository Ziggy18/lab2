import java.util.ArrayList;

public class Object {

    private ArrayList<Coordinate> coordinates;

    private ArrayList<Polygon> polygons;

    public Object(){
        coordinates=new ArrayList<Coordinate>();
        polygons=new ArrayList<Polygon>();
    }

    public ArrayList<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void addCoordinate(Coordinate coordinate) {
        coordinates.add(coordinate);
    }

    public ArrayList<Polygon> getPolygons() {
        return polygons;
    }

    public void addPolygon(Polygon polygon) {
        polygons.add(polygon);
    }
}
