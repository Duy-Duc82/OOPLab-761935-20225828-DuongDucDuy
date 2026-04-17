package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super(assignId(), title, null, 0.0f);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super(assignId(), title, category, cost);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(assignId(), title, category, director, 0, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(assignId(), title, category, director, length, cost);
    }

    private static int assignId() {
        nbDigitalVideoDiscs++;
        return nbDigitalVideoDiscs;
    }

    public void setTitle(String title) {
        super.setTitle(title);
    }

    public boolean isMatch(String title) {
        if (getTitle() == null || title == null) {
            return false;
        }

        return getTitle().toLowerCase().contains(title.trim().toLowerCase());
    }

    @Override
    public String toString() {
        return String.format(
                "DVD - %d - %s - %s - %s - %d: %.2f $",
            getId(),
            getTitle(),
            getCategory(),
            getDirector(),
            getLength(),
            getCost()
        );
    }

    @Override
    public void play() {
        if (getLength() <= 0) {
            System.out.println("ERROR: DVD length is non-positive");
            return;
        }

        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
}

