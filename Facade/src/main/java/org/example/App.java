package org.example;

public class App
{
    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();

        // Get random Chuck Norris joke
        try {
            String joke = facade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Chuck Norris Joke: " + joke);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Get recent exchange rates for USD
        try {
            String exchangeRate = facade.getAttributeValueFromJson("https://api.fxratesapi.com/latest", "rates");
            System.out.println("Exchange Rates: " + exchangeRate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
