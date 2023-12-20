package hello.core1.member;

import hello.core1.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    // psvm+Enter 치면 아래 코드 생성
    public static void main(String[] args) {
        // AppConfig appConfig=new AppConfig();
        //MemberService memberService=appConfig.memberService();
        // MemberService memberService=new MemberServiceImpl();

        //AppConfig에 있는 환경 설정 정보를 스프링이 스프링 컨테이너에 다 넣어서 관리
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);

        //이름:memberService, type:MemberService.class
        MemberService memberService=applicationContext.getBean("memberService",MemberService.class);

        //Long id, String name, Grade grade
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        //soutv+Enter 치면 아래 코드 생성
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
