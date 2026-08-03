package proxydesignpattern.remoteproxy.localserver;

import proxydesignpattern.remoteproxy.remoteserver.Weather;

public class Main {
    public static void main(String[] args) {
        Weather w=new WeatherProxy();
        w.getweather();
    }
}
