package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _14391 implements Executable {
	static int n, m;
	static int[][] arr;
	static boolean[][] check;
	
	static int ti, tj;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		check = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
//				System.out.print(arr[i][j] + " ");
			}
//			System.out.println();
		}
//		System.out.println();
		
		int sol = backtracking(0,0);
		bw.write(String.valueOf(sol));
		bw.close();
		br.close();
	}
	
	public static int backtracking(int ci, int cj) {
		if(ci == -1) return 0;
		
		
		int max = 0;
		int i,j;
		for(j = cj; j < m && !check[ci][j]; j++) {
			check[ci][j] = true;
			findTarget();
//			System.out.println("cal:" + calJ(cj,j,ci) + ", ti:" + ti + ", tj:" + tj);
			max = Math.max(max, backtracking(ti, tj) + calJ(cj,j,ci));
		}
		for(int tmp = j - 1; tmp >= cj; tmp--) {
			check[ci][tmp] = false;
		}
		
		for(i = ci; i < n && !check[i][cj]; i++) {
			check[i][cj] = true;
			findTarget();
			max = Math.max(max, backtracking(ti, tj) + calI(ci,i,cj));
		}
		for(int tmp = i - 1; tmp >= ci; tmp--) {
			check[tmp][cj] = false;
		}
	
		return max;
	}
	
	public static int calJ(int sj, int ej, int i) {
		int sum = 0;
		int offset = 1;
		
		for(int j = ej; j >= sj; j--, offset *= 10) {
			sum += arr[i][j] * offset;
		}
		return sum;
	}
	
	public static int calI(int si, int ei, int j) {
		int sum = 0;
		int offset = 1;
		
		for(int i = ei; i >= si; i--, offset *= 10) {
			sum += arr[i][j] * offset;
		}
		return sum;
	}
	
	public static void findTarget() {
		ti = -1;
		tj = -1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!check[i][j]) {
					ti = i;
					tj = j;
					return;
				}
			}
		}
	}
}
