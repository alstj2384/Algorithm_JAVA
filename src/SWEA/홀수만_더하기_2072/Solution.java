package SWEA.홀수만_더하기_2072;
import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int sum = 0;
            int t;
            for(int i = 0; i < 10; i++)
                if((t = sc.nextInt()) % 2 == 1) sum += t;

            System.out.println("#"+test_case+" " + sum);
        }
    }
}