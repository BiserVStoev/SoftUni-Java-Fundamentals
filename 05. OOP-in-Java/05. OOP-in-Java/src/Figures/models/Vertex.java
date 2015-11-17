package Figures.models;

public abstract class Vertex {
    private double x;
    private double y;
    private double z;

    protected Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    protected double getX() {
        return x;
    }

    protected double getY() {
        return y;
    }

    protected double getZ() {
        return z;
    }
}