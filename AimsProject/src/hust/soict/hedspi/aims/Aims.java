package hust.soict.hedspi.aims;

import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    public static void main(String[] args) {
        Store store = createSampleStore();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1:
                    storeMenu(scanner, store, cart);
                    break;
                case 2:
                    updateStoreMenu(scanner, store);
                    break;
                case 3:
                    cartMenu(scanner, cart);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

        scanner.close();
        System.out.println("Application closed.");
    }

    private static Store createSampleStore() {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        Book book = new Book(1001, "Clean Code", "Programming", 29.99f);
        book.addAuthor("Robert C. Martin");

        CompactDisc cd = new CompactDisc(2001, "Greatest Hits", "Music", 19.50f, "Various Artists");
        cd.addTrack(new Track("Track One", 180));
        cd.addTrack(new Track("Track Two", 210));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book);
        store.addMedia(cd);

        return store;
    }

    private static void showMainMenu() {
        System.out.println("\nAIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
    }

    private static void storeMenu(Scanner scanner, Store store, Cart cart) {
        boolean inStoreMenu = true;
        while (inStoreMenu) {
            printStoreItems(store.getItemsInStore());
            System.out.println("\nStore options:");
            System.out.println("1. See media details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back to main menu");

            int choice = readInt(scanner, "Choose an option: ");
            switch (choice) {
                case 1:
                    int detailId = readInt(scanner, "Enter media id: ");
                    Media media = store.findById(detailId);
                    if (media == null) {
                        System.out.println("Media not found");
                    } else {
                        mediaDetailsMenu(scanner, media, cart);
                    }
                    break;
                case 2:
                    int addId = readInt(scanner, "Enter media id to add to cart: ");
                    Media mediaToAdd = store.findById(addId);
                    if (mediaToAdd == null) {
                        System.out.println("Media not found");
                    } else {
                        cart.addMedia(mediaToAdd);
                    }
                    break;
                case 3:
                    int playId = readInt(scanner, "Enter media id to play: ");
                    Media mediaToPlay = store.findById(playId);
                    playMedia(mediaToPlay);
                    break;
                case 4:
                    cartMenu(scanner, cart);
                    break;
                case 0:
                    inStoreMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private static void mediaDetailsMenu(Scanner scanner, Media media, Cart cart) {
        boolean inDetails = true;
        while (inDetails) {
            System.out.println("\nSelected media: " + media);
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");

            int choice = readInt(scanner, "Choose an option: ");
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    playMedia(media);
                    break;
                case 0:
                    inDetails = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private static void cartMenu(Scanner scanner, Cart cart) {
        boolean inCartMenu = true;
        while (inCartMenu) {
            cart.print();
            System.out.println("\nCart options:");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");

            int choice = readInt(scanner, "Choose an option: ");
            switch (choice) {
                case 1:
                    System.out.println("1. Filter by id");
                    System.out.println("2. Filter by title");
                    int filterChoice = readInt(scanner, "Choose filter option: ");
                    if (filterChoice == 1) {
                        int id = readInt(scanner, "Enter media id: ");
                        cart.search(id);
                    } else if (filterChoice == 2) {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        cart.search(title);
                    } else {
                        System.out.println("Invalid filter choice");
                    }
                    break;
                case 2:
                    System.out.println("1. Sort by title then cost");
                    System.out.println("2. Sort by cost then title");
                    int sortChoice = readInt(scanner, "Choose sort option: ");
                    if (sortChoice == 1) {
                        cart.sort(Media.COMPARE_BY_TITLE_COST);
                    } else if (sortChoice == 2) {
                        cart.sort(Media.COMPARE_BY_COST_TITLE);
                    } else {
                        System.out.println("Invalid sort choice");
                    }
                    break;
                case 3:
                    int removeId = readInt(scanner, "Enter media id to remove: ");
                    Media mediaToRemove = cart.findById(removeId);
                    if (mediaToRemove == null) {
                        System.out.println("Media not found in cart");
                    } else {
                        cart.removeMedia(mediaToRemove);
                    }
                    break;
                case 4:
                    int playId = readInt(scanner, "Enter media id to play: ");
                    cart.playMedia(playId);
                    break;
                case 5:
                    cart.placeOrder();
                    break;
                case 0:
                    inCartMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private static void updateStoreMenu(Scanner scanner, Store store) {
        boolean inUpdateMenu = true;
        while (inUpdateMenu) {
            System.out.println("\nUpdate store:");
            System.out.println("1. Add DVD");
            System.out.println("2. Remove media by id");
            System.out.println("0. Back");

            int choice = readInt(scanner, "Choose an option: ");
            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Director: ");
                    String director = scanner.nextLine();
                    int length = readInt(scanner, "Length: ");
                    float cost = readFloat(scanner, "Cost: ");
                    store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
                    break;
                case 2:
                    int id = readInt(scanner, "Enter media id to remove: ");
                    Media media = store.findById(id);
                    if (media == null) {
                        System.out.println("Media not found");
                    } else {
                        store.removeMedia(media);
                    }
                    break;
                case 0:
                    inUpdateMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private static void printStoreItems(List<Media> mediaList) {
        System.out.println("\nItems in store:");
        if (mediaList.isEmpty()) {
            System.out.println("Store is empty");
            return;
        }

        for (Media media : mediaList) {
            System.out.println(media);
        }
    }

    private static void playMedia(Media media) {
        if (media == null) {
            System.out.println("Media not found");
            return;
        }

        if (media instanceof Playable) {
            ((Playable) media).play();
            return;
        }

        System.out.println("Selected media is not playable");
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer");
            }
        }
    }

    private static float readFloat(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Float.parseFloat(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }
}

