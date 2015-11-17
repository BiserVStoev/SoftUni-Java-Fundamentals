package Figures.models;

import interfaces.AreaMeasurable;
import interfaces.VolumeMeasurable;

public class SquarePyramid extends SpaceShape implements AreaMeasurable, VolumeMeasurable {
    private double baseWidth;
    private double height;

    public SquarePyramid(Vertex3D vertex, double baseWidth, double height) {
        super(vertex);
        this.baseWidth = baseWidth;
        this.height = height;
    }

    public double getBaseWidth() {
        return baseWidth;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        double area = (this.baseWidth * this.baseWidth)
                + ((this.baseWidth * 2) * Math.sqrt(((this.baseWidth * this.baseWidth) / 4) + (this.height * this.height)));
        return area;
    }

    @Override
    public double getVolume() {
        return (this.baseWidth * this.baseWidth) * (this.height / 3);
    }

    @Override
    public String toString() {
        return String.format(
                "SquarePyramid{baseWidth=%.2f, height=%.2f, volume=%.2f, area=%.2f, vertices=%s",
                this.baseWidth,
                this.height,
                this.getVolume(),
                this.getArea(),
                this.getVertices());
    }
}
