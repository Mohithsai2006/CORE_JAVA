package proxydesignpattern.virtualproxy.reflectiondynamicproxy;

import java.lang.reflect.Proxy;

/*
 * ==========================================================
 * DYNAMIC PROXY DEMO
 * ==========================================================
 */

public class Demo {

    public static void main(String[] args) {

        /*
         * Create Proxy Object.
         *
         * NOTE:
         *
         * We are NOT creating
         * StudentServiceImpl here.
         *
         * The JVM dynamically creates
         * a proxy class in memory.
         */

        StudentService proxy =
                (StudentService) Proxy.newProxyInstance(

                        /*
                         * Class Loader
                         *
                         * Used by JVM to define
                         * the generated proxy class.
                         */

                        StudentService.class.getClassLoader(),

                        /*
                         * Interfaces
                         *
                         * Proxy must implement
                         * StudentService.
                         */

                        new Class<?>[]{
                                StudentService.class
                        },

                        /*
                         * Invocation Handler
                         *
                         * Whenever any method
                         * is called on the proxy,
                         * JVM forwards that call
                         * to invoke().
                         */

                        new VirtualProxyHandler()

                );

        System.out.println("Proxy Created");
        System.out.println();

        /*
         * Client calls addStudent().
         *
         * It DOES NOT directly execute
         * StudentServiceImpl.
         *
         * Flow:
         *
         * proxy.addStudent()
         *
         * ↓
         *
         * invoke(...)
         *
         * ↓
         *
         * method.invoke(...)
         *
         * ↓
         *
         * StudentServiceImpl.addStudent()
         */

        proxy.addStudent();

        System.out.println();

        proxy.deleteStudent();

        System.out.println();

        proxy.updateStudent();
    }
}
