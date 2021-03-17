package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import tester.Executable;

public class _4195 implements Executable {
	public static int[][] set;
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			set = new int[2 * n][2];
			for(int i = 0; i < set.length; i++) {
				set[i][0] = -1;
				set[i][1] = 1;
			}
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String friend1 = st.nextToken();
				String friend2 = st.nextToken();
				int idx1, idx2;
				
				if(map.containsKey(friend1)) {
					idx1 = map.get(friend1);
				} else {
					idx1 = map.size();
					map.put(friend1, idx1);
				}
				
				if(map.containsKey(friend2)) {
					idx2 = map.get(friend2);
				} else {
					idx2 = map.size();
					map.put(friend2, idx2);
				}

				union(idx1,idx2);
				bw.write(String.valueOf(set[find(idx2)][1]) + '\n');
			}
		}
		bw.close();
		br.close();
	}
	
	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) {
			set[pa][0] = pb;
			set[pb][1] += set[pa][1];
//			pb[1] += pa[1];
		}
	}
	
	public static int find(int num) {
		if(set[num][0] == -1) return num;
		int p = find(set[num][0]);
		set[num][0] = p;
		return p;
	}
}
