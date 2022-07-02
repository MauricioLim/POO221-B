package moduleB;

public class Bork {
    private int health;

    public Bork() {
        this.setHealth(20);
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