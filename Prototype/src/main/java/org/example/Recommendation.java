package org.example;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void changeTargetAudience(String newTargetAudience) {
        this.targetAudience = newTargetAudience;
    }

    @Override
    protected Recommendation clone() {
        Recommendation clonedRecommendation = new Recommendation(this.targetAudience);
        for (Book book : this.books) {
            clonedRecommendation.addBook(book.clone());
        }
        return clonedRecommendation;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
