public class Dog extends Animal implements Pet{

    private String name;
    public Dog(){


    }
public Dog(String name){
        this.name = name;
}
    @Override
    String makeSound() {
        return "Barking woof woof";
    }

    @Override
    public void play() {
        System.out.println("Dog is playing ...... catch " );
    }
}
