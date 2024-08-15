public class GameBoard {
    public static boolean isWinnable(int[] board) {
        int n = board.length;
        if (n == 0) return false;  // No positions on the board

        // Initialize the range of reachable positions
        int s = 0; // currentStart
        int e = 0; // currentEnd

        while (s <= e) {
            // Expand the farthest position reachable within the current range
            int newEnd = e;
            for (int i = s; i <= e; i++) {
                newEnd = Math.max(newEnd, i + board[i]);
                if (newEnd >= n - 1) {
                    return true;
                }
            }

            // Move to the next range
            s = e + 1;
            e = newEnd;

            // If the next start position is beyond the currentEnd, break out
            if (s > e) {
                return false;
            }
        }

        // If we exit the loop without reaching the end
        return false;
    }

    public static void main(String[] args) {
        int[] winnableBoard = {3, 2, 0, 1, 3, 2, 1, 0};
        int[] notWinnableBoard = {2, 0, 0, 4, 3, 0, 1, 0};

        System.out.println("Winnable Board: " + isWinnable(winnableBoard)); // Output: true
        System.out.println("Not Winnable Board: " + isWinnable(notWinnableBoard)); // Output: false
    }
}
