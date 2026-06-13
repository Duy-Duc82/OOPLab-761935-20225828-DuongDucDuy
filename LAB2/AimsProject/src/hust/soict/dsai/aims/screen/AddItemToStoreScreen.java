package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart;

    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    public AddItemToStoreScreen(Store store, Cart cart, String title) {
        super(title);
        this.store = store;
        this.cart = cart;

        this.setSize(400, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Header Menu Bar
        setJMenuBar(createMenuBar());

        // Central Form Panel
        JPanel centerPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        centerPanel.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        centerPanel.add(tfTitle);

        centerPanel.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        centerPanel.add(tfCategory);

        centerPanel.add(new JLabel("Cost ($):"));
        tfCost = new JTextField();
        centerPanel.add(tfCost);

        addSpecificFields(centerPanel);

        this.add(centerPanel, BorderLayout.CENTER);

        // Footer Button Panel
        JPanel footerPanel = new JPanel();
        JButton btnAdd = new JButton("Add Item");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String itemTitle = tfTitle.getText().trim();
                    String itemCategory = tfCategory.getText().trim();
                    float itemCost = Float.parseFloat(tfCost.getText().trim());

                    if (itemTitle.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Title cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (itemCost < 0) {
                        JOptionPane.showMessageDialog(null, "Cost must be non-negative!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    handleAdd(itemTitle, itemCategory, itemCost);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Cost format!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        footerPanel.add(btnAdd);
        this.add(footerPanel, BorderLayout.SOUTH);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreScreen(store, cart);
                dispose();
            }
        });
        menu.add(viewStore);

        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cart);
                dispose();
            }
        });
        menu.add(viewCart);

        menuBar.add(menu);
        return menuBar;
    }

    protected abstract void addSpecificFields(JPanel panel);
    protected abstract void handleAdd(String title, String category, float cost);
}
