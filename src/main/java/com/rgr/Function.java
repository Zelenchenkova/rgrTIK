package com.rgr;

import javafx.stage.Stage;

public interface Function {
    public int getXmin();

    void setXmin(int xmin);

    int getXmax();

    void setXmax(int xmax);

    Double getA();

    void setA(Double a);

    Double getB();

    void setB(Double b);

    double getDx();

    void setDx(double dx);

    double getDy();

    void setDy(double dy);

    public void start(final Stage stage);
}
