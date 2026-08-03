package proxydesignpattern.virtualproxy.normalproxy;


/*
 * Expensive Object
 */

public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {

        this.fileName = fileName;

        loadImage(); //expensive operation
    }

    private void loadImage() {

        System.out.println("Loading image from disk : " + fileName);
    }

    @Override
    public void display() {

        System.out.println("Displaying : " + fileName);
    }
}