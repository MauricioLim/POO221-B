public class House {
    private String description;
    private boolean isAtTheHouse;
    private boolean rugIsRemoved;
    private boolean trapdoorIsOpen;
    private boolean bottleIsTaken;

    public House(boolean iath, boolean rir, boolean tio, boolean bit) {
        this.setIsAtTheHouse(iath);
        this.setBottleIsTaken(bit);
        this.setRugIsRemoved(rir); 
        this.setTrapdoorIsOpen(tio);
    }

    public void setDescription() {
        this.description = "Voce esta na sala de estar. Ha uma espada pendurada na parede, e, encostado no sofa, um machado de ferro. Tambem ha um belo tapete no centro e uma mesa redonda com um pequeno frasco de vidro.";
    }

    public void setIsAtTheHouse(boolean iath) {
        this.isAtTheHouse = iath;
    }

    public void setBottleIsTaken(boolean bit) {
        this.bottleIsTaken = bit;
    }

    public void setRugIsRemoved(boolean rir) {
        this.rugIsRemoved = rir;
    }

    public void setTrapdoorIsOpen(boolean tio) {
        this.trapdoorIsOpen = tio;
    }

    public String getDescription() {
        return description;
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
}
