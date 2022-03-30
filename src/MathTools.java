public class MathTools {

    // барицентрические координаты точки для треугольника
    public static Coordinate barycentric(int x, int y, Coordinate xtr, Coordinate ytr){
        double x0=xtr.getX();
        double x1=xtr.getY();
        double x2=xtr.getZ();
        double y0=ytr.getX();
        double y1=ytr.getY();
        double y2=ytr.getZ();
        return new Coordinate(
                ((x1 - x2)*(y - y2) - (y1 - y2)*(x - x2)) / ((x1 - x2)*(y0 - y2) - (y1 - y2)*(x0 - x2)),
                ((x2 - x0)*(y - y0) - (y2 - y0)*(x - x0)) / ((x2 - x0)*(y1 - y0) - (y2 - y0)*(x1 - x0)),
                ((x0 - x1)*(y - y1) - (y0 - y1)*(x - x1)) / ((x0 - x1)*(y2 - y1) - (y0 - y1)*(x2 - x1))
        );
    }

    // значение нормали треугольника
    public static Coordinate normal(Coordinate c0, Coordinate c1, Coordinate c2){
        double x0=c0.getX();
        double x1=c1.getX();
        double x2=c2.getX();
        double y0=c0.getY();
        double y1=c1.getY();
        double y2=c2.getY();
        double z0=c0.getZ();
        double z1=c1.getZ();
        double z2=c2.getZ();
        return new Coordinate(
                (y2-y0)*(z1-z0)-(z2-z0)*(y1-y0),
                (x1-x0)*(z2-z0)-(x2-x0)*(z1-z0),
                (x2-x0)*(y1-y0)-(x1-x0)*(y2-y0)
        );
    }

    // нормализованное скалярное произведение
    public static double normDotProduct(Coordinate n, Coordinate v){
        double nx=n.getX();
        double ny=n.getY();
        double nz=n.getZ();
        double vx=v.getX();
        double vy=v.getY();
        double vz=v.getZ();
        return (nx* vx+ny*vy+nz*vz)/Math.sqrt((nx*nx+ny*ny+nz*nz)*(vx*vx+vy*vy+vz*vz));
    }
}
