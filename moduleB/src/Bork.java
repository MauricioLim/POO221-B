public class Bork {
    private int health;
    private int score;

    public Bork() {
        this.setHealth(20);
        this.setScore(0);
    }

    public void setHealth(int h) {
        this.health = h;
    }

    public int getHealth() {
        if (health < 0) {
            return 0;
        }
        else {
            return health;
        }
    }

}
