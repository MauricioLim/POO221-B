/*
metodo falas do dragão
arrumar construtor, deixar valores default. (OK)
*/

public class Dragon {
    private int damage;
    private int health;

    public Dragon(int h) {
        this.setHealth(h);
    }

    public void setDamage(int d) {
        this.damage = 5;
    }

    public void setHealth(int h) {
        this.health = h;
    }

    public int getDamage() {
        return damage;
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
