package com.example.service;

import com.example.model.Member;
import com.example.model.MemberDto;
import com.example.repository.MemberRepository;
import com.example.repository.MemberRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberRepositoryCustom memberRepositoryCustom;

    public List<MemberDto> selectuserinformation(String reqId){
        List<Object[]> results = memberRepository.selectuserinformation(reqId);
        List<MemberDto> memberDtos = new ArrayList<>();

        for (Object[] result : results) {

            String id = (String) result[0];
            String password = (String) result[1];
            String email = (String) result[2];
            String name = (String) result[3];
            String address = (String) result[4];
            String membership = (String) result[5];
            String status = (String) result[6];

            memberDtos.add(new MemberDto(id, password, email, name, address, membership, status));
        }

        return memberDtos;
    }

    //동일하니 패스
    public Member getMembers(String id) {
    return memberRepositoryCustom.findByMember(id);
}

    public String PostMappping(Member member1){
        return memberRepositoryCustom.InsertMember(member1);
    }
    public String UpdatePassword(String OldPassword, String NewPassword){
        return memberRepositoryCustom.UpdateUser(OldPassword, NewPassword);
//        try {
//            if(status.equals("y")){
//                return "ok";
//            }else {
//                return "500 error";
//            }
//        } catch (Exception e) {//     throw new RuntimeException(e);
//        }
    }


    public String DeleteUser(String id){
        return memberRepositoryCustom.DeleteUser(id);
    }




    public Member createuser(Member insert){
        return memberRepository.save(insert);
    }



















}