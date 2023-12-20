package hello.core1.member;

import hello.core1.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {
    MemberService memberService;

    @BeforeEach // test 실행 전 무조건 실행하도록 함
    public void beforeEach(){
        AppConfig appConfig=new AppConfig();
        memberService=appConfig.memberService();
    }

    //MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member); // 회원 추가
        Member findMember = memberService.findMember(1L); //해당 회원 조회
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
