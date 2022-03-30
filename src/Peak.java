// вершина полигона
public class Peak {
    // номер координаты вершины
    private int v;
    // номер текстурной координаты
    private int vt;
    // номер нормали
    private int vn;

    public Peak(int v, int vt, int vn){
        this.v=v;
        this.vt=vt;
        this.vn=vn;
    }

    public int getP() {
        return v;
    }
}
