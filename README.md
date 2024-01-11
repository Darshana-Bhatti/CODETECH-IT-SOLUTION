# CODETECH-IT-SOLUTION
for internship java program.
import java.util.Scanner;
import java.util.Random;
public class TicTacToe{
private static char[][] board = {{' ',' ', ' ',},{' ', ' ', ' '},{' ',' ',' '}};
private static char currentPlayer;
private static Scanner scanner=new Scanner(System.in);
  public static void main(String args[])
 {
	 initializeGame();
	 printBoard();
	 while(true){
		 play();
		 printBoard();
		 if(checkWin())
		 {
			 System.out.println("Player" + currentPlayer+ "wins!");
		      break;
		 }
		 if(isBoardFull())
		 {
			 System.out.println("It's a draw!");
			  break;
		 }
		 switchPlayer();
	 }
	 scanner.close();
 }
 private static void initializeGame(){
 System.out.println("Welcome to TicTacToe!");
	 System.out.println("Enter 1 to play aganinst another human or '2'to play against the computer:");
	 int choice = scanner.nextInt();
	 if(choice == 1)
	 {
		 currentPlayer='X';
	 }else if(choice==2)
	 {
		 currentPlayer='X';
		 System.out.println("you are player X. The computer is Player 0.");
	 }else{
		 System.out.println("Invalid choice. Exiting.");
		 System.exit(0);
	 }
 }
 private static void printBoard(){
	 System.out.println("----------------------");
	 for(int i=0; i<3; i++){
		 System.out.println("| ");
		 for(int j=0; j<3; j++)
		 {
			 System.out.println(board[i][j] +" | ");
		 }
System.out.println();
System.out.println("------------------");
	 }
 }
 private static void play(){
	 int row, col;
	 while(true){
		if(currentPlayer =='X'){
			 System.out.println("Player X's turn. Enter row(1-3) and Column (1-3) separated by a space:");
			 row = scanner.nextInt() - 1;
			 col = scanner.nextInt() - 1;
		 }
		 else{
			 System.out.println("Computers turn (Player 0):");
			 row = new Random().nextInt(3);
			 col = new Random(). nextInt(3);
		 }
		 if(isValidMove(row, col)){
			 board[row][col] = currentPlayer;
			  break;
		 }else{
			 System.out.println("Invalid move Try again.");
		 }
	 }
 }
 private static boolean isValidMove(int row, int col){
	 return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
 }
 private static void switchPlayer(){
	 currentPlayer = (currentPlayer == 'X') ? '0' : 'X';
 }
 private static boolean checkWin(){
	 //check rows, columns, and diagonals for win.
	 return checkRows() || checkColumns() || checkDiagonals();
 }
 private static boolean checkRows(){
	 for(int i = 0; i < 3; i++){
		 if(board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer){
			 return true;
		 }
	 }
	 return false;
 }
 private static boolean checkColumns(){
	 for(int i = 0; i<3; i++){
	 if(board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i]== currentPlayer){
			 return true;
		 }
	 }
	 return false;
 }
 private static boolean checkDiagonals(){
	 return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)||
             (board[0][2] == currentPlayer && board [1][1] == currentPlayer && board[2][0] == currentPlayer);
 }
 private static boolean isBoardFull(){
	 for(int i = 0; i < 3; i++){
		 for(int j = 0; j < 3; j++){
			 if(board[i][j] == ' '){
				 return false;
			 }
		 }
	 }
	 return true;
 }
}
 
		 
