package Figures.models;

public class Triangle extends PlaneShape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c) {
        super(a, b, c);
        this.sideA = calcSideLenght(a, b);
        this.sideB = calcSideLenght(b, c);
        this.sideC = calcSideLenght(c, a);
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public double getArea() {
        double halfPerimeter = this.getPerimeter() / 2;
        return Math.sqrt(halfPerimeter
                * (halfPerimeter - this.sideA)
                * (halfPerimeter - this.sideB)
                * (halfPerimeter - this.sideC));
    }

    @Override
    public double getPerimeter() {
        return this.sideA + this.sideB + this.sideC;
    }

    @Override
    public String toString() {
        return String.format(
                "Triangle{area=%.2f, perimeter=%.2f, sideA=%.2f, sideB=%.2f, sideC=%.2f, Vertices=%s}",
                this.getArea(),
                this.getPerimeter(),
                this.sideA,
                this.sideB,
                this.sideC,
                this.getVertices());
    }

    private double calcSideLenght(Vertex2D a, Vertex2D b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }
}