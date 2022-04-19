package LotteTicket;

import java.util.Scanner;

public class InputData { // 입력부
	
	TicketSystem system = new TicketSystem();
	
	int orderTicketClass() { // 이용권 종류 입력
		OrderData orderItem = new OrderData();
		int errorIndex = 0;
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("이용권 종류를 선택하세요 : ");
			System.out.println("1. 종합이용권 (롯데월드 + 민속박물관)");
			System.out.println("2. 파크이용권 (롯데월드)");
			Scanner scan = new Scanner(System.in);
			orderItem.setTicketClass(scan.nextInt());

			if (orderItem.getTicketClass() > 2 || orderItem.getTicketClass() < 1) {
				system.errorMessagePrint();
				errorIndex = 0;
			}
		}

		return orderItem.getTicketClass();

	}

	int orderTicketType() { // 권종 종류 입력
		OrderData orderItem = new OrderData();
		int errorIndex = 0;
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("권종을 선택하세요 : ");
			System.out.println("1. 1Day");
			System.out.println("2. After4 (오후 4시부터 입장)");
			Scanner scan = new Scanner(System.in);
			orderItem.setTicketType(scan.nextInt());
			if (orderItem.getTicketType() > 2 || orderItem.getTicketType() < 1) {
				system.errorMessagePrint();
				errorIndex = 0;
			}
		}
		return orderItem.getTicketType();

	}

	String orderCitizenNum() { // 주민번호 입력
		int returnIndex = 0;
		Scanner scan = new Scanner(System.in);
		OrderData orderItem = new OrderData();

		while (returnIndex == 0) {
			System.out.println("주민번호를 뒷자리 첫째자리까지 입력하세요 (ex:9304081) : ");
			orderItem.setCitizenNum(scan.nextLine());
			returnIndex++;
			int citizenMil = Integer.parseInt(orderItem.getCitizenNum().substring(6, 7));
			int citizenDay = Integer.parseInt(orderItem.getCitizenNum().substring(4, 6));
			int citizenMonth = Integer.parseInt(orderItem.getCitizenNum().substring(2, 4));
			int citizenYear = Integer.parseInt(orderItem.getCitizenNum().substring(0, 2));

			if (citizenDay < 1 || citizenDay > 31) {
				returnIndex = 0;
				system.errorMessagePrint();
			}
			if (citizenMonth < 1 || citizenMonth > 12) {
				returnIndex = 0;
				system.errorMessagePrint();
			}
		}
		return orderItem.getCitizenNum();
	}

	int orderTicketCount(int ticketCount) { // 티켓 장수 입력

		Scanner scan = new Scanner(System.in);
		OrderData orderItem = new OrderData();
		int errorIndex = 0;
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("몇개를 주문하시겠습니까?(최대 10개)");
			orderItem.setTicketCount(scan.nextInt());
			if (orderItem.getTicketCount() > 10 || orderItem.getTicketCount() < 1) {
				system.errorMessagePrint();
				errorIndex = 0;
			}
		}
		return orderItem.getTicketCount();

	}

	int orderPreferClass(int preferClass) { // 우대사항 입력

		Scanner scan = new Scanner(System.in);
		OrderData orderItem = new OrderData();
		while (orderItem.getPreferClass() < 1 || orderItem.getPreferClass() > 6) {
			System.out.println("우대사항을 선택하세요.");
			System.out.println("1. 없음 (나이 우대는 자동처리)");
			System.out.println("2. 장애인 우대"); // 동반1인
			System.out.println("3. 국가유공자 우대"); // 동반1인
			System.out.println("4. 휴가장병 우대"); // 동반1인
			System.out.println("5. 임산부 우대");
			System.out.println("6. 다둥이 행복카드 우대");
			orderItem.setPreferClass(scan.nextInt());
			if (orderItem.getPreferClass() < 1 || orderItem.getPreferClass() > 6) {
				system.errorMessagePrint();
			}
		}
		return orderItem.getPreferClass();
	}

	
}
