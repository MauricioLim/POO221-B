package moduleB;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPanel;

public class GameB implements Game{
    private int vezesAcionado;

	Scanner s = new Scanner(System.in);

    Bork b = new Bork();
    Weapon w = new Weapon();
    Dragon d = new Dragon();
    Room r = new Room();
    Console c = Console.getInstance();
    Player p = c.getPlayer("TheTester");
     
    public GameB(){
    	
    }
        
    public String info(String info) {
    	String test ="";
    	
    	if(info.equals("info")) { 
    	    test = " Acao:   +	        Objeto(s): \n";
            test += "===================================\n";
            test += "CENARIO: CASA\n";
            test += "===================================\n";
            test += "pegar        	obj.\n";
            test += "mover        	obj.\n";
            test += "abrir        	obj.\n";
            test += "descer       	obj.\n";
            test += "===================================\n";
            test += "CENARIO: CAVERNA\n";
            test += "===================================\n";
            test += "atacar      	obj.\n";
            test += "usar        	obj.\n";
            test += "mostrar     	vida\n";
            test += "atirar      	obj.\n";
            test += "-----------------------------------\n";
    		return test;
    	} else {
    		test += "Ao final de um longa jornada, Bork, um aventureiro experiente, finalmente chega\nperto do seu objetivo!";
    		test +=	"\nSeguindo os rastros de seu pai, ele procura por seu paradeiro.";
    		test +=	"\nSubindo a Montanha da Prata, Bork chega em frente a um velho chale abandonado...";
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
            				resposta = "Voce ja esta no chale.";
            				break;
            				} 
					else {
            					r.setLocal('H');
            					resposta = r.getDescription();
            					r.setIsAtTheHouse(true);
            					c.addPoints(p, 10);
            				}
        				break;
        		}
        		break;
        		
            case "pegar":
            	switch (object) {
                	case "espada":
                		if (w.isEquipped()) {
                			resposta += "Voce já tem uma arma.";
                			break;
                		}  
                		else {
                			c.addPoints(p,30);
                			w.setName("sword");
                			w.setEquipped(true);
                			resposta += "Voce agora tem uma espada.";
                		} 
                		break;
                	case "machado":
                		if (w.isEquipped()) {
                			resposta += "Voce já tem uma arma.";    
                		}  
                		else {
                			c.addPoints(p,30);
                			w.setName("axe");
                			w.setEquipped(true);
                			resposta += "Voce agora tem um machado.";
                		} 
                		break;
                	case "garrafa":
                		if (r.isBottleIsTaken()){
                			resposta += "Voce já pegou a garrafa.";
                		}
                		else {
                			r.setBottleIsTaken(true);
                			resposta += "Voce pega a garrafa. Ele contem um líquido, que é uma pocao de cura.";
                			c.addPoints(p,30);
                		}
                		break;
					case "comida":
						if (r.isFoofIsTaken()){
							resposta += "Voce já pegou a comida.";
						}
						else {
							r.setFoodIsTaken(true);
							resposta += "Voce pega a comida para viagem. O maior inimigo sempre sera a fome!";
							c.addPoints(p,30);
						}
						break;
					default:
						resposta += "Opcao invalida!";
            	}
            	break;
            case "mover":
            	switch (object) {
                	case "tapete":
                		if (r.isRugIsRemoved()) {
                			resposta += "O tapete ja foi movido.";
                		}
                		else {
                			c.addPoints(p,40);
                			r.setRugIsRemoved(true);
                			resposta += "Voce remove o tapete, revelando no piso uma pequena escotilha de madeira.";
                		}
                		break;
					default:
						resposta += "Opcao invalida!";
            	}
            	break;
            case "abrir":
            	switch (object) {
                	case "escotilha":
                		if (r.isTrapdoorIsOpen()) {
                			resposta += "A escotilha ja esta aberta.";
                		}
                		else if (r.isRugIsRemoved()) {
                			c.addPoints(p,40);
                			r.setTrapdoorIsOpen(true);
                			resposta += "Voce abre a escotilha. Embaixo esta uma longa escada, que desce ate a escuridao.";                    
                		}                  
                		break; 
					default:
						resposta += "Opcao invalida!";
            	}
            	break;
            case "descer":
            	switch (object) {
            		case "escada":
            			if (r.isTrapdoorIsOpen()) {
            				if (w.isEquipped()) {
            					c.addPoints(p,40);
            					r.setIsAtTheHouse(false);
								r.setLocal('C');
								resposta += "\n" +r.getDescription();
            				}
            				else {
            					w.setName("fists");
            					r.setIsAtTheHouse(false);
            					resposta +=  "Voce desce as escadas com os punhos cerrilhados. Eles e sua coragem serao \nsua unica arma...\n";
            					c.addPoints(p,40);
            					r.setLocal('C');
            					resposta += "\n" +r.getDescription();
            				}                        
            			}
            			break;
					default:
						resposta += "Opcao invalida!";
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
            						c.addPoints(p,100);
            						resposta += "Golpe fatal! Voce esmurra a fera, \ntirando-lhe 10 pontos de vida.\n";
            						resposta += d.getDragonSpeech(w.getName());
            						if(d.getHealth() <= 0) {
            							r.setLocal('F');
            							resposta += "\nVocê chegou ao fim da sua jornada, o poderoso dragão foi derrotado, mas o paradeiro de seu pai ainda é inconclusivo.";
            							if(w.getName().equals("fists")) {
            								// get achievement the bork
            								AchievementC a = new AchievementC("Dwayne 'The Bork' Johnson");
            								c.addAchievements(p,a);
            							}
            							if(b.getHealth() == 20 && !(r.isBottleIsTaken())) {
            								//get achievement intocado
            								AchievementC a = new AchievementC("Intocado");
            								c.addAchievements(p,a);
            							}
            							c.addPoints(p,350);
                        			}
            						break;
            					case 5:
            						d.setHealth(d.getHealth() - w.getDamage());
            						c.addPoints(p,50);
            						resposta += "Acerto critico! Voce desfere um grande golpe; \natarantado, o dragao perde 5 pontos de vida.\n";
            						resposta += d.getDragonSpeech(w.getName());
            						if(d.getHealth() <= 0) {
            							r.setLocal('F');
            							resposta += "\nVocê chegou ao fim da sua jornada, o poderoso dragão foi derrotado, mas o paradeiro de seu pai ainda é inconclusivo.";
            							if(w.getName().equals("fists")) {
            								// get achievement the bork
            								AchievementC a = new AchievementC("Dwayne 'The Bork' Johnson");
            								c.addAchievements(p,a);
            							}
            							if(b.getHealth() == 20 && !(r.isBottleIsTaken())) {
            								//get achievement intocado
            								AchievementC a = new AchievementC("Intocado");
            								c.addAchievements(p,a);
            							}
            							c.addPoints(p,350);
                        			}
            						break;
            					case 4:
            						d.setHealth(d.getHealth() - w.getDamage());
            						c.addPoints(p,50);
            						resposta += "Sucesso! Voce acerta o pescoco da fera, \nfazendo 4 pontos de dano.\n";
            						resposta += d.getDragonSpeech(w.getName());
            						if(d.getHealth() <= 0) {
            							r.setLocal('F');
            							resposta += "\nVocê chegou ao fim da sua jornada, o poderoso dragão foi derrotado, mas o paradeiro de seu pai ainda é inconclusivo.";
            							if(w.getName().equals("fists")) {
            								// get achievement the bork
            								AchievementC a = new AchievementC("Dwayne 'The Bork' Johnson");
            								c.addAchievements(p,a);
            							}
            							if(b.getHealth() == 20 && !(r.isBottleIsTaken())) {
            								//get achievement intocado
            								AchievementC a = new AchievementC("Intocado");
            								c.addAchievements(p,a);
            							}
            							c.addPoints(p,350);
                        			}
            						break;
            					case 3:
            						d.setHealth(d.getHealth() - w.getDamage());
            						c.addPoints(p,30);
            						resposta += "Sucesso! Voce acerta o pescoco da fera, \nfazendo 3 pontos de dano.\n";
            						resposta += d.getDragonSpeech(w.getName());
            						if(d.getHealth() <= 0) {
            							r.setLocal('F');
            							resposta += "\nVocê chegou ao fim da sua jornada, o poderoso dragão foi derrotado, mas o paradeiro de seu pai ainda é inconclusivo.";
            							if(w.getName().equals("fists")) {
            								// get achievement the bork
            								AchievementC a = new AchievementC("Dwayne 'The Bork' Johnson");
            								c.addAchievements(p,a);
            							}
            							if(b.getHealth() == 20 && !(r.isBottleIsTaken())) {
            								//get achievement intocado
            								AchievementC a = new AchievementC("Intocado");
            								c.addAchievements(p,a);
            							}
            							c.addPoints(p,350);
                        			}
            						break;
            					case 0:
            						b.setHealth(b.getHealth() - d.getDamage());
            						c.addPoints(p,-50);
            						resposta += "Errou! Seu golpe passa a centimetros do dragao. \nIleso, ele revida, fazendo 5 pontos de dano\n";
            						resposta += d.getDragonSpeech(w.getName());
            						break;
            				}
						default:
							resposta += "Opção Invalida";	
            		}
            	case "usar":
            		switch (object) {
            			case "pocao":
            				if (r.isBottleIsTaken()) {
            					if (b.getHealth() > 16) {
            						resposta += "Voce ja esta com a vida bem cheia.";
            					}
            					else {
            						b.setHealth(b.getHealth() + 4);
            						c.addPoints(p,30);
            						resposta += "Voce bebe a pocao de cura, recuperando 4 pontos de vida.";
            						resposta += "SUA VIDA: " + b.getHealth();
            						r.setBottleIsTaken(false);
            					}
            				}
            				else {
            					resposta += "Voce nao tem nenhuma pocao.";
            				}
            				break;
            			case "comida":
            				if(r.isFoofIsTaken()) {
            					resposta += "Você quer comer no meio de uma luta? Acha que isso é um vídeo game?";
            					// get achievement detetive
            					AchievementC a = new AchievementC("Detetive");
            					c.addAchievements(p,a);
            				}
            				break;
						default:
							resposta += "Opção Invalida";
            		} 
            	case "mostrar":
            		switch (object) {
                		case "vida":
                			resposta += "SUA VIDA: " + b.getHealth();
                			resposta += "\nVIDA DO DRAGAO: " + d.getHealth();
                			c.addPoints(p,10);
                			break;
						default:
							resposta += "Opcao invalida!";
            		} 
            	case "atirar":
            		switch (object) {
                		case "pedra":
                			d.setHealth(d.getHealth() - 1);
                			resposta += "Voce pega uma pedrinha do chao e a atira na fera, \nfazendo 1 misero ponto de dano. Patetico.";
                			if(d.getHealth() <= 0) {
                				resposta += "\nVocê chegou ao fim da sua jornada, o poderoso dragão foi derrotado, mas o paradeiro de seu pai ainda é inconclusivo.";
                				r.setLocal('F');
                				c.addPoints(p,400);
                			}
                			break;
						case "comida":
							resposta += "Dragão: MEU LANCHINHOOOOOOOO!!! Muito obrigado amigo, eu estava \ncom muita fome desde que o Sr. Bork sumiu... sinto sua falta...\n";
							c.addPoints(p,400);
							r.setLocal('F');
							// get achievement bff
							AchievementC a = new AchievementC("Best Friends Forever");
							c.addAchievements(p,a);
							resposta += "\nVocê chegou ao fim da sua jornada, o dragão jorge virou um grande amigo\n e agora ambos estão a procura do seu pai.. o Senhor Bork.";
							break;
						default:
							resposta += "Opcao invalida!";
            		}                           
        	}
       } else if(r.getLocal()=='F') {
    	   resposta += "\nFIM!";
       }
        return resposta;
   }
    
    public void save(){
    	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dataPlayer.bin"))) {
    		oos.writeObject(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
    		
    }
    
    public int getActivations() {
    	try(BufferedReader br = new BufferedReader(new FileReader("inicializacao.txt"))) {
    		String texto = br.readLine();
    		vezesAcionado = Integer.parseInt(texto) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return vezesAcionado;
    }
    
    public int getHowManyPlayers() {
    	ArrayList<Player> listP = new ArrayList<>();
    	try {
    		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dataPlayer.bin"))) {
				while(true) {
					Player pl = (Player) ois.readObject();
					listP.add(pl);
				}
			}
    		} catch (IOException | ClassNotFoundException e) {
    			e.printStackTrace();
    		}
    	return listP.size();
    }

    public Player getWorstPlayer() {
    	ArrayList<Player> listP = new ArrayList<>();
		Player wp = null;
    	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dataPlayer.bin"))) {
				while(true) {
					Player pl = (Player) ois.readObject();
					listP.add(pl);
				}
			
    		} catch (IOException | ClassNotFoundException e) {
    			e.printStackTrace();
    		}
    	for(Player p: listP) {
    		
    		if(wp.compareTo(p) > 0 || wp == null) {
    			wp = p;
    		}
    	}
    	
    	return wp;
    }

    public Player getBestPlayer() {
    	ArrayList<Player> listP = new ArrayList<>();
		Player bp = null;
    	try {
    		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dataPlayer.bin"))) {
				while(true) {
					Player pl = (Player) ois.readObject();
					listP.add(pl);
				}
			}
    		} catch (IOException | ClassNotFoundException e) {
    			e.printStackTrace();
    		}
    	for(Player p: listP) {
    		
    		if(bp.compareTo(p) < 0 || bp == null) {
    			bp = p;
    		}
    	}
    	return bp;
    }

    public int getWorstPlayerPoints() {
    	return getWorstPlayer().getPoints();
    }

    public int getBestPlayerPoints() {
    	return getBestPlayer().getPoints();
    }
    
    public String getName() {
    	return "Bork";
    }
    
    public String getDescription() {
    	return "Um jogo estilo rpg o qual o jogador escolhe e realiza suas ações com caixas texto, o limite é a imaginação.";
    }
    
    public JPanel getPanel() {
    	Presentation pane = new Presentation();
    	return pane.returnPanel();
    }
    
    public void start(Player p) {
    	this.p = p;
    	this.vezesAcionado++;
    	//contando vezes acionado
    	try {
			FileWriter fw = new FileWriter("inicializacao.txt");
			fw.write(""+vezesAcionado);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	// escrevendo o player
    	try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dataPlayer.bin"))){
    		oos.writeObject(p);
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}