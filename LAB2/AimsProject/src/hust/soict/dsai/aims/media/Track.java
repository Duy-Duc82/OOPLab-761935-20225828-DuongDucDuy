package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {

    private String title;
    private int length;

    public Track(String title, int length) {

        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {

        if (length <= 0) {
            System.err.println("ERROR: Track length is non-positive!");
            throw new PlayerException("ERROR: Track length is non-positive!");
        }

        System.out.println(
                "Playing Track: " + title
        );

        System.out.println(
                "Track length: " + length
        );
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Track) {

            Track track = (Track) obj;

            return this.title.equals(track.title)
                    && this.length == track.length;
        }

        return false;
    }
}