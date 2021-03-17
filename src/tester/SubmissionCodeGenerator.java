package tester;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubmissionCodeGenerator {
	private final String packagePattern = "package\\s+(\\w|\\.)+;\n";
	private final String importInterfacePattern = "import\\s+tester\\.(\\w|\\.)+;\\n";
	private final String classNamePattern = "public\\s+class\\s+(\\w|_)+\\s+implements\\s+Executable";
	private final String overridePattern = "@Override\\s*\n";
	private final String mainMethodNamePattern = "public\\s+void\\s+main\\s*\\((\\w|\\s|,)+\\)";
//	private final String instanceNamePattern = "(^(?!static).\\s+)+";
	static public int a;
	final static public int b = 1;
	
	private final String inPattern = "(\\r|\\n|\\s|\\t|\\v|\\()(in)(\\W)";
	private final String outPattern = "(\\r|\\n|\\s|\\t|\\v|\\()(out)(\\W)";

	
//	public static void main(String[] args) {
//		String SOURCE_DIR = "src";
//		String PAKAGE_NAME = "testcode";
//
//		String currentPath = System.getProperty("user.dir");
//		
//		Path sourceCodePath = Paths.get(currentPath, SOURCE_DIR, PAKAGE_NAME, "_10799.java");
//		Path testcaseDir = Paths.get(currentPath, "submit_code.txt");
//		
//		SubmissionCodeGenerator submissionCodeGenerator = new SubmissionCodeGenerator();
//		
//		if(submissionCodeGenerator.generate(sourceCodePath,testcaseDir)) {
//			System.out.println("성공!");
//		} else {
//			System.out.println("실패!");
//		}
//	}
	
	
	public boolean generate(Path targetFilePath, Path destPath) {
		if (!targetFilePath.toFile().exists()) {
			System.out.println("타겟 파일이 존재하지 않습니다.\n" + targetFilePath.toString());
			return false;
		}
		System.out.println("제출용 코드를 만듭니다.");
		System.out.println(targetFilePath + "\n=> " + destPath);
//		if (!destPath.toFile().) {
//			System.out.println("해당 경로에 파일을 생성할 수 없습니다.\n" + destPath.toString());
//			return false;
//		}
		boolean cleanSuccess = true;

		try {
			String file = Files.readString(targetFilePath);
			StringBuffer sb = new StringBuffer(file);

			if (!replace(sb, packagePattern, "")) {
				System.out.println("패키지 선언부를 찾지 못했습니다.");
				cleanSuccess = false;
			}
			if (!replace(sb, importInterfacePattern, "")) {
				System.out.println("인터페이스 인포팅 부분을 찾지 못했습니다.");
				cleanSuccess = false;
			}
			if (!replace(sb, classNamePattern, "public class Main")) {
				System.out.println("클래스 이름을 찾지 못했습니다.");
				cleanSuccess = false;
			}
			if (!replace(sb, overridePattern, "")) {
				System.out.println("오버라이딩 부분을 찾지 못했습니다.");
//				cleanSuccess = false;
			}
			if (!replace(sb, mainMethodNamePattern, "public static void main(String[] args)")) {
				System.out.println("메소드 부분을 찾지 못했습니다.");
				cleanSuccess = false;
			}
//			if (!replace(sb, instanceNamePattern, "public static void main(String[] args)")) {
//				System.out.println("메소드 부분을 찾지 못했습니다.");
//				cleanSuccess = false;
//			}
			if (!replaceGroup(sb, inPattern, 2, "System.in")) {
				
				System.out.println("in 부분을 찾지 못했습니다.");
				cleanSuccess = false;
			}
			if (!replaceGroup(sb, outPattern, 2, "System.out")) {
				System.out.println("out 부분을 찾지 못했습니다.");
				cleanSuccess = false;
			}

			Files.write(destPath, sb.toString().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
			cleanSuccess = false;
		}
		return cleanSuccess;
	}

	private boolean replace(StringBuffer sb, String regex, String alter) {
		boolean replaced = false;
		try {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(sb);

			while (matcher.find()) {
				sb.replace(matcher.start(), matcher.end(), alter);
				replaced = true;
				matcher = pattern.matcher(sb);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return replaced;
	}
	
	private boolean replaceGroup(StringBuffer sb, String regex,int groupNumber, String alter) {
		boolean replaced = false;
		try {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(sb);

			while (matcher.find()) {
				sb.replace(matcher.start(groupNumber), matcher.end(groupNumber), alter);
				replaced = true;
				matcher = pattern.matcher(sb);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return replaced;
	}
}
