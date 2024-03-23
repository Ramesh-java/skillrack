import java.util.ArrayList;
import java.util.Scanner;

public class SelectionSort{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        ArrayList <Integer> myList=new ArrayList<>();
        int num=sc.nextInt();
        for(int i=0;i<num;i++){
            int val=sc.nextInt();
            myList.add(val);
        }

        /*Arraylist.add(12);
        Arraylist.add(6);
        Arraylist.add(15);
        Arraylist.add(9);
        Arraylist.add(10);*/






        selection(myList);

    }
    public static void selection(ArrayList<Integer> list){
        int n=list.size();

        for (int i=0;i<n-1;i++){
            int minindex=i;

            for (int j=i+1;j<n;j++){
                if (list.get(minindex)>list.get(j)){
                    minindex=j;
                }
            }
            int temp=list.get(minindex);
            list.set(minindex,list.get(i));
            list.set(i,temp);
            for (int value:list){
                System.out.print(value+" ");

            }
            System.out.println();

        }
    }

}
