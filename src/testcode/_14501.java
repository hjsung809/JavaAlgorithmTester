package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _14501 implements Executable {
	static int[][] arr;
	static int n;

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][2];
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int sol = backtracking(1);
		bw.write(String.valueOf(sol));
		bw.close();
		br.close();
	}
	
	static int backtracking(int idx) {
		if(idx > n) {
			return 0;
		}
		
		int max = 0;
		for(int i = idx; i <= n; i++) {
			if(i + arr[i][0] <= n + 1) {
				max = Math.max(max, backtracking(i + arr[i][0]) + arr[i][1]);
			}
		}
		
		return max;
	}

}
