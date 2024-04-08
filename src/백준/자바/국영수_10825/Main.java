package 백준.자바.국영수_10825;

import java.io.*;
import java.util.*;

public class Main {

    class Student{
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Student> std = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            std.add(new Student(name, korean, english, math));
        }

        Collections.sort(std, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2){
                if(o1.korean != o2.korean){
                    return o2.korean - o1.korean;
                }
                else {
                    if(o1.english != o2.english){
                        return o1.english - o2.english;
                    }
                    else{
                        if(o1.math != o2.math){
                            return o2.math - o1.math;
                        }
                        else{
                            return o1.name.compareTo(o2.name);
                        }
                    }
                }
            };
        });

        StringBuilder sb = new StringBuilder();
        for(var k : std){
            sb.append(k.name+ "\n");
        }

        System.out.print(sb);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
