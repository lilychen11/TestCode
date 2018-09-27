package cn.lily.DesignPattern.OberservePattern;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData1 weatherData = new WeatherData1();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
