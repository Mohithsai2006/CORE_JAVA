package proxydesignpattern.remoteproxy.remoteserver;

public class WeatherService implements  Weather{
    @Override
   public  String getweather(){
        System.out.println("Fetching the weather data");
        return "35 degree celsius";
    }
}
