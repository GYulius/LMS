package service.member;

import java.util.Scanner;

public interface MemberService {
    void insertMember(Scanner scanner);
    void editMemberRecord(Scanner scanner);
    void viewMemberRecord(Scanner scanner);
    void deleteMemberRecord(Scanner scanner);
}
