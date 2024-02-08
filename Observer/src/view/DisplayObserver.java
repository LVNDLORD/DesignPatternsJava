package view;

import model.WeatherObserver;

public class DisplayObserver implements WeatherObserver {
    private String name;

    public DisplayObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " - Current temperature: " + temperature + "°C");
    }

    @Override
    public String toString() {
        return name;
    }
}
