/*
metodo falas do dragão
*/
import java.util.Random;

public class Dragon {
    private int damage;
    private int health;
    private Random r;

    public Dragon() {
        this.setDamage(5);
        this.setHealth(15);
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

    public String getDragonSpeech(String n){ // nome da arma
        String speech="";
        int numero = r.nextInt(2);
        if(health==0){
            if(n.equals("axe")){
                speech = "C-Com esse machado... pode dizer que cortou o mal pela ra..iz...";
            } else if(n.equals("sword")){
                speech = "Essa... é a espada do senhor B-bork solte-a...";
            } else if(n.equals("fists")){
                speech = "Nunca fui tão humilhado... morrer para um humano no soco...";
            }
        }
        if(health <= 10 && health >= 1){
            if(numero == 0){
                speech = "AAAIIII!! Isso doeu seu fedelho fedorento!";
            } else if(numero == 1){
                speech = "Isso vai deixar uma cicatriz.";
            } else if(numero == 2){
                speech = "Agora você me deixou bravo!!";
            }
        }
        if(health>=11){
            if(numero == 0){
                speech = "Vai ter que fazer melhor que isso se quiser me derrotar!";
            } else if(numero == 1){
                speech = "Minha avó bate mais forte que isso!";
            } else if(numero == 2){
                speech = "Você precisa ir pra academia garoto.";
            }
        }

        return speech;
    }

}