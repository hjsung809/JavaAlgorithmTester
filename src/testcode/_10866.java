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

public class _10866 implements Executable{
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		Deque<String> deque = new ArrayDeque<String>();
		
		int n = Integer.parseInt(br.readLine());
		String tmp;
		
		for(int i = 0; i < n ; i ++) {
			String[] command = br.readLine().split(" ");
			tmp = null;
			switch(command[0]) {
				case "push_front":
					deque.addFirst(command[1]);
					break;
				case "push_back":
					deque.addLast(command[1]);
					break;
				case "pop_front":
					tmp = deque.pollFirst();
					if(tmp == null) tmp = "-1";
					break;
				case "pop_back":
					tmp = deque.pollLast();
					if(tmp == null) tmp = "-1";
					break;
				case "size":
					tmp = String.valueOf(deque.size());
					break;
				case "empty":
					if(deque.isEmpty()) {
						tmp = "1";
					} else {
						tmp = "0";
					}
					break;
				case "front":
					tmp = deque.peekFirst();
					if(tmp == null) tmp = "-1";
					break;
				case "back":
					tmp = deque.peekLast();
					if(tmp == null) tmp = "-1";
					break;
				
			}
			if(tmp != null) {
				bw.write(tmp);
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
