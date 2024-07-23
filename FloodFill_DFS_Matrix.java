class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int init_color = image[sr][sc];

        //if starting point is desired color, no need of change
        if(init_color == color) return image;

        int dx[] = {0,-1,0,1};
        int dy[]= {-1,0,1,0};


        floodFillUtil(image,sr,sc,init_color, color,dx, dy);
        return image;

    }

    public static void floodFillUtil(int [][] arr, int row, int col, int init_color, int final_color, int dx[], int dy[]) 
    {

        if(row <0 || row>=arr.length || col<0 || col>=arr[0].length|| arr[row][col]!=init_color) return;
            
        //fill with final color
        arr[row][col] = final_color;
        
      
        //traverse 4 directions
        for(int i=0;i<4;i++)
        {
            int new_row = row+ dx[i];
            int new_col = col + dy[i];

            floodFillUtil(arr,new_row,new_col,init_color,final_color,dx,dy);

            
        }

    }
}
