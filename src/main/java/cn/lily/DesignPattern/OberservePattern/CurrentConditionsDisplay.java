package cn.lily.DesignPattern.OberservePattern;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temprature;
    private float humidity;

    // private Subject weatherDate;
    public CurrentConditionsDisplay(Observable observable) {
       /* this.weatherDate = weatherDate;
        weatherDate.registerObserver(this);*/
        this.observable = observable;
        observable.addObserver(this);
    }

   /* @Override
    public void update(float temp, float humidity, float pressure) {
        this.temprature = temp;
        this.humidity = humidity;
        display();
    }*/

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData1) {
            WeatherData1 weatherData1 = (WeatherData1) obs;
            this.temprature = weatherData1.getTemprature();
            this.humidity = weatherData1.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temprature + "F degrees and " + humidity + "% humidity");
    }
}
