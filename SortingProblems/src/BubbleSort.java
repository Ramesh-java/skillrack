import java.util.*;


public class BubbleSort {
    public static void BubbleSort(ArrayList<Integer> list){
        int n=list.size();
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-i-1;j++){
                if (list.get(j) >list.get(j+1)){
                    int temp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
                for (int u=0;u<list.size();u++){
                    System.out.print(list.get(u)+" ");
                }
                System.out.println();
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        ArrayList<Integer> input=new ArrayList<Integer>();
        for (int i=1;i<=num;i++){
            int val=sc.nextInt();
            input.add(val);
        }
        BubbleSort(input);
    }
}