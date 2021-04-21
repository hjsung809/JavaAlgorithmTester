package testcode;

import tester.Executable;

import java.io.*;

public class _1987 implements Executable {
    static int r, c;
    static int[][] arr;
    static boolean[] check;
    static int[] di = {0, 0, 1, -1};
    static int[] dj = {1, -1, 0, 0};

    public static int getMaxDistance(int ci, int cj) {
        int max = 0;

        for(int i = 0; i < 4; i++) {
            int ti = ci + di[i];
            int tj = cj + dj[i];
            if(ti >= 0 && ti < r && tj >= 0 && tj < c) {
                if(!check[arr[ti][tj]]) {
                    check[arr[ti][tj]] = true;
                    max = Math.max(max, getMaxDistance(ti, tj) + 1);
                    check[arr[ti][tj]] = false;
                }
            }
        }
        return max;
    }

    @Override
    public void main(InputStream in, OutputStream out) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
        String[] rc = br.readLine().split(" ");
        r = Integer.parseInt(rc[0]);
        c = Integer.parseInt(rc[1]);
        arr = new int[r][c];
        check = new boolean[26];

        for(int i = 0; i < r; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < c; j++) {
                arr[i][j] = line[j] - 'A';
            }
        }

        check[arr[0][0]] = true;
        int sol = getMaxDistance(0, 0) + 1;
        bw.write(String.valueOf(sol));

        bw.close();
        br.close();
    }


}
