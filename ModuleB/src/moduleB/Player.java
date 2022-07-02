package moduleB;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que representa um jogador na plataforma de jogos (<i>gameplace</i>). Os jogadores s�o gerenciados pela Console.
 * <br>Esta classe � serializ�vel (Serializable) e compar�vel (Comparable).
 * <br><br>Desenvolvido em Java 11.
 * 
 * @author Marcel Hugo e turma de POO 22/1 (BCC/SIS)
 *
 * @version 1.0.0
 *
 */
public class Player implements Comparable<Player>, Serializable {
	private static final long serialVersionUID = 1L;
	private String fullName;
	private String nickname;
	private int points;
	private ArrayList<Achievement> achies = new ArrayList<>();

	protected Player(String full, String nick) {
		this.fullName = full;
		this.nickname = nick;
	}

	/**
	 * M�todo que retorna o nome completo do jogador.
	 *   
	 * @return String - nome do jogador.
	 * 
	*/	
	public String getName() {
		return fullName;
	}

	protected void setName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * M�todo que retorna o apelido (<i>nickname</i>) do jogador. 
	 * � por esse apelido que ele se identifica e figura no ranking. Logo, n�o haver� dois jogadores com o mesmo apelido. 
	 *   
	 * @return String - apelido do jogador.
	 * 
	*/
	public String getNickname() {
		return nickname;
	}

	protected void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * M�todo que retorna a pontua��o atual do jogador, acumulada em todos os jogos que jogou na plataforma. 
	 *   
	 * @return int - pontua��o atual acumulada.
	 * 
	*/
	public int getPoints() {
		return points;
	}

	protected void sumPoints(int morePoints) {
		this.points += morePoints;
	}

	protected void addAchievement(Achievement a) {
		if (a != null) {
			achies.add(a);
		}
	}

	protected ArrayList<Achievement> getAchievementList() {
		return this.achies;
	}

	@Override
	public int compareTo(Player other) {
		return (this.getPoints() - other.getPoints());
	}
}
