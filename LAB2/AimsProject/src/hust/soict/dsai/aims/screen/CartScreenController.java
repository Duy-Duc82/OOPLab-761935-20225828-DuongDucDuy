package hust.soict.dsai.aims.screen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Disc;

public class CartScreenController {
    private Store store;
    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label totalLabel;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    public CartScreenController(Store store, Cart cart) {
        super();
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    } else {
                        btnPlay.setVisible(false);
                        btnRemove.setVisible(false);
                    }
                }
            }
        );

        // Update total cost initially
        updateTotalCost();

        // Listen for changes in the list to update total cost
        cart.getItemsOrdered().addListener(new ListChangeListener<Media>() {
            @Override
            public void onChanged(Change<? extends Media> c) {
                updateTotalCost();
            }
        });
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    private void updateTotalCost() {
        totalLabel.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                // Actually invoke play() method to throw PlayerException if length <= 0
                ((Playable) media).play();

                int length = 0;
                if (media instanceof Disc) {
                    length = ((Disc) media).getLength();
                }
                JDialog playDialog = new JDialog();
                playDialog.setTitle("Playing " + media.getTitle());
                playDialog.setSize(350, 150);
                playDialog.setLocationRelativeTo(null);
                
                JLabel label = new JLabel("<html><center><h2>Playing Media</h2><b>Title:</b> " 
                    + media.getTitle() + "<br><b>Length:</b> " 
                    + length + " mins</center></html>", SwingConstants.CENTER);
                playDialog.add(label);
                playDialog.setVisible(true);
            } catch (hust.soict.dsai.aims.exception.PlayerException ex) {
                JOptionPane.showMessageDialog(null, 
                    ex.getMessage(), 
                    "Illegal DVD Length", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Your cart is empty!", "Order Status", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "An order has been created!\nTotal cost: " + String.format("%.2f $", cart.totalCost()), "Order Status", JOptionPane.INFORMATION_MESSAGE);
        cart.clear();
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
    }

    private void closeCurrentScreen() {
        for (java.awt.Frame frame : java.awt.Frame.getFrames()) {
            if (frame instanceof CartScreen) {
                frame.dispose();
            }
        }
    }

    @FXML
    void viewStoreMenuItemPressed(ActionEvent event) {
        new StoreScreen(store, cart);
        closeCurrentScreen();
    }

    @FXML
    void viewCartMenuItemPressed(ActionEvent event) {
        // Already in cart screen, do nothing
    }

    @FXML
    void addBookMenuItemPressed(ActionEvent event) {
        new AddBookToStoreScreen(store, cart);
        closeCurrentScreen();
    }

    @FXML
    void addCDMenuItemPressed(ActionEvent event) {
        new AddCompactDiscToStoreScreen(store, cart);
        closeCurrentScreen();
    }

    @FXML
    void addDVDMenuItemPressed(ActionEvent event) {
        new AddDigitalVideoDiscToStoreScreen(store, cart);
        closeCurrentScreen();
    }
}
