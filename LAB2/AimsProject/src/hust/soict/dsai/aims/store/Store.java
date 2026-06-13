package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {

    // ================= ATTRIBUTES =================

    private ArrayList<Media> itemsInStore
            = new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    // ================= ADD =================

    public void addMedia(Media media) {

        if (media == null) return;

        if (!itemsInStore.contains(media)) {

            itemsInStore.add(media);

            System.out.println(
                    media.getTitle()
                    + " has been added to store."
            );

        } else {

            System.out.println(
                    media.getTitle()
                    + " already exists in store."
            );
        }
    }

    // ================= REMOVE =================

    public void removeMedia(Media media) {

        if (itemsInStore.contains(media)) {

            itemsInStore.remove(media);

            System.out.println(
                    media.getTitle()
                    + " has been removed from store."
            );

        } else {

            System.out.println(
                    "Media not found in store!"
            );
        }
    }

    // ================= DISPLAY =================

    public void displayStore() {

        System.out.println(
                "***********************STORE***********************"
        );

        for (int i = 0;
             i < itemsInStore.size();
             i++) {

            System.out.println(
                    (i + 1)
                    + ". "
                    + itemsInStore.get(i)
            );
        }

        System.out.println(
                "***************************************************"
        );
    }

    // ================= SEARCH =================

    public void searchByTitle(String title) {

        boolean found = false;

        for (Media media : itemsInStore) {

            if (media.getTitle()
                    .toLowerCase()
                    .contains(title.toLowerCase())) {

                System.out.println(media);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No match found"
            );
        }
    }

    // ================= FIND MEDIA =================

    public Media findMediaByTitle(String title) {

        for (Media media : itemsInStore) {

            if (media != null
                    && media.getTitle()
                    .equalsIgnoreCase(title)) {

                return media;
            }
        }

        return null;
    }
}