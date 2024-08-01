//https://leetcode.com/problems/word-search/
class Solution {
    public boolean exist(char[][] board, String word) 
    {
        int m = board.length;
        int n  = board[0].length;

        if(m==0) return false;
        if(n==0) return false;
        if(word.length()==0) return false;

       for(int i=0;i<m;i++)
        {
             for(int j=0;j<n;j++)
             {
                //whenever starting char matches, do dfs
                if(word.charAt(0)==board[i][j])
                {
                    if(existHelper(board,word,i,j,0,m,n)) return true;
                }
             }
        }

        return false;

        
        
    }


    public boolean existHelper(char[][] board, String word, int i , int j, int index, int m , int n ) 
    {
    
        // if index is greater than word length
       if(index>= word.length()) return true;

        //out of bounds, already visited, or not matching
        if(i<0 || i>=m || j<0 || j>=n || board[i][j]=='.' || word.charAt(index)!=board[i][j]) return false;


        //visit it
        board[i][j] ='.';
        boolean ans = false;

        int dx[]={0,0,-1,1};
        int dy[]={-1,1,0,0};

        for(int  k=0;k<4;k++)
        {
            int newI = i + dx[k];
            int newJ = j + dy[k];
            ans = ans || existHelper(board,word,newI,newJ,index+1,m,n);
            if(ans) break;
        }

          board[i][j] =word.charAt(index);

        return ans;

        
    }


}
