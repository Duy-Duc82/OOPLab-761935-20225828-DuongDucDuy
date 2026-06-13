package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

    // swap sai 
    public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
        DigitalVideoDisc temp = o1;
        o1 = o2;
        o2 = temp;
    }

    // changeTitle
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        dvd.setTitle(title);
    }

    // swap đúng 
    public static void swapCorrect(DigitalVideoDisc o1, DigitalVideoDisc o2) {
        String tempTitle = o1.getTitle();
        o1.setTitle(o2.getTitle());
        o2.setTitle(tempTitle);
    }

    public static void main(String[] args) {

        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // ===== BEFORE =====
        System.out.println("Before swap:");
        System.out.println("Jungle DVD: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD: " + cinderellaDVD.getTitle());

        // ===== SWAP SAI =====
        swap(jungleDVD, cinderellaDVD);

        System.out.println("\nAfter swap (wrong):");
        System.out.println("Jungle DVD: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD: " + cinderellaDVD.getTitle());

        // ===== CHANGE TITLE =====
        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        System.out.println("\nAfter changeTitle:");
        System.out.println("Jungle DVD: " + jungleDVD.getTitle());

        // ===== SWAP ĐÚNG =====
        swapCorrect(jungleDVD, cinderellaDVD);

        System.out.println("\nAfter swapCorrect:");
        System.out.println("Jungle DVD: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD: " + cinderellaDVD.getTitle());
    }
}
