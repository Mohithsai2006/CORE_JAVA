package D7_methodreferences.constructorreference;
@FunctionalInterface
public interface Creator<T>{
    T create(String name);
}
