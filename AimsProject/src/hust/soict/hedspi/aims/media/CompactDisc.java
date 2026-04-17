package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public CompactDisc(int id, String title, String category, String director, int length, float cost, String artist) {
        super(id, title, category, director, length, cost);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void addTrack(Track track) {
        if (track == null) {
            return;
        }

        if (tracks.contains(track)) {
            System.out.println("The track already exists");
            return;
        }

        tracks.add(track);
        System.out.println("The track has been added");
    }

    public void removeTrack(Track track) {
        if (track == null) {
            return;
        }

        if (!tracks.contains(track)) {
            System.out.println("The track does not exist");
            return;
        }

        tracks.remove(track);
        System.out.println("The track has been removed");
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public String toString() {
        return String.format("CD - %d - %s - %s - %s - %d: %.2f $",
                getId(), getTitle(), getCategory(), artist, getLength(), getCost());
    }

    @Override
    public void play() {
        if (tracks.isEmpty()) {
            System.out.println("No tracks in CD: " + getTitle());
            return;
        }

        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD length: " + getLength());
        for (Track track : tracks) {
            track.play();
        }
    }
}
