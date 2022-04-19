package LotteTicket;

import java.util.ArrayList;
import java.util.Scanner;

public class Print { // 출력부
	int entrancePrint(int position, int companionPrint, ArrayList<OrderData> orderList) {

		OrderData orderItem = new OrderData();
		ConvertOutput convert = new ConvertOutput();
		int totalPrice = 0;
		System.out.println("티켓 발권을 종료합니다. 감사합니다.");
		System.out.println("---------------------롯데월드-----------------------------");

		for (int column = 0; column <= position; column++) {

			String ticketClass = convert.convertTicketClass(orderList.get(column).ticketClass);
			String ticketType = convert.convertTicketType(orderList.get(column).ticketType);
			String ageGroup = convert.convertAgeGroup(orderList.get(column).ageGroup);
			String preferClass = convert.convertPreferClass(orderList.get(column).preferClass);
			// ticketClass ticketType ageGroup ticketCount price preferClass
			System.out.println(ticketClass + "\t" + ticketType + "\t" + ageGroup + "\t"
					+ orderList.get(column).ticketCount + "장\t" + orderList.get(column).price + "원\t*" + preferClass);

		}

		return 2;
	}

	int continuePrint(int position, int companionPrint, ArrayList<OrderData> orderList) {
		
		System.out.println("계속 발권 하시겠습니까?");
		System.out.println("1. 티켓 발권");
		System.out.println("2. 종료");
		Scanner scan = new Scanner(System.in);
		int continueSelect = scan.nextInt();

		if (continueSelect == 1) {
			return 0;
		} else if (continueSelect == 2) {
			int reset;
			reset = entrancePrint(position, companionPrint, orderList);
			return reset;
		} else if (continueSelect == 33) { // 숨겨진 번호 33을 누르면 시스템 종료
			return 1;
		}
		return 0;
	}

	void companionPossible() {
		System.out.println("동반할인을 받을 수 있습니다.\n");
	}

	
}
