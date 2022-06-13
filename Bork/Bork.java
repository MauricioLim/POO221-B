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
        Dragon d = new Dragon(5, 15);
        House h = new House("Voce esta na sala de estar. Ha uma espada pendurada na parede, e, encostado no sofa, um machado de ferro. Tambem ha um belo tapete no centro e uma mesa redonda com um pequeno frasco de vidro.", true, false, false, false);
        Cave c = new Cave("Descendo as escadas, voce chega a uma caverna subterranea. Nela ha um enorme dragao adormecido. Ele acorda com o barulho, e, vendo voce, prepara-se para desferir um golpe.");
        Instructions i = new Instructions();

        System.out.println("Seja bem-vindo ao Bork! Digite 'i' para visualizar as instrucoes, ou qualquer coisa para comecar o jogo.");

        if (s.next().equals("i")) {
            i.showInstructions();
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
                    if (w.isCritic()) {
                        d.setHealth(d.getHealth() - w.getDamage());
                        p.setScore(p.getScore() + 50);
                        System.out.println("Acerto critico! Com toda a sua forca, voce desfere um golpe fatal. Atarantado, o dragao perde 5 pontos de vida.");
                        System.out.println("SUA VIDA: " + p.getHealth());
			System.out.println("VIDA DO DRAGAO: " + d.getHealth());                    
                    }
                    else if (w.isMiss()) {
                        p.setHealth(p.getHealth() - d.getDamage());
                        p.setScore(p.getScore() - 50);
                        System.out.println("Errou! Sua arma passa a centimetros do dragao. Ileso, ele cospe fogo, tirando 5 dos seus pontos de vida.");
                        System.out.println("SUA VIDA: " + p.getHealth());
			System.out.println("VIDA DO DRAGAO: " + d.getHealth());                     
                    }
                    else {
                        p.setHealth(p.getHealth() - d.getDamage()); 
                        d.setHealth(d.getHealth() - w.getDamage());
                        p.setScore(p.getScore() + 30);
                        System.out.println("Voce e o dragao trocam golpes. Agitando sua arma, voce acerta o pescoco da fera, causando 3 pontos de dano. Ele, por sua vez, investe com a cauda, acertando voce bem no estomago, tirando-lhe 5 pontos de vida.");
                        System.out.println("SUA VIDA: " + p.getHealth());
			System.out.println("VIDA DO DRAGAO: " + d.getHealth());
                    }  
                    break; 
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
