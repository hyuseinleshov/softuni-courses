package Lab.P02Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double perimeter, Double area) {
        super(perimeter, area);
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    Double calculateArea() {
        return height * width;
    }

    @Override
    Double calculatePerimeter() {
        return 2 * (height + width);
    }

}
