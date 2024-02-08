import model.WeatherStation;
import view.DisplayObserver;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        DisplayObserver observer1 = new DisplayObserver("Observer 1");
        DisplayObserver observer2 = new DisplayObserver("Observer 2");
        DisplayObserver observer3 = new DisplayObserver("Observer 3");

        weatherStation.registerObserver(observer1);
        weatherStation.registerObserver(observer2);
        weatherStation.registerObserver(observer3);

        Thread weatherThread = new Thread(weatherStation);
        weatherThread.start();

        try {
            //simulation runs for 10s
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        weatherStation.removeObserver(observer1);

        try {
            // continue simulation running for another 10s
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop simulation
        weatherThread.interrupt();
    }
}
