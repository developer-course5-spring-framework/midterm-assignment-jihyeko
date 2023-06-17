package com.ohgiraffers.midtermassignmentjihyeko.model.dao;

import com.ohgiraffers.midtermassignmentjihyeko.model.dto.MemberDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component //Bean등록 Annotation
public class MemberDAO {
    private final Map<Integer, MemberDTO> memberMap;

    public MemberDAO() {
        memberMap = new HashMap<>();

        memberMap.put(1, new MemberDTO(1, "고지혜", "user01", "pass01"));
        memberMap.put(2, new MemberDTO(2, "임돌돌", "user02", "pass02"));

    }

    public MemberDTO getMemberBySequence(int sequence) {
        if(memberMap.get(sequence) != null){
            return memberMap.get(sequence);
        }
        return null;
    }
}
