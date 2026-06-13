package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {

        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger", 90, 250.0);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-fi", "George Lucas", 120, 1000.0);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Disney", 95, 300.0);

        // ===== ADD =====
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        // ===== DISPLAY =====
        cart.displayCart();

        // ===== TOTAL =====
        System.out.println("Total cost is: " + cart.totalCost());

        // ===== REMOVE =====
        cart.removeDigitalVideoDisc(dvd2);

        // ===== DISPLAY AGAIN =====
        cart.displayCart();
    }
}