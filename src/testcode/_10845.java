package testcode;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
//import java.util.LinkedList;
import java.util.StringTokenizer;

import tester.Executable;

public class _10845 implements Executable{
	
	public void main(InputStream in, OutputStream out) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		Deque<String> queue = new ArrayDeque<String>();
//		LinkedList<String> queue = new LinkedList<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n; i++) {
			String[] tokens = br.readLine().split(" ");
			
			switch(tokens[0]) {
				case "push":
					queue.add(tokens[1]);
					break;
				case "pop":
					String pop = queue.poll();
					if (pop == null) {
						bw.write("-1");
					} else {
						bw.write(pop);
					}				
					bw.write("\n");
					break;
				case "size":
					bw.write(String.valueOf(queue.size()));
					bw.write("\n");
					break;
				case "empty":
					if (queue.isEmpty()) {
						bw.write("1");
					} else {
						bw.write("0");
					}		
					bw.write("\n");
					break;
				case "front":
					String front = queue.peekFirst();
					if (front == null) {
						bw.write("-1");
					} else {
						bw.write(front);
					}	
					bw.write("\n");
					break;
				case "back":
					String back = queue.peekLast();
					if (back == null) {
						bw.write("-1");
					} else {
						bw.write(back);
					}	
					bw.write("\n");
					break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}

