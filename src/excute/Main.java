package excute;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	// 1. 작성된 코드중, 가장 최근에 작성된 코드를 찾는다.
	// 2. 컴파일 및 실행한다.
	// 3. 테스트 케이스를 입력할지 선택 입력을 받는다.
	// 4. 테스트 케이스를 입력하지 않으면 저장된 테스트 케이스로 실행된 결과를 보여준다.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String currentPath = System.getProperty("user.dir");
//	    System.out.println("Current Directory : " + currentPath);
		
		Path javaFilePath = Paths.get(currentPath, "src", "testcode");
		Path testCasePath = Paths.get(currentPath, "testcase");
		
	    RecentFileFinder recentFileFinder = new RecentFileFinder(javaFilePath);
	    TestCaseManager testCaseManager = new TestCaseManager(testCasePath);
	    
	    Tester tester = new Tester(recentFileFinder, testCaseManager);
	    if (!tester.excute()) {
	    	System.out.println("실행에 실패하였습니다.");
	    }
	}

}
