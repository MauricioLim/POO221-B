/*
arrumar compatibilidade com outras classes
aderir classe acao
*/

import java.util.Scanner;

public class GameB {
	 Scanner s = new Scanner(System.in);

     Player p = new Player();
     Weapon w = new Weapon(false);
     Dragon d = new Dragon();
     Room r = new Room(false, false, false, false,false);
     
    public GameB(){

    }
    
    
    public String info(String info) {
    	String test ="";
    	
    	if(info.equals("info")) { 
    		test = "Acao:   +     Objeto(s): \n";
            test += "===================================\n";
            test += "CENARIO: CASA\n";
            test += "===================================\n";
            test += "pegar        obj.\n";
            test += "mover        obj.\n";
            test += "abrir        obj.\n";
            test += "descer       obj.\n";
            test += "===================================\n";
            test += "CENARIO: CAVERNA\n";
            test += "===================================\n";
            test += "atacar      obj.\n";
            test += "usar        obj.\n";
            test += "mostrar     obj.\n";
            test += "atirar      obj.\n";
            test += "-----------------------------------\n";
    		return test;
    	} else {
    		test += "Ao fim de um longa jornada, Bork um experiente aventureiro, finalmente chega\npróximo ao seu objetivo!";
    		test +=	"\nSeguindo os rastros de seu pai a procura de seu paradeiro.";
    		test +=	"\nSubindo a montanha da prata Bork chega em frente a um velho chalé abandonado...";
    		return test;
    	}
    }

   public String acoes(String test) {
	   String[] testSplit = test.split(" ");
	   String action = testSplit[0];
	   String object = testSplit[1];
	   String resposta = r.getDescription() + "\n\n";
    
        if(r.getLocal() == 'H') {
        	switch (action) {
        	case "entrar":
        		switch(object) {
        			case "chale":
        				if(r.isIsAtTheHouse()) {
            				resposta = "Você ja esta dentro da chale";
            				break;
            			} else {
            				r.setLocal('H');
            				resposta = r.getDescription();
            				r.setIsAtTheHouse(true);
            			}
        				break;
        		}
        		break;
        		
            case "pegar":
            	switch (object) {
                	case "espada":
                		if (w.isEquipped()) {
                			resposta += "Voce ja tem uma arma.";
                			break;
                		}  
                		else {
                			p.setScore(p.getScore() + 10);
                			w.setName("sword");
                			w.setEquipped(true);
                			resposta += "Voce agora tem uma espada";
                		} 
                		break;
                	case "machado":
                		if (w.isEquipped()) {
                			resposta += "Voce ja tem uma arma.";                       
                		}  
                		else {
                			p.setScore(p.getScore() + 10);
                			w.setName("axe");
                			w.setEquipped(true);
                			resposta += "Voce agora tem um machado.";
                		} 
                		break;
                	case "frasco":
                		if (r.isBottleIsTaken()){
                			resposta += "Voce ja pegou o frasco.";
                		}
                		else {
                			r.setBottleIsTaken(true);
                			resposta += "Voce pega o frasco. Ele contem um liquido, que e uma pocao de cura.";
                		}
                		break;
					case "comida":
						if (r.isFoofIsTaken()){
							resposta += "Voce ja pegou a comida.";
						}
						else {
							r.setFoodIsTaken(true);
							resposta += "Você pega a comida para viagem, o maior inimigo sempre será a fome.";
						}
						break;
					default:
						resposta += "Opção Invalida";
            	}
            	break;
            case "mover":
            	switch (object) {
                	case "tapete":
                		if (r.isRugIsRemoved()) {
                			resposta += "O tapete ja foi movido.";
                		}
                		else {
                			p.setScore(p.getScore() + 10);
                			r.setRugIsRemoved(true);
                			resposta += "Voce remove o tapete, revelando no piso uma pequena escotilha de madeira.";
                		}
                		break;
					default:
						resposta += "Opção Invalida";
            	}
            	break;
            case "abrir":
            	switch (object) {
                	case "escotilha":
                		if (r.isTrapdoorIsOpen()) {
                			resposta += "A escotilha já está aberta.";
                		}
                		else if (r.isRugIsRemoved()) {
                			p.setScore(p.getScore() + 10);
                			r.setTrapdoorIsOpen(true);
                			resposta += "Voce abre a escotilha. Embaixo esta uma longa escada, que desce ate a escuridao.";                    
                		}                  
                		break; 
					default:
						resposta += "Opção Invalida";
            	}
            	break;
            case "descer":
            	switch (object) {
            		case "escada":
            			if (r.isTrapdoorIsOpen()) {
            				if (w.isEquipped()) {
            					p.setScore(p.getScore() + 10);
            					r.setIsAtTheHouse(false);
								r.setLocal('C');
								resposta += "\n" +r.getDescription();
            				}
            				else {
            					w.setName("fists");
            					r.setIsAtTheHouse(false);
            					resposta +=  "Você desce as escada com punhos cerrilhados, eles e sua coragem seram \nsua única arma.\n";
            					r.setLocal('C');
            					resposta += "\n" +r.getDescription();
            				}                        
            			}
            			break;
					default:
						resposta += "Opção Invalida";
            	}
            	break;
            default: 
            	resposta +=  "Opção Invalida";
            	break;
        	}
    	
        } else if(r.getLocal() == 'C') {
        	switch (action) {
            	case "atacar":
            		switch (object) {
            			case "dragao":
            				switch (w.getDamage()) {
            					case 10:
            						d.setHealth(d.getHealth() - w.getDamage());
            						p.setScore(p.getScore() + 100);
            						resposta += "Golpe fatal! Voce esmurra a fera, \ntirando-lhe 10 pontos de vida.";
            						break;
            					case 5:
            						d.setHealth(d.getHealth() - w.getDamage());
            						p.setScore(p.getScore() + 50);
            						resposta += "Acerto critico! Voce desfere um grande golpe; \natarantado, o dragao perde 5 pontos de vida.";
            						break;
            					case 4:
            						d.setHealth(d.getHealth() - w.getDamage());
            						p.setScore(p.getScore() + 40);
            						resposta += "Sucesso! Voce acerta o pescoco da fera, \nfazendo 4 pontos de dano.";
            						break;
            					case 3:
            						d.setHealth(d.getHealth() - w.getDamage());
            						p.setScore(p.getScore() + 30);
            						resposta += "Sucesso! Voce acerta o pescoco da fera, \nfazendo 3 pontos de dano.";
            						break;
            					case 0:
            						p.setHealth(p.getHealth() - d.getDamage());
            						p.setScore(p.getScore() - 50);
            						resposta += "Errou! Seu golpe passa a centimetros do dragao. \nIleso, ele revida, fazendo 5 pontos de dano";
            						break;
            				}
						default:
							resposta += "Opção Invalida";	
            		}
            	case "usar":
            		switch (object) {
            			case "pocao":
            				if (r.isBottleIsTaken()) {
            					if (p.getHealth() > 16) {
            						resposta += "Voce ja esta com a vida bem cheia.";
            					}
            					else {
            						p.setHealth(p.getHealth() + 4);
            						p.setScore(p.getScore() + 20);
            						resposta += "Voce bebe a pocao de cura, recuperando 4 pontos de vida.";
            						resposta += "SUA VIDA: " + p.getHealth();
            						r.setBottleIsTaken(false);
            					}
            				}
            				else {
            					resposta += "Voce nao tem nenhuma pocao.";
            				}
            				break;
						default:
							resposta += "Opção Invalida";
            		} 
            	case "mostrar":
            		switch (object) {
                		case "vida":
                			resposta += "SUA VIDA: " + p.getHealth();
                			resposta += "\nVIDA DO DRAGAO: " + d.getHealth();
						default:
							resposta += "Opção Invalida";
            		} 
            	case "atirar":
            		switch (object) {
                		case "pedra":
                			d.setHealth(d.getHealth() - 1);
                			resposta += "Voce pega uma pedrinha do chao e a atira na fera, \nfazendo 1 misero ponto de dano. Patetico.";
						case "comida":
							resposta += "MEU LANCHINHOOOOOOOO!!! Muito obrigado amigo, eu tava \ncom muita fome desde que o Senhor Bork sumiu... sinto sua falta...\n";

						default:
							resposta += "Opção Invalida";
            		}                           
        	}
       }
        return resposta;
   }
}