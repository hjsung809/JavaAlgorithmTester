

package testcode;

import java.io.*;
import java.util.*;

import tester.Executable;

public class _1991 implements Executable {
	static int n;
	static Node[] nodes;
	
	public static class Node {
		Node left;
		Node right;
		
		int idx;
	}

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		n = Integer.parseInt(br.readLine());
		nodes = new Node[n];
		for(int i = 0; i < n; i++) {
			nodes[i] = new Node();
			nodes[i].idx = i;
		}
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int current = st.nextToken().charAt(0) - 'A';
			int left = st.nextToken().charAt(0) - 'A';
			int right = st.nextToken().charAt(0) - 'A';
			
			if(left != '.' - 'A') nodes[current].left = nodes[left];
			if(right != '.' - 'A') nodes[current].right = nodes[right];
		}
		
		for(int i = 1; i <= 3; i++) {
			bw.write(traversal(i));
		}
		bw.close();
		br.close();
	}
	
	public static String traversal(int order) {
		StringBuilder sb = new StringBuilder();
		
		if(order == 1) preorder(nodes[0], sb);
		else if(order == 2) inorder(nodes[0], sb);
		else postorder(nodes[0], sb);
		
		sb.append('\n');
		return sb.toString();
	}
	
	public static void preorder(Node current, StringBuilder sb) {
		if(current == null) return;
		
		sb.append((char)(current.idx + 'A'));
		preorder(current.left, sb);
		preorder(current.right, sb);
	}
	
	public static void inorder(Node current, StringBuilder sb) {
		if(current == null) return;
		
		inorder(current.left, sb);
		sb.append((char)(current.idx + 'A'));
		inorder(current.right, sb);
	}
	
	public static void postorder(Node current, StringBuilder sb) {
		if(current == null) return;
		
		postorder(current.left, sb);
		postorder(current.right, sb);
		sb.append((char)(current.idx + 'A'));
	}

}
