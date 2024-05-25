package Lab.P02Shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    public Shape(Double perimeter, Double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public Double getArea() {
        return area;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    Double calculatePerimeter() {
        return perimeter;
    }

    Double calculateArea() {
        return area;
    }

}
