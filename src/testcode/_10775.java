package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import tester.Executable;

public class _10775 implements Executable {
	static int[] set;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		int g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		
		int count = 0;
		set = new int[100001];
		for(int i = 0; i < set.length; i++) {
			set[i] = i;
		}
		
		while(p-- > 0) {
			int gi = Integer.parseInt(br.readLine());
			int parent = find(gi);
			
			if(parent == 0) {
				break;
			}
			union(parent, parent - 1);
//			set[parent] = set[parent - 1];
			count ++;
		}
		bw.write(String.valueOf(count));
		br.close();
		bw.close();
	}
	
	public static int find(int num) {
		if(set[num] == num) return num;
		return set[num] = find(set[num]);
	}
	
	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		set[pa] = set[pb];
	}
}
