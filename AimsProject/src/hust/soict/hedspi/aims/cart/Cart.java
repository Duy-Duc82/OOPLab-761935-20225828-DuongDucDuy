package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private List<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (media == null) {
            return;
        }

        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        addMedia(disc);
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (dvdList == null) {
            return;
        }

        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        removeMedia(disc);
    }

    public void removeMedia(Media media) {
        if (media == null) {
            return;
        }

        if (!itemsOrdered.remove(media)) {
            System.out.println("The media was not found");
            return;
        }

        System.out.println("The media has been removed");
    }

    public float totalCost() {
        float totalCost = 0.0f;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i));
        }

        System.out.printf("Total cost: %.2f $%n", totalCost());
        System.out.println("***************************************************");
    }

    public void search(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Result: " + media);
                return;
            }
        }

        System.out.println("No match is found for ID: " + id);
    }

    public void search(String title) {
        if (title == null) {
            System.out.println("No match is found for title: null");
            return;
        }

        for (Media media : itemsOrdered) {
            String mediaTitle = media.getTitle();
            if (mediaTitle != null && mediaTitle.toLowerCase().contains(title.trim().toLowerCase())) {
                System.out.println("Result: " + media);
                return;
            }
        }

        System.out.println("No match is found for title: " + title);
    }

    public List<Media> getItemsOrdered() {
        return new ArrayList<>(itemsOrdered);
    }

    public Media findById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public Media findByTitle(String title) {
        if (title == null) {
            return null;
        }

        for (Media media : itemsOrdered) {
            String mediaTitle = media.getTitle();
            if (mediaTitle != null && mediaTitle.toLowerCase().contains(title.trim().toLowerCase())) {
                return media;
            }
        }
        return null;
    }

    public void sort(Comparator<Media> comparator) {
        Collections.sort(itemsOrdered, comparator);
    }

    public void playMedia(int id) {
        Media media = findById(id);
        if (media == null) {
            System.out.println("No media found with id: " + id);
            return;
        }

        if (media instanceof Playable) {
            ((Playable) media).play();
            return;
        }

        System.out.println("Selected media is not playable");
    }

    public void placeOrder() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Your cart is empty");
            return;
        }

        itemsOrdered.clear();
        System.out.println("Order is created. The cart is now empty.");
    }
}

