package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.cart.Cart;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cart.addMedia(media);
                    JOptionPane.showMessageDialog(null, 
                        media.getTitle() + " has been added to cart.", 
                        "Cart Update", JOptionPane.INFORMATION_MESSAGE);
                } catch (hust.soict.dsai.aims.exception.LimitExceededException ex) {
                    JOptionPane.showMessageDialog(null, 
                        ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        container.add(btnAddToCart);

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Invoke play to check constraints (throws PlayerException if length <= 0)
                        ((Playable) media).play();

                        // Create a dialog window to play the media
                        JDialog playDialog = new JDialog();
                        playDialog.setTitle("Playing " + media.getTitle());
                        playDialog.setSize(350, 150);
                        playDialog.setLocationRelativeTo(null);
                        
                        int length = 0;
                        if (media instanceof Disc) {
                            length = ((Disc) media).getLength();
                        }
                        
                        // Simple HTML rendering to style the play dialog
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
            });
            container.add(btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
