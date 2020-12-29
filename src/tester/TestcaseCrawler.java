package tester;

import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TestcaseCrawler {
	public static enum SITE {
		ACMICPC,
	};
	private static final String ACMICPC_URL = "https://www.acmicpc.net/problem/";
	
	private SITE site;
	private String baseUrl;
	
//	public static void main(String[] args) {
//		TestcaseCrawler tc = new TestcaseCrawler(SITE.ACMICPC);
//		String currentPath = System.getProperty("user.dir");
//		Path path = Paths.get(currentPath, "testcase", "_" + String.valueOf(1874));
//		tc.crawlling("1874", path);
//	}
	
	public TestcaseCrawler(SITE site) {
		this.site = site;
		
		switch(site) {
		case ACMICPC:
			this.baseUrl = ACMICPC_URL;
		}
	}
	
	public int crawlling(String problem, Path path) {
		if(problem.startsWith("_")) {
			problem = problem.substring(1);
		}
		String url = baseUrl + problem;
		System.out.println("다음 URL로 부터 테스트 케이스를 다운로드합니다.\n" + url) ;
		int num = 0;
		
		try {
			Document doc = Jsoup.connect(url).get();
		
			for(num = 1; true; num++) {
				Element inputElement = doc.getElementById("sample-input-" + num);
				Element answerElement = doc.getElementById("sample-output-" + num);
				if(inputElement == null || answerElement == null) {
					num --;
					break;
				}
				
				Path destPath = Paths.get(path.toString(), String.valueOf(num));
				destPath.toFile().mkdir();
				
				Path destInputPath = Paths.get(path.toString(), String.valueOf(num), "input.txt");
				Path destAnswerPath = Paths.get(path.toString(), String.valueOf(num), "answer.txt");
				FileOutputStream inputFileOutputStream = new FileOutputStream(destInputPath.toFile()); 
				FileOutputStream answerFileOutputStream = new FileOutputStream(destAnswerPath.toFile());
				
				inputFileOutputStream.write(inputElement.text().getBytes());
				answerFileOutputStream.write(answerElement.text().getBytes());
				inputFileOutputStream.close();
				answerFileOutputStream.close();
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(num + "개의 테스트 케이스를 다운로드했습니다.\n");
		return num;
	}
}
