package Exercise.P03PlayersAndMonsters;

public class Hero {

    private final String username;
    private final int level;

    public Hero(String username, int level) {
        this.username = username;
        this.level = level;
    }

    protected String getUsername() {
        return username;
    }

    protected int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %s",
                this.getClass().getName(),
                this.getUsername(),
                this.getLevel());
    }

}