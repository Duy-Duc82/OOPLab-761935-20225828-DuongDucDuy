package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.JFrame;
import java.io.IOException;

public class CartScreen extends JFrame {
    private Store store;
    private Cart cart;

    public CartScreen(Cart cart) {
        this(new Store(), cart);
    }

    public CartScreen(Store store, Cart cart) {
        super();
        this.store = store;
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass()
                            .getResource("cart.fxml"));
                    CartScreenController controller = new CartScreenController(store, cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Animation", "The Lion King", 250.0);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Sci-fi", "Star Wars", 1000.0);
        
        Book book1 = new Book(3, "Java Programming", "Programming", 20.0f);
        book1.addAuthor("Deitel");

        CompactDisc cd1 = new CompactDisc(4, "Thriller", "Pop", 15.0f, 42, "Quincy Jones", "Michael Jackson");
        cd1.addTrack(new Track("Thriller", 6));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(cd1);

        try {
            cart.addMedia(dvd1);
            cart.addMedia(dvd2);
            cart.addMedia(book1);
            cart.addMedia(cd1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new CartScreen(store, cart);
    }
}
