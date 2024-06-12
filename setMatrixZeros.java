
//https://leetcode.com/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    public void setZeroes(int[][] matrix) {
       int m = matrix.length;
        int n = matrix[0].length;

        boolean rowFlag= false;
        boolean colFlag = false;


        //set flags
        for (int i = 0; i <m ; i++)
        {
            for (int j = 0; j <n ; j++)
            {

                if(matrix[i][j]==0){

                    if(j==0) rowFlag=true;
                    if(i==0) colFlag = true;

                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }



        for (int i = 1; i <m ; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }

        }

        if(rowFlag){
            for (int i = 0; i <m ; i++){
                matrix[i][0] = 0;
            }
        }

        if(colFlag){
            for (int j = 0; j <n ; j++) {
                matrix[0][j]= 0;
            }
        }
       
    }
}
