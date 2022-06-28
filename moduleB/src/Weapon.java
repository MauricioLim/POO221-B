import java.util.Random;

public class Weapon {
    private String name;
    private boolean isEquipped;

    Random r = new Random();

    public Weapon() {
        this.setEquipped(false);
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
            if (this.getName().equals("axe")) {
                return 4;
            }
            else if (this.getName().equals("fists")) {
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
        else {
            if (chance == 4) {
                return true;
            }
            else {
                return false;
            }
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
            if (chance != 4) {
                return true;
            }
            else {
                return false;
            }
        }
    }   
}