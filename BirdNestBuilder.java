import java.util.ArrayList;
import java.util.List;

public class BirdNestBuilder {

    public static List<Integer> collectSticks(int[] forest, int bird) {
        List<Integer> collectedIndices = new ArrayList<>();
        int totalLength = 0;
        int n = forest.length;
        boolean[] visited = new boolean[n];
        
        while (totalLength < 100) {
            // Go right
            int i = bird + 1;
            while (i < n && forest[i] == 0 || visited[i]) {
                i++;
            }
            if (i < n) {
                collectedIndices.add(i);
                totalLength += forest[i];
                visited[i] = true;
            }

            // Go left
            i = bird - 1;
            while (i >= 0 && forest[i] == 0 || visited[i]) {
                i--;
            }
            if (i >= 0) {
                collectedIndices.add(i);
                totalLength += forest[i];
                visited[i] = true;
            }
        }

        return collectedIndices;
    }

    public static void main(String[] args) {
        int[] forest = {0, 0, 5, 0, 0, 10, 0, 0, 20, 0, 0, 30, 0, 0};
        int bird = 0;
        List<Integer> result = collectSticks(forest, bird);
        System.out.println(result);
    }
}
