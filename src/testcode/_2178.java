package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import tester.Executable;

public class _2178 implements Executable {
	static int n ,m;
	static boolean[][] arr;
	static int[][] check;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new boolean[n + 1][m + 1];
		check = new int[n + 1][m + 1];
		
		for(int i = 1; i <= n; i ++) {
			String str = br.readLine();
			for(int j = 1; j <= m; j++) {
				arr[i][j] = str.charAt(j - 1) == '1';
			}
		}
		

		backtracking(1, 1);
		bw.write(String.valueOf(check[n][m]));
		bw.close();
		br.close();
	}
	
	public static void backtracking(int ci, int cj) {
		Queue<int[]> q = new LinkedList<>();
		check[1][1] = 1;
		q.add(new int[] {ci, cj});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int ti = tmp[0];
			int tj = tmp[1];
			
			if(ti > 1 && arr[ti - 1][tj] && check[ti - 1][tj] ==0 ) {
				check[ti - 1][tj] = check[ti][tj] + 1;
				q.add(new int[] {ti - 1, tj});
			}
			
			if(ti < n && arr[ti + 1][tj] && check[ti + 1][tj] == 0) {
				check[ti + 1][tj] = check[ti][tj] + 1;
				q.add(new int[] {ti + 1, tj});
			}
			
			if(tj > 1 && arr[ti][tj - 1] && check[ti][tj - 1] == 0) {
				check[ti][tj - 1] = check[ti][tj] + 1;
				q.add(new int[] {ti, tj - 1});
			}
			if(tj < m && arr[ti][tj + 1] && check[ti][tj + 1] == 0) {
				check[ti][tj + 1] = check[ti][tj] + 1;
				q.add(new int[] {ti, tj + 1});
			}
		}
	}

}
