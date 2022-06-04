package com.rgr;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.InputStream;

public class StartController {
    @FXML private TextField a;
    @FXML private TextField b;
    @FXML private TextField dx;
    @FXML private TextField dy;
    @FXML private ImageView picture;
    @FXML private TextField xmin;
    @FXML private TextField xmax;
    @FXML private Label errorMsg;

    public void initialize(){
        Class<?> clazz = StartController.class;
        InputStream input = clazz.getResourceAsStream("function.png");
        Image image = new Image(input);
        errorMsg.setText("");
        picture.setImage(image);

    }

    @FXML
    protected void onAButtonClick() {
        Function ac = new First();
        errorMsg.setText("");
        setEverything(ac);
    }

    @FXML
    protected void onBButtonClick() {
        Function ac = new Second();
        errorMsg.setText("");
        setEverything(ac);
    }

    @FXML
    protected void onCButtonClick() {
        Function ac = new Third();
        errorMsg.setText("");
        setEverything(ac);
    }

    @FXML
    protected void onDButtonClick() {
        Function ac = new Fourth();
        errorMsg.setText("");
        setEverything(ac);
    }

    private void setEverything(Function ac){
        try {
            ac.setA(Double.valueOf(a.getText()));
            ac.setB(Double.valueOf(b.getText()));
            ac.setXmin(Integer.parseInt(xmin.getText()));
            ac.setXmax(Integer.parseInt(xmax.getText()));
            ac.setDx(Double.parseDouble(dx.getText()));
            ac.setDy(Double.parseDouble(dy.getText()));
            ac.start(new Stage());
        } catch (Exception e){
         errorMsg.setText("Помилка в заповненні полів!");
        }
    }
}