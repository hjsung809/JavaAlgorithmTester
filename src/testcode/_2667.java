package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import tester.Executable;

public class _2667 implements Executable {
	static int n;
	static int[][] arr;
	static boolean[][] check;
	static ArrayList<Integer> answers;
	
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		check = new boolean[n][n];
		answers = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 1 && !check[i][j]) {
					answers.add(bfs(i,j));
				}
			}
		}
		Collections.sort(answers);
		bw.write(String.valueOf(answers.size()) + '\n');
		for(int a : answers) { 
			bw.write(String.valueOf(a) + '\n');
		}
		
		bw.close();
		br.close();
	}
	
	static int bfs(int i, int j) { 
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {i,j});
		check[i][j] = true;
		int count = 0;
		
		while(!q.isEmpty()) {
			int[] e = q.poll();
			count ++;
			int ti = e[0];
			int tj = e[1];
			
			if(ti > 0 && !check[ti - 1][tj] && arr[ti - 1][tj] == 1) {
				check[ti - 1][tj]  = true;
				q.add(new int[] {ti - 1, tj});
			}
			if(ti < n - 1 && !check[ti + 1][tj] && arr[ti + 1][tj] == 1) {
				check[ti + 1][tj]  = true;
				q.add(new int[] {ti + 1, tj});
			}
			if(tj > 0 && !check[ti][tj - 1] && arr[ti][tj - 1] == 1) {
				check[ti][tj - 1]  = true;
				q.add(new int[] {ti, tj - 1});
			}
			if(tj < n - 1 && !check[ti][tj + 1] && arr[ti][tj + 1] == 1) {
				check[ti][tj + 1]  = true;
				q.add(new int[] {ti, tj + 1});
			}
		}
		
		return count;
	}

}
