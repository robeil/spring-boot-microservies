public class TestMain {
    public static void main(String[] args) {
//        Animal dog = new Dog(1L,"Mobile");
//        System.out.println(dog.makeNoise());
//        Animal animal = new Animal(2L,"Tekula ");
//        System.out.println( animal.makeNoise());

        final String names = "Robeil";
        System.out.println(names.length());
        String days[]={"Sun","Mon","wed","thu","fri","sat"};
        System.out.println(days[0].length());
        final char n = 'b';
        int a = 15;
        a = a >>> 3;
        System.out.println(a);
        Ab b = new A();
        System.out.println(b.printName("Robeil Aregawi"));
        try{
            int c = a/3;
            System.out.println("Try");
            System.exit(0);
        }
        catch (Exception e){
           // throw new RuntimeException();
            System.out.println("Catch");
        }finally {
            System.out.println("Finally");
        }

        Integer boxedNum = 10;
        int num = boxedNum;

    }
}
