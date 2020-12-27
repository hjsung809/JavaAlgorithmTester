package excute;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestCaseManager {
	Path testCasePath;
	File testCasedir;
	
	public TestCaseManager(Path testCasePath) {
		this.testCasePath = testCasePath;
		this.testCasedir = testCasePath.toFile();
		
	}
	
	//테스트 케이스 폴더가 존재하고 유효한지 체크.
	public int countValidTestcase(String targetClassName) {
		if (!testCasedir.exists()) {
			System.out.println("테스트 케이스 폴더가 없습니다.");
			return 0;
		}

		for (int i = 1; true; i++) {
			// 인풋 파일과 정답 파일.
			Path targetInputPath = Paths.get(testCasePath.toString(), targetClassName, i + "_input.txt");
			Path targetAnswerPath = Paths.get(testCasePath.toString(), targetClassName, i + "_answer.txt");

			File targetInputFile = targetInputPath.toFile();
			File targetAnswerFile = targetAnswerPath.toFile();

			if (targetInputFile.exists() ^ targetAnswerFile.exists()) {
				System.out.println(i + "번째 테스트 케이스의 짝이 맞지않습니다.\n");
				return i - 1;
			}

			if (!targetInputFile.exists() && !targetAnswerFile.exists()) {
				System.out.println((i - 1) + "개의 테스트 케이스를 사용할 수 있습니다.\n");
				return i - 1;
			}
		}
	}
	
	public List<Path> getInputPaths(String targetClassName, int num) {
		List<Path> inputPaths = new ArrayList<Path>();
		
		for (int i = 1; i <= num; i++) {
			Path targetInputPath = Paths.get(testCasePath.toString(), targetClassName, i + "_input.txt");
			File targetInputFile = targetInputPath.toFile();
			if (!targetInputFile.exists()) {
				break;
			}
			inputPaths.add(targetInputPath);
		}
		return inputPaths;
	}
	
	public List<Path> getAnswerPaths(String targetClassName, int num) {
		List<Path> answerPaths = new ArrayList<Path>();
		
		for (int i = 1; i <= num; i++) {
			Path targetAnswerPaths = Paths.get(testCasePath.toString(), targetClassName, i + "_answer.txt");
			File targetAnswerFile = targetAnswerPaths.toFile();
			if (!targetAnswerFile.exists()) {
				break;
			}
			answerPaths.add(targetAnswerPaths);
		}
		return answerPaths;
	}
	
	public List<Path> getOutputPaths(String targetClassName, int num) {
		List<Path> outputPaths = new ArrayList<Path>();
		
		for (int i = 1; i <= num; i++) {
			Path targetOutputPath = Paths.get(testCasePath.toString(), targetClassName, i + "_output.txt");
			outputPaths.add(targetOutputPath);
		}
		return outputPaths;
	}
	
//	public boolean ready(String targetClassName) {
//		isInit = false;		
//		inputs = (List<Path>)new LinkedList<Path>();
//		inputIndex = 0;
//		
//		testOutputs = (List<Path>)new LinkedList<Path>();
//		testOutputIndex = 0;
//		
//		answers = (List<Path>)new LinkedList<Path>();
//		answerIndex = 0;
//		
//		if (!testCasedir.exists()) {
//			System.out.println("대상 테스트 폴더가 없습니다.");
//			return false;
//		}
//		
//		int num = 0;
//		while (true) {
//			num += 1;
//			Path targetInputPath = Paths.get(testCasePath.toString(), targetClassName, num + "_input.txt");
//			Path targetAnswerPath = Paths.get(testCasePath.toString(), targetClassName, num + "_answer.txt");
//			Path targetTestOutputPath = Paths.get(testCasePath.toString(), targetClassName, num + "_test_output.txt");
//			
//			
//			// 인풋 파일이 존재할 때 아웃풋 파일을 만듬.
//			File targetInputFile = targetInputPath.toFile();
//			File targetAnswerFile = targetAnswerPath.toFile();
//			
//			if (!targetInputFile.exists() || !targetAnswerFile.exists()) {
//				System.out.println((num - 1) + "개의 테스트 케이스를 읽었습니다.\n");
//				break;
//			}
//			
//			inputs.add(targetInputPath);
//			answers.add(targetAnswerPath);
//			testOutputs.add(targetTestOutputPath);
//		}
//		
//		isInit = true;
//		return true;
//	}
	
//	public boolean hasNext() {
//		if (!isInit) {
//			System.out.println("테스트 케이스 매니저가 초기화되지 았습니다.");
//			return false;
//		}
//		return inputs.size() > inputIndex;
//	}
	
//	public InputStream getNextInputStream() {
//		FileInputStream fileInputStream = null;
//		
//		try {
//			Path path = inputs.get(inputIndex++);
//			System.out.println("인풋 파일을 읽습니다.\n" + path.toString());
//			fileInputStream = new FileInputStream(path.toFile());
//		} catch(FileNotFoundException e) {
//			System.out.println("테스트 인풋 파일을 찾을 수 없습니다.");
//		}
//		return fileInputStream;
//	}
//	
//	public OutputStream getNextOutputStream() {
//		FileOutputStream fileOutputStream = null;
//		
//		try {
//			Path path = testOutputs.get(testOutputIndex++);
//			System.out.println("아웃풋 파일을 생성합니다.\n" + path.toString());
//			fileOutputStream = new FileOutputStream(path.toFile());
//		} catch(FileNotFoundException e) {
//			System.out.println("테스트 아웃풋 파일을 생성할 수 없습니다.");
//		}
//		return fileOutputStream;
//	}
	
//	public boolean markUp() {
//		boolean success = true;
//		
//		for(int i = 0; i < inputs.size(); i++) {
//			Path testOutputPath = testOutputs.get(i);
//			Path answerPath = answers.get(i);
//			
//			if(!compare(testOutputPath.toFile(), answerPath.toFile())) {
//				success = false;
//				System.out.println(i + "번째 테스트 케이스가 틀렸습니다.");
//			}
//		}
//		return success;
//	}
//	
//	private boolean compare(File testFile, File answerFile) {
//		if(!testFile.exists() || !answerFile.exists()) {
//			System.out.println("비교 파일중 하나가 존재하지 않습니다.");
//			return false;
//		}
//		
//		try {
//			BufferedReader tbr = new BufferedReader(new FileReader(testFile));
//			BufferedReader abr = new BufferedReader(new FileReader(answerFile));
//			
//			int lineNum = 1;
//			String tbrLine = tbr.readLine();
//			String abrLine = abr.readLine();
//			
//			while(tbrLine != null && abrLine != null) {
//				tbrLine = tbrLine.trim();
//				abrLine = abrLine.trim();
//				
//				if(!tbrLine.equals(abrLine)) {
//					System.out.println(lineNum + "번째 줄이 다릅니다.");
//					System.out.println("출력 [" + tbrLine + "]");
//					System.out.println("정답 [" + abrLine + "]");
//					tbr.close();
//					abr.close();
//					return false;
//				}
//				
//				lineNum++;
//				tbrLine = tbr.readLine();
//				abrLine = abr.readLine();
//			}
//			
//			// 두 파일 모두 끝났을 때.
//			if(tbrLine == null && abrLine == null) {
//				tbr.close();
//				abr.close();
//				return true;
//			}
//			
//			tbr.close();
//			abr.close();
//			System.out.println("비교 파일의 줄 수가 다릅니다." + tbrLine + "," + abrLine);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		// 둘 중 하나는 끝나지 않았을때.
//
//		return false;
//	}
}
