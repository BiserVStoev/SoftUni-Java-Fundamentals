package Figures.models;

import interfaces.AreaMeasurable;
import interfaces.PerimeterMeasurable;

public abstract class PlaneShape extends Shape implements PerimeterMeasurable, AreaMeasurable {
    protected PlaneShape(Vertex2D... vertices) {
        super.addVertices(vertices);
    }
}