package com.etech.tanzu;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.etech.tanzu.repository.JpaMemberRepository;
import com.etech.tanzu.repository.MemberRepository;
import com.etech.tanzu.repository.MemoryMemberRepository;
import com.etech.tanzu.service.MemberService;

@Configuration
public class SpringConfig {

    // private EntityManager em;

    // @Autowired
    // public SpringConfig(EntityManager em){
    //     this.em = em;
    // }
    
    // @Bean
    // public MemberService memberService() {
    //     return new MemberService(memberRepository());
    // }

    // @Bean
    // public MemberRepository memberRepository() {
    //     // return new MemoryMemberRepository();
    //     return new JpaMemberRepository(em);
    // }


    // springdatajpa용
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}
