package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    public StoreScreen(Store store) {
        this(store, new Cart());
    }

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookToStoreScreen(store, cart);
                dispose();
            }
        });
        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCompactDiscToStoreScreen(store, cart);
                dispose();
            }
        });
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDigitalVideoDiscToStoreScreen(store, cart);
                dispose();
            }
        });
        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);

        menu.add(smUpdateStore);
        
        JMenuItem viewStoreMenu = new JMenuItem("View store");
        viewStoreMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreScreen(store, cart);
                dispose();
            }
        });
        menu.add(viewStoreMenu);
        
        JMenuItem viewCartMenu = new JMenuItem("View cart");
        viewCartMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cart);
                dispose();
            }
        });
        menu.add(viewCartMenu);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton viewCart = new JButton("View cart");
        viewCart.setPreferredSize(new Dimension(100, 50));
        viewCart.setMaximumSize(new Dimension(100, 50));
        viewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cart);
                dispose();
            }
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(viewCart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        int limit = Math.min(mediaInStore.size(), 9);
        for (int i = 0; i < limit; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        // Populate sample media items in store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Animation", "The Lion King", 250.0);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Sci-fi", "Star Wars", 1000.0);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Anime", "Dragon Ball Z", 500.5);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Anime", "One Piece", 50.55);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Anime", "Doraemon", 345.5);
        
        Book book1 = new Book(6, "Java Programming", "Programming", 20.0f);
        book1.addAuthor("Deitel");
        
        Book book2 = new Book(7, "Clean Code", "Software Engineering", 30.0f);
        book2.addAuthor("Robert C. Martin");

        CompactDisc cd1 = new CompactDisc(8, "Thriller", "Pop", 15.0f, 42, "Quincy Jones", "Michael Jackson");
        cd1.addTrack(new Track("Wanna Be Startin' Somethin'", 6));
        cd1.addTrack(new Track("Thriller", 6));
        
        CompactDisc cd2 = new CompactDisc(9, "Back in Black", "Rock", 18.0f, 42, "Robert John Lange", "AC/DC");
        cd2.addTrack(new Track("Hells Bells", 5));
        cd2.addTrack(new Track("Back in Black", 4));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(cd1);
        store.addMedia(cd2);

        new StoreScreen(store, cart);
    }
}
