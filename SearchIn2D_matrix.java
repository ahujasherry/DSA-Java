//https://leetcode.com/problems/search-a-2d-matrix/
//T.C = O(Log(M*N)
//S.C = O(1)
import java.util.*;

public class Solution {
    public static boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        //apply binary search:
        int low = 0, high = m * n - 1;
        while (low <= high) 
        {
            int mid = (low + high) / 2;
            int row = mid / n, col = mid % n;
            
            if (matrix.get(row).get(col) == target) return true;
            else if (matrix.get(row).get(col) < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        matrix.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
        matrix.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));

        boolean result = searchMatrix(matrix, 8);
        System.out.println(result ? "true" : "false");
    }
}


