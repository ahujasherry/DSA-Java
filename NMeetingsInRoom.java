
//https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
import java.util.*;
import java.util.stream.Collectors;

class Meeting{
    int start;
    int end;
    int pos;

    public Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }

    @Override
    public  String toString(){
        return "start : "+this.start +" ,end: "+this.end +" ,pos: "+this.pos+"";
    }
}



public class Main {


    public static void main(String[] args)
    {

        int n = 5;
        int start[] = {3,0,1,8,5};
        int end[] =   {4,5,2,9,9};
        maxMeetings(start,end,n);

    }

    private static void maxMeetings(int[] start, int[] end, int n)
    {
        List<Meeting> meetings = new ArrayList<>();
        int maxMeetings = 0;

        List<Integer> meetingOrder = new ArrayList<>();

        //store meeting objects
        for (int i = 0; i <n ; i++) {
            meetings.add(new Meeting(start[i],end[i],i));
        }

        //sort meetings
        List<Meeting> sortedMeetings = meetings.stream().
                sorted(Comparator.comparingInt((Meeting m )-> m.end).thenComparingInt(m -> m.pos))
                .collect(Collectors.toList());


        meetingOrder.add(sortedMeetings.get(0).pos);
        int limit = sortedMeetings.get(0).end;

        for (int i = 1; i < start.length; i++) {
            if (sortedMeetings.get(i).start > limit) {
                limit = sortedMeetings.get(i).end;
                meetingOrder.add(sortedMeetings.get(i).pos);
            }
        }

        System.out.println("The order in which the meetings will be performed is:");
        meetingOrder.forEach(pos -> System.out.print(pos + " "));



    }


}
