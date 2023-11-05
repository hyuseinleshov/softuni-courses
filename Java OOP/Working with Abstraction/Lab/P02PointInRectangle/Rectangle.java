package Lab.P02PointInRectangle;

public class Rectangle {

    private Point bottomLeft;
    private Point topRight;


    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRightX, int toprightY) {

        this.bottomLeft = new Point(bottomLeftX, bottomLeftY);
        this.topRight = new Point(topRightX, toprightY);

    }

    public boolean contains(Point point) {

        return point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX()
                && point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY();

    }

}
