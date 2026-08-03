package D5_Immutable_Class;
//Immutable Class

// It is a class where the state of the object cannot be changed once it is created.
//
// Once the fields of an Object are assigned some values, it can't be updated.
//
//It is a Read-Only class.

//Rules of Immutability in a Class
//
//. No setter methods inside the class.
//
//· Fields must be private.
//
//· Initialization of Fields using Constructor
//
//· Fields must be final
//
//. Class must be final
//
//. In case of a mutable field, copy must be returned instead of original reference.

public final class Immutable {// we need to make the class final so that they cant be inherited

    private final int age; // fields must be private so that they cant be changed by accessing them
    private final String name;// we should add final so that once initialized via constructor they cant be re intialized
                                // even by its own methods.
    private final Ranking ranking;

    Immutable(int age, String name, Ranking rank1){
        this.age = age;

        this.name = name;
         //this.ranking = rank1; //we should not do it like this for mutable objects
        // create a deep copy and assign it to final field
        this.ranking = new Ranking(rank1.rank);
    }
    void print(){
        System.out.println("age: "+this.age+", name: "+this.name+", rank: "+this.ranking.rank);
    }


    public String getName() {
        return name;// String is immutable
    }

    public int getAge() {
        return age;
    }

    public Ranking getRanking() {
        //return ranking; //we should not return the direct reference like this
        return new Ranking(ranking.rank);
    }
    //void setAge(){
    //        this.age =100; // this is not possible because fields are final
    //    }
    // our class is still not immutable because rank (which is a member) is mutable
    // always try to use structures that are immutable in immutable classes
    // if need to use mutable objects, then ensure we only send copy of the said mutable object,
    // so that thay cant change fields of immutable class via mutable object


}

//To maintain immutability when dealing with mutable objects in Java, use defensive copying.
// Never store or return direct references to mutable internal state.
// Instead, create and manipulate independent copies in both the constructor and getter methods.
// How to Implement Defensive CopyingIn the Constructor:
// When accepting a mutable object, do not assign the reference directly to your final field.
// Create a new independent copy (deep copy) of the passed object and store that instead.
// In the Getters: When returning a mutable field, do not return the actual reference.
// Return a new copy of the object so the caller cannot modify the internal state.
