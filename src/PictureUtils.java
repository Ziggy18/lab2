import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

// методы для работы с изображением
public class PictureUtils {

    // сохранение изображения в файл
    public static void Save(Picture picture, String filename) throws IOException {
        BufferedImage png = new BufferedImage(picture.getW(), picture.getH(), TYPE_INT_RGB);
        for (int i = 0; i < picture.getW(); i++) {
            for (int j = 0; j < picture.getH(); j++) {
                Color color = picture.getColorArray()[i][j];
                png.setRGB(i, j, new java.awt.Color(color.getR(), color.getG(), color.getB()).getRGB());
            }
        }
        ImageIO.write(png, "png", new File(filename));
    }

    // отрисовка одного пикселя
    public static void Pixel(Picture picture, int x, int y, Color color) {
        int h = picture.getH();
        picture.getColorArray()[x][h - y - 1] = color;
    }

    // отрисовка треугольника
    public static Picture Triangle(Picture picture, Coordinate xtr, Coordinate ytr, Color color) {
        int xmin = (int) Math.round(Math.min(xtr.getX(), Math.min(xtr.getY(), xtr.getZ())));
        int ymin = (int) Math.round(Math.min(ytr.getX(), Math.min(ytr.getY(), ytr.getZ())));
        int xmax = (int) Math.round(Math.max(xtr.getX(), Math.max(xtr.getY(), xtr.getZ()))) + 1;
        int ymax = (int) Math.round(Math.max(ytr.getX(), Math.max(ytr.getY(), ytr.getZ()))) + 1;
        if (xmin < 0) xmin = 0;
        if (xmax > picture.getW()) xmax = picture.getW();
        if (ymin < 0) ymin = 0;
        if (ymax > picture.getH()) ymax = picture.getH();
        for (int i = xmin; i < xmax; i++)
            for (int j = ymin; j < ymax; j++) {
                Coordinate coordinate = MathTools.barycentric(i, j, xtr, ytr);
                if (coordinate.getX() >= 0 && coordinate.getY() >= 0 && coordinate.getZ() >= 0)
                    Pixel(picture, i, j, color);
            }
        return picture;
    }

    // с z-буффером
    public static Picture TriangleZ(Picture picture, Coordinate xtri, Coordinate ytri, Coordinate ztri, Color color) {
        int xmin = (int) Math.round(Math.min(xtri.getX(), Math.min(xtri.getY(), xtri.getZ())));
        int ymin = (int) Math.round(Math.min(ytri.getX(), Math.min(ytri.getY(), ytri.getZ())));
        int xmax = (int) Math.round(Math.max(xtri.getX(), Math.max(xtri.getY(), xtri.getZ()))) + 1;
        int ymax = (int) Math.round(Math.max(ytri.getX(), Math.max(ytri.getY(), ytri.getZ()))) + 1;
        if (xmin < 0) xmin = 0;
        if (xmax > picture.getW()) xmax = picture.getW();
        if (ymin < 0) ymin = 0;
        if (ymax > picture.getH()) ymax = picture.getH();
        double z = 0;
        for (int i = xmin; i < xmax; i++)
            for (int j = ymin; j < ymax; j++) {
                Coordinate coordinate = MathTools.barycentric(i, j, xtri, ytri);
                if (coordinate.getX() >= 0 && coordinate.getY() >= 0 && coordinate.getZ() >= 0) {
                    z = coordinate.getX() * ztri.getX() + coordinate.getY() * ztri.getY() + coordinate.getZ() * ztri.getZ();
                    if (z < picture.getZBuffer(i, j)) {
                        Pixel(picture, i, j, color);
                        picture.setZBuffer(i, j, z);
                    }
                }
            }
        return picture;
    }
}
