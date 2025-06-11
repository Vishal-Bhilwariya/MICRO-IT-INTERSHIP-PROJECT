package Projects;
import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        // 3 X 3 matrix
        char[][] board = new char[3][3];
        // fill empty space
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j] = ' ';
            }
        }

        char player = 'X' ; // Player with X will initiate the game
        boolean isGameFinished = false;

        while (!isGameFinished){
            // print the board
            printTheBoard(board);
            System.out.println("Player "+player+" will choose the next place :");
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.print("Enter row --> ");
                int row = sc.nextInt();
                System.out.print("Enter column --> ");
                int col = sc.nextInt();
                if(row < 0 || row > 3 || col < 0 || col > 3){
                    System.out.println("INVALID INDEX ( Index out of bound )");
                }
                else if(board[row][col] == ' '){ // we can place here
                    board[row][col] = player;
                    isGameFinished = haveWon(board,player);
                    if(isGameFinished){
                        printTheBoard(board);
                        System.out.println("Player "+player+" have won the game");
                        break;
                    }else{
                        if(player=='X') player = 'O';
                        else player = 'X';
                    }
                    break;
                }else{ // already exist -- so can not place here
                    System.out.println("Invalid place");
                    System.out.println("Player "+player+"will choose the next place again:");
                }
            }
        }
    }
    public static void printTheBoard(char[][] board){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]);
                if(j != 2) System.out.print('|');
            }
            System.out.println();
        }
    }
    public static boolean haveWon(char[][] board,char player){
        // check in row
        for (int i = 0; i < 3; i++) {
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player){
                return true;
            }
        }
        // check in col
        for (int i = 0; i < 3; i++) {
            if(board[0][i] == player && board[1][i] == player && board[2][i] == player){
                return true;
            }
        }
        // check diagonally
        if((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

}
