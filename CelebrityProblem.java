public class CelebrityProblem {
    
    public static int findCelebrity(boolean[][] knows) {
        int n = knows.length;

        // Array to keep track of in-degrees and out-degrees
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        
        // Count in-degrees and out-degrees
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (knows[i][j]) { // If person i knows person j
                    outDegree[i]++;
                    inDegree[j]++;
                }
            }
        }

        // Find the celebrity
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i; // Person i is the celebrity
            }
        }

        return -1; // No celebrity found
    }

    public static void main(String[] args) {
        boolean[][] knows = {
            {false, true, false},
            {false, false, false},
            {true, true, false}
        };

        int celebrity = findCelebrity(knows);
        if (celebrity != -1) {
            System.out.println("Celebrity is person: " + celebrity);
        } else {
            System.out.println("No celebrity found.");
        }
    }
}
