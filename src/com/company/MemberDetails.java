package com.company;

public class MemberDetails {

    private int memberId;
    private String memberName;

    public MemberDetails(int memberId, String memberName){
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public int getmemberId() {
        return memberId;
    }

    public void setmemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}