package LotteTicket;

import java.io.IOException;
import java.util.Scanner;

public class InputData { // 입력부
	
	int errorIndex;
	int ticketClass;
	int ticketType;
	String citizenNum;
	int ticketCount;
	int preferClass;
	int citizenMil;
	int citizenDay;
	int citizenMonth;
	int citizenYear;
	
	public InputData() {
		errorIndex = 0;
		ticketClass = 0;
		ticketType = 0;
		citizenNum = "";
		ticketCount = 0;
		preferClass = 0;
		citizenMil = 0;
		citizenDay = 0;
		citizenMonth = 0;
		citizenYear = 0;
	}
	
		
	int orderTicketClass() throws IOException { // 이용권 종류 입력
		
		ErrorProcess error = new ErrorProcess();
		Scanner scan = new Scanner(System.in);
		Print print = new Print();
		
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("이용권 종류를 선택하세요 : ");
			System.out.println("1. 종합이용권 (롯데월드 + 민속박물관)");
			System.out.println("2. 파크이용권 (롯데월드)");
			
			ticketClass = scan.nextInt();

			if (ticketClass > 2 || ticketClass < 1) {
				if(ticketClass == 33) {
					errorIndex = 1;
				} else if (ticketClass == 0) {
					print.printCsv();// lotteReport.csv 파일의 상황을 출력하기 위한 메소드로 이동
				} else {
					error.errorMessagePrint();
					errorIndex = 0;
				}
			}
		}

		return ticketClass;
	}

	int orderTicketType() { // 권종 종류 입력
	
		ErrorProcess error = new ErrorProcess();
		Scanner scan = new Scanner(System.in);
		
		do {
			errorIndex = 1;
			System.out.println("권종을 선택하세요 : ");
			System.out.println("1. 1Day");
			System.out.println("2. After4 (오후 4시부터 입장)");
			
			ticketType = scan.nextInt();
			if (ticketType > 2 || ticketType < 1) {
				error.errorMessagePrint();
				errorIndex = 0;
			}
		} while (errorIndex == 0);
		
		return ticketType;

	}

	String orderCitizenNum() { // 주민번호 입력
		
		Scanner scan = new Scanner(System.in);
		ErrorProcess error = new ErrorProcess();
		OrderData order = new OrderData();
		
		
		do { 
			errorIndex = 1;
			System.out.println("주민번호를 뒷자리 첫째자리까지 입력하세요 (ex:9304081) : ");
			citizenNum = scan.nextLine();
			
			if(citizenNum.length() != 7) { // 주민번호가 7자리입력이 안되었을 경우 에러 출력
				errorIndex = 0;
				error.errorMessagePrint();
			}
			
				
			if(errorIndex == 1) {
				citizenMil = Integer.parseInt(citizenNum.substring(6, 7));
				citizenDay = Integer.parseInt(citizenNum.substring(4, 6));
				citizenMonth = Integer.parseInt(citizenNum.substring(2, 4));
				citizenYear = Integer.parseInt(citizenNum.substring(0, 2));
			
				if (citizenDay < 1 || citizenDay > 31) { // 일자가 1~31일이 아닐경우 에러 출력
					errorIndex = 0;
					error.errorMessagePrint();
				}
				if (citizenMonth < 1 || citizenMonth > 12) { // 월이 1~12월이 아닐경우 에러 출력
					errorIndex = 0;
					error.errorMessagePrint();
				}
				
				if (citizenYear < 2000 && citizenMil >=3) { // 1900년대생인데 뒷자리첫째자리가 3이상일 때 에러 출력
					errorIndex = 0;
					error.errorMessagePrint();
				}
				
				if (citizenYear >= 2000 && citizenMil < 3) { // 2000년대생인데 뒷자리 첫째자리가 3미만일 때 에러 출력
					errorIndex = 0;
					error.errorMessagePrint();
				}

			}
		} while (errorIndex == 0);
		 
		return citizenNum;
	}

	int orderTicketCount() { // 티켓 장수 입력

		Scanner scan = new Scanner(System.in);
		ErrorProcess error = new ErrorProcess();
	
		do {
			errorIndex = 1;
			System.out.println("몇개를 주문하시겠습니까?(최대 10개)");
			ticketCount = scan.nextInt();
			if (ticketCount > 10 || ticketCount < 1) {
				error.errorMessagePrint();
				errorIndex = 0;
			}
		} while (errorIndex == 0);
		
		return ticketCount;

	}

	int orderPreferClass() { // 우대사항 입력

		Scanner scan = new Scanner(System.in);
		ErrorProcess error = new ErrorProcess();
		
		
		do {
			System.out.println("우대사항을 선택하세요.");
			System.out.println("1. 없음 (나이 우대는 자동처리)");
			System.out.println("2. 장애인 우대"); // 동반1인
			System.out.println("3. 국가유공자 우대"); // 동반1인
			System.out.println("4. 휴가장병 우대"); // 동반1인
			System.out.println("5. 임산부 우대");
			System.out.println("6. 다둥이 행복카드 우대");
			preferClass = scan.nextInt();
			if (preferClass < 1 || preferClass > 6) {
				error.errorMessagePrint();
			}
		} while (preferClass < 1 || preferClass > 6);
		
		return preferClass;
	}

	
}
