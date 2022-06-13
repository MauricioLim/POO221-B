/*
arrumar compatibilidade com outras classes
aderir classe acao
*/

import java.util.Scanner;

public class Bork {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Player p = new Player(20, 0);
        Weapon w = new Weapon(false);
        Dragon d = new Dragon();
        House h = new House("Voce esta na sala de estar. Ha uma espada pendurada na parede, e, encostado no sofa, um machado de ferro. Tambem ha um belo tapete no centro e uma mesa redonda com um pequeno frasco de vidro.", true, false, false, false);
        Cave c = new Cave("Descendo as escadas, voce chega a uma caverna subterranea. Nela ha um enorme dragao adormecido. Ele acorda com o barulho, e, vendo voce, prepara-se para desferir um golpe.");

        System.out.println("Seja bem-vindo ao Bork! Digite 'i' para visualizar as instrucoes, ou qualquer coisa para comecar o jogo.");

        if (s.next().equals("i")) {
            System.out.println("Acao:       Objeto(s):");
            System.out.println("===================================");
            System.out.println("CENARIO: CASA");
            System.out.println("===================================");
            System.out.println("pegar       espada, machado, frasco");
            System.out.println("mover       tapete");
            System.out.println("abrir       escotilha");
            System.out.println("descer      escada");
            System.out.println("===================================");
            System.out.println("CENARIO: CAVERNA");
            System.out.println("===================================");
            System.out.println("atacar      dragao");
            System.out.println("usar        pocao");
            System.out.println("mostrar     vida");
            System.out.println("atirar      pedra");
            System.out.println("-----------------------------------");
            System.out.println("DIGITE QUALQUER COISA PARA SAIR");
            s.next();
        }

        String action;
        String object;
            
        System.out.println(h.getDescription());
        while (h.isIsAtTheHouse()) {
            action = s.next();
            object = s.next();
            switch (action) {
                case "pegar":
                switch (object) {
                    case "espada":
                    if (w.isEquipped()) {
                        System.out.println("Voce ja tem uma arma.");                        
                    }  
                    else {
                        p.setScore(p.getScore() + 10);
                        System.out.println("Voce agora tem uma espada.");
                        w.setName("sword");
                        w.setEquipped(true);
                    } 
                    break;
                    case "machado":
                    if (w.isEquipped()) {
                        System.out.println("Voce ja tem uma arma.");                       
                    }  
                    else {
                        p.setScore(p.getScore() + 10);
                        System.out.println("Voce agora tem um machado.");
			w.setName("axe");
                        w.setEquipped(true);
                    } 
                    break;
                    case "frasco":
                    if (h.isBottleIsTaken()){
                        System.out.println("Voce ja pegou o frasco.");
                    }
                    else {
                        System.out.println("Voce pega o frasco. Ele contem um liquido, que e uma pocao de cura.");
                        h.setBottleIsTaken(true);
                    }
                    break;                  
                }
                case "mover":
                switch (object) {
                    case "tapete":
                    if (h.isRugIsRemoved()) {
                        System.out.println("O tapete ja foi movido.");
                    }
                    else {
                        p.setScore(p.getScore() + 10);
                        System.out.println("Voce remove o tapete, revelando no piso uma pequena escotilha de madeira.");
                        h.setRugIsRemoved(true);
                    }                   
                    break; 
                }
                break;
                case "abrir":
                switch (object) {
                    case "escotilha":
                    if (h.isTrapdoorIsOpen()) {
                        System.out.println("A escotilha já está aberta.");
                        
                    }
                    else if (h.isRugIsRemoved()) {
                        p.setScore(p.getScore() + 10);
                        System.out.println("Voce abre a escotilha. Embaixo esta uma longa escada, que desce ate a escuridao.");
                        h.setTrapdoorIsOpen(true);
                        
                    }                  
                    break; 
                }
                break;
                case "descer":
                switch (object) {
                    case "escada":
                    if (h.isTrapdoorIsOpen()) {
                        if (w.isEquipped()) {
                            p.setScore(p.getScore() + 10);
                            h.setIsAtTheHouse(false);
                        }
                        else {
                            System.out.println("E perigoso descer sem uma arma! Tem certeza?");
                            if (s.next().equals("sim")) {
                                w.setName("fists");
                                System.out.println("Voce desce as escadas armado apenas de seus punhos, sem saber o que encontrara...");
                                h.setIsAtTheHouse(false);
                            }

                        }                        
                    }         
                }
                break;
            }
        }

        System.out.println(c.getDescription());
        System.out.println("SUA VIDA: " + p.getHealth());
        System.out.println("VIDA DO DRAGAO: " + d.getHealth());
        while (d.getHealth() > 0 && p.getHealth() > 0) {
            action = s.next();
            object = s.next();
            switch (action) {
                case "atacar":
                switch (object) {
                    case "dragao":
                    switch (w.getDamage()) {
                        case 10:
                        d.setHealth(d.getHealth() - w.getDamage());
                        p.setScore(p.getScore() + 100);
                        System.out.println("Golpe fatal! Voce esmurra a fera, tirando-lhe 10 pontos de vida.");
                        break;
                        case 5:
                        d.setHealth(d.getHealth() - w.getDamage());
                        p.setScore(p.getScore() + 50);
                        System.out.println("Acerto critico! Voce desfere um grande golpe; atarantado, o dragao perde 5 pontos de vida.");
                        break;
                        case 4:
                        p.setHealth(p.getHealth() - d.getDamage()); 
                        d.setHealth(d.getHealth() - w.getDamage());
                        p.setScore(p.getScore() + 40);
                        System.out.println("Sucesso! Voce acerta o pescoco da fera, fazendo 4 pontos de dano.");
                        break;
                        case 3:
                        p.setHealth(p.getHealth() - d.getDamage()); 
                        d.setHealth(d.getHealth() - w.getDamage());
                        p.setScore(p.getScore() + 30);
                        System.out.println("Sucesso! Voce acerta o pescoco da fera, fazendo 3 pontos de dano.");
                        break;
                        case 0:
                        p.setHealth(p.getHealth() - d.getDamage());
                        p.setScore(p.getScore() - 50);
                        System.out.println("Errou! Seu golpe passa a centimetros do dragao. Ileso, ele revida, fazendo 5 pontos de dano");
                        break;
                    }
                }
                case "usar":
                switch (object) {
                    case "pocao":
                    if (h.isBottleIsTaken()) {
                        if (p.getHealth() > 16) {
                            System.out.println("Voce ja esta com a vida bem cheia.");
                        }
                        else {
                            p.setHealth(p.getHealth() + 4);
                            p.setScore(p.getScore() + 20);
                            System.out.println("Voce bebe a pocao de cura, recuperando 4 pontos de vida.");
                            System.out.println("SUA VIDA: " + p.getHealth());
                            h.setBottleIsTaken(false);
                        }
                    }
                    else {
                        System.out.println("Voce nao tem nenhuma pocao.");
                    }
                    break;
                } 
                case "mostrar":
                switch (object) {
                    case "vida":
                    System.out.println("SUA VIDA: " + p.getHealth());
                    System.out.println("VIDA DO DRAGAO: " + d.getHealth());
                } 
                case "atirar":
                switch (object) {
                    case "pedra":
                    d.setHealth(d.getHealth() - 1);
                    System.out.println("Voce pega uma pedrinha do chao e a atira na fera, fazendo 1 misero ponto de dano. Patetico.");
                }                           
            }
        }

        if (p.getHealth() <= 0) {
            System.out.println("FIM DE JOGO! Voce foi morto pelo dragao.");
            System.out.println("SUA PONTUACAO FINAL: " + p.getScore());
        }
        else {
            p.setScore(p.getScore() + 300);
            System.out.println("Parabens, voce derrotou o dragao e venceu o jogo!");
            System.out.println("SUA PONTUACAO FINAL: " + p.getScore());
        } 

        s.close();

    }
}
