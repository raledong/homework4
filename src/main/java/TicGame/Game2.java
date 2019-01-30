package TicGame;

import java.util.Scanner;

/**
 * author: rale
 * createdAt: 1/24/19
 */
public class Game2 {
    private int[][] board ;

    private int players;

    public Game2(int players, int boardLength) {
    }

    /**
     * 放棋，如果该位置可以放置棋子，则返回true，否则返回false
     * @param playerId
     * @param x
     * @param y
     * @return
     */
    public boolean play(int playerId, int x, int y) {
        return false;

    }

    /**
     * 判断游戏是否结束
     * @return
     */
    public boolean isOver() {
        return false;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

    }

    public static void main(String[] args) {
        System.out.println("游戏开始");
        System.out.println("请输入棋盘格式，可输入3，7, 9");

        //用户选择棋盘规格
        Scanner scanner = new Scanner(System.in);

        Game game = new Game();
        game.start();
    }
}
