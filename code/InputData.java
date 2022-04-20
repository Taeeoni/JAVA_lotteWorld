package LotteTicket;

import java.util.Scanner;

public class InputData { // 입력부
	
	TicketSystem system = new TicketSystem();
	
	int orderTicketClass() { // 이용권 종류 입력
		
		ErrorProcess error = new ErrorProcess();
		Scanner scan = new Scanner(System.in);
		
		int errorIndex = 0;
		int TicketClass = 0;
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("이용권 종류를 선택하세요 : ");
			System.out.println("1. 종합이용권 (롯데월드 + 민속박물관)");
			System.out.println("2. 파크이용권 (롯데월드)");
			
			TicketClass = scan.nextInt();

			if (TicketClass > 2 || TicketClass < 1) {
				error.errorMessagePrint();
				errorIndex = 0;
			}
		}

		return TicketClass;
	}

	int orderTicketType() { // 권종 종류 입력
	
		ErrorProcess error = new ErrorProcess();
		Scanner scan = new Scanner(System.in);
		int errorIndex = 0;
		int TicketType = 0;
		
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("권종을 선택하세요 : ");
			System.out.println("1. 1Day");
			System.out.println("2. After4 (오후 4시부터 입장)");
			
			TicketType = scan.nextInt();
			if (TicketType > 2 || TicketType < 1) {
				error.errorMessagePrint();
				errorIndex = 0;
			}
		}
		return TicketType;

	}

	String orderCitizenNum() { // 주민번호 입력
		
		int returnIndex = 0;
		Scanner scan = new Scanner(System.in);
		ErrorProcess error = new ErrorProcess();
		String citizenNum = "";
		
		while (returnIndex == 0) {
			System.out.println("주민번호를 뒷자리 첫째자리까지 입력하세요 (ex:9304081) : ");
			citizenNum = scan.nextLine();
			returnIndex++;
			int citizenMil = Integer.parseInt(citizenNum.substring(6, 7));
			int citizenDay = Integer.parseInt(citizenNum.substring(4, 6));
			int citizenMonth = Integer.parseInt(citizenNum.substring(2, 4));
			int citizenYear = Integer.parseInt(citizenNum.substring(0, 2));

			if (citizenDay < 1 || citizenDay > 31) {
				returnIndex = 0;
				error.errorMessagePrint();
			}
			if (citizenMonth < 1 || citizenMonth > 12) {
				returnIndex = 0;
				error.errorMessagePrint();
			}
		}
		return citizenNum;
	}

	int orderTicketCount() { // 티켓 장수 입력

		Scanner scan = new Scanner(System.in);
		ErrorProcess error = new ErrorProcess();
		int errorIndex = 0;
		int ticketCount = 0;
		
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("몇개를 주문하시겠습니까?(최대 10개)");
			ticketCount = scan.nextInt();
			if (ticketCount > 10 || ticketCount < 1) {
				error.errorMessagePrint();
				errorIndex = 0;
			}
		}
		return ticketCount;

	}

	int orderPreferClass() { // 우대사항 입력

		Scanner scan = new Scanner(System.in);
		ErrorProcess error = new ErrorProcess();
		int preferClass = 0;
		
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
