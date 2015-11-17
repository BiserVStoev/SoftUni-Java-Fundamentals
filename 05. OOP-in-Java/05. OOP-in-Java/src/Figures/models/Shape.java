package Figures.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
    private List<Vertex> vertices;

    protected Shape() {
        vertices = new ArrayList<>();
    }

    protected List<Vertex> getVertices() {
        return vertices;
    }

    protected void addVertices(Vertex... vertices) {
        for (Vertex vertex : vertices) {
            this.vertices.add(vertex);
        }
    }
}