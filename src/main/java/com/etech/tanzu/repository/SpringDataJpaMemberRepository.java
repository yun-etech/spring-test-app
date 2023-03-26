package com.etech.tanzu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etech.tanzu.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);    
}
