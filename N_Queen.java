class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];

        // init
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solveNQueensUtil(0, board, n, ans);
        return ans;

    }

    public static boolean isSafe(char board[][], int row, int col, int n) {
        // Check for queens in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check for queens in the upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check for queens in the upper right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            list.add(row);
        }

        return list;
    }

    public void solveNQueensUtil(int row, char board[][], int n , List<List<String>> ans) 
    {
        //conf generated success
        if(row==n)
        {
            ans.add(construct(board));
        }

        //try placin queen in every col for that row
        for(int col=0;col<n;col++)
        {
            if(isSafe(board,row,col,n))
            {
                //place queen in curr row and col
                board[row][col] = 'Q';
            
                //check for next row
                solveNQueensUtil(row+1,board,n,ans);
                
                board[row][col]= '.';

            }

        }

    }
}
