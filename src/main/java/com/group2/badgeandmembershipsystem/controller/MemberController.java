package com.group2.badgeandmembershipsystem.controller;


import com.group2.badgeandmembershipsystem.domain.Email;
import com.group2.badgeandmembershipsystem.dto.*;
import com.group2.badgeandmembershipsystem.exception.payload.ApiResponse;
import com.group2.badgeandmembershipsystem.service.EmailService;
import com.group2.badgeandmembershipsystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

//    @Autowired
//    private EmailService emailService;

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getMembers(){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.getAllMembers());
    }
    @PostMapping
    public ResponseEntity<MemberDTO> addNewMember(@RequestBody RegistrationDTO member) throws MessagingException {
//        String toAddress = member.getEmailAddress();
//        String subject = "Membership Added";
//        String body = "Dear " + member.getFirstName() + ",\n\n" +
//                "Your membership has been successfully added to our system. Thank you for choosing our university!\n\n" +
//                "Sincerely,\n" +
//                "The University Team";
//        Email email = new Email(toAddress, subject, body);
//        emailService.sendEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(memberService.createNewMember(member));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable long id, @RequestBody UpdateMemberDTO memberDTO){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.updateMember(id,memberDTO));
    }
    @PatchMapping("/{id}/password")
    public ResponseEntity<ApiResponse> changePassword(@PathVariable long id, @RequestBody PasswordDTO passwordDTO){
        memberService.changePassword(id,passwordDTO);
        ApiResponse response = ApiResponse.builder().message("Password changed successfully").success(true).status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getMember(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.getMember(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteMember(@PathVariable long id){
        memberService.deleteMember(id);
        ApiResponse response = ApiResponse.builder().message("Member is deleted successfully").success(true).status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{memberId}/transactions")
    public ResponseEntity<List<TransactionDTO>> findTransactionsByMemberId(@PathVariable Long memberId){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findTransactionsByMemberId(memberId));
    }
    @GetMapping("/{memberId}/plans")
    public ResponseEntity<List<PlanDTO>> findPlansByMemberId(@PathVariable Long memberId){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findPlansByMemberId(memberId));
    }
    @GetMapping("/{memberId}/badges")
    public ResponseEntity<List<BadgeDTO>> findBadgesByMemberId(@PathVariable Long memberId){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findBadgesByMemberId(memberId));
    }
    @GetMapping("/{memberId}/memberships")
    public ResponseEntity<List<MembershipDTO>> findMembershipsByMemberId(@PathVariable Long memberId){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findMembershipsByMemberId(memberId));
    }
}
