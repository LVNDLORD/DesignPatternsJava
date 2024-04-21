package org.example;

public class App {
    public static void main(String[] args) {
        // Create some sample books
        Book book1 = new Book("Dr. Anna Lembke", "Dopamine nation", "non-fiction", 2021);
        Book book2 = new Book("Philip K. Dick", "The Man in the High Castle", "science-fiction", 1962);

        Recommendation recommendation1 = new Recommendation("Young Adults");
        recommendation1.addBook(book1);
        recommendation1.addBook(book2);

        Recommendation recommendation2 = recommendation1.clone();
        recommendation2.changeTargetAudience("Middle-old");
        recommendation2.removeBook(book2);

        System.out.println("Original Recommendation:");
        printRecommendation(recommendation1);
        System.out.println("\nCloned Recommendation:");
        printRecommendation(recommendation2);
    }

    public static void printRecommendation(Recommendation recommendation) {
        System.out.println("Target Audience: " + recommendation.getTargetAudience());
        System.out.println("Books:");
        for (Book book : recommendation.getBooks()) {
            System.out.println("- Title: " + book.getTitle());
            System.out.println("  Author: " + book.getAuthor());
            System.out.println("  Genre: " + book.getGenre());
            System.out.println("  Publication Year: " + book.getPublicationYear());
        }
    }
}
