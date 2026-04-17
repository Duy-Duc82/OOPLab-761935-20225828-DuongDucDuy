package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;

public class MediaPolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<>();

        Book book = new Book(1, "Clean Code", "Programming", 29.99f);
        book.addAuthor("Robert C. Martin");

        DigitalVideoDisc dvd = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 24.99f);

        CompactDisc cd = new CompactDisc(3, "Greatest Hits", "Music", 19.50f, "Various Artists");
        cd.addTrack(new Track("Track One", 180));
        cd.addTrack(new Track("Track Two", 210));

        mediaList.add(book);
        mediaList.add(dvd);
        mediaList.add(cd);

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
