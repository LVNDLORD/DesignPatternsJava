package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
// to sync methods for observers while accessing shared temperature
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WeatherStation implements Runnable {
    private List<WeatherObserver> observers;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private int temperature;
    private final int MAX_TEMPERATURE = 30;
    private final int MIN_TEMPERATURE = -20;
    private Random random;

    public WeatherStation() {
        observers = new ArrayList<>();
        random = new Random();
        temperature = random.nextInt(MAX_TEMPERATURE - MIN_TEMPERATURE + 1) + MIN_TEMPERATURE;
    }

    public void registerObserver(WeatherObserver observer) {
        lock.writeLock().lock();
        try {
            observers.add(observer);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void removeObserver(WeatherObserver observer) {
        lock.writeLock().lock();
        try {
            observers.remove(observer);
            System.out.println(observer.toString() + " removed");
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void notifyObservers() {
        lock.readLock().lock();
        try {
            for (WeatherObserver observer : observers) {
                observer.update(temperature);
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(random.nextInt(4000) + 1000); // Random 5 sec interval
                temperature += random.nextBoolean() ? 1 : -1; // random temp change
                temperature = Math.min(MAX_TEMPERATURE, Math.max(MIN_TEMPERATURE, temperature)); // Ensure temp within bounds
                notifyObservers();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Simulation ended");
            }
        }

    }
}
