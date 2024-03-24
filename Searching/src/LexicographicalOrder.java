import java.util.*;

public class LexicographicalOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input=sc.nextLine();
        String []arr=input.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for(String val:arr){
            list.add(val);
        }
        String str=sc.next();
        list.add(str);
        Collections.sort(list);
        for (String val:list){
            System.out.print(val+" ");
        }

    }
}
