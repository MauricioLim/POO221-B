public class Room {
    private char local = 'H';
    private boolean isAtTheHouse;
    private boolean rugIsRemoved;
    private boolean trapdoorIsOpen;
    private boolean bottleIsTaken;
    private boolean foodIsTaken;

    public Room() {
        this.setIsAtTheHouse(true);
        this.setBottleIsTaken(false);
        this.setRugIsRemoved(false); 
        this.setTrapdoorIsOpen(false);
        this.setFoodIsTaken(false);
    }
    
    public char getLocal() {
    	return this.local;
    }
    public void setLocal(char l) {
    	this.local = l;
    }

    public void setIsAtTheHouse(boolean iath) {
    		this.isAtTheHouse = iath;
    }

    public void setBottleIsTaken(boolean bit) {
    	if(isIsAtTheHouse()) {
    		this.bottleIsTaken = bit;
    	} // jogar excessao e dizer player q nao é possivel
    }
    	

    public void setRugIsRemoved(boolean rir) {
    	if(isIsAtTheHouse()) {
    		this.rugIsRemoved = rir;
    	} // jogar excessao e dizer player q nao é possivel
    }

    public void setTrapdoorIsOpen(boolean tio) {
    	if(isIsAtTheHouse()) {
    		this.trapdoorIsOpen = tio;
    	} // jogar excessao e dizer player q nao é possivel
    }
    public void setFoodIsTaken(boolean fit){
        if(isIsAtTheHouse()){
            this.foodIsTaken = fit;
        }// jogar excessao e dizer player q nao é possivel
    }

    public String getDescription() {
    	String desc = "?";
    	if (local == 'H') {
    		desc = "A porta range e uma nuvem de poeira enche o ar.  O chale aparenta ter sido \n abandonado as pressas."
    				+ "Ha lenha cortada junto a um machado de ferro proximo à \n lareira, e uma espada rutilante sobre ela."
    				+ "A direita esta uma pequena mesa \n com um frasco, cheio de um liquido prateado, "
    				+ "junto de comida \n preparada para viagem. No centro do velho chala ha uma belo tapete com \no brasao de sua familia um tanto chamuscado.";
    	} else if(local == 'C') {
    		desc = "Descendo as escadas, o som da madeira rangendo vai se trocando pelo eco \ndos seus passos sobre a pedra fria."
    				+ "O corredor segue ate uma sala bem \niluminada pelo brilho de ouro e prata. "
    				+ "Ao se aproximar da sala voce ve um grande \ndragao vermelho brincando e empilhando pedras em formato de lanca.\n"
    				+ "Percebendo sua presenca, ele se prepara para batalha!";
    	}
        return desc;
    }

    public boolean isIsAtTheHouse() {
        return isAtTheHouse;
    }

    public boolean isRugIsRemoved() {
        return rugIsRemoved;
    }

    public boolean isTrapdoorIsOpen() {
        return trapdoorIsOpen;
    }

    public boolean isBottleIsTaken() {
        return bottleIsTaken;
    }    

    public boolean isFoofIsTaken(){
        return foodIsTaken;
    }
}
