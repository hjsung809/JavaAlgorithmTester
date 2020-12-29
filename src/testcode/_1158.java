package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import tester.Executable;

public class _1158 implements Executable{

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		String[] tokens = br.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int k = Integer.parseInt(tokens[1]);
		
		LinkedList<Integer> circle = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			circle.add(i);
		}
		
		ListIterator<Integer> li = circle.listIterator();
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		int value = -1;
		while(circle.size() > 0) {
			for(int i = 0; i < k; i++) {
				if(li.hasNext()) {
					value = li.next();
				}else {
					li = circle.listIterator();
					value = li.next();
				}
			}
			sb.append(value + ", ");
			li.remove();
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");
		bw.write(sb.toString());
		bw.flush();
	}
	
}
