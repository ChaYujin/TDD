# AssertJ 사용법

## AssertJ의 장점
1. 메소드 체이닝을 지원하기 때문에 좀 더 깔끔하고 읽기 쉬운 테스트 코드를 작성할 수 있습니다.
2. 개발자가 테스트를 하면서 필요하다고 상상할 수 있는 거의 모든 메소드를 제공합니다.

## 라이브러리 의존성 설정
Java8 이상 기반 프로젝트는 3.x 버전을, Java7 이하 기반 프로젝트는 2.x 버전을 사용하셔야 합니다.
    
*  Gradle
    ```
    Java8 : testCompile 'org.assertj:assertj-core:3.6.2'
    Java7 : testCompile 'org.assertj:assertj-core:2.6.0'
    ```
*  Maven
    ```
    <dependency>
        <groupId>org.assertj</groupId>
        <artifactId>assertj-core</artifactId>
        <!-- use 2.6.0 for Java 7 projects -->
        <version>3.6.2</version>
        <scope>test</scope>
    </dependency>                 
    ```
    
## 테스트의 시작
* 모든 테스트 코드는 assertThat() 메소드에서 출발합니다.
* 다음과 같은 포멧으로 AssertJ에서 제공하는 다양한 메소드를 연쇄 호출 하면서 코드를 작성할 수 있습니다.
* assertThat(테스트 타켓).메소드1().메소드2().메소드3();

## AssertJ API 사용법
* [common] AssertJ를 사용하기위해 필요한 package import
    >import static org.assertj.core.api.Assertions.*; 

* [Object] assertions(가정설정문?표명?)의 기본 
    * assertThat(frodo.getName()).isEqualTo("Frodo"); 
    * assertThat(frodo).isNotEqualTo(sauron); 
    * 검증 : frodo 이름이 "Frodo"이고, sauron 객체와 다름을 확인

* [String] 체이닝 기능을 이용하여 문자열에 대한 구체적인 assertion 작성 
    * assertThat(frodo.getName()).startsWith("Fro") .endsWith("do") .isEqualToIgnoringCase("frodo");
    * 검증 : 이름이 'Fro'로 시작하고, 'do'로 끝나며 대소문자 구분없이 "frodo"인지 확인

* [Collection] collection의 assertion방법 (예시. below fellowshipOfTheRing=List\<TolkienCharacter\> )
    * assertThat(fellowshipOfTheRing).hasSize(9) .contains(frodo, sam) .doesNotContain(sauron);
    * 검증 : List의 사이즈, 내부 객체의 포함 여부를 확인 
    
* [Exception] as() 를 이용하여 메세지를 표출 (assertion 전에 as메소드 사용)
    * assertThat(frodo.getAge()).as("check %s's age", frodo.getName()).isEqualTo(33);
    * 결과 : (에러발생)[check frodo's age] expected:<100> but was:<33>

* [Exception] exception assertion 작성 방법(Java8)
    * assertThatThrownBy(() -> { throw new Exception("boom!"); }).hasMessage("boom!");
    * 검증 : 예외 발생시 "boom!" 메세지가 나오는가?

* [Exception] exception assertion (BDD 스타일)(BDD=Behaviour-Driven Development, 진짜 시나리오대로 테스트하는 기법)
    * Throwable thrown = catchThrowable(() -> { throw new Exception("boom!"); }); 
    * assertThat(thrown).hasMessageContaining("boom"); 
    * 검증 : catchThrowable로 Exception을 잡아내어 assertJ로 "boom" 에러 메세지 확인

* [Object,Collection] extracting을 이용하여 Collection의 특정 속성값을 확인함 
    * assertThat(fellowshipOfTheRing).extracting("name") .contains("Boromir", "Gandalf", "Frodo", "Legolas")
    * 검증 : List\<tockienCharacter\>인 fellowshipOfTheRing에서 name값을 가져와 목록안에 해당되는 값을 가지고 있는지 확인. 

* [Object,Collection] Java8의 메소드와 extracting을 이용하여 Collection의 특정 속성값을 확인함 
    * assertThat(fellowshipOfTheRing).extracting(TolkienCharacter::getName) .doesNotContain("Sauron", "Elrond"); 
    * 검증 : fellowshipOfTheRing에서 TolkienCharacter의 getName메소드로부터 값을 가져와 포함되지 않는지 비교

* [Object,Collection]여러값을 추출하여 값 순서대로 group으로 비교 (Java 7) 
    * assertThat(fellowshipOfTheRing).extracting("name", "age", "race.name") .contains(tuple("Boromir", 37, "Man"), tuple("Sam", 38, "Hobbit"), tuple("Legolas", 1000, "Elf"));
    * 검증 : 이름, 나이, 레이스이름을 가져와 3명의 정보와 비교하여 포함되는지 확인 

* [Filtering] race값이 HOBBIT인 값을 가져와 속하는지 확인
    * assertThat(fellowshipOfTheRing).filteredOn("race" HOBBIT) .containsOnly(sam, frodo, pippin, merry); 

* [Filtering] Java8 name에 "o"가 포함된 정보를 가져와 객체 안에 속하는지 확인
    * assertThat(fellowshipOfTheRing).filteredOn(character -> character.getName().contains("o")) .containsOnly(aragorn, frodo, legolas, boromir); 

* combining filtering and extraction (yes we can) 
    * assertThat(fellowshipOfTheRing).filteredOn(character -> character.getName().contains("o")) .containsOnly(aragorn, frodo, legolas, boromir) .extracting(character -> character.getRace().getName()) .contains("Hobbit", "Elf", "Man"); 

## AssertJ 참고 사이트
* AssertJ는 오픈 소스 프로젝트로 github에 공개되어있다. 아래 URL에 상황에 맞는 샘플이 작성되어있는데 시간이 남을 때 참고하면 좋겠다.
* AssertJ 샘플 : https://github.com/joel-costigliola/assertj-examples/tree/master/assertions-examples/src/test/java/org/assertj/examples
* AssertJ java doc : http://joel-costigliola.github.io/assertj/core-8/api/index.html

## 아직 궁금한 부분
* 어디까지 검증할 수 있는가?
* Front-End TDD 적용 방법
* DB 연관된 부분
* TDD코드도 함께 배포하는가?
