package c04.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 象棋棋盘
 */
public class ChessBoard {
    private Map<Integer, ChessPiece> chess = new HashMap<>();

    private void init() {
        chess.put(1, new ChessPiece(ChessFactory.pieces.get(1), 5, 0)); //帅的位置
        // todo : 摆棋
    }

}
