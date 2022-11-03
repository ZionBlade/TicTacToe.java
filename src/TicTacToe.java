import java.util.Scanner;

public class TicTacToe
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        boolean finished = false;
        boolean playing = true;
        Scanner in = new Scanner(System.in);
        String player = "X";
        int moveCnt = 0;
        int row = -1;
        int col = -1;
        final int MOVES_FOR_WIN = 5;
        final int MOVE_FOR_TIE = 7;

        do //program loop
        {
            //begin a game
            player = "X";
            playing = true;
            moveCnt = 0;
            clearBoard();

            do //game loop
            {
                //get the move
                do
                {
                    display();
                    System.out.println("Enter move for " + player);

                }
            }
        }
    }

    private static void clearBoard()
    {
        //sets all the board elements to a spave
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                board[row][col] = " ";
            }
        }
    }

    private static void display()
    {
        //shows the tic tac toe game
        for(int row = 0; row < ROW; row++)
        {
            System.out.print("| ");
            for(int col = 0; col < COL; col++)
            {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col)
    {
        boolean retVal = false;
        if(board[row][col].equals(" "))
        {
            retVal = true;
        }
        return retVal;
    }

    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }

        return false;
    }

    private static boolean isColWin(String player)
    {
        //checks for a col win for a specified player
        for(int col = 0; col < COL; col++)
        {
            if (board(0)[col].equals(player) &&
                    board[1][col].equals(player) &&
                    board[2][col].equals(player))
            {
                return true;
            }
        }
        return false; // no col win
    }

    private static boolean isRowWin(String player)
    {
        //checks for a row win for the specified player
        for (int row = 0; row < ROW; row++)
        {
            if(board[row][0].equals(player) &&
            board[row][1].equals(player) &&
            board[row][2].equals(player))
            {
                return true;
            }
        }
        return false; // now row win
    }

    private static boolean isDiagonalWin(String player)
    {
        //checks for a diagonal win for the specified player
        if(board[0][0].equals(player) &&
        board[1][1].equals(player) &&
        board [2][2].equals(player))
        {
            return true;
        }
        return false;
    }
    //checks for a tie before board is filled.
    //check for the win first to be efficient
    private static boolean isTie()
    {
        boolean xFlag = false;
        boolean oFlag = false;
        //check all 8 win vectors for an x and o so
        //no win is possible
        //check for row ties
        for(int row = 0; row < ROW; row++)
        {
            if(board[row][0].equals("X") ||
            board[row][1].equals("X") ||
            board[row][2].equals("X"))
            {
                xFlag = true; //three is an x in this row
            }
            if(board[row][0].equals("O") ||
                    board[row][1].equals("O") ||
                    board[row][2].equals("O"))
            {
                oFlag = true; // there is an O in this row
            }

            if(! (xFlag && oFlag) )
            {
                return false; // no tie can still have a row win
            }
            xFlag = oFlag = false;
        }
        //now scan the columns
        for (int col = 0; col < COL; col++)
        {
            if(board[0][col].equals("X") ||
                    board[1][col].equals("X") ||
                    board[2][col].equals("X"))
            {
                xFlag = true; //three is an x in this col
            }
            if(board[0][col].equals("O") ||
                    board[1][col].equals("O") ||
                    board[2][col].equals("O"))
            {
                oFlag = true; // there is an O in this col
            }

            if(! (xFlag && oFlag) )
            {
                return false; // no tie can still have a col win
            }
        }
        //now check for the diagonals
        xFlag = oFlag = false;

        if(board[0][0].equals("X") ||
                board[1][1].equals("X") ||
                board[2][2].equals("X"))
        {
            xFlag = true; //three is an x in this col
        }
        if(board[0][0].equals("O") ||
                board[1][1].equals("O") ||
                board[2][2].equals("O"))
        {
            oFlag = true; // there is an O in this col
        }

        if(! (xFlag && oFlag) )
        {
            return false; // no tie can still have a col win
        }

        //checked every vector so I know I have a tie
        return true;

    }
}
