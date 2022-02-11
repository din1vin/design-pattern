package c04.flyweight;

/**
 * 象棋棋子享元类
 * 无setter方法
 */
public class ChessPieceUnit {
    private int id;
    private String text;
    private Color color;

    public ChessPieceUnit(int id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }
}
