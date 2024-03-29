import java.util.Scanner;
public class Code {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] board = new char[3][3];
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;

        while(!gameOver){
            print(board);
            System.out.print("Player "+player+" Enter move : ");
            int row = in.nextInt();
            int col = in.nextInt();
            if(board[row][col] == ' '){
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if(gameOver){
                    System.out.println("Congratulations Player "+player+" have won the game");
                }else{
                    player = (player == 'X') ? '0' : 'X';
                }
            }else{
                System.out.println("Invalid move try again");
            }
        }
        print(board);
    }
    private static boolean haveWon(char[][] board, char player){
        // check row wise
        for(int row = 0; row < board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        // check col wise
        for(int col = 0; col < board.length; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
        // check diagonal wise
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        // if none of the above true then the game is not over return false
        return false;
    }
    private static void print(char[][] board){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                System.out.print("| "+board[row][col]+" |");
            }
            System.out.println();
        }
    }
}
