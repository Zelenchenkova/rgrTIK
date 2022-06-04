package com.rgr;

import javafx.application.Application;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class First extends Application  implements Function {

    private Double a;
    private Double b;

    private int xmin;
    private int xmax;

    public int getXmin() {
        return xmin;
    }

    public void setXmin(int xmin) {
        this.xmin = xmin;
    }

    public int getXmax() {
        return xmax;
    }

    public void setXmax(int xmax) {
        this.xmax = xmax;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    @Override
    public double getDx() {
        return 0;
    }

    @Override
    public void setDx(double dx) {

    }

    @Override
    public double getDy() {
        return 0;
    }

    @Override
    public void setDy(double dy) {

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) {


        Axes axes = new Axes(
                500, 400,
                -10, 10, 1,
                -10, 10, 1
        );

        Plot plot = new Plot(
                x -> Math.round((2*(Math.atan((25*a)/b))+ 3*(Math.pow(Math.cos((9 * x * b) / (b - x)), 2)))*100.0)/100.0,
                getXmin(), getXmax(), 0.00001,
                axes
        );

        StackPane layout = new StackPane(
                plot
        );
        layout.setPadding(new Insets(20));

        stage.setTitle("Aналоговий сигнал");
        stage.setScene(new Scene(layout, Color.rgb(35, 39, 50)));
        stage.show();
    }
}
