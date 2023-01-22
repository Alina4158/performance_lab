import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task2 {
    public static void main(String[] args) {
        String firstFileContent = readFile(args[0]);
        String[] firstStrings = firstFileContent.split("\r\n");
        float radius = Float.parseFloat(firstStrings[1]);
        String[] coordinatesArr = firstStrings[0].split(" ");
        float xc = Float.parseFloat(coordinatesArr[0]);
        float yc = Float.parseFloat(coordinatesArr[1]);

        String secondFileContent = readFile(args[1]);
        String[] secondStrings = secondFileContent.split("\r\n");
        int length = secondStrings.length;
        for (int i = 0; i < length; i++) {
            String[] coordinatesPoint = secondStrings[i].split(" ");
            float x = Float.parseFloat(coordinatesPoint[0]);
            float y = Float.parseFloat(coordinatesPoint[1]);
            Integer pointPosition = getPosition(xc, yc, radius, x, y);
            System.out.print(pointPosition + " ");
        }

//        float xc = 1;
//        float yc = 1;
//        float radius = 5;
//        float x = 0;
//        float y = 0;
//        Integer pointPosition = getPosition(xc, yc, radius, x, y);

//        System.out.println(pointPosition);
    }
    public static Integer getPosition( float xc,  float yc, float radius, float x, float y){
        Integer pointPosition;
        double d = Math.pow(x - xc, 2) + Math.pow(y - yc, 2);
        if (d < Math.pow(radius, 2)) {
            pointPosition = 1;
        } else if (d > Math.pow(radius, 2)) {
            pointPosition = 2;
        } else {
            pointPosition = 0;
        }
        return pointPosition;
    }

    public static String readFile(String path){
        Path writeFilePath = Paths.get(path);
        String content = null;
        try {
            content = Files.readString(writeFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

}
