public class Aims {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Animation", "Star Wars", 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Quentin Tarantino", "Drama", "Pulp Fiction", 14.99f);

        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        System.out.println("Total cost: " + cart.totalCost());

        cart.removeDigitalVideoDisc(dvd2);

        System.out.println("Total cost after removal: " + cart.totalCost());
    }
}
