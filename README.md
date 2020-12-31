# Java Algorithm Tester

[백준](https://www.acmicpc.net/)에서 사용가능한 초간단 알고리즘 테스트 프레임워크 입니다.

가장 최근 수정한 소스를 찾고, 테스트 케이스를 다운로드 한 뒤, 실행하여 실행 결과를 정답과 비교해 주는 기능을 가지고 있습니다.

현재 이클립스에 의존적으로(컴파일 등) 실행가능한 상태입니다.

(또한, JDK 11.0.9 환경에서 개발되었습니다.)

![image](https://user-images.githubusercontent.com/43060547/103292817-ed4c8500-4a31-11eb-88dc-094cf02a39be.png)



## Usage

1. 레포지터리를 다운로드 후, 이클립스를 통해 Open 합니다.
2. testcode 패키지 밑에 '_문제번호.java'형태로 테스트할 자바 파일을 작성합니다.

![image](https://user-images.githubusercontent.com/43060547/103293004-5b914780-4a32-11eb-8c29-7b4e0be54f6f.png)



3. tester.Executable 인터페이스를 구현하는 클래스를 생성합니다.

   ![image](https://user-images.githubusercontent.com/43060547/103293299-f12cd700-4a32-11eb-838c-1098432a66df.png)

   이때, main함수의 매개변수인 in과 out을 System.in과 System.out 처럼 사용하면 됩니다.

   

4. 이클립스를 통해 Main클래스의 메인 함수를 실행 합니다.

   테스트 케이스가 없으면, testcase폴더 아래에 테스트 케이스가 다운로드되어 저장됩니다.

   ![image](https://user-images.githubusercontent.com/43060547/103293537-72846980-4a33-11eb-97bd-8a2eef343c2e.png)

   Input.txt와 answer.txt는 크롤링 단계에서 생성됩니다.

   input.txt는 테스트 코드의 인풋으로 사용되며, output.txt는 실행 시, 프로그램의 출력 값이 저장되는 파일입니다.

   실행이 끝난 뒤, output.txt 파일의 내용과 answer.txt의 내용이 비교되어 출력됩니다.

   

   

   # 추가 기능 

   제출용 코드를 생성하는 기능이 추가되었습니다. (2020.12.31)

   모든 테스트 케이스가 일치하면 제출용 코드를 생성합니다.

   기존 Executable 인터페이스를 상속한 '_문제번호.java' 형태의 파일은 그대로 제출하면 작동하지 않아 일일이 변경해줘야 했습니다.

   클래스 이름 변경, 메소드 변경, 오버라이딩 어노테이션 삭제 등을 진행하고 최상위 폴더의 'submit_code.txt'에 저장합니다.

   

   ![image](https://user-images.githubusercontent.com/43060547/103362987-5b11b300-4afd-11eb-9fe1-1e7df3f51c6a.png)

   

   'submit_code.txt'의 내용을 복사해서 백준에 제출하면 됩니다.

   # Update

   업데이트 예정 사항은 다음과 같습니다.

   

   1. <del>백준 사이트 업로드용 파일 생성 기능.</del>
   2. 대상 자바 파일에 대한 컴파일 기능.
   3. 반복 실행 기능.
   4. DI과 XML을 이용한 설정 기능.
   5. JUnit 도입

   

   

