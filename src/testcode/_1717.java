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

public class _1717 implements Executable {
	public static int[] arr;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n + 1];
		Arrays.fill(arr, -1);
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = i;
//		}
		
		int[] tmp = new int[3];
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			tmp[0] = Integer.parseInt(st.nextToken());
			tmp[1] = Integer.parseInt(st.nextToken());
			tmp[2] = Integer.parseInt(st.nextToken());
			
			if(tmp[0] == 0) {
				union(tmp[1], tmp[2]);
			} else {
				if(isSameParent(tmp[1], tmp[2])) {
					bw.write("YES\n");					
				} else {
					bw.write("NO\n");	
				}
			}
		}
		bw.close();
		br.close();
	}
	
	public static boolean isSameParent(int a, int b) {
		return  find(a) == find(b);
	}
	
	public static int find(int num) {
		if(arr[num] == -1) return num;
		return arr[num] = find(arr[num]);
	}
	
	public static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		if(aParent != bParent) {
			arr[bParent] = aParent;
		}
	}
}
