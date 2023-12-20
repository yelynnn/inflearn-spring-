package hello.core1.order;

import hello.core1.AppConfig;
import hello.core1.member.Grade;
import hello.core1.member.Member;
import hello.core1.member.MemberService;
import hello.core1.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        //AppConfig appConfig=new AppConfig();
        //MemberService memberService=appConfig.memberService();
        //OrderService orderService= appConfig.orderService();

        //MemberService memberService=new MemberServiceImpl();
        //OrderService orderService=new OrderServiceImpl();

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService=applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService=applicationContext.getBean("orderService",OrderService.class);

        Long memberId =1L;

        Member member=new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order=OrderService.createOrder(memberId,"itemA",10000);
        System.out.println("order="+order);

    }
}
