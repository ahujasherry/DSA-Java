public class ImageBlurrer {

    public static int[][] applyBlur(int[][] image, int radius) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] blurredImage = new int[rows][cols];

        // Helper function to calculate the mean intensity of neighbors and the pixel itself
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                int count = 0;

                // Consider all pixels within the radius
                for (int k = Math.max(0, i - radius); k <= Math.min(rows - 1, i + radius); k++) {
                    for (int l = Math.max(0, j - radius); l <= Math.min(cols - 1, j + radius); l++) {
                        sum += image[k][l];
                        count++;
                    }
                }

                // Compute the mean intensity
                int mean = sum / count;

                // Update intensity based on the mean value
                if (mean == 0) {
                    blurredImage[i][j] = image[i][j] / 2;
                } else {
                    blurredImage[i][j] = (mean + image[i][j]) / 2;
                }
            }
        }

        return blurredImage;
    }

    public static void main(String[] args) {
        int[][] image = {
            {100, 200, 100},
            {200, 50, 200},
            {100, 200, 100}
        };
        int radius = 1;
        int[][] result = applyBlur(image, radius);
        
        // Print the result
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
