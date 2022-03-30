import java.util.ArrayList;

public class Polygon {

    // массив вершин
    private ArrayList<Peak> peaks;

    public Polygon(){
        peaks=new ArrayList<Peak>();
    }

    public ArrayList<Peak> getPeaks() {
        return peaks;
    }

    public void addPeak(Peak peak) {
        peaks.add(peak);
    }
}
