package hello.core1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class MemberServiceImpl implements MemberService{

    //MemberRepository와 연결 필요. 이때 구현 객체(MemoryMemberRepository)도 선택해야 한다.
    private final MemberRepository memberRepository;
    public String getMemberRepository;



    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }



}
