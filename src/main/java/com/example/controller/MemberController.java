package com.example.controller;


import com.example.model.Member;
import com.example.model.MemberDto;
import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;



//select = param, insert,update,delete =
@GetMapping("/selectuser")
public List<MemberDto> selectuserinformation(@RequestParam String id){
    return memberService.selectuserinformation(id);
}
}