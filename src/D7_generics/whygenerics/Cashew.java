package D7_generics.whygenerics;

public class Cashew {
    private String origin;
    public Cashew(String origin) {
        this.origin = origin;
    }
    @Override
    public String toString() {
        return origin;
    }
}