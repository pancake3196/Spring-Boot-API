package com.example.repository;

import com.example.model.Member;
import com.example.model.QMember;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

//    private final EntityPath<Member> member = QMember.member;

    QMember member = QMember.member;


    @Override
    public Member findByMember(String id){
        return jpaQueryFactory.
                selectFrom(member)
                .where(member.id.eq(id))
                //
                .fetchOne();
    }
    @Override
    public Member InsertMember(member){
        return jpaQueryFactory
                .insert into
                //insert into member values()
    }
}

