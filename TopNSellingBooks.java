// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class BookSales
{
    HashMap<String, Integer> salesMap;
    
    public BookSales()
    {
        salesMap= new HashMap<String,Integer>(); 
    }
    
    
    public void purchaseBook(String bookName) {
        salesMap.put(bookName, salesMap.getOrDefault(bookName, 0) + 1);
    }
    
     public void purchaseRefund(String bookName)
     {
         
         
         if(salesMap.containsKey(bookName))
         {
             int salesCount = salesMap.get(bookName);
             if (salesCount > 1) {
                salesMap.put(bookName, salesCount - 1);
            } else {
                salesMap.remove(bookName); 
            }
         }
         
     }
     
     public List<String> TopNSelling(int n) 
     {
         if(n<=0) return Collections.emptyList();
        PriorityQueue<Map.Entry<String,Integer>> minHeap= new PriorityQueue<>((e1,e2)-> e1.getValue()- e2.getValue());
        
        //add map values to minHeap
        for (Map.Entry<String, Integer> entry : salesMap.entrySet())
        {
            minHeap.offer(entry);
            if(minHeap.size()>n) 
                minHeap.poll();
        
        }
        
        
        List<String> list = new ArrayList<>();
        while(!minHeap.isEmpty())
        {
            list.add(minHeap.poll().getKey());
        }
        
        Collections.reverse(list);
        return list;
    
     }
    
}

public class HelloWorld {
    public static void main(String[] args) {
        BookSales bookSales = new BookSales();

        // Simulating book purchases
        bookSales.purchaseBook("Harry Potter");
                bookSales.purchaseBook("Harry Potter");

        bookSales.purchaseBook("Lord of the Rings");
        bookSales.purchaseBook("Harry Potter");
        bookSales.purchaseBook("Game of Thrones");
        bookSales.purchaseBook("Game of Thrones");
        bookSales.purchaseBook("Game of Thrones");

        // Simulating a refund
        bookSales.purchaseRefund("Harry Potter");

        // Getting the top 2 selling books
        List<String> topBooks = bookSales.TopNSelling(2);
        System.out.println("Top 2 Selling Books: " + topBooks);

        // Using constructor with initial sales data
          }
}
