public class Cave {
    private String description;

    public Cave(String d) {
        this.setDescription(d);
    }

    public void setDescription() {
        this.description = "Descendo as escadas, voce chega a uma caverna subterranea. Nela ha um enorme dragao adormecido. Ele acorda com o barulho, e, vendo voce, prepara-se para desferir um golpe.";
    }

    public String getDescription() {
        return description;
    }   
}
