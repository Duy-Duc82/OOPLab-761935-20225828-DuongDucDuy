package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    private static int nbDigitalVideoDiscs = 0;

    // ================= CONSTRUCTOR =================

    public DigitalVideoDisc(String title) {

        super(
                ++nbDigitalVideoDiscs,
                title,
                "",
                0,
                0,
                ""
        );
    }

    public DigitalVideoDisc(String category,
                            String title,
                            double cost) {

        super(
                ++nbDigitalVideoDiscs,
                title,
                category,
                (float) cost,
                0,
                ""
        );
    }

    public DigitalVideoDisc(String director,
                            String category,
                            String title,
                            double cost) {

        super(
                ++nbDigitalVideoDiscs,
                title,
                category,
                (float) cost,
                0,
                director
        );
    }

    public DigitalVideoDisc(String title,
                            String category,
                            String director,
                            int length,
                            double cost) {

        super(
                ++nbDigitalVideoDiscs,
                title,
                category,
                (float) cost,
                length,
                director
        );
    }

    // ================= METHODS =================

    public boolean isMatch(String title) {

        return getTitle() != null
                && getTitle().toLowerCase()
                .contains(title.toLowerCase());
    }

    @Override
    public void play() throws PlayerException {

        if (getLength() <= 0) {
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }

        System.out.println(
                "Playing DVD: " + getTitle()
        );

        System.out.println(
                "DVD length: " + getLength()
        );
    }

    @Override
    public String toString() {

        return "DVD - "
                + getTitle() + " - "
                + getCategory() + " - "
                + getDirector() + " - "
                + getLength() + ": "
                + getCost() + "$";
    }
}