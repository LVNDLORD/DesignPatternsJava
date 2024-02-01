package app;

import factories.AFactory;
import factories.BFactory;
import factories.UIFactory;


import java.util.Scanner;

public class Main {

    public static Application configureApplication() {
        Application app;
        UIFactory factory = null;
        Scanner scanner = new Scanner(System.in);

        while (factory == null) {
            System.out.println("Pick UIFactory style for elements to proceed, A or B");
            String userInput = scanner.next();

            switch (userInput.toUpperCase()) {
                case "A":
                    factory = new AFactory();
                    break;
                case "B":
                    factory = new BFactory();
                    break;
                default:
                    System.out.println("Error while selecting the UIFactory. Try again with correct value.");
                    break;
            }
        }
        app = new Application(factory);
        return app;

    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.display();

    }
}
