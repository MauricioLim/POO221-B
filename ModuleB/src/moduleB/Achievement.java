package moduleB;

import java.awt.Image;
import java.io.Serializable;

/**
 * Interface que define o comportamento de um trof�u que pode ser conquistado pelos jogadores ao longo do jogo.
 * <br>A interface j� define que Achievement � um objeto serializ�vel (Serializable).
 * <br><br>Desenvolvido em Java 11.
 * 
 * @author Marcel Hugo e turma de POO 22/1 (BCC/SIS)
 *
 * @version 1.0.0
 *
 */
public interface Achievement extends Serializable {
	/**
	 * M�todo que retorna o nome do trof�u.
	 *   
	 * @return String - nome do jogo.
	 * 
	*/
	String getName();
	
	/**
	 * M�todo que retorna a motiva��o do jogador para conquistar o trof�u, ou seja, quais as raz�es que o levaram � conquista.
	 *   
	 * @return String - motiva��o para conquista.
	 * 
	*/
	String getMotivation();
	
	/**
	 * M�todo que retorna uma imagem do trof�u para ser exibido na Console em formato quadrado.
	 * A imagem pode ser de qualquer tamanho, mas a Console ir� converter para 50x50 pixels. Para melhor defini��o, recomend�vel que a imagem j� seja criada pensando nessas dimens�es.   
	 * 
	 * @return java.awt.Image - uma imagem que representa o trof�u.
	 * 
	*/
	Image getImage();
}
