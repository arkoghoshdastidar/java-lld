public class TestPlayground {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        String[] names = {"arko","rick","ajay","rajesh","umesh"};
        char[] symbols = {'a','b','c','d','e'};

        for(int number: numbers) {
            System.out.println(number);
        }
        for(int i=0; i<names.length; i++) {
            System.out.println(names[i]);
        }
        for(char symbol : symbols) {
            System.out.println(symbol);
        }
    }
}