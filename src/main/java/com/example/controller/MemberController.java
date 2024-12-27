package com.example.controller;


import com.example.model.Member;
import com.example.model.MemberDto;
import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/member")
public class MemberController{

    @Autowired
    private MemberService memberService;

    //select = param, insert,update,delete =
    @GetMapping("/selectuser")
    public List<MemberDto> selectUserInformation(@RequestParam String id){
        return memberService.selectuserinformation(id);
    }


    //일단 일반적인 jpa 와 동일하니 패스
    @GetMapping("/all")
    public Member getMembers(@RequestParam String id){
        return memberService.getMembers(id);
    }
    @PostMapping("/insert")
    public String postMember(@RequestBody Member member1){
        return memberService.PostMappping(member1);
    }

    @PatchMapping("/update")
    public String UpdateUser(@RequestParam String OldPassword, String NewPassword){
        return memberService.UpdatePassword(OldPassword, NewPassword);
    }

    @DeleteMapping("/delete")
    public String DeleteUser(@RequestParam String id){
        return memberService.DeleteUser(id);
    }



//클라이언트로 받아오니까 json멤버와 동일하게


//selectuserinformation;
//
//select_user_information // snakeCase
//selectUserInformation // camelCase - method Name
//SelectUserInformation // pascalCase - Class Name, File




@PostMapping("/InsertUser")
public Member MakeUser(@RequestBody Member insert){
    return memberService.createuser(insert);
}
}















