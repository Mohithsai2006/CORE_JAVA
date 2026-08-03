package proxydesignpattern.virtualproxy.normalproxy;
/*
 * Virtual Proxy
 *
 * Creates RealImage only when required.
 */

public class ProxyImage implements Image {

    private String fileName;

    private RealImage realImage;

    public ProxyImage(String fileName) {

        this.fileName = fileName;
    }

    @Override
    public void display() {

        if (realImage == null) {

            System.out.println("Real object not created.");
            System.out.println("Creating RealImage...");

            realImage = new RealImage(fileName);
        }

        realImage.display();
    }
}