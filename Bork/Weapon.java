/*
aumentar dano do machado (OK)
diminuir chance de crit do machado (OK)
aumentar chance de crit da espada (OK)
aumentar muito a chance de crit e dano do punho (dano sim, crit não tenho bem certeza)
aumentar chance de errar do punho (OK)
criar var temp do random (OK)
tirar metodo random? (deixei comentado)
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
        int chance = r.nextInt(5);
        if (this.isCritic(chance)) {
            return 5;
        }
        else if (this.isMiss(chance)) {
            return 0;
        }
        else {
            if (this.getName().equals("axe") {
                return 4;
            }
            else if (this.getName().equals("fists") {
                return 10;
            }            
            else {
                return 3;   
            }
        }
    }

    //public int getChance() {
    //    return r.nextInt(5);
    //}

    public boolean isCritic(int chance) {
        if (this.getName().equals("sword") || this.getName().equals("fists")) {
            if (chance == 3 || chance == 4) {
                return true;
            }
            else {
                return false;
            }
        }
        else if (this.getName().equals("axe")) {
            if (chance == 4) {
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

    public boolean isMiss(int chance) {
        if (this.getName().equals("sword")) {
            if (chance == 0) {
                return true;
            }
            else {
                return false;
            }
        }
        else if (this.getName().equals("axe")) {
            if (chance == 0 || chance == 1) {
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
