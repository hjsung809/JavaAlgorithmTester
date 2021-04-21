package testcode;

import tester.Executable;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1931 implements Executable
{
    public static class Schedule {
        int startTime;
        int endTime;

        public Schedule(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    @Override
    public void main(InputStream in, OutputStream out) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Schedule> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            list.add(new Schedule(startTime, endTime));
        }
        list.sort((a, b) -> {
            if(a.endTime == b.endTime) {
                return a.startTime - b.startTime;
            }
            return a.endTime - b.endTime;
        });

        int count = 0;
        int current = 0;
        for(Schedule schedule : list) {
            if(current <= schedule.startTime) {
                count ++;
                current = schedule.endTime;
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }
}
