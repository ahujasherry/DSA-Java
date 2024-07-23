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

    public int[][] floodFill(int[][] image, int sr, int sc, int color)
     {
        if(image[sr][sc] == color) return image;

        Queue<int[]> q = new LinkedList<>();      
        int dx[] = {0,-1,0,1};
        int dy[]= {-1,0,1,0};


        // clone 2d array
        int copy_image[][]= duplicateArray(image);
        int init_color = image[sr][sc];

        q.offer(new int[]{sr,sc});
        copy_image[sr][sc]= color;


        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                int coord[]=q.poll();
                for(int j=0;j<4;j++)
                {
                    int new_row = coord[0]+ dx[j];
                    int new_col= coord[1] + dy[j];

                    if(new_row >=0 && new_row<copy_image.length && 
                        new_col>=0 && new_col<copy_image[0].length
                        && copy_image[new_row][new_col]==init_color)
                    {
                            copy_image[new_row][new_col] = color;
                            q.offer(new int[]{new_row,new_col});
                    }
                }

            }


        }



        return copy_image;

    }

    

    
}
