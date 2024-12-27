package com.example.repository;

import com.example.model.Member;
import com.example.model.QMember;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.transaction.annotation.Transactional;


public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

//    private final EntityPath<Member> member = QMember.member;

    QMember member = QMember.member;

    public MemberRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }


    public Member findByMember(String id) {
        return jpaQueryFactory.
                selectFrom(member)
                .where(member.id.eq(id))
                //
                .fetchOne();
    }


    public String InsertMember(Member member1) {
        jpaQueryFactory
                .insert(member)
                .columns(member.id, member.password, member.email, member.name, member.address, member.membership, member.status)
                .values(member1.getId(), member1.getPassword(), member1.getEmail(), member1.getName(), member1.getAddress(), member1.getMembership(), member1.getStatus())
                .execute();

//            INSERT INTO member(id, password, email, name ,address, membership, status) VALUES (id, password, email, name ,address, membership, status);

        String abc = "y";

        return abc;
        //insert into member values()
    }

    @Transactional
    public String UpdateUser(String OldPassword, String NewPassword) {
        try {
            jpaQueryFactory
                    .update(member)
                    .set(member.password, NewPassword)
                    .where(member.password.eq(OldPassword))
                    .execute();
        } catch (Exception e){
            return "쿼리실행중 에러가 발생했습니다" ;  // 예외 메시지 출력
        }
        return "정상적으로 수정되었습니다.";
    }































///delete from member where id = 'aosaos';
@Transactional
    public String DeleteUser(String id){
        try {
            jpaQueryFactory
                    .delete(member)
                    .where(member.id.eq(id))
                    .execute();
        } catch (Exception e) {
            return "에러가 발생했습니다 에러코드 : " + e.getMessage();
        }
       return "성공적으로 삭제되었습니다.";

    }


}


