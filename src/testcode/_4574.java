package testcode;

import tester.Executable;

import java.io.*;
import java.util.StringTokenizer;

public class _4574 implements Executable {
    static int[][] arr;
    static boolean[][] dominoCheck;
    static int[] rowCheck, colCheck, sectionCheck;
    static int[] di = {0, 0, -1, 1};
    static int[] dj=  {-1, 1, 0, 0};

    public static int getSectionIndex(int i, int j) {
        int sr = (i - 1) / 3;
        int sc = (j - 1) / 3;
        return sr * 3 + sc + 1;
    }

    public static boolean backtracking(int count) {
        if(count == 36) {
            return true;
        }

        // 재귀
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                if(arr[i][j] == 0) {
                    // arr[i][j] 에 들어갈 수 있는 도미노를 검색함.
                    for(int d = 0; d < 4; d++) {
                        int ci = i + di[d];
                        int cj = j + dj[d];

                        if (ci >= 1 && ci <= 9 && cj >= 0 && cj <= 9) {
                            if(arr[ci][cj] == 0) {
                                // arr[i][j], arr[ci][cj]에 채워넣을 도미노를 선택
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void main(InputStream in, OutputStream out) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            arr = new int[10][10];
            dominoCheck = new boolean[10][10];
            rowCheck = new int[10];
            colCheck = new int[10];
            sectionCheck = new int[10];

            for(int i = 1; i <= 9; i++) {
                rowCheck[i] = Integer.MAX_VALUE;
                colCheck[i] = Integer.MAX_VALUE;
                sectionCheck[i] = Integer.MAX_VALUE;
            }

            while(n-- > 0) {
                String[] domino = br.readLine().split(" ");

                int value1 = Integer.parseInt(domino[0]);
                int value2 = Integer.parseInt(domino[2]);
                int i1 = domino[1].charAt(0) - 'A' + 1;
                int j1 = domino[1].charAt(1) - '0';
                int i2 = domino[3].charAt(0) - 'A' + 1;
                int j2 = domino[3].charAt(1) - '0';
                arr[i1][j1] = value1;
                arr[i2][j2] = value2;

                dominoCheck[value1][value2] = true;
                dominoCheck[value2][value1] = true;

                int adder = 1 << value1;
                rowCheck[i1] -= adder;
                colCheck[j1] -= adder;
                sectionCheck[getSectionIndex(i1,j1)] -= adder;

                adder = 1 << value2;
                rowCheck[i2] -= adder;
                colCheck[j2] -= adder;
                sectionCheck[getSectionIndex(i2, j2)] -= adder;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= 9; i++) {
                String token = st.nextToken();
                int i1 = token.charAt(0) - 'A' + 1;
                int j1 = token.charAt(1) - '0';
                rowCheck[i1] -= 1 << i;
                colCheck[j1] -= 1 << i;
                sectionCheck[getSectionIndex(i1, j1)] -= 1 << i;
                arr[i1][j1] = i;
            }
        }
    }
}
