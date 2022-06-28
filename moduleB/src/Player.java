import java.io.Serializable;

public class Player implements Serializable{
	private String nomeCompleto;
	private String nickName = "Jog";
	private int pontuacao;
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNome(String nC) {
		this.nomeCompleto = nC;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String n) {
		this.nickName = n;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int p) {
		this.pontuacao = p;
	}

}
