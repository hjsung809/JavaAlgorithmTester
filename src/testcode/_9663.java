package testcode;

import java.io.*;

import tester.Executable;

public class _9663 implements Executable {
	static int n;
	static int check[][];
	static int count;
	static int[] dx = { 0, 1, -1};
	static int[] dy = { 1, 1,  1};
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		n = Integer.parseInt(br.readLine());
		check = new int[n][n];
		count = 0;
		
		backtracking(0);
		bw.write(String.valueOf(count));
		bw.close();
		br.close();
	}
	
	public static void backtracking(int line) {
		if(line == n) {
			count++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(check[line][i] == 0) {
				updateCheck(line, i,  1);
				backtracking(line + 1);
				updateCheck(line, i, -1);
			}
		}
	}
	
	public static void updateCheck(int ci, int cj, int sign) {
		for(int i = 0; i < dx.length; i++) {
			int progress = 1;
			int ti = ci +dy[i] * progress;
			int tj = cj + dx[i] * progress;
			
			while(ti < n && ti >=0 &&
					tj <n && tj >= 0) {
				check[ti][tj] += sign;
				progress++;
				ti = ci +dy[i] * progress;
				tj = cj + dx[i] * progress;
			}
		}
	}
}
