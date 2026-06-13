package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {

    public static void main(String[] args) throws hust.soict.dsai.aims.exception.PlayerException, hust.soict.dsai.aims.exception.LimitExceededException {

        // ================= CREATE DVD =================

        DigitalVideoDisc dvd1 =
                new DigitalVideoDisc(
                        "Animation",
                        "The Lion King",
                        250.0
                );

        DigitalVideoDisc dvd2 =
                new DigitalVideoDisc(
                        "Sci-fi",
                        "Star Wars",
                        1000.0
                );

        DigitalVideoDisc dvd3 =
                new DigitalVideoDisc(
                        "Anime",
                        "Dragon Ball Z",
                        500.5
                );

        DigitalVideoDisc dvd4 =
                new DigitalVideoDisc(
                        "Anime",
                        "One Piece",
                        50.555
                );

        DigitalVideoDisc dvd5 =
                new DigitalVideoDisc(
                        "Anime",
                        "Doraemon",
                        345.5438
                );

        // ================= CREATE CART =================

        Cart cart = new Cart();

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(dvd4);
        cart.addMedia(dvd5);

        // test overloading
        cart.addMedia(dvd1, dvd2);

        // ================= REMOVE =================

        cart.removeMedia(dvd1);
        cart.removeMedia(dvd3);

        // ================= DISPLAY =================

        cart.displayCart();

        // ================= SEARCH =================

        cart.searchByTitle("star");
        cart.searchById(2);

        // ================= BOOK =================

        Book book1 = new Book(
                1,
                "Java",
                "Programming",
                20f
        );

        book1.addAuthor("Nam");

        System.out.println(book1);

        // ================= PLAY DVD =================

        DigitalVideoDisc dvd =
                new DigitalVideoDisc(
                        "Batman",
                        "Action",
                        "Nolan",
                        120,
                        20
                );

        dvd.play();

        // ================= TRACK =================

        Track track1 = new Track(
                "Track 1",
                5
        );

        track1.play();

        // ================= TRACK EQUALS =================

        Track t1 = new Track("Hello", 5);
        Track t2 = new Track("Hello", 5);

        System.out.println(t1.equals(t2));

        // ================= COMPACT DISC =================

        CompactDisc cd = new CompactDisc(
                1,
                "My CD",
                "Music",
                20f,
                0,
                "Director",
                "Artist"
        );

        cd.addTrack(t1);
        cd.addTrack(track1);

        cd.play();

        // ================= STORE =================

        Store store = new Store();

        store.addMedia(dvd1);
        store.addMedia(book1);
        store.addMedia(dvd2);
        store.addMedia(cd);

        store.displayStore();

        store.searchByTitle("java");

        // ================= POLYMORPHISM =================

        System.out.println(
                "\n===== POLYMORPHISM TEST ====="
        );

        ArrayList<Media> mediae =
                new ArrayList<Media>();

        Book polyBook = new Book(
                2,
                "Clean Code",
                "Programming",
                30f
        );

        DigitalVideoDisc polyDVD =
                new DigitalVideoDisc(
                        "Action",
                        "Avengers",
                        25.0
                );

        CompactDisc polyCD =
                new CompactDisc(
                        3,
                        "Music CD",
                        "Music",
                        20f,
                        0,
                        "Director",
                        "Artist"
        );

        mediae.add(polyBook);
        mediae.add(polyDVD);
        mediae.add(polyCD);

        for (Media media : mediae) {

            System.out.println(media);
        }

        // ================= SORT TEST =================

        System.out.println(
                "\n===== SORT BY TITLE THEN COST ====="
        );

        Collections.sort(
                cart.getItemsOrdered(),
                Media.COMPARE_BY_TITLE_COST
        );

        cart.displayCart();

        System.out.println(
                "\n===== SORT BY COST THEN TITLE ====="
        );

        Collections.sort(
                cart.getItemsOrdered(),
                Media.COMPARE_BY_COST_TITLE
        );

        cart.displayCart();

        // ================= CONSOLE MENU =================

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {

            showMenu();

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    int storeChoice;

                    do {

                        System.out.println(
                                "\n===== STORE ====="
                        );

                        store.displayStore();

                        storeMenu();

                        storeChoice =
                                scanner.nextInt();

                        switch (storeChoice) {

                            // ================= SEE DETAILS =================

                            case 1:

                                scanner.nextLine();

                                System.out.print(
                                        "Enter media title: "
                                );

                                String detailTitle =
                                        scanner.nextLine();

                                Media foundMedia =
                                        store.findMediaByTitle(
                                                detailTitle
                                        );

                                if (foundMedia != null) {

                                    System.out.println(
                                            "\n===== MEDIA DETAILS ====="
                                    );

                                    System.out.println(
                                            foundMedia
                                    );

                                    int detailChoice;

                                    do {

                                        mediaDetailsMenu();

                                        detailChoice =
                                                scanner.nextInt();

                                        switch (detailChoice) {

                                            case 1:

                                                cart.addMedia(
                                                        foundMedia
                                                );

                                                break;

                                            case 2:

                                                if (foundMedia
                                                        instanceof DigitalVideoDisc) {

                                                    ((DigitalVideoDisc)
                                                            foundMedia).play();

                                                } else if (foundMedia
                                                        instanceof CompactDisc) {

                                                    ((CompactDisc)
                                                            foundMedia).play();

                                                } else {

                                                    System.out.println(
                                                            "Cannot play this media"
                                                    );
                                                }

                                                break;

                                            case 0:

                                                break;

                                            default:

                                                System.out.println(
                                                        "Invalid choice!"
                                                );
                                        }

                                    } while (detailChoice != 0);

                                } else {

                                    System.out.println(
                                            "Media not found!"
                                    );
                                }

                                break;

                            // ================= ADD TO CART =================

                            case 2:

                                scanner.nextLine();

                                System.out.print(
                                        "Enter media title: "
                                );

                                String addTitle =
                                        scanner.nextLine();

                                Media addMedia =
                                        store.findMediaByTitle(
                                                addTitle
                                        );

                                if (addMedia != null) {

                                    cart.addMedia(addMedia);

                                } else {

                                    System.out.println(
                                            "Media not found!"
                                    );
                                }

                                break;

                            // ================= PLAY MEDIA =================

                            case 3:

                                scanner.nextLine();

                                System.out.print(
                                        "Enter media title: "
                                );

                                String playTitle =
                                        scanner.nextLine();

                                Media playMedia =
                                        store.findMediaByTitle(
                                                playTitle
                                        );

                                if (playMedia != null) {

                                    if (playMedia
                                            instanceof DigitalVideoDisc) {

                                        ((DigitalVideoDisc)
                                                playMedia).play();

                                    } else if (playMedia
                                            instanceof CompactDisc) {

                                        ((CompactDisc)
                                                playMedia).play();

                                    } else {

                                        System.out.println(
                                                "Cannot play this media"
                                        );
                                    }

                                } else {

                                    System.out.println(
                                            "Media not found!"
                                    );
                                }

                                break;

                            // ================= SEE CART =================

                            case 4:

                                cart.displayCart();

                                break;

                            case 0:

                                break;

                            default:

                                System.out.println(
                                        "Invalid choice!"
                                );
                        }

                    } while (storeChoice != 0);

                    break;

                case 2:

                    System.out.println(
                            "\nUpdate store feature"
                    );

                    break;

                case 3:

                    int cartChoice;

                    do {

                        System.out.println(
                                "\n===== CURRENT CART ====="
                        );

                        cart.displayCart();

                        cartMenu();

                        cartChoice = scanner.nextInt();

                        switch (cartChoice) {

                            // ================= FILTER =================

                            case 1:

                                System.out.println(
                                        "Filter by:"
                                );

                                System.out.println(
                                        "1. Id"
                                );

                                System.out.println(
                                        "2. Title"
                                );

                                int filterChoice =
                                        scanner.nextInt();

                                scanner.nextLine();

                                if (filterChoice == 1) {

                                    System.out.print(
                                            "Enter id: "
                                    );

                                    int id =
                                            scanner.nextInt();

                                    cart.searchById(id);

                                } else if (filterChoice == 2) {

                                    System.out.print(
                                            "Enter title: "
                                    );

                                    String title =
                                            scanner.nextLine();

                                    cart.searchByTitle(title);
                                }

                                break;

                            // ================= SORT =================

                            case 2:

                                System.out.println(
                                        "Sort by:"
                                );

                                System.out.println(
                                        "1. Title"
                                );

                                System.out.println(
                                        "2. Cost"
                                );

                                int sortChoice =
                                        scanner.nextInt();

                                if (sortChoice == 1) {

                                    Collections.sort(
                                            cart.getItemsOrdered(),
                                            Media.COMPARE_BY_TITLE_COST
                                    );

                                    System.out.println(
                                            "Sorted by title"
                                    );

                                } else if (sortChoice == 2) {

                                    Collections.sort(
                                            cart.getItemsOrdered(),
                                            Media.COMPARE_BY_COST_TITLE
                                    );

                                    System.out.println(
                                            "Sorted by cost"
                                    );
                                }

                                break;

                            // ================= REMOVE =================

                            case 3:

                                scanner.nextLine();

                                System.out.print(
                                        "Enter title: "
                                );

                                String removeTitle =
                                        scanner.nextLine();

                                Media removeMedia = null;

                                for (Media media :
                                        cart.getItemsOrdered()) {

                                    if (media.getTitle()
                                            .equalsIgnoreCase(
                                                    removeTitle
                                            )) {

                                        removeMedia = media;
                                        break;
                                    }
                                }

                                if (removeMedia != null) {

                                    cart.removeMedia(
                                            removeMedia
                                    );

                                } else {

                                    System.out.println(
                                            "Media not found!"
                                    );
                                }

                                break;

                            // ================= PLAY =================

                            case 4:

                                scanner.nextLine();

                                System.out.print(
                                        "Enter title: "
                                );

                                String playTitle =
                                        scanner.nextLine();

                                Media playMedia = null;

                                for (Media media :
                                        cart.getItemsOrdered()) {

                                    if (media.getTitle()
                                            .equalsIgnoreCase(
                                                    playTitle
                                            )) {

                                        playMedia = media;
                                        break;
                                    }
                                }

                                if (playMedia != null) {

                                    if (playMedia
                                            instanceof DigitalVideoDisc) {

                                        ((DigitalVideoDisc)
                                                playMedia).play();

                                    } else if (playMedia
                                            instanceof CompactDisc) {

                                        ((CompactDisc)
                                                playMedia).play();

                                    } else {

                                        System.out.println(
                                                "Cannot play this media"
                                        );
                                    }

                                } else {

                                    System.out.println(
                                            "Media not found!"
                                    );
                                }

                                break;

                            // ================= PLACE ORDER =================

                            case 5:

                                System.out.println(
                                        "An order has been created!"
                                );

                                cart.clear();

                                break;

                            case 0:

                                break;

                            default:

                                System.out.println(
                                        "Invalid choice!"
                                );
                        }

                    } while (cartChoice != 0);

                    break;

                case 0:

                    System.out.println(
                            "Goodbye!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice!"
                    );
            }

        } while (choice != 0);

        scanner.close();
    }

    // ================= MAIN MENU =================

    public static void showMenu() {

        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println(
                "Please choose a number: 0-1-2-3"
        );
    }

    // ================= STORE MENU =================

    public static void storeMenu() {

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println(
                "Please choose a number: 0-1-2-3-4"
        );
    }

    // ================= MEDIA DETAILS MENU =================

    public static void mediaDetailsMenu() {

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println(
                "Please choose a number: 0-1-2"
        );
    }

    // ================= CART MENU =================

        public static void cartMenu() {
            

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println(
                "Please choose a number: 0-1-2-3-4-5"
        );
    }
}