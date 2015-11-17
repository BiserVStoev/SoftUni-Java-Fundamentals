package Figures.models;

public class Circle extends PlaneShape {
    private double radius;

    public Circle(Vertex2D vertex, double radius) {
        super(vertex);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.pow(Math.PI * this.radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * (Math.PI * this.radius);
    }

    @Override
    public String toString() {
        return String.format(
                "Circle{area=%.2f, perimeter=%.2f, Vertices=%s}",
                this.getArea(),
                this.getPerimeter(),
                this.getVertices());
    }
}
