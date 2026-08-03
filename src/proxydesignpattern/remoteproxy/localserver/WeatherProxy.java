package proxydesignpattern.remoteproxy.localserver;

import proxydesignpattern.remoteproxy.remoteserver.Weather;
import proxydesignpattern.remoteproxy.remoteserver.WeatherService;

public class WeatherProxy implements Weather {
    private Weather weather;
    public WeatherProxy(){
        this.weather=new WeatherService();
    }
    @Override
    public String getweather(){
        authenticate();
        openconection();
        return  sendhttprequest();
    }
    private void authenticate(){
        System.out.println("Authenticating ....");
    }
    private void openconection(){
        System.out.println("Openinig connection.....");
    }
    private String sendhttprequest(){
        System.out.println("Sending request");
       return weather.getweather();
    }
}
