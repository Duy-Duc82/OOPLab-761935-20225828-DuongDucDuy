package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add DVD to Store");
        setVisible(true);
    }

    @Override
    protected void addSpecificFields(JPanel panel) {
        panel.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        panel.add(tfDirector);

        panel.add(new JLabel("Length (mins):"));
        tfLength = new JTextField();
        panel.add(tfLength);
    }

    @Override
    protected void handleAdd(String title, String category, float cost) {
        try {
            String director = tfDirector.getText().trim();
            int length = Integer.parseInt(tfLength.getText().trim());

            if (length < 0) {
                JOptionPane.showMessageDialog(this, "Length must be non-negative!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "DVD has been added to store successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            new StoreScreen(store, cart);
            this.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Length format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
