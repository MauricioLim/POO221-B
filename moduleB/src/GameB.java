import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

public class GameB {
    private int vezesAcionado;
    private Presentation tela;

	Scanner s = new Scanner(System.in);

    Bork b = new Bork();
    Weapon w = new Weapon();
    Dragon d = new Dragon();
    Room r = new Room();
    Player p;
     
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
            					p.sumPoint(10);
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
                			p.sumPoint(30);
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
                			p.sumPoint(30);
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
                			p.sumPoint(30);
                		}
                		break;
					case "comida":
						if (r.isFoofIsTaken()){
							resposta += "Voce já pegou a comida.";
						}
						else {
							r.setFoodIsTaken(true);
							resposta += "Voce pega a comida para viagem. O maior inimigo sempre sera a fome!";
							p.sumPoint(30);
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
                			p.sumPoint(40);
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
                			p.sumPoint(40);
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
            					p.sumPoint(40);
            					r.setIsAtTheHouse(false);
								r.setLocal('C');
								resposta += "\n" +r.getDescription();
            				}
            				else {
            					w.setName("fists");
            					r.setIsAtTheHouse(false);
            					resposta +=  "Voce desce as escadas com os punhos cerrilhados. Eles e sua coragem serao \nsua unica arma...\n";
            					p.sumPoint(40);
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
            						p.sumPoint(100);
            						resposta += "Golpe fatal! Voce esmurra a fera, \ntirando-lhe 10 pontos de vida.\n";
            						resposta += d.getDragonSpeech(w.getName());
            						if(d.getHealth() <= 0) {
            							if(w.getName.equals("fists")) {
            								// get achievement the bork
            								AchievemetC a = ("Dwayne 'The Bork' Johnson")
            								p.addAchievement(a);
            							}
            							if(b.getHalth() == 20 && !(r.isBottleIsTaken())) {
            								//get achievement intocado
            								AchievemetC a = ("Intocado")
                    						p.addAchievement(a);
            							}
            							p.sumPoint(350);
                        			}
            						break;
            					case 5:
            						d.setHealth(d.getHealth() - w.getDamage());
            						p.sumPoint(50);
            						resposta += "Acerto critico! Voce desfere um grande golpe; \natarantado, o dragao perde 5 pontos de vida.\n";
            						resposta += d.getDragonSpeech(w.getName());
            						if(d.getHealth() <= 0) {
            							if(w.getName.equals("fists")) {
            								// get achievement the bork
            								AchievemetC a = ("Dwayne 'The Bork' Johnson")
            								p.addAchievement(a);
            							}
            							if(b.getHalth() == 20 && !(r.isBottleIsTaken())) {
            								//get achievement intocado
            								AchievemetC a = ("Intocado")
                    						p.addAchievement(a);
            							}
            							p.sumPoint(350);
                        			}
            						break;
            					case 4:
            						d.setHealth(d.getHealth() - w.getDamage());
            						p.sumPoint(50);
            						resposta += "Sucesso! Voce acerta o pescoco da fera, \nfazendo 4 pontos de dano.\n";
            						resposta += d.getDragonSpeech(w.getName());
            						if(d.getHealth() <= 0) {
            							if(w.getName.equals("fists")) {
            								// get achievement the bork
            								AchievemetC a = ("Dwayne 'The Bork' Johnson")
            								p.addAchievement(a);
            							}
            							if(b.getHalth() == 20 && !(r.isBottleIsTaken())) {
            								//get achievement intocado
            								AchievemetC a = ("Intocado")
                    						p.addAchievement(a);
            							}
            							p.sumPoint(350);
                        			}
            						break;
            					case 3:
            						d.setHealth(d.getHealth() - w.getDamage());
            						p.sumPoint(30);
            						resposta += "Sucesso! Voce acerta o pescoco da fera, \nfazendo 3 pontos de dano.\n";
            						resposta += d.getDragonSpeech(w.getName());
            						if(d.getHealth() <= 0) {
            							if(w.getName.equals("fists")) {
            								// get achievement the bork
            								AchievemetC a = ("Dwayne 'The Bork' Johnson")
            								p.addAchievement(a);
            							}
            							if(b.getHalth() == 20 && !(r.isBottleIsTaken())) {
            								//get achievement intocado
            								AchievemetC a = ("Intocado")
                    						p.addAchievement(a);
            							}
            							p.sumPoint(350);
                        			}
            						break;
            					case 0:
            						b.setHealth(b.getHealth() - d.getDamage());
            						p.sumPoint(-50);
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
            						p.sumPoint(30);
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
            				if(r.isFoodIsTaken()) {
            					resposta += "Você quer comer no meio de uma luta? Acha que isso é um vídeo game?";
            					// get achievement detetive
            					AchievemetC a = ("Detetive")
                        		p.addAchievement(a);
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
                			p.sumPoint(10);
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
                				p.sumPoint(400);
                			}
                			break;
						case "comida":
							resposta += "Dragão: MEU LANCHINHOOOOOOOO!!! Muito obrigado amigo, eu estava \ncom muita fome desde que o Sr. Bork sumiu... sinto sua falta...\n";
							p.sumPoint(350);
							// get achievement bff
							AchievemetC a = ("Best Friends Forever")
            				p.addAchievement(a);
							break;
						default:
							resposta += "Opcao invalida!";
            		}                           
        	}
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
    	int worstP = Integer.MAX_VALUE;
		Player wp = null;
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
    		
    		if(p.getPontuacao() < worstP) {
    			worstP = p.getPontuacao();
    			wp = p;
    		}
    	}
    	
    	return wp;
    }

    public Player getBestPlayer() {
    	ArrayList<Player> listP = new ArrayList<>();
    	int bestP = 0;
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
    		
    		if(p.getPontuacao() > bestP) {
    			bestP = p.getPontuacao();
    			bp = p;
    		}
    	}
    	return bp;
    }

    public int getWorstPlayerPoints() {
    	return getWorstPlayer().getPontuacao();
    }

    public int getBestPlayerPoints() {
    	return getBestPlayer().getPontuacao();
    }
    
    public String getName() {
    	return "Bork";
    }
    
    public String getDescription() {
    	return "Um jogo estilo rpg o qual o jogador escolhe e realiza suas ações com caixas texto, o limite é a imaginação.";
    }
    
    public JFrame getPanel() {
    	tela = new Presentation();
    	tela.frame.setVisible(true);
    	return tela.returnPane();
    }
    
    public void Start(Player p) {
    	this.p = p;
    	this.vezesAcionado++;
    	try {
			FileWriter fw = new FileWriter("inicializacao.txt");
			fw.write(""+vezesAcionado);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}
