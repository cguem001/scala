package playground;

public class JavaPlayground {

    public static void main(String[] args) {
        System.out.println(Person.N_EYES);
    } //--> tHIS IS CALLED CLASS LEVEL FUNCTIONALITY
}

class Person {
    public static final int N_EYES = 2;
}