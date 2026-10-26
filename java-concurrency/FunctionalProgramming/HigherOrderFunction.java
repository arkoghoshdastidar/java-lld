import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class HigherOrderFunction {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Rick");
        names.add("Arko");

        Collections.sort(names, (String a, String b) -> {
            return a.compareTo(b);
        });

        System.out.println(names);
    }
}