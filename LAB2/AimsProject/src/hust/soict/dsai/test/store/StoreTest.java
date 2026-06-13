package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {

        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger", 90, 250.0);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-fi", "George Lucas", 120, 1000.0);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("One Piece", "Anime", "Oda", 95, 50.555);

        // add
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        store.displayStore();

        // remove
        store.removeDVD(dvd2);

        store.displayStore();
    }
}