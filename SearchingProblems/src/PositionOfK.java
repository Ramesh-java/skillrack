import java.util.Scanner;

public class PositionOfK
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[]arr=new int[num];
        for (int i=0;i<num;i++){
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        int count=0;
        for (int i=0;i<num;i++){
            if (arr[i]==target){
                System.out.print(i+1+" ");
                count++;
            }
        }
    }
}
