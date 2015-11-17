package Figures.models;

public class Vertex3D extends Vertex {
    public Vertex3D(double x, double y, double z) {
        super(x, y, z);
    }

    @Override
    public String toString() {
        return String.format("Vertex3D{x=%.2f, y=%.2f, z=%.2f}", this.getX(), this.getY(), this.getZ());
    }
}