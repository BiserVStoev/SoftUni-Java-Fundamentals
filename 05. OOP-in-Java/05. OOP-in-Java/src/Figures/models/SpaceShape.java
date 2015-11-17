package Figures.models;

import interfaces.AreaMeasurable;
import interfaces.VolumeMeasurable;

public abstract class SpaceShape extends Shape implements AreaMeasurable, VolumeMeasurable {
    protected SpaceShape(Vertex3D... vertices) {
        super.addVertices(vertices);
    }
}