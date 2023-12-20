package hello.core1.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingletonService {

    //static 영역에 객체를 딱 1개만 생성해둔다
    //자기 자신을 참조해서 isntance에 넣음
    private static final SingletonService instance=new SingletonService();

    //public으로 열어서 객체 인스턴스가 필요하면 static 메서드를 통해서만 조회하도록 허용
    //객체 인스턴스가 필요하면 오직 getInstance()를 통해서만 조회 가능
    public static SingletonService getInstance(){
        return instance;
    }

    //생성자를 private로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1="+singletonService1);
        System.out.println("singletonService2="+singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }
}

