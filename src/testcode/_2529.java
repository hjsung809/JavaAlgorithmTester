package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _2529 implements Executable {
	static int n;
	static boolean[] arr;
	static boolean[] check;
	static int[] numbers;
	static long min, max;
	static int[] minArr, maxArr;
	
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		n = Integer.parseInt(br.readLine());
		arr = new boolean[n];
		numbers = new int[n + 1];
		minArr = new int[n + 1];
		maxArr = new int[n + 1];
		
		check = new boolean[10];
		
		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;

		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = st.nextToken().charAt(0) == '<';
//			System.out.print(arr[i] + " ");
		}
//		System.out.println();
		
		backtracking(0);
		
		
		StringBuilder sb = new StringBuilder();
		for(int m : maxArr) {
			sb.append(m);
		}
		sb.append('\n');
		bw.write(sb.toString());
		sb = new StringBuilder();
		for(int m : minArr) {
			sb.append(m);
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void backtracking(int idx) {
		if(idx == n + 1) {
			long tmp = cal();
			
//			for(int i = 0; i < n + 1; i++) {
//				System.out.print(numbers[i] + " ");
//			}
//			System.out.println();
//			System.out.println(tmp);
			
			if(tmp < min) {
				min = tmp;
				for(int i = 0; i < n + 1; i++) minArr[i] = numbers[i];
			}
			
			if(tmp > max) {
				max = tmp;
				for(int i = 0; i < n + 1; i++) maxArr[i] = numbers[i];
			}
			return;
		}
		
		for(int i = 0; i <= 9; i++) {
			if(!check[i]) {
				if(idx == 0
						|| (arr[idx - 1] &&  numbers[idx - 1] < i)
						|| (!arr[idx - 1] && numbers[idx - 1] > i)) {
					check[i] = true;
					numbers[idx] = i;
					backtracking(idx + 1);
					check[i] = false;
				}
			}
		}
	}
	
	static long cal() {
		long sum = 0;
		long offset = 1;
		for(int i = n; i >= 0; i--, offset *= 10) {
			sum += numbers[i] * offset;
		}
		return sum;
	}
}
