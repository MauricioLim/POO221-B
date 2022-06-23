/*
arrumar construtor, para construtor padrão (não é possível)
*/

public class Player {
    private int health;
    private int score;

    public Player() {
        this.setHealth(20);
        this.setScore(0);
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
