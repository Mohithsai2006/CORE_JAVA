package D7_generics.wildcardsandbounding;
import java.util.ArrayList;
import java.util.List;
public class Demo {
    /*
     * ====================================================
     * 1. Upper Bound
     * ====================================================
     *
     * T must be Number
     * or subclass of Number.
     */
    static <T extends Number> void display(T value){
        // Since every Number has doubleValue(),
        // compiler allows this.
        System.out.println(value.doubleValue());
    }
    /*
     * ====================================================
     * 2. Custom Upper Bound
     * ====================================================
     *
     * T must be Animal
     * or subclass of Animal.
     */
    static <T extends Animal> void animalSound(T animal){
        animal.sound();
    }
    /*
     * ====================================================
     * 3. Unbounded Wildcard
     * ====================================================
     *
     * Accepts ANY List.
     */
    static void print(List<?> list){
        /*
         * We don't know
         * what datatype is inside.
         *
         * Safe to READ.
         */
        for(Object obj:list){

            System.out.println(obj);

        }
        // list.add(10);
        // Compile Error
    }
    /*
     * ====================================================
     * 4. Upper Wildcard
     * ====================================================
     *
     * Accepts
     *
     * List<Integer>
     * List<Double>
     * List<Float>
     * ...
     */
    static void sum(List<? extends Number> list){
        double total=0;
        /*
         * Safe to READ.
         */
        for(Number n:list){

            total+=n.doubleValue();

        }
        System.out.println(total);
        /*
         * Cannot safely add.
         */
        // list.add(100);
    }
    /*
     * ====================================================
     * 5. Lower Wildcard
     * ====================================================
     *
     * Accepts
     *
     * List<Integer>
     * List<Number>
     * List<Object>
     */
    static void addNumbers(List<? super Integer> list){
        /*
         * Safe to ADD Integer.
         */
        list.add(100);
        list.add(200);
        /*
         * Reading returns Object.
         */
        Object obj=list.get(0);
        System.out.println(obj);
    }
    public static void main(String[] args) {
        /*
         * ========= Upper Bound =========
         */
        display(100);
        display(25.5);
        // display("Java");
        // Compile Error
        /*
         * ========= Custom Upper Bound =========
         */
        animalSound(new Dog());
        animalSound(new Cat());
        // animalSound("Hello");
        // Compile Error
        /*
         * ========= Unbounded Wildcard =========
         */
        List<String> names=new ArrayList<>();
        names.add("Java");
        names.add("Python");
        print(names);
        List<Integer> nums=new ArrayList<>();
        nums.add(10);
        nums.add(20);
        print(nums);
        /*
         * ========= Upper Wildcard =========
         */
        sum(nums);
        /*
         * ========= Lower Wildcard =========
         */
        List<Number> values=new ArrayList<>();
        addNumbers(values);
        System.out.println(values);
    }
}
