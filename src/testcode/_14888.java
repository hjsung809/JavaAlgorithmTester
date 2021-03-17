package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

import tester.Executable;

public class _14888 implements Executable {
	static int n;
	static int[] A;
	static int[] operation;
	
	static int[] check;
	static ArrayList<Integer> o;
	static int max;
	static int min;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		n = Integer.parseInt(br.readLine());
		o = new ArrayList<Integer>();
//		operation = new int[4];
		
		A = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		
		operation = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		
		check = new int[4];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		backtracking();
		bw.write(String.valueOf(max) + '\n');
		bw.write(String.valueOf(min) + '\n');
		bw.close();
		br.close();
		
	}
	
	public static void backtracking() {
		if(o.size() == n -1) {
			int value = getValue();
			max = Math.max(max, value);
			min = Math.min(min, value);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(check[i] < operation[i]) {
				o.add(i);
				check[i] ++;
				
				backtracking();
				
				o.remove(o.size() - 1);
				check[i] --;
			}
		}
	}
	
	public static int getValue() {
		int value = A[0];
		
		for(int i = 0; i < n - 1; i++) {
			switch(o.get(i)) {
				case 0: value += A[i + 1]; break;
				case 1: value -= A[i + 1]; break;
				case 2: value *= A[i + 1]; break;
				case 3: value /= A[i + 1]; break;
			}
		}
		return value;
	}

}
