package service.member;

import java.util.Scanner;

public interface MemberService {
    void insertMember(Scanner scanner);
    void editMemberRecord();
    void viewMemberRecord();
    void deleteMemberRecord();
}
