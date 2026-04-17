package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        String title1 = media1.getTitle() == null ? "" : media1.getTitle();
        String title2 = media2.getTitle() == null ? "" : media2.getTitle();

        int titleCompare = title1.compareToIgnoreCase(title2);
        if (titleCompare != 0) {
            return titleCompare;
        }

        return Float.compare(media1.getCost(), media2.getCost());
    }
}
