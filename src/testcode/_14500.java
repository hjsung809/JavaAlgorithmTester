package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _14500 implements Executable {
	static int [][][] t = {
			{
				{1, 1, 1, 1}
			},
			{
				{1, 1},
				{1, 1}
			},
			{
				{1, 0},
				{1, 0},
				{1, 1},
			},
			{
				{1, 0},
				{1, 1},
				{0, 1},
			},
			{
				{1, 1, 1},
				{0, 1, 0},
			}
	};

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int sol = 0;
		for(int i = 0; i < t.length; i++) {
			for(int j = 0; j < 4; j++) {
				sol = Math.max(sol, calMax(arr, t[i]));
				t[i] = rotateArr(t[i]);
			}
		}
		
		for(int i = 0; i < 4; i++) {
			t[i] = turnArr(t[i]);
		}
		
		for(int i = 0; i < t.length; i++) {
			for(int j = 0; j < 4; j++) {
				sol = Math.max(sol, calMax(arr, t[i]));
				t[i] = rotateArr(t[i]);
			}
		}
		
		bw.write(String.valueOf(sol));
		bw.close();
		br.close();
	}
	
	public static int[][] turnArr(int[][] arr) {
		int[][] newArr = new int[arr.length][arr[0].length];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				newArr[i][arr[0].length - 1 - j] = arr[i][j];
			}
		}
		return newArr;
	}
	
	public static int[][] rotateArr(int[][] arr) {
		int[][] newArr = new int[arr[0].length][arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				newArr[j][arr.length - 1 - i] = arr[i][j];
			}
		}
		return newArr;
	}
	
	public static int calMax(int[][] arr, int tt[][]) {
		int max = 0;
		for(int i = 0; i <= arr.length - tt.length; i++) {
			for(int j = 0;j <= arr[i].length - tt[0].length; j++) {
				max = Math.max(max, calArr(arr, tt, i, j));
			}
		}
		return max;
	}
	
	public static int calArr(int[][] arr, int[][] tt,  int di, int dj) {
		int sum = 0;
		
		for(int i = 0 ; i < tt.length; i++) {
			for(int j = 0 ; j < tt[0].length; j++) {
				sum += arr[i + di][j + dj] * tt[i][j];
			}
		}
		return sum;
	}
}
