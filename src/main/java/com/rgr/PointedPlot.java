package com.rgr;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PointedPlot extends Pane {
    public PointedPlot(
            Function<Double, Double> f,
            double xMin, double xMax, double xInc,
            Axes axes
    ) {

        List<Circle> points = new ArrayList<>();
        double x = xMin;
        double y;
            while (x < xMax) {

            y = Math.round(f.apply(x) * 100) / 100.0;

                if (!Double.isNaN(f.apply(x))) {
                    Circle point = new Circle(2, Color.ORANGE.deriveColor(0, 1, 1, 0.6));
                    point.setCenterX(mapX(x, axes));
                    point.setCenterY(mapY(y, axes));
                    points.add(point);
                }

                x += xInc;
        }

        setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
        setPrefSize(axes.getPrefWidth(), axes.getPrefHeight());
        setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
        getChildren().setAll(axes);
        getChildren().addAll(points);
        Text Y = new Text();


        Y.setX(260);
        Y.setY(10);
        Y.setText("y");

        getChildren().add(Y);

        Text X = new Text();


        X.setX(490);
        X.setY(195);
        X.setText("x");

        getChildren().add(X);

    }

    private double mapX(double x, Axes axes) {
        double tx = axes.getPrefWidth() / 2;
        double sx = axes.getPrefWidth() /
                (axes.getXAxis().getUpperBound() -
                        axes.getXAxis().getLowerBound());

        return x * sx + tx;
    }

    private double mapY(double y, Axes axes) {
        double ty = axes.getPrefHeight() / 2;
        double sy = axes.getPrefHeight() /
                (axes.getYAxis().getUpperBound() -
                        axes.getYAxis().getLowerBound());

        return -y * sy + ty;
    }
}

