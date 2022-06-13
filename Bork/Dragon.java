/*
metodo falas do dragão
arrumar construtor, deixar valores default.
*/

public class Dragon {
    private int damage;
    private int health;

    public Dragon(int d, int h) {
        this.setDamage(d);
        this.setHealth(h);
    }

    public void setDamage(int d) {
        this.damage = d;
    }

    public void setHealth(int h) {
        this.health = h;
    }

    public int getDamage() {
        return damage;
    }  
    
    public int getHealth() {
        return health;
    }
}