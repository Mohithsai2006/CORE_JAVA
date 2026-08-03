package D7_generics.whygenerics;

public class Almond {
    private String origin;
    public Almond(String origin) {
        this.origin = origin;
    }
    @Override
    public String toString() {
        return origin;
    }
}