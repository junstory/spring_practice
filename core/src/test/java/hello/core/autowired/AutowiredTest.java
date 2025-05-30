package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
//Member는 스프링 빈이 아니다.
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1= " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean1= " + noBean2);
        }

        @Autowired(required = false)
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean1= " + noBean3);
        }
    }
}
