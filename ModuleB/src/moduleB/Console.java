package moduleB;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Classe que comanda a plataforma do jogo, sendo respons�vel por identificar o
 * usu�rio e fazer com que ele selecione o jogo. <br>
 * Por meio dela � que o jogo ser� instanciado (construtor do jogo), colocado na
 * �rea de visualiza��o (<i>getPanel</i>) e iniciado (<i>start</i>). <br>
 * <br>
 * Desenvolvido em Java 11.
 * 
 * @author Marcel Hugo e turma de POO 22/1 (BCC/SIS)
 *
 * @version 1.1.0
 *
 */
public class Console implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String NOME_TESTE = "F";
	// private static final String[] EQUIPES = { NOME_TESTE, NOME_TESTE, NOME_TESTE,
	// NOME_TESTE, NOME_TESTE, NOME_TESTE };
	private static final String[] EQUIPES = { "F", "D", "B" }; // , "GameC", "GameD", "GameE", "GameG", "GameH",
	// "GameI", "GameJ", "GameK", "GameP"};

	private static Console singleton;
	private HashMap<String, Player> players = new HashMap<>(); // nickname, player
	private transient HashMap<String, Game> games = new HashMap<>(); // name, game

	private Console() {
	}

	public void loadGames() {
		for (int num = 0; num < EQUIPES.length; num++) {
			this.loadGame(EQUIPES[num]);
		}
		// linha abaixo apenas para primeiros testes
		this.addPlayer(new Player("Teste", "Feroz"));
	}

	protected Game loadGame(String letra) {
		letra = "module" + letra + ".Game" + letra;
		Game g = this.loadClass(letra);
		this.addGame(g);
		return g;
	}

	private Game loadClass(String name) {
		Game g = null;
		Class<?> c;
		try {
			c = Class.forName(name);
			Constructor<?>[] construtor = c.getDeclaredConstructors();
			g = (Game) construtor[0].newInstance();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, name + " = " + e.getClass().getName() + ":" + e.getMessage());
			// e.printStackTrace();
		}
		return g;
	}

	/**
	 * M�todo para retornar o objeto de Console que est� comandando o
	 * <i>espet�culo</i>. <br>
	 * O jogo precisar� conhecer este objeto para poder comunicar na finaliza��o da
	 * rodada a pontua��o obtida pelo jogador (por meio do m�todo <i>addPoints</i>)
	 * e os trof�us conquistados pelo jogador (m�todo <i>addAchievements</i>).
	 * 
	 * @return Console - objeto de Console que est� ativo e comandando a plataforma.
	 * 
	 */
	public static Console getInstance() {
		if (singleton == null) {
			singleton = new Console();
		}
		return singleton;
	}

	public void addPlayer(Player p) {
		if (!players.containsKey(p.getNickname())) {
			players.put(p.getNickname(), p);
		}
	}

	protected void addGame(Game g) {
		if (g != null) {
			String key = String.valueOf(g.getName().charAt(0)).toUpperCase();
			if (!games.containsKey(key)) {
				games.put(key, g);
			}
		}
	}

	/**
	 * M�todo para indicar para a Console quantos pontos devem ser adicionados na
	 * pontua��o de um jogador ap�s um jogo.
	 * 
	 * @param player indica qual jogador (Player) deve receber a pontua��o.
	 * @param points indica qual a quantidade de pontos (int) deve ser somada �
	 *               pontua��o atual do jogador.
	 * 
	 * @throws IllegalArgumentException caso a pontua��o esteja fora dos limites
	 *                                  [0..1000] ou o jogador n�o esteja registrado
	 *                                  na Console.
	 */
	public void addPoints(Player player, int points) {
		if (points < 0 || points > 1000) {
			throw new IllegalArgumentException("Points are out of range [0..1000]");
		}
		Player p = players.get(player.getNickname());
		if (p == null) {
			throw new IllegalArgumentException("Player is not available. Try another...");
		}
		p.sumPoints(points);
		System.out.println(p.getNickname() + " com pontua��o atualizada: " + p.getPoints());
	}

	/**
	 * M�todo para adicionar mais um trof�u � galeria do jogador. N�o verifica se o
	 * jogador j� possui o trof�u que est� sendo adicionado.
	 * 
	 * @param player indica qual jogador (Player) est� recebendo o trof�u.
	 * @param achie  � o objeto de Achievement que ser� inserido na galeria de
	 *               trof�us do jogador indicado.
	 * 
	 * @throws IllegalArgumentException caso achie seja nulo ou o jogador n�o esteja
	 *                                  registrado na Console.
	 */
	public void addAchievements(Player player, Achievement achie) {
		if (achie == null) {
			throw new IllegalArgumentException("Invalid achievement");
		}
		Player p = players.get(player.getNickname());
		if (p == null) {
			throw new IllegalArgumentException("Player is not available. Try another...");
		}
		p.addAchievement(achie);
		System.out.println(p.getNickname() + " com mais um trof�u: " + achie.getName());
	}

	public List<Player> getRanking() {
		ArrayList<Player> result = new ArrayList<>(this.players.values());
		result.sort(Comparator.reverseOrder());
		return result;
	}

	public List<String> getGames() {
		ArrayList<String> gameNames = new ArrayList<>(games.keySet());
		gameNames.sort(null);
		return gameNames;
	}

	public Game getGame(String name) {
		return games.get(name);
	}

	public Player getPlayer(String nick) {
		return players.get(nick);
	}
}
