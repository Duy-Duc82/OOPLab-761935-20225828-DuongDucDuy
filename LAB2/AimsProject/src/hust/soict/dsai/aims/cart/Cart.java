package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import hust.soict.dsai.aims.exception.LimitExceededException;

import hust.soict.dsai.aims.media.Media;

public class Cart {

    // ================= ATTRIBUTES =================

    private ObservableList<Media> itemsOrdered
            = FXCollections.observableArrayList();

    // ================= GET ITEMS =================

    public ObservableList<Media> getItemsOrdered() {

        return itemsOrdered;
    }

    // ================= ADD =================

    public static final int MAX_NUMBERS_ORDERED = 20;

    public void addMedia(Media media) throws LimitExceededException {

        if (media == null) return;

        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: The number of media has reached its limit (" + MAX_NUMBERS_ORDERED + ")");
        }

        if (!itemsOrdered.contains(media)) {

            itemsOrdered.add(media);

            System.out.println(
                    media.getTitle()
                    + " has been added."
            );

        } else {

            System.out.println(
                    media.getTitle()
                    + " already exists!"
            );
        }
    }

    // ================= OVERLOAD VARARGS =================

    public void addMedia(Media... mediaList) throws LimitExceededException {

        for (Media media : mediaList) {

            addMedia(media);
        }
    }

    // ================= OVERLOAD 2 PARAMS =================

    public void addMedia(Media media1,
                         Media media2) throws LimitExceededException {

        addMedia(media1);
        addMedia(media2);
    }

    // ================= REMOVE =================

    public void removeMedia(Media media) {

        if (itemsOrdered.contains(media)) {

            itemsOrdered.remove(media);

            System.out.println(
                    media.getTitle()
                    + " has been removed."
            );

        } else {

            System.out.println(
                    "Media not found!"
            );
        }
    }

    // ================= TOTAL COST =================

    public float totalCost() {

        float sum = 0;

        for (Media media : itemsOrdered) {

            sum += media.getCost();
        }

        return sum;
    }

    // ================= DISPLAY CART =================

    public void displayCart() {

        System.out.println(
                "***********************CART***********************"
        );

        System.out.println("Ordered Items:");

        for (int i = 0;
             i < itemsOrdered.size();
             i++) {

            System.out.println(
                    (i + 1)
                    + ". "
                    + itemsOrdered.get(i)
            );
        }

        System.out.printf(
                "Total cost: %.2f\n",
                totalCost()
        );

        System.out.println(
                "***************************************************"
        );
    }

    // ================= SEARCH BY ID =================

    public void searchById(int id) {

        for (Media media : itemsOrdered) {

            if (media.getId() == id) {

                System.out.println(media);

                return;
            }
        }

        System.out.println("No match found");
    }

    // ================= SEARCH BY TITLE =================

    public void searchByTitle(String title) {

        boolean found = false;

        for (Media media : itemsOrdered) {

            if (media.getTitle()
                    .toLowerCase()
                    .contains(title.toLowerCase())) {

                System.out.println(media);

                found = true;
            }
        }

        if (!found) {

            System.out.println("No match found");
        }
    }
        public void clear() {

        itemsOrdered.clear();

        System.out.println(
                "The cart has been cleared."
        );
    }
}