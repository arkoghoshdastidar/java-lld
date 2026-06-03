import java.util.Arrays;

public class ArrayCopyExample {
    public static void main(String[] args) {
        int[] copyFrom = {1, 2, 3, 4, 5, 6};
        int[] copyTo = Arrays.copyOfRange(copyFrom, 2, 5);
        Arrays.stream(copyTo).forEach(System.out::println);
    }
}