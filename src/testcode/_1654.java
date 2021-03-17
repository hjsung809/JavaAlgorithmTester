package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import tester.Executable;

public class _1654 implements Executable {
	static int k, n;
	static int[] arr;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		String[] tmp = br.readLine().split(" ");
		k = Integer.parseInt(tmp[0]);
		n = Integer.parseInt(tmp[1]);
		
		arr = br.lines()
				.mapToInt(Integer::parseInt)
				.sorted()
				.toArray();
		
		long sol = solution();
		bw.write(String.valueOf(sol));
		bw.close();
		br.close();
	}
	
	public static long solution() {
		long bottom = 1, top = arr[arr.length - 1];
		long result = 0;
		
		while(bottom <= top) {
			long mid = (bottom + top) / 2;
			
			if(cal(mid)) {
				if(result < mid) result = mid;
				
				bottom = mid + 1;
//				System.out.println(bottom);
			} else {
				top = mid - 1;
			}
		}
		
		return result;
	}
	
	public static boolean cal(long length) {
		long sum = Arrays.stream(arr)
				.mapToLong(i -> i/length)
				.sum();
		return sum >= n;
	}

}
