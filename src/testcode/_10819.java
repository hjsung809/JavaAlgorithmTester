package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import tester.Executable;

public class _10819 implements Executable {
	static int n;
	static int[] arr;
	static boolean[] check;
	static int[] target;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		target = new int[n];
		check = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);		
		
		int solution = backtracking(0);
		bw.write(String.valueOf(solution));
		bw.close();
		br.close();
	}
	
	static int backtracking(int idx) {
		if(idx == n) {
			return cal();
		}
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			if(!check[i]) {
				check[i] = true;
				target[idx] = arr[i];
				max = Math.max(max, backtracking(idx + 1));
				check[i] = false;
			}
		}
		return max;
	}
	
	static int cal() {
		int sum = 0;
		for(int i = 0; i < n - 1; i++) {
			sum += Math.abs(target[i] - target[i + 1]);
		}
		return sum;
	}
}
