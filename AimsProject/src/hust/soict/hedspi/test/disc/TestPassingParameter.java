package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungle = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderella = new DigitalVideoDisc("Cinderella");

        System.out.println("Before swap:");
        System.out.println("Jungle title: " + jungle.getTitle());
        System.out.println("Cinderella title: " + cinderella.getTitle());

        swap(jungle, cinderella);

        System.out.println("After swap:");
        System.out.println("Jungle title: " + jungle.getTitle());
        System.out.println("Cinderella title: " + cinderella.getTitle());

        changeTitle(jungle, "The Jungle Book");

        System.out.println("After changeTitle:");
        System.out.println("Jungle title: " + jungle.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}

