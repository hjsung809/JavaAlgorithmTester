package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import tester.Executable;

public class _11728 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		br.readLine();
		
		Queue<Integer> q = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.boxed()
			.collect(Collectors.toCollection(LinkedList::new));
		
		Queue<Integer> q2 = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toCollection(LinkedList::new));
		
		List<Integer> list = new ArrayList<Integer>();
		
		while(!q.isEmpty() && !q2.isEmpty()) {
			if(q.peek() < q2.peek()) {
				list.add(q.poll());
			} else {
				list.add(q2.poll());
			}
		}
		
		while(!q.isEmpty()) list.add(q.poll());
		while(!q2.isEmpty()) list.add(q2.poll());
		
		for(int e : list) {
			bw.append(String.valueOf(e) + " ");
		}
		bw.close();
	}

}
