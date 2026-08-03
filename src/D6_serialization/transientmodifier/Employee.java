package D6_serialization.transientmodifier;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;

    String name;

    // Will NOT be serialized
    transient String password;

    // Belongs to class, not object
    static String company = "OpenAI";

    public Employee(int id, String name, String password) {

        this.id = id;
        this.name = name;
        this.password = password;
    }
}
