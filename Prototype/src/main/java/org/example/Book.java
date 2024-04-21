package org.example;

public class Book implements Cloneable {
    private String author;
    private String title;
    private String genre;
    private int publicationYear;

    public Book(String author, String title, String genre, int publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    @Override
    protected Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
