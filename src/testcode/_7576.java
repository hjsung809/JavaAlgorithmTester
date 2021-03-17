package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

import tester.Executable;

public class _7576 implements Executable {
	static int n, m;
	static int[][] arr;
	static int[][] check;
	static int max;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		check = new int[n][m];
		max = -1;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				check[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		
		boolean done = true;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) {
					done = false;
					break;
				}
			}
		}

		if(done) { 
			bw.write(String.valueOf(max));
		} else {
			bw.write("-1");
		}

		bw.close();
		br.close();
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 1) {
					check[i][j] = 0;
					q.add(new int[] {i, j});
				}
			}
		}
		
		if(!q.isEmpty()) max = 0;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int ti = current[0];
			int tj = current[1];
			
			if(ti > 0 && arr[ti - 1][tj] == 0) {
				arr[ti - 1][tj] = 1;
				check[ti - 1][tj] = check[ti][tj] + 1;
				max = Math.max(max, check[ti][tj] + 1);
				q.add(new int[] {ti - 1, tj});
			}
			
			if(ti < n - 1 &&  arr[ti + 1][tj] == 0) {
				arr[ti + 1][tj] = 1;
				check[ti + 1][tj] = check[ti][tj] + 1;
				max = Math.max(max, check[ti][tj] + 1);
				q.add(new int[] {ti + 1, tj});
			}
			
			if(tj > 0 && arr[ti][tj - 1] == 0) {
				arr[ti][tj - 1] = 1;
				check[ti][tj - 1] = check[ti][tj] + 1;
				max = Math.max(max, check[ti][tj] + 1);
				q.add(new int[] {ti, tj - 1});
			}
			
			if(tj < m - 1 && arr[ti][tj + 1] == 0) {
				arr[ti][tj + 1] = 1;
				check[ti][tj + 1] = check[ti][tj] + 1;
				max = Math.max(max, check[ti][tj] + 1);
				q.add(new int[] {ti, tj + 1});
			}
		}
	}

}
