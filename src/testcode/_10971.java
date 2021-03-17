package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _10971 implements Executable {
	static int n;
	static int[][] arr;
	static boolean[] check;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		check = new boolean[n];
//		path = new int[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
//				System.out.print(arr[i][j] + " ");
			}
//			System.out.println();
		}
		
		int solution = backtracking(0,-1, -1, 0);
		bw.write(String.valueOf(solution));
		bw.close();
		br.close();
	}
	
	static int backtracking(int count,int start, int from, int cost) {
		if (count == n) {
			if(arr[from][start] != 0) {
				return cost + arr[from][start];
			}
			return Integer.MAX_VALUE;
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			if(!check[i]) {
				check[i] = true;
//				path[count] = i;
				
				if(from == -1) {
					min = Math.min(min, backtracking(count + 1, i, i, cost));					
				} else if(arr[from][i] != 0){
					
					min = Math.min(min, backtracking(count + 1,start, i, cost + arr[from][i]));
				}
				check[i] = false;
			}
		}
		return min;
	}
}
