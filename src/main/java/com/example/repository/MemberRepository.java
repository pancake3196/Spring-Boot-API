package com.example.repository;



import com.example.model.Member;
import com.example.model.MemberDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, String>
{

    @Query("SELECT id, password, email, name, address, CASE when membership = 1 then '일반' when membership = 2 then '구독자' else '' end as membership,CASE when status = 1 then '정상' when status = 2 then '휴면' when status = 3 then '밴' else '' end as status FROM Member  WHERE id = :id")
    List<Object[]> selectuserinformation(@Param("id") String id);
}
