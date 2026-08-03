package proxydesignpattern.virtualproxy.reflectiondynamicproxy;

/*
        * ==========================================================
        * SUBJECT INTERFACE
 * ==========================================================
         *
         * Both the Real Object and the Proxy Object
 * will implement this interface.
        *
        * The client always communicates through
 * this interface.
        */

public interface StudentService {

    void addStudent();

    void deleteStudent();

    void updateStudent();
}