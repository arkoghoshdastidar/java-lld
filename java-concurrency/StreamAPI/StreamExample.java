import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("arko ghosh dastidar");
        names.add("arko ghosh dastidar");
        names.add("rick king");
        names.add("abhi ghosh");

        // flatMap example
        names.stream()
            .flatMap(name -> {
                String[] splitName = name.split(" ");
                return Arrays.stream(splitName);
            })
            .forEach(part -> System.out.println(part));

        //distinct example
        List<String> listOfDistinctNames = names.stream().distinct().collect(Collectors.toList());
        System.out.println(listOfDistinctNames);

        
    }
}