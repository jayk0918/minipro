package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhonebookApp {

	public static void main(String[] args) throws IOException {
		
		List<Person>pList = new ArrayList<Person>();
		
		Reader fr = new FileReader("./phoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = br.readLine();
			if(str == null) {
				break;
			}
			
			String[]personInfo = str.split(",");
			String name = personInfo[0];
			String hp = personInfo[1];
			String company = personInfo[2];
			
			Person person = new Person(name, hp, company);
			pList.add(person);
		}
		
		System.out.println("******************************");
		System.out.println("*      전화번호 관리 프로그램      *");
		System.out.println("******************************");
		
		while(true) {
			System.out.println("");
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("-----------------------------");
			System.out.print(">메뉴번호:");
			int choice = sc.nextInt();
			
			if(choice == 5) {
				System.out.println("***************");
				System.out.println("*   감사합니다   *");
				System.out.println("***************");
				break;
				
			}else {
				for(int i=0; i<pList.size(); i++) {
					pList.get(i).setIndex(i+1);
				}
				
				switch(choice) {
					case 1:
						System.out.println("<1.리스트>");
						for(int i=0; i<pList.size(); i++) {
							pList.get(i).indexInfo();
						}
						break;
						
					case 2:
						System.out.println("<2.등록>");
						sc.nextLine();	// 입력에러방지
						System.out.print(">이름:");
						String newName = sc.nextLine();
						
						System.out.print(">휴대전화:");
						String newHp = sc.nextLine();
						
						System.out.print(">회사전화:");
						String newCompany = sc.nextLine();
						
						Person newMember = new Person(newName, newHp, newCompany);
						pList.add(newMember);
						
						Writer fw = new FileWriter("./phoneDB.txt");
						BufferedWriter bw = new BufferedWriter(fw);
						
						for(Person newList : pList) {
							String saveStr = newList.getName()+ "," + newList.getHp()+ "," + newList.getCompany();
							bw.write(saveStr);
							bw.newLine();
						}
						bw.close();
						System.out.println("[등록되었습니다.]");
						break;
						
					case 3:
						System.out.println("<3.삭제>");
						System.out.print(">번호 : ");
						int delete = sc.nextInt();
						pList.remove((delete) - 1);
						
						Writer fw2 = new FileWriter("./phoneDB.txt");
						BufferedWriter bw2 = new BufferedWriter(fw2);
						
						for(Person newList : pList) {
							String saveStr = newList.getName()+ "," + newList.getHp()+ "," + newList.getCompany();
							bw2.write(saveStr);
							bw2.newLine();
						}
						bw2.close();
						System.out.println("[삭제되었습니다.]");
						break;
						
					case 4:
						System.out.println("<4.검색>");
						System.out.print(">이름: ");
						sc.nextLine(); // 입력에러방지
						String search = sc.nextLine();
						
						for(Person searchName : pList) {
							if(searchName.getName().contains(search)) {
								searchName.indexInfo();
							}
						}
						break;
						
					default:
						System.out.println("[다시 입력해 주세요.]");
						break;
				} //switch-case end
			}//else end
		}// while 2 end
		
		br.close();
		sc.close();
	}

}
