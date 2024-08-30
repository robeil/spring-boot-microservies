public class MyGenerics<T> {
    private T content;

    public void setContent(T content){
        this.content = content;
    }
    public T getContent(){
        return this.content;
    }

    public static void main(String[] args) {
        MyGenerics<String> strGeneric = new MyGenerics<>();
        strGeneric.setContent("Robeil");
        MyGenerics<Integer> intGeneric = new MyGenerics<>();
        intGeneric.setContent(1994);
        System.out.println(strGeneric.getContent());
        System.out.println(intGeneric.getContent());
    }
}
