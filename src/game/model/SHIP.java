package game.model;

public enum SHIP {

    GREY("views/schipchooser/rocket1.png"),
    WHITE("views/schipchooser/rocket2.png"),
    BLUE("views/schipchooser/rocket3.png");

    String urlShip;

    private SHIP(String urlShip) {
        this.urlShip = urlShip;
    }
}
