package 백준.자바.도서관_1461;


import java.io.*;
import java.util.*;

public class Main {

    private int N, M;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> MinusArr = new ArrayList<>();
        List<Integer> PlusArr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(n > 0) PlusArr.add(n);
            else MinusArr.add(-n);
        }

        Collections.sort(MinusArr);
        Collections.sort(PlusArr);

        // 0 = minus
        // 1 = plus 가 더 큼

        int result = 0;

        if(!MinusArr.isEmpty() && !PlusArr.isEmpty())
            result = MinusArr.get(MinusArr.size()-1) > PlusArr.get(PlusArr.size()-1) ? getDist(PlusArr)+ getDistHalf(MinusArr) : getDist(MinusArr)+getDistHalf(PlusArr);

        else if(MinusArr.isEmpty()){
            result = getDistHalf(PlusArr);
        }
        else{
            result = getDistHalf(MinusArr);
        }

        System.out.println(result);
    }

    private int getDist(List<Integer> arr){
        int pos = arr.size()-1;
        int total = 0;
        while(pos >= 0){
            total += arr.get(pos)*2;
            pos -= M;
        }
        return total;
    }

    private int getDistHalf(List<Integer> arr){
        int pos = arr.size()-1;
        int total = 0;
        total += arr.get(pos);
        pos -= M;

        while(pos >= 0){
            total += arr.get(pos)*2;
            pos -= M;
        }
        return total;
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
