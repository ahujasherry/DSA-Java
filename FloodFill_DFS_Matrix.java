class Solution {


    public static int[][] duplicateArray(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = new int[original[i].length];
            for (int j = 0; j < original[i].length; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // clone 2d array
        int copy_image[][]= duplicateArray(image);
        int init_color = copy_image[sr][sc];

        //if starting point is desired color, no need of change
        if(init_color == color) return image;

        floodFillUtil(copy_image,sr,sc,init_color, color);
        return copy_image;

    }

    public static void floodFillUtil(int [][] arr, int row, int col, int init_color, int final_color) 
    {
        //fill with final color
        arr[row][col] = final_color;
        
        int dx[] = {0,-1,0,1};
        int dy[]= {-1,0,1,0};

        //traverse 4 directions
        for(int i=0;i<4;i++)
        {
            int new_row = row+ dx[i];
            int new_col = col + dy[i];

            if(new_row >=0 && new_row<arr.length && new_col>=0 && new_col<arr[0].length
                 && arr[new_row][new_col]==init_color)
            {
                floodFillUtil(arr,new_row,new_col,init_color,final_color);

            }
        }

    }
}
