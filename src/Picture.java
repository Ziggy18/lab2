// двумерное изображение
public class Picture {
    // размеры картинки
    private int w;
    private int h;

    // двумерный массив цветов
    private Color[][] colorArray;

    // z-буффер
    private double[][] zBuffer;

    public Picture(int w, int h) {
        this.w = w;
        this.h = h;
        colorArray = new Color[w][h];
        initArray();
        zBuffer=new double[w][h];
        for(int i=0;i<w;i++)
            for(int j=0;j<h;j++)
                zBuffer[i][j]=Math.pow(10,4);
    }

    public Picture(int w, int h, Color color) {
        this.w = w;
        this.h = h;
        colorArray = new Color[w][h];
        initArray(color);
        zBuffer=new double[w][h];
        for(int i=0;i<w;i++)
            for(int j=0;j<h;j++)
                zBuffer[i][j]=Math.pow(10,4);
    }

    public int getW(){
        return w;
    }

    public int getH(){
        return h;
    }

    public Color[][] getColorArray(){
        return colorArray;
    }

    private void initArray() {
        initArray(null);
    }

    private void initArray(Color color) {
        if(color == null) {
            color = new Color();
        }
        for(int i = 0; i < w; i++) {
            for(int j = 0; j < h; j++) {
                colorArray[i][j] = color;
            }
        }
    }

    public double getZBuffer(int i, int j) {
        return zBuffer[i][j];
    }

    public void setZBuffer(int i, int j, double z) {
        this.zBuffer[i][j]=z;
    }

}
