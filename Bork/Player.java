/*
arrumar construtor, para construtor padrão
*/

public class Player {
    private int health;
    private int score;

    public Player(int h, int s) {
        this.setHealth(h);
        this.setScore(s);
    }

    public void setHealth(int h) {
        this.health = h;
    }

    public void setScore(int s) {
        this.score = s;
    }

    public int getHealth() {
        if (health < 0) {
            return 0;
        }
        else {
            return health;
        }
    }

    public int getScore() {
        if (score < 0) {
           return 0;   
        }
        else {
           return score;   
        }
    }
}
