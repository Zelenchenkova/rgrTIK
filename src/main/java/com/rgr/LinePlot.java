package com.rgr;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;

import java.util.function.Function;

public class LinePlot extends Pane {
    public LinePlot(
            Function<Double, Double> f,
            double xMin, double xMax, double xInc,
            Axes axes
    ) {
        Path path = new Path();
        Path newPath = new Path();
        path.setStroke(Color.ORANGE.deriveColor(0, 1, 1, 0.6));
        path.setStrokeWidth(2);


        double x = xMin;
        double y = f.apply(x);

        path.getElements().add(
                new MoveTo(
                        mapX(x, axes), mapY(y, axes)
                )
        );

        x += xInc;
        try {
            while (x < xMax) {
                y = Math.round(f.apply(x) * 100) / 100.0;
                if (!Double.isNaN(f.apply(x))) {
                    path.getElements().addAll(
                            new HLineTo(mapX(x, axes)),
                            new VLineTo(mapY(y, axes))
                    );
                } else {
                    path.getElements().addAll(
                            new HLineTo(mapX(x, axes))
                    );
                    throw new NullPointerException();


                }

                x += xInc;
            }
        } catch (NullPointerException e){
            getChildren().add(path);
            newPath.setStroke(Color.ORANGE.deriveColor(0, 1, 1, 0.6));
            newPath.setStrokeWidth(2);


            y = f.apply(x);

            newPath.getElements().add(
                    new MoveTo(
                            mapX(x, axes), mapY(y, axes)
                    )
            );

            x += xInc;
                while (x < xMax) {
                    y = Math.round(f.apply(x) * 100) / 100.0;
                    if (!Double.isNaN(f.apply(x))) {
                        newPath.getElements().addAll(
                                new HLineTo(mapX(x, axes)),
                                new VLineTo(mapY(y, axes))
                        );
                    } else {
                        getChildren().add(newPath);
                    }

                    x += xInc;
                }

        }

        setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
        setPrefSize(axes.getPrefWidth(), axes.getPrefHeight());
        setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);

        getChildren().setAll(axes, path, newPath);
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
