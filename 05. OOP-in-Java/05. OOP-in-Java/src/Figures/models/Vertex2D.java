package Figures.models;

public class Vertex2D extends Vertex {
    public Vertex2D(double x, double y) {
        super(x, y, 0);
    }

    @Override
    public String toString() {
        return String.format("Vertex2D{x=%.2f, y=%.2f}", this.getX(), this.getY());
    }
}