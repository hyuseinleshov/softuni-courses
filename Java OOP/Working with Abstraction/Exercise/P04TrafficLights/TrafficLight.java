package Exercise.P04TrafficLights;

public class TrafficLight {

    private Color color;

    public TrafficLight(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void changeColor() {

        switch (getColor()) {

            case RED:

                setColor(Color.GREEN);
                break;
            case GREEN:

                setColor(Color.YELLOW);
                break;
            case YELLOW:

                setColor(Color.RED);
                break;
        }
    }

}
