package com.example.repository;

import com.example.model.Member;


//코드가 어떤 원리로 리포지터리 구현체 이동이 되는지
//implements로 인해
public interface MemberRepositoryCustom {


    Member findByMember(String id);

    String InsertMember(Member member1);

    String UpdateUser(String OldPassword, String NewPassword);

    String DeleteUser(String id);

}





