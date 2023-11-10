package Lab.P02Shapes;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double perimeter, Double area) {
        super(perimeter, area);
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    Double calculateArea() {
        return Math.PI * radius;
    }

    @Override
    Double calculatePerimeter() {
        return 2 * calculateArea();
    }

}
