package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors;

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        this.authors = new ArrayList<>();
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
        if (authorName == null || authorName.isBlank()) {
            return;
        }

        if (authors.contains(authorName)) {
            System.out.println("Author already exists");
            return;
        }

        authors.add(authorName);
        System.out.println("Author has been added");
    }

    public void removeAuthor(String authorName) {
        if (authorName == null || authorName.isBlank()) {
            return;
        }

        if (!authors.contains(authorName)) {
            System.out.println("Author does not exist");
            return;
        }

        authors.remove(authorName);
        System.out.println("Author has been removed");
    }

    @Override
    public String toString() {
        return String.format("Book - %d - %s - %s: %.2f $", getId(), getTitle(), getCategory(), getCost());
    }
}
