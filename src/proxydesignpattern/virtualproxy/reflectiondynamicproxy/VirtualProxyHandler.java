package proxydesignpattern.virtualproxy.reflectiondynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/*
 * ==========================================================
 * INVOCATION HANDLER
 * ==========================================================
 *
 * This class contains the proxy logic.
 *
 * IMPORTANT:
 *
 * We are NOT creating the proxy object here.
 *
 * The JVM creates the proxy object automatically.
 *
 * Whenever any method is called on the proxy,
 * the JVM automatically calls invoke().
 */
public class VirtualProxyHandler implements InvocationHandler {
    /*
     * Reference to the actual object.
     *
     * Initially it is null.
     *
     * We will create it only when
     * the first method is called.
     */
    private StudentService realObject;
    /*
     * This method belongs to InvocationHandler.
     *
     * Since we implement InvocationHandler,
     * we must override invoke().
     *
     * We NEVER call invoke() ourselves.
     *
     * The JVM automatically calls it whenever
     * a method is invoked on the proxy object.
     */
    @Override
    public Object invoke(
            Object proxy,
            Method method,
            Object[] args) throws Throwable {
        /*
         * Lazy Loading
         *
         * If the real object doesn't exist,
         * create it now.
         */
        if (realObject == null) {
            System.out.println("Creating Real Object...");
            realObject = new StudentServiceImpl();
        }
        /*
         * Code before actual method execution.
         *
         * This is where logging,
         * authentication,
         * transactions,
         * security etc.
         * can be written.
         */
        System.out.println("Before Method : " + method.getName());
        /*
         * Reflection
         *
         * Execute whichever method
         * the client actually called.
         *
         * If client called
         * proxy.addStudent()
         *
         * Reflection executes
         * realObject.addStudent()
         *
         * If client called
         * proxy.deleteStudent()
         *
         * Reflection executes
         * realObject.deleteStudent()
         */
        Object result = method.invoke(realObject, args);
        /*
         * Code after actual method execution.
         */
        System.out.println("After Method : " + method.getName());
        /*
         * Return whatever the original method returned.
         *
         * In this example,
         * methods are void,
         * so result will be null.
         */
        return result;
    }
}