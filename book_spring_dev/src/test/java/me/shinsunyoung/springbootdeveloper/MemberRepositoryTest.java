package me.shinsunyoung.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Sql("/insert-member.sql")
    @Test
    void getAllMembers(){
        List<Member> members = memberRepository.findAll();

        org.assertj.core.api.Assertions.assertThat(members.size()).isEqualTo(6);
    }
    
    @Sql("/insert-member.sql")
    @Test
    void getMemberByName(){
        Member member = memberRepository.findByName("C").get();

        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo("C");
    }

    @Sql("/insert-member.sql")
    @Test
    void update(){
        Member member = memberRepository.findByName("C").get();

        member.changeName("BC");

        org.assertj.core.api.Assertions.assertThat(memberRepository.findById(30L).get().getName()).isEqualTo("BC");
    }

    @AfterEach
    public void cleanUp(){
        memberRepository.deleteAll();
    }

}