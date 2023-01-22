import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        String numbers = readFile(args[0]);
        String[] numbersStrings = numbers.split("\r\n");
        int[] values = Arrays.stream(numbersStrings)
                .mapToInt(Integer::parseInt)
                .toArray();
        int result = findShortWay(values);
        System.out.println(result);
    }

    public static String readFile(String path) {
        Path writeFilePath = Paths.get(path);
        String content;
        try {
            content = Files.readString(writeFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

    /**
     * Найти минимальное число ходов, требуемых для приведения всех элементов
     * массива к одному числу
     *
     * @param nums массив числел
     * @return {@link Integer} - минимальное число ходов
     */
    private static int findShortWay(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        int mid = nums.length / 2;
        int result = 0;
        for (int n : nums) {
            result += Math.abs(n - nums[mid]);
        }
        return result;
    }
}


