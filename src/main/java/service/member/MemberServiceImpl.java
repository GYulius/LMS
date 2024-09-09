package service.member;

import entities.Member;
import enums.Social;
import repositories.MemberRepository;
import java.util.Scanner;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository = new MemberRepository();

    public static void displayAllSocials() {
        for (Social social : Social.values()) {
            System.out.println(social.toString());
        }
    }

    @Override
    public void insertMember(Scanner scanner) {
        System.out.println("Please provide the first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Please enter the last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Please check our social statuses list below and then pick (copy and paste) for the new member: " + "\n");
        displayAllSocials();


        Social social = null;



        while (social == null) {
            String chosenSocial = scanner.nextLine();
            try {
                social = Social.valueOf(chosenSocial);
                System.out.println(social + " chosen as social status." + "\n");

            } catch (IllegalArgumentException e) {
                System.out.println(" Invalid social status. Review our social statuses list and try again." + "\n");
            }
        }

        System.out.println("Please enter the age: ");
        int ageOf = Integer.parseInt(scanner.nextLine());

        Member addedmember = Member.builder()
                .firstName(firstName)
                .lastName(lastName)
                .social(social)
                .age(ageOf)
                .build();

        memberRepository.saveMember(addedmember);
        System.out.println("New member added successfully.");
    }

    @Override
    public void editMemberRecord(Scanner scanner) {
        System.out.println("Please provide the number of the member record you want to edit: ");

        int memberId = Integer.parseInt(scanner.nextLine());

        Member foundMember = memberRepository.findMemberById((memberId));

        if(foundMember != null) {
            System.out.println("The following record has been found:" + "\n" + foundMember.getId() + "\n" + foundMember.getFirstName() + "\n" + foundMember.getLastName() + "\n");
            System.out.println("Please provide the age: ");
            int newAge = Integer.parseInt(scanner.nextLine());

            foundMember.setAge(newAge);

            memberRepository.updateMember(foundMember);
            System.out.println("Member record updated successfully. The added age is: " + newAge);

        } else {
            System.out.println("Member not found, please provide an new Member ID.");
        }
    }

    @Override
    public void viewMemberRecord(Scanner scanner) {
        System.out.println("Please provide the number of the member record you want to view: ");

        int memberId = Integer.parseInt(scanner.nextLine());

        Member foundMember = memberRepository.findMemberById(memberId);

        if(foundMember != null) {
            System.out.println(foundMember);
        } else {
            System.out.println("Member not found, please provide an new Member ID.");
        }

    }

    @Override
    public void deleteMemberRecord(Scanner scanner) {
        System.out.println("Please provide the number of the member record you want to delete: ");

        int memberId = Integer.parseInt(scanner.nextLine());

        Member foundMember = memberRepository.findMemberById(memberId);

        if(foundMember != null) {
            System.out.println("The following record has been found:" + "\n" + foundMember.getId() + "\n" + foundMember.getFirstName() + "\n" + foundMember.getLastName() + "\n");

            memberRepository.deleteMember(foundMember.getId());

            System.out.println("Member record deleted successfully.");

        } else {
            System.out.println("Member not found, please provide an new Member ID.");
        }
    }
}
