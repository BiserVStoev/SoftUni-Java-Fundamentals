package Figures.models;

public class Rectangle extends PlaneShape {
    private double width;
    private double heigth;

    public Rectangle(Vertex2D vertex, double width, double heigth) {
        super(vertex);
        this.width = width;
        this.heigth = heigth;
    }

    public double getWidth() {
        return width;
    }

    public double getHeigth() {
        return heigth;
    }

    @Override
    public double getArea() {
        return this.width * this.heigth;
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.width + this.heigth);
    }

    @Override
    public String toString() {
        return String.format(
                "Rectangle{width=%.2f, heigth=%.2f, area=%.2f, perimeter=%.2f, Vertices=%s}",
                this.width,
                this.heigth,
                this.getArea(),
                this.getPerimeter(),
                this.getVertices());
    }
}
