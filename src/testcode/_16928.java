package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

import tester.Executable;

public class _16928 implements Executable {
	static int arr[];
	static int move[];
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		br.readLine();
		arr = new int[101];
		move = new int[101];
		
		br.lines()
			.forEach(s -> {
				String[] tmp = s.split(" ");
				move[Integer.parseInt(tmp[0])] = Integer.parseInt(tmp[1]);
			});
		
		int solution = search() - 1;
		bw.write(String.valueOf(solution));
		bw.close();
		br.close();
	}
	
	public static int search() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		arr[1] = 1;
		
		while(!q.isEmpty()) {
			int c = q.poll();
			
			if(c == 100) {
				return arr[c];
			}
			
			if(move[c] != 0) {
				arr[move[c]] = arr[c];
				c = move[c];
			}
			
			for(int i = 1; i <= 6; i++) {
				if(c + i <= 100 && arr[c + i] == 0) {
					q.add(c + i);
					arr[c + i] = arr[c] + 1;
				}
			}
		}
		
		return 0;
	}

}
