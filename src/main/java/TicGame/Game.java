package TicGame;

import java.util.Scanner;

/**
 * author: rale
 * createdAt: 1/24/19
 */
public class Game {

    private int[][] board ;

    private int players;
    /**
     * 已经进行的游戏回合数
     */
    private int round;

    private static final int WIN_COUNT = 3;

    public Game() {
        board = new int[7][7];
        players = 2;
    }

    /**
     * 放棋，如果该位置可以放置棋子，则返回true，否则返回false
     * @param playerId
     * @param x
     * @param y
     * @return
     */
    public boolean play(int playerId, int x, int y) {
        if (x<0 || x>=board.length || y<0 || y>=board.length || board[x][y] != 0) return false;
        board[x][y] = playerId;
        //回合数加一
        round++;
        return true;
    }

    /**
     * 返回下一个放子的玩家的编号
     * @return
     */
    public int nextPlayerId() {
        return round % players + 1;
    }

    /**
     * 判断游戏是否结束
     * 棋盘是否已经满格
     * @return
     */
    public boolean isOver() {
        for (int i = 0 ; i<board.length ; i++) {
            for (int j = 0 ; j<board[i].length ; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }

    /**
     * 判断该玩家走完这一步后是否赢了
     * @param playerId
     * @param x
     * @param y
     * @return
     */
    public boolean win(int playerId, int x, int y) {
        int count = 1;
        int startX = x-1;
        while (startX >= 0 && board[startX][y] == playerId) {
            count++;
            startX--;
        }

        startX = x+1;
        while (startX < board.length && board[startX][y] == playerId){
            count++;
            startX++;
        }
        if (count>=WIN_COUNT) {
            return true;
        }

        count = 1;
        int startY = y-1;
        while(startY >=0 && board[x][startY] == playerId) {
            count++;
            startY--;
        }

        startY = y+1;
        while(startY <board.length && board[x][startY] == playerId) {
            count++;
            startY++;
        }
        if (count>=WIN_COUNT) {
            return true;
        }

        count = 1;
        startX = x-1;
        startY = y-1;
        while (startX >= 0 && startY >= 0 && board[startX][startY] == playerId) {
            count++;
            startX--;
            startY--;
        }

        startX = x+1;
        startY = y+1;
        while (startX < board.length && startY < board.length && board[startX][startY] == playerId) {
            count++;
            startX++;
            startY++;
        }
        if (count>=WIN_COUNT) {
            return true;
        }

        count = 1;
        startX = x-1;
        startY = y+1;
        while (startX >= 0 && startY < board.length && board[startX][startY] == playerId) {
            count++;
            startX--;
            startY++;
        }
        startX = x+1;
        startY = y-1;
        while (startX < board.length && startY >= 0 && board[startX][startY] == playerId){
            count++;
            startX++;
            startY--;
        }
        if (count >= WIN_COUNT) {
            return true;
        }
        return false;
    }

    /**
     * 打印棋盘
     */
    public void printBoard() {
        for(int i = 0 ; i<board.length ; i++ ){
            for (int j = 0 ; j<board[0].length ;j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (!isOver()) {
            System.out.println("当前棋盘如下");
            printBoard();

            //获取下一个执子的玩家编号
            int id = nextPlayerId();

            System.out.println("请" + id + "号玩家输入棋子的位置");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            boolean success = play(id, x, y);


            if (!success) {
                System.out.println("该位置不可放置棋子");
                continue;
            }

            //如果当前玩家执子后胜出，则游戏结束
            if (win(id, x, y)) {
                System.out.println("恭喜" + id + "号玩家获胜，游戏结束");
                printBoard();
                break;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("游戏开始");
        Game game = new Game();
        game.start();
    }
}
