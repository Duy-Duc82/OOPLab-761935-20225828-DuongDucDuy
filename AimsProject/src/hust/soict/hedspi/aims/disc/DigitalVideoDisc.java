package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc extends hust.soict.hedspi.aims.media.DigitalVideoDisc {
    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super(category, title, cost);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(director, category, title, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
}
