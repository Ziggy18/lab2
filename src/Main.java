public class Main {

    public static void main(String[] args) {
        try {

            // проверка суммы барицентрических координат
            Coordinate barycentricCoordinate = MathTools.barycentric(1,1, new Coordinate(2, 5, 8), new Coordinate(3, 15, 6));
            System.out.println(barycentricCoordinate.getX()+ barycentricCoordinate.getY()+ barycentricCoordinate.getZ());
            
            // проверка функции отрисовки треугольников
            Picture picture0 = new Picture(400, 400, new Color(100,100,220));
            PictureUtils.Triangle(picture0, new Coordinate(-100, -50, 50), new Coordinate(300, 370, 320), new Color(255,255,255));
            PictureUtils.Triangle(picture0, new Coordinate(300, 260, 420), new Coordinate(170, 260, 180.4), new Color(0,100,100));
            PictureUtils.Triangle(picture0, new Coordinate(100, 150, 200), new Coordinate(50, 100, 50), new Color(200,200,0));
            PictureUtils.Save(picture0, "pictures/triangles.png");

            // считываем объект из .obj файла
            Object stormTrooper = ObjectUtils.ObjectFromFile("objects/StormTrooper.obj");
            // Отрисовка полигонов трёхмерной модели
            Picture picture1 = ObjectUtils.ObjectToPicture1(stormTrooper,1000,1000,250,500,500);
            PictureUtils.Save(picture1, "pictures/picture1.png");
            // Отсечение нелицевых граней
            Picture picture2 = ObjectUtils.ObjectToPicture2(stormTrooper,1000,1000,250,500,500);
            PictureUtils.Save(picture2, "pictures/picture2.png");
            // базовое освещение
            Picture picture3 = ObjectUtils.ObjectToPicture3(stormTrooper,1000,1000,250,500,500);
            PictureUtils.Save(picture3, "pictures/picture3.png");
            // z-буффер
            Picture picture4 = ObjectUtils.ObjectToPicture4(stormTrooper,1000,1000,250,500,500);
            PictureUtils.Save(picture4, "pictures/picture4.png");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
