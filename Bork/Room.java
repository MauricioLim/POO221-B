public class Room {
	private char local = 'H';
    private boolean isAtTheHouse;
    private boolean rugIsRemoved;
    private boolean trapdoorIsOpen;
    private boolean bottleIsTaken;
    private boolean foodIsTaken;

    public Room(boolean iath, boolean bit , boolean rir, boolean tio, boolean fit) {
        this.setIsAtTheHouse(iath);
        this.setBottleIsTaken(bit);
        this.setRugIsRemoved(rir); 
        this.setTrapdoorIsOpen(tio);
        this.setFoodIsTaken(fit);
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
    		desc = "A porta range e uma nuvem de poeira enche o local.  O chalé aparenta ter sido \n abandonado as presas,"
    				+ "há lenha cortada junto a um machado de ferro próximo a \n lareira e uma espada cintilante sobre a mesma."
    				+ "A direita está a uma pequena mesa \n com uma garrafa, cheira de um liquido prata em seu interior, "
    				+ "junto com comida \n preparada para viagem. Já ao centro do velho chalé há uma belo tapete com \no brasão de sua família bem chamuscado.";
    	} else if(local == 'C') {
    		desc = "Descendo as escadas o som da madeira rangendo vai sendo substituido pelo eco \ndos seus passos sobre a pedra fria."
    				+ "O corredor segue até uma sala muito bem \niluminada com o brilho do ouro e prata. "
    				+ "Ao se aproximar da sala você vê um grande \ndragão vermelho brincando empilhando pedras em formato de lança.\n"
    				+ "Percebendo sua presença ele se prepara para batalha!!";
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