package com.rgr;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Third extends Application  implements Function {
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

    double dy;

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
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

        PointedPlot pointedPlot = new PointedPlot(
                x ->  Math.ceil((2*(Math.atan((25*a)/b))+ 3*(Math.pow(Math.cos((9 * x * b) / (b - x)), 2)))/dy)*dy,
                getXmin(), getXmax(), getDx(),
                axes
        );

        StackPane layout = new StackPane(
                pointedPlot
        );
        layout.setPadding(new Insets(20));

        stage.setTitle("Дискретна функція безперервного аргументу");
        stage.setScene(new Scene(layout, Color.rgb(35, 39, 50)));
        stage.show();
    }
}
