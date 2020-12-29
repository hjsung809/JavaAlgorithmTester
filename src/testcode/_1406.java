package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

import tester.Executable;


public class _1406 implements Executable{

	@Override
	public void main(InputStream in, OutputStream out) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		String line = br.readLine();
		LinkedList<Character> list = new LinkedList<Character>();
		for(int i = 0; i < line.length(); i++) {
			list.add(line.charAt(i));
		}
		
		int n = Integer.parseInt(br.readLine());
			
		ListIterator<Character> cursor = list.listIterator(list.size());
		
		
		for(int i = 0; i < n; i++) {
			String command = br.readLine();
			
			if (command.charAt(0) == 'L') {
				if(cursor.hasPrevious()) {
					cursor.previous();
				}
			} else if (command.charAt(0) == 'D') {
				if(cursor.hasNext()) {
					cursor.next();
				} 
			} else if (command.charAt(0) == 'B') {
				if (cursor.hasPrevious()) {
					cursor.previous();
					cursor.remove();
				}
			} else if (command.charAt(0) == 'P') {
				cursor.add(command.charAt(2));
			}
		}
		
		for(char tmp : list) {
			bw.write(tmp);
		}
		bw.flush();
	}
}
