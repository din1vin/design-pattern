package c04.flyweight;

public class ChessPiece {
    private final ChessPieceUnit chessPieceUnit;

    private int x;
    private int y;

    public ChessPiece(ChessPieceUnit chessPieceUnit, int x, int y) {
        this.chessPieceUnit = chessPieceUnit;
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
