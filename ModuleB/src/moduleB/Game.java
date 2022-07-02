package moduleB;

import javax.swing.JPanel;

/**
 * Interface que define o comportamento de um jogo que pode ser inserido na Console.
 * <br>
 * <br>Desenvolvido em Java 11.
 * 
 * @author Marcel Hugo e turma de POO 22/1 (BCC/SIS)
 *
 * @version 1.0.0
 *
 */
public interface Game {
	/**
	 * M�todo para retornar a quantidade de vezes que este jogo j� foi ativado (m�todo start) pela Console.
	 * @return int - quantidade de ativa��es.
	 * 
	*/
	int getActivations();
	
	/**
	 * M�todo para indicar o jogador que conquistou a mais alta pontua��o deste jogo em todas as suas execu��es.
	 * Este m�todo deve funcionar em conjunto com o m�todo getBestPlayerPoints().
	 * 
	 * @return Player - o jogador que conquistou a mais alta pontua��o. 
	 * 			Caso haja mais de um jogador que tenha obtido esta fa�anha, o jogo pode decidir se mant�m o primeiro ou se retorna o �ltimo a ter conseguido.
	 * 
	*/
	Player getBestPlayer();
	
	/**
	 * M�todo para retornar a mais alta quantidade de pontos obtida por um jogador em uma ativa��o (rodada) deste jogo.
	 * Este m�todo deve funcionar em conjunto com o m�todo getBestPlayer().
	 *  
	 * @return int - quantidade de pontos.
	 * 
	*/
	int getBestPlayerPoints();

	/**
	 * M�todo para retornar a descri��o textual do jogo - uma String mais longa que conta a finalidade do jogo, suas principais caracter�sticas e modo de jogar>
	 *  
	 * @return String - descri��o.
	 * 
	*/
	String getDescription();

	/**
	 * M�todo que retorna a quantidade de jogadores diferentes que j� ativaram este jogo, por meio do m�todo start pela Console.
	 * Se um mesmo jogador joga v�rias vezes o jogo, ele � contabilizado apenas uma vez.
	 *   
	 * @return int - quantidade de jogadores diferentes.
	 * 
	*/
	int getHowManyPlayers();

	/**
	 * M�todo que retorna o nome do jogo.
	 *   
	 * @return String - nome do jogo.
	 * 
	*/
	String getName();
	
	/**
	 * M�todo que retorna o painel (JPanel) que deve ser apresentado na Console para que o jogo seja executado.
	 * Cada jogo possui suas pr�prias caracter�sticas e forma de jogar. Assim cada jogo tem sua pr�pria interface com usu�rio que ser� exibida na Console.
	 * Este painel deve ter o tamanho de 500 x 480 pixels.
	 *   
	 * @return JPanel - painel da interface ao usu�rio do jogo.
	 * 
	*/
	JPanel getPanel();

	/**
	 * M�todo para indicar o jogador que teve a mais baixa pontua��o deste jogo em todas as suas execu��es.
	 * Este m�todo deve funcionar em conjunto com o m�todo getWorstPlayerPoints().
	 * 
	 * @return Player - o jogador que teve a menor pontua��o. 
	 * 	Caso haja mais de um jogador nesta situa��o, o jogo pode decidir se mant�m o primeiro ou se retorna o �ltimo a ter conseguido.
	 * 
	*/
	Player getWorstPlayer();

	/**
	 * M�todo para retornar a menor quantidade de pontos obtida por um jogador em uma ativa��o (rodada) deste jogo.
	 * Este m�todo deve funcionar em conjunto com o m�todo getWorstPlayer().
	 *  
	 * @return int - quantidade de pontos.
	 * 
	*/
	int getWorstPlayerPoints();
	
	/**
	 * M�todo para iniciar (ativar) o jogo para que o jogador informado comece a jogar.
	 *
	 * @param Player p - o jogador que se identificou na Console e selecionou este jogo.
	*/
	void start(Player p);
}
/**
 * @param - descreve os par�metros de um m�todo acompanhado por uma descri��o.
 * 
 * @return int - quantidade de vezes que este jogo j� foi ativado (m�todo start) pela Console
 * 
 * @throws nenhuma exce��o prevista
*/
