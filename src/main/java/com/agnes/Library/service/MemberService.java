package com.agnes.Library.service;

import com.agnes.Library.model.Member;
import com.agnes.Library.repository.MemberRepository;

public class MemberService {

    private MemberRepository memberRepository;


    public void addMemberToDB(Member member) {
        memberRepository.save(member);
    }
    public void deleteMemberFromDB(Member member) {
        memberRepository.delete(member);
    }
    public Member getMemberById(int id) {
        return memberRepository.findById(id).orElseGet(() -> null);
    }
}

