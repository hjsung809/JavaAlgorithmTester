package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

import tester.Executable;

public class _2146 implements Executable {
	static int n;
	static int[][] arr;
	static int[][] check;
	static int[][] check2;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1 ,1};
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		check = new int[n][n];
		
		for(int i = 0; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int islandNumber = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 1 && check[i][j] == 0) {
					check2 = new int[n][n];
					min = Math.min(min, separateIsland(i, j, ++islandNumber));
				}
			}
		}
		
		bw.write(String.valueOf(min));
		bw.close();
		br.close();
	}
	
	public static int separateIsland(int si, int sj, int number) {
		Queue<int[]> q = new LinkedList<int[]>();
		Queue<int[]> q2 = new LinkedList<int[]>();
		q.add(new int[]{si, sj});
		check[si][sj] = number;
		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int ti = t[0];
			int tj = t[1];
			
			for(int i = 0; i < di.length; i++) {
				int ci = ti + di[i];
				int cj = tj + dj[i];
				
				if(ci >=0 && ci < n && cj >= 0 && cj < n) {
					if(arr[ci][cj] == 1 && check[ci][cj] == 0) {
						check[ci][cj] = number;
						q.add(new int[] {ci, cj});
					}else if(arr[ci][cj] == 0 && check2[ci][cj] == 0){
						check2[ci][cj] = 1;
						q2.add(new int[] {ci, cj});
					}
				}
			}
		}
		
		return getMinDistance(q2, number);
	}
	
	public static int getMinDistance(Queue<int[]> q, int number) {
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int ti = t[0];
			int tj = t[1];
			
			for(int i = 0; i < di.length; i++) {
				int ci = ti + di[i];
				int cj = tj + dj[i];
				
				if(ci >=0 && ci < n && cj >= 0 && cj < n) {
					if(arr[ci][cj] == 0 && check2[ci][cj] == 0) {
						check2[ci][cj] = check2[ti][tj] + 1;
						q.add(new int[] {ci, cj});
					}else if(arr[ci][cj] == 1 && check[ci][cj] != number){
						return check2[ti][tj];
					}
				}
			}
		}

		return Integer.MAX_VALUE;
	}

}
