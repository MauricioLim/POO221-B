/*
aumentar dano do machado
diminuir chance de crit do machado
aumentar chance de crit da espada
aumentar muito a chance de crit e dano do punho
aumentar chance de errar do punho
criar var temp do random
tirar metodo random?
*/

import java.util.Random;

public class Weapon {
    private String name;
    private boolean isEquipped;

    Random r = new Random();

    public Weapon(boolean e) {
        this.setEquipped(e);
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setEquipped(boolean e) {
        this.isEquipped = e;
    }

    public String getName() {
        return name;
    }

    public boolean isEquipped() {
        return isEquipped;
    }

    public int getDamage() {
        if (this.isCritic()) {
            return 5;
        }
        else if (this.isMiss()) {
            return 0;
        }
        else {
            return 3;
        }
    }

    public int getChance() {
        return r.nextInt(6);
    }

    public boolean isCritic() {
        if (this.getName().equals("sword") || this.getName().equals("fists")) {
            if (this.getChance() == 4) {
                return true;
            }
            else {
                return false;
            }
        }
        else if (this.getName().equals("axe")) {
            if (this.getChance() == 3 || this.getChance() == 4) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public boolean isMiss() {
        if (this.getName().equals("sword")) {
            if (this.getChance() == 0 || this.getChance() == 1) {
                return true;
            }
            else {
                return false;
            }
        }
        else if (this.getName().equals("axe")) {
            if (this.getChance() == 0 || this.getChance() == 1 || this.getChance() == 2) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (this.getChance() != 4) {
                return true;
            }
            else {
                return false;
            }
        }
    }   
}