package testcode;

import tester.Executable;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _13460 implements Executable {
    static int n, m;
    static char[][] arr;
    static int[][][][] check;
    static int[] di = {0,  0,  1, -1};
    static int[] dj = {1, -1,  0,  0};

    public static class Coordinates {
        int ri, rj;
        int bi, bj;
//        int count;
        boolean escaped; // 빨간색만 들어간 경우
        boolean failed;   // 둘다 들어간 경우

        public Coordinates(int ri, int rj, int bi, int bj) {
            this.ri = ri;
            this.rj = rj;
            this.bi = bi;
            this.bj = bj;
//            this.count = count;
            escaped = false;
            failed = false;
        }

        public Coordinates move(int di, int dj) {
            int rti = ri, rtj = rj, bti = bi, btj = bj;
            boolean rMove = true, bMove = true;
            boolean rEscape = false, bEscape = false;

            while(rMove || bMove) {
                if(rMove) {
                    rti += di;
                    rtj += dj;
                    if(arr[rti][rtj] == '#') {
                        rMove = false;
                        rti -= di;
                        rtj -= dj;
                    } else if(arr[rti][rtj] == 'O') {
                        rMove = false;
                        rEscape = true;
                        rti = -1;
                        rtj = -1;
                    }
                }
                if(bMove) {
                    bti += di;
                    btj += dj;
                    if(arr[bti][btj] == '#') {
                        bMove = false;
                        bti -= di;
                        btj -= dj;
                    } else if(arr[bti][btj] == 'O') {
                        bMove = false;
                        bEscape = true;
                        bti = -1;
                        btj = -1;
                        break;
                    }
                }
                // 충돌시
                if(rti == bti && rtj == btj) {
                    if(rMove) {
                        rMove = false;
                        rti -= di;
                        rtj -= dj;
                    }
                    if(bMove) {
                        bMove = false;
                        bti -= di;
                        btj -= dj;
                    }
                }
            }

            Coordinates moved = new Coordinates(rti, rtj, bti, btj);
            if(bEscape) moved.failed = true;
            else if(rEscape) moved.escaped = true;
            return moved;
        }
    }

    public static int bfs(Coordinates start) {
        Queue<Coordinates> queue = new LinkedList<>();
        queue.add(start);
        check[start.ri][start.rj][start.bi][start.bj] = 1;

        while(!queue.isEmpty()) {
            Coordinates current = queue.poll();

            for(int i = 0; i < 4; i++) {
                Coordinates moved = current.move(di[i], dj[i]);

                if(moved.escaped) {
                    return check[current.ri][current.rj][current.bi][current.bj];
                }
                else if(moved.failed) continue;
                else if(check[moved.ri][moved.rj][moved.bi][moved.bj] == 0) {
                    if(check[current.ri][current.rj][current.bi][current.bj] < 10) {
                        check[moved.ri][moved.rj][moved.bi][moved.bj] = check[current.ri][current.rj][current.bi][current.bj] + 1;
                        queue.add(moved);
                    }
                }
            }
        }

        return -1;
    }

    @Override
    public void main(InputStream in, OutputStream out) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        arr = new char[n][m];
        check = new int[n][m][n][m];

        int ri = 0, rj = 0;
        int bi = 0, bj = 0;
        for(int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                arr[i][j] = line[j];

                switch (arr[i][j]) {
                    case 'R':
                        arr[i][j] = '.';
                        ri = i;
                        rj = j;
                        break;
                    case 'B':
                        arr[i][j] = '.';
                        bi = i;
                        bj = j;
                        break;
                }
            }
        }
        Coordinates start = new Coordinates(ri, rj, bi, bj);
        int sol = bfs(start);
        bw.write(String.valueOf(sol));
        br.close();
        bw.close();
    }
}
