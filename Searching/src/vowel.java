import java.util.*;
public class vowel {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input= sc.next();
        int count=0;
        String vowels="aeiouAEIOU";
        for (int i=0;i<input.length();i++){
            for (int j=0;j<vowels.length();j++){
                if(input.charAt(i)==vowels.charAt(j)){
                    System.out.println(vowels.charAt(j));
                    count++;
                    return;
                }
            }
        }if(count==0){
            System.out.println(-1);
        }
    }
}
