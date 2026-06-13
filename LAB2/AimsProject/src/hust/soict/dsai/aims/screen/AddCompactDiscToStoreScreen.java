package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;

import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfArtist;
    private JTextField tfTracks;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add CD to Store");
        setVisible(true);
    }

    @Override
    protected void addSpecificFields(JPanel panel) {
        panel.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        panel.add(tfDirector);

        panel.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        panel.add(tfArtist);

        panel.add(new JLabel("Tracks (Title:Length, comma-separated):"));
        tfTracks = new JTextField();
        panel.add(tfTracks);
    }

    @Override
    protected void handleAdd(String title, String category, float cost) {
        try {
            int id = store.getItemsInStore().size() + 1;
            String director = tfDirector.getText().trim();
            String artist = tfArtist.getText().trim();

            CompactDisc cd = new CompactDisc(id, title, category, cost, 0, director, artist);

            String tracksText = tfTracks.getText().trim();
            if (!tracksText.isEmpty()) {
                String[] tracksData = tracksText.split(",");
                for (String trackData : tracksData) {
                    String[] parts = trackData.split(":");
                    if (parts.length == 2) {
                        String trackTitle = parts[0].trim();
                        int trackLength = Integer.parseInt(parts[1].trim());
                        cd.addTrack(new Track(trackTitle, trackLength));
                    }
                }
            }

            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "CD has been added to store successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            new StoreScreen(store, cart);
            this.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Track Length format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
