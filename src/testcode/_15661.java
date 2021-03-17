package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _15661 implements Executable {
	static int[][] arr;
	static int check;
	static int n;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		check = 0;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int sol = backtracking(0);
		bw.write(String.valueOf(sol));
		bw.close();
		br.close();
	}
	
	static int backtracking(int idx) {
		if(idx == n) {
			return cal();
		}
		
		int min;
		min = backtracking(idx + 1);
		check += 1 << idx;
		min = Math.min(min, backtracking(idx + 1));
		check -= 1 << idx;
		return min;
	}
	
	static int cal() {
		int sum1 = 0, sum2 = 0;
		
		for(int i = 0, iMask = 1; i < n; i++, iMask <<= 1) {
			for(int j = i + 1, jMask = 1 << j; j < n; j ++, jMask <<= 1) {
				if((check & iMask) == iMask && (check & jMask) == jMask ) {
					sum1 += arr[i][j] + arr[j][i];
				} else if((check & iMask) == 0 && (check & jMask) == 0) {
					sum2 += arr[i][j] + arr[j][i];
				}
			}
		}
		return Math.abs(sum1 - sum2);
	}

}
