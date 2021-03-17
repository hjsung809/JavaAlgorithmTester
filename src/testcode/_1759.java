package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import tester.Executable;

public class _1759 implements Executable {
	static List<Character> vowels = Arrays.asList(
		'a','e','i','o','u'
	);
	static BufferedWriter bw;

	static int L;
	static int S;
//	static int vowelCount;
	static char[] arr;
	static char[] target;

	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		bw = new BufferedWriter(new OutputStreamWriter(out));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new char[S];
		target = new char[L];
//		vowelCount = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < S; i++) {
			arr[i] = st.nextToken().charAt(0);
//			if(vowels.contains(arr[i])) vowelCount++;
		}
		Arrays.sort(arr);
		backtracking(0);
		
		bw.close();
		br.close();
	}
	
	public static void backtracking(int idx) throws IOException {
		if(idx == L) {
			int vowelCount = 0;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < L; i++) {
				sb.append(target[i]);
//				System.out.print(target[i]);
				if(vowels.contains(target[i])) {
					vowelCount ++;
				}
			}
//			System.out.println();
			sb.append('\n');
			if(vowelCount >= 1 && L - vowelCount >= 2) {
				bw.write(sb.toString());				
			}
			return;
		}
		
		for(int i = 0; i < S; i++) {
			if(idx == 0 || target[idx - 1] < arr[i]) {
				target[idx] = arr[i];
				backtracking(idx + 1);
			}
		}
	}
	
}
