package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;

import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add Book to Store");
        setVisible(true);
    }

    @Override
    protected void addSpecificFields(JPanel panel) {
        panel.add(new JLabel("Authors (comma-separated):"));
        tfAuthors = new JTextField();
        panel.add(tfAuthors);
    }

    @Override
    protected void handleAdd(String title, String category, float cost) {
        int id = store.getItemsInStore().size() + 1;
        Book book = new Book(id, title, category, cost);

        String authorsText = tfAuthors.getText().trim();
        if (!authorsText.isEmpty()) {
            String[] authorNames = authorsText.split(",");
            for (String author : authorNames) {
                book.addAuthor(author.trim());
            }
        }

        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Book has been added to store successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        new StoreScreen(store, cart);
        this.dispose();
    }
}
