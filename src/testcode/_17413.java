package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;


import tester.Executable;

public class _17413 implements Executable{

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		Deque<Character> deque = new ArrayDeque<Character>();
		boolean isTag = false;
		
		char[] line = br.readLine().toCharArray();
		
		for(char c : line) {
			if(c == '<') {
				isTag = true;
				
				while(deque.size() > 0) {
					bw.write(deque.pollLast());
				}
				deque.add(c);
			} else if(c == '>') {
				isTag = false;
				
				deque.add(c);
				while(deque.size() > 0) {
					bw.write(deque.pollFirst());
				}
			} else if(!isTag && c == ' ') {
				while(deque.size() > 0) {
					bw.write(deque.pollLast());
				}
				bw.write(c);
				continue;
			} else {
				deque.add(c);
			}
		}
		
		//잔여
		while(deque.size() > 0) {
			bw.write(deque.pollLast());
		}
		
		bw.flush();
	}
}
