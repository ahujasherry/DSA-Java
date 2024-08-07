import java.util.*;

//https://www.geeksforgeeks.org/the-celebrity-problem/
public class Main {
public static int celebrity(ArrayList<ArrayList<Integer>> M, int n) 
  {
    //ad[i] -> list of people who knows ith
    ArrayList<Integer>[] adj = new ArrayList[n];

    //prepare
    for (int i = 0; i < n; i++) 
    {
      adj[i] = new ArrayList<Integer>();
      for (int j = 0; j < n; j++) 
      {
        if (M.get(i).get(j) == 1) {
        adj[i].add(j);
        }
      }
    }

    //if any adj[i] is empty, check if remaining people knows hiM? if not, ith is the ans
    for (int i = 0; i < n; i++) 
    {
      if (adj[i].isEmpty()) 
      {
        boolean flag = true;
        for (int j = 0; j < n; j++)
        {
          if (i == j)
          continue;
          if (!adj[j].contains(i)) {
          flag = false;
          break;
          }
        }
      if (flag)
        return i;
      }
    }
    
    return -1;
}
  public static void main(String[] args) 
  {
    ArrayList<ArrayList<Integer>> M = new ArrayList<>();
    M.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0)));
    M.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0)));
    M.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0)));
    M.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0)));

    int n = M.size();
    int Celebrity = celebrity(M, n);

    if (Celebrity != -1) {
        System.out.println("Celebrity is : " + Celebrity);
    } else {
        System.out.println("No celebrity");
    }
  }
}
