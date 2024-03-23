import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSortDescending {
    public static void main(String []args){
        Scanner sc =new Scanner(System.in);
        ArrayList<Integer> myList=new ArrayList<>();
        int num=sc.nextInt();
        for(int i=0;i<num;i++){
            int val=sc.nextInt();
            myList.add(val);
        }

            /* Arraylist.add(7);
            Arraylist.add(2);
            Arraylist.add(3);
            Arraylist.add(1);
            Arraylist.add(-5);
            for (int val:Arraylist){
                System.out.print(val+" ");
            }
        System.out.println();*/
        for (int val:myList){
            System.out.print(val+" ");
        }
        System.out.println();
        Insertion(myList);


    }
    public static void Insertion(ArrayList<Integer> list){
        for (int i=1;i<list.size();i++){
            int key=list.get(i);
            int j=i-1;
            while (j>=0 && list.get(j)<key){
                list.set(j+1,list.get(j));
                j--;
            }list.set(j+1,key);
            for (int val:list){
                System.out.print(val+" ");
            }
            System.out.println();
        }

    }


}
