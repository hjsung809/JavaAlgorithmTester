package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _10974 implements Executable {
	static int[] arr;
	static int n;

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = i + 1;
			sb.append(arr[i]).append(" ");
		}
		sb.append('\n');

		while(nextPermutation()) {
//			System.out.println("a");
			for(int i = 0; i < n; i++) {
				sb.append(arr[i]).append(" ");
//				System.out.print(arr[i] + " ");
			}
//			System.out.println();
			sb.append('\n');
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static boolean nextPermutation() {
		int i,j;
		for(i = n - 2; i >= 0; i--) {
			if(arr[i] < arr[i + 1]) break;
		}
		if(i < 0) return false;
		
		for(j = n - 1; j > i; j--) {
			if(arr[i] < arr[j]) break;
		}
		swap(i, j);
		
		i += 1;
		for(j = n - 1; j > i; i++, j--) {
			swap(i, j);
		}
		return true;
	}
	
	static void swap(int idx1,int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}
}
