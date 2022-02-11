package c04.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ChessFactory {
    public static final Map<Integer, ChessPieceUnit> pieces = new HashMap<>();

    //一次创建所有象棋
    static {
        //红旗
        pieces.put(1, new ChessPieceUnit(1, "帅", Color.RED));
        pieces.put(2, new ChessPieceUnit(2, "仕", Color.RED));
        pieces.put(3, new ChessPieceUnit(3, "仕", Color.RED));
        pieces.put(4, new ChessPieceUnit(4, "相", Color.RED));
        pieces.put(5, new ChessPieceUnit(5, "相", Color.RED));
        pieces.put(6, new ChessPieceUnit(6, "馬", Color.RED));
        pieces.put(7, new ChessPieceUnit(7, "馬", Color.RED));
        pieces.put(8, new ChessPieceUnit(8, "車", Color.RED));
        pieces.put(9, new ChessPieceUnit(9, "車", Color.RED));
        pieces.put(10, new ChessPieceUnit(10, "炮", Color.RED));
        pieces.put(11, new ChessPieceUnit(11, "炮", Color.RED));
        pieces.put(12, new ChessPieceUnit(12, "兵", Color.RED));
        pieces.put(13, new ChessPieceUnit(13, "兵", Color.RED));
        pieces.put(14, new ChessPieceUnit(14, "兵", Color.RED));
        pieces.put(15, new ChessPieceUnit(15, "兵", Color.RED));
        pieces.put(16, new ChessPieceUnit(16, "兵", Color.RED));

        //黑旗
        pieces.put(17, new ChessPieceUnit(1, "将", Color.BLACK));
        pieces.put(18, new ChessPieceUnit(2, "士", Color.BLACK));
        pieces.put(19, new ChessPieceUnit(3, "士", Color.BLACK));
        pieces.put(20, new ChessPieceUnit(4, "象", Color.BLACK));
        pieces.put(21, new ChessPieceUnit(5, "象", Color.BLACK));
        pieces.put(22, new ChessPieceUnit(6, "馬", Color.BLACK));
        pieces.put(23, new ChessPieceUnit(7, "馬", Color.BLACK));
        pieces.put(24, new ChessPieceUnit(8, "車", Color.BLACK));
        pieces.put(25, new ChessPieceUnit(9, "車", Color.BLACK));
        pieces.put(26, new ChessPieceUnit(10, "炮", Color.BLACK));
        pieces.put(27, new ChessPieceUnit(11, "炮", Color.BLACK));
        pieces.put(28, new ChessPieceUnit(12, "卒", Color.BLACK));
        pieces.put(29, new ChessPieceUnit(13, "卒", Color.BLACK));
        pieces.put(30, new ChessPieceUnit(14, "卒", Color.BLACK));
        pieces.put(31, new ChessPieceUnit(15, "卒", Color.BLACK));
        pieces.put(32, new ChessPieceUnit(16, "卒", Color.BLACK));
    }
}
