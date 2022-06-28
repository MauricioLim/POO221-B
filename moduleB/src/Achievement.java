import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Achievement {
	private String name;
	private String motivo;
	private Image imagem;
	
	public String getName() {
		return name;
	}

	public String getMotivo(){
		return motivo;
	}
	
	public Image getImagem() {
		return imagem;
	}
		
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMotivo(String m) {
		this.motivo = m;
	}
	
	public void setImagem(String pathImg) {
		try {
			this.imagem = ImageIO.read(this.getClass().getResource(pathImg));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
