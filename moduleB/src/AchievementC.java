import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AchievementC implements Achievement{
	private String name;
	private String motivation;
	private Image imagem;
	
	public String getName() {
		return name;
	}

	public String getMotivation(){
		if(name.equals("Dwayne 'The Bork' Johnson")) {
			motivation = "Matar dragão no murro.";
		}else if(name.equals("Detetive")) {
			motivation = "Achar o easter egg escondido.";
		}else if(name.equals("Intocado")) {
			motivation = "Matar o dragão sem levar dano.";
		}else if(name.equals("Best Friends Forever")) {
			motivation = "Tornar-se amigo do dragão.";
		}
		
		return motivation;
	}
	
	public Image getImagem() {
		try {
			if(name.equals("Dwayne 'The Bork' Johnson")) {
				this.imagem = ImageIO.read(this.getClass().getResource("\Imagens/DwayneTheBorkJohnson.jpg"));
			}else if(name.equals("Detetive")) {
				this.imagem = ImageIO.read(this.getClass().getResource("\Imagens/Detetive.jpg"));
			}else if(name.equals("Intocado")) {
				this.imagem = ImageIO.read(this.getClass().getResource("\Imagens/intocado.jpg"));
			}else if(name.equals("Best Friends Forever")) {
				this.imagem = ImageIO.read(this.getClass().getResource("\Imagens/bff.jpg"));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imagem;
	}
		
	public void setName(String n) {
		this.name = n;		
	}

}
