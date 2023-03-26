package com.etech.tanzu.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.etech.tanzu.domain.Member;
import com.etech.tanzu.repository.MemberRepository;

// @Service
@Transactional
public class MemberService {
    
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */

    public Long join(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            try {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        });

        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 전체 회원 조회
     */

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
