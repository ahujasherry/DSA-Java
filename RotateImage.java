
//https://leetcode.com/problems/rotate-image/description/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //transpose
        for(int i=0;i<m;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse matrix
        for(int i=0;i<m;i++){
            int start =0;
            int end = n-1;
            while(start <end){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }

    }
}
