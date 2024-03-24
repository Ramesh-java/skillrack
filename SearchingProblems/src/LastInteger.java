import java.util.Scanner;

public class LastInteger {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[]arr=new int[num];
        for (int i=0;i<num;i++){
            arr[i]=sc.nextInt();
        }
        int lastnum=arr[num-1];
        int count=0;
        for(int val:arr) {
            if (val == lastnum) {
                count++;
            }
        }
        System.out.println(count);

    }
}
