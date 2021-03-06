package com.rgr;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Second extends Application  implements Function {

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

    double dx;
    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
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

        LinePlot linePlot = new LinePlot(
                x ->  (2*(Math.atan((25*a)/b))+ 3*(Math.pow(Math.cos((9 * x * b) / (b - x)), 2))),
                getXmin(), getXmax(), getDx(),
                axes
        );

        StackPane layout = new StackPane(
                linePlot
        );
        layout.setPadding(new Insets(20));

        stage.setTitle("Безперервна функція дискретного аргументу");
        stage.setScene(new Scene(layout, Color.rgb(35, 39, 50)));
        stage.show();
    }

}
