package tester;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
	public static final String SOURCE_DIR = "src";
	public static final String PAKAGE_NAME = "testcode";
	public static final String TESTCASE_DIR = "testcase";

	// 1. 작성된 코드중, 가장 최근에 작성된 코드를 찾는다.
	// 2. 컴파일 및 실행한다.
	// 3. 테스트 케이스를 입력할지 선택 입력을 받는다.
	// 4. 테스트 케이스를 입력하지 않으면 저장된 테스트 케이스로 실행된 결과를 보여준다.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String currentPath = System.getProperty("user.dir");
//	    System.out.println("Current Directory : " + currentPath);

		Path sourceCodeDir = Paths.get(currentPath, SOURCE_DIR, PAKAGE_NAME);
		Path testcaseDir = Paths.get(currentPath, TESTCASE_DIR);

		// 초기화
		FileFinder fileFinder = new RecentFileFinder(sourceCodeDir);
		TestCaseManager testCaseManager = new TestCaseManager(testcaseDir);
		Executor executor = new Executor(PAKAGE_NAME);
		TestcaseCrawler testcaseCrawler = new TestcaseCrawler(TestcaseCrawler.SITE.ACMICPC);

		// 최근 변경 파일 찾기.
		if (!fileFinder.findFile()) {
			System.out.println("파일 검색에 실패하였습니다.");
			return;
		}
		String targetClassName = fileFinder.getClassName();
		if (targetClassName == null) {
			System.out.println("유효한 파일을 찾을 수 없습니다.");
			return;
		}
		System.out.println("다음 파일을 실행합니다. [" + targetClassName + "]");

		// 테스트 케이스 경로 계산.
		int validTestcaseCount = testCaseManager.countValidTestcase(targetClassName);
		if (validTestcaseCount < 1) {
			System.out.println("유효한 테스트 케이스가 없습니다.");

			Path crawlingPath = testCaseManager.getCrawlingPath(targetClassName);
			validTestcaseCount = testcaseCrawler.crawlling(targetClassName, crawlingPath);
			if (validTestcaseCount < 1) {
				return;
			}
		}
		List<Path> inputPaths = testCaseManager.getInputPaths(targetClassName, validTestcaseCount);
		List<Path> outputPaths = testCaseManager.getOutputPaths(targetClassName, validTestcaseCount);
		List<Path> answerPaths = testCaseManager.getAnswerPaths(targetClassName, validTestcaseCount);

		// 실행
		if (!executor.excute(targetClassName, inputPaths, outputPaths)) {
			System.out.println("실행에 실패하였습니다.");
		}

		// 결과 비교
		ResultComparator resultComparator = new ResultComparator();
		int successCount = resultComparator.compare(outputPaths, answerPaths);
		System.out.println("실행 결과 : " + successCount + "/" + validTestcaseCount + "\n");
		
		// 전부 맞았을 때, 코드 변환.
//		if(successCount == validTestcaseCount) {
//			
//		}
		SubmissionCodeGenerator submissionCodeGenerator = new SubmissionCodeGenerator();
		if (!submissionCodeGenerator.generate(fileFinder.getPath(), Paths.get(currentPath, "submit_code.txt"))) {
			System.out.println("코드변환에 문제가 발견되었습니다.");
		} else {
			System.out.println("코드 변환이 완료되었습니다. 제출해 보세요!");
		}
	}

}
