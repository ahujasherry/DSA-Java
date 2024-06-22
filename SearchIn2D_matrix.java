//https://leetcode.com/problems/search-a-2d-matrix/
//T.C = O(M) or O(N) whichever is larger
//S.C = O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
      int m = matrix.length;
        int n = matrix[0].length;

        int  i = 0;
        int j  = n-1;

        while(j>=0 && i<m)
        {
            if(matrix[i][j]==target){
                return  true;
            } else if (matrix[i][j] > target) {
                j--;
            }else{
                i++;
            }

        }

        return false;
        
    }
}
