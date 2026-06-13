package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    private ToggleGroup toolsToggleGroup;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle;
        if (penRadioButton.isSelected()) {
            newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        } else {
            newCircle = new Circle(event.getX(), event.getY(), 8, Color.WHITE);
        }
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
}
