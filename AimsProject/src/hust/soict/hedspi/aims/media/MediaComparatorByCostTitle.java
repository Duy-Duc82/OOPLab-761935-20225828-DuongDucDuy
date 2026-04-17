package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        int costCompare = Float.compare(media1.getCost(), media2.getCost());
        if (costCompare != 0) {
            return costCompare;
        }

        String title1 = media1.getTitle() == null ? "" : media1.getTitle();
        String title2 = media2.getTitle() == null ? "" : media2.getTitle();
        return title1.compareToIgnoreCase(title2);
    }
}
