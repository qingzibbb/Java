链接：https://www.nowcoder.com/questionTerminal/069e2130430c41229ab25e47fa0949a6
来源：牛客网

import java.util.*;
public class Main
{
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt())
        {
            int n=sc.nextInt();
            int [] arr=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            int x=sc.nextInt();
            int index=-1;
            for(int i=0;i<n;i++)
            {
                if(arr[i]==x)
                {
                    index=i;
                }
            }
             System.out.println(index);
        }
    }
}