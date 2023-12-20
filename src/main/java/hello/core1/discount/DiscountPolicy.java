package hello.core1.discount;

import hello.core1.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    // member: 할인 받을 회원, prince: 할인 금액
    int discount(Member member, int price);
}
