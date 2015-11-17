package Figures.models;

import interfaces.AreaMeasurable;
import interfaces.VolumeMeasurable;

public class Sphere extends SpaceShape implements AreaMeasurable, VolumeMeasurable{
    private double radius;

    public Sphere(Vertex3D vertex, double radius) {
        super(vertex);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return 4d * Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double getVolume() {
        return (4d / 3d) * Math.PI * Math.pow(this.radius, 3);
    }

    @Override
    public String toString() {
        return String.format(
                "Sphere{radius=%.2f, volume=%.2f, area=%.2f, vertices=%s",
                this.radius,
                this.getVolume(),
                this.getArea(),
                this.getVertices());
    }
}
