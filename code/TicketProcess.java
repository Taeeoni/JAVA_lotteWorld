package LotteTicket;

import java.util.ArrayList;

public class TicketProcess {
	
	void inputData(int position, int companionPrint, ArrayList<OrderData> orderList) {
		TicketSystem system = new TicketSystem();
		int manAge = 0;

		OrderData orderItem = new OrderData();
		InputData input = new InputData(); // 입력부
		InputCalculate cal = new InputCalculate(); // 처리부
		Print print = new Print(); // 출력부
		SaveArray save = new SaveArray(); // 배열저장

		orderItem.setTicketClass(input.orderTicketClass()); // 이용권
		orderItem.setTicketType(input.orderTicketType()); // 권종
		orderItem.setCitizenNum(input.orderCitizenNum()); // 주민번호
		manAge = cal.calcAge(orderItem.getCitizenNum(), system.nowTime); // 주민번호 -> 만나이
		orderItem.setAgeGroup(cal.calcAgeGroup(manAge)); // 만나이 -> 나이그룹
		
		orderItem.setPrice(cal.calcPriceProcess(orderItem.getAgeGroup(), orderItem.getTicketClass(), orderItem.getTicketType()));
		orderItem.setTicketCount(input.orderTicketCount(0)); // 3
		orderItem.setPrice(cal.calcTicketCount(orderItem.getTicketCount(), orderItem.getPrice())); // 4
		orderItem.setPreferClass(input.orderPreferClass(0)); // 5
		if (orderItem.getPreferClass() != 1) { // 만약 우대사항이 있다면 할인금액으로 변경

			orderItem.setPrice(cal.calcDiscount(orderItem.getPrice(), orderItem.getPreferClass(), orderItem.getTicketClass()));
			system.companionIndex = orderItem.getPreferClass(); // 우대사항에 대한 정보를 기록

		} else { // 우대사항이 없는경우
			if (system.companionIndex == 2 || system.companionIndex == 3 || system.companionIndex == 4) {
				// 동반1인도 할인이 되는 우대사항 (장애인, 국가유공자, 휴가장병)
				print.companionPossible(); // 동반할인이 가능하다는 안내 출력
				companionPrint = 1; // 우대사항 칸에 동반할인 출력하는 index 변경
				orderItem.setPrice(cal.calcDiscount(orderItem.getPrice(), system.companionIndex, orderItem.getTicketClass())); // 동반할인금액으로 변경
				system.companionIndex = 0; // 동반할인은 전부 1인까지만 되므로 index를 바로 0으로 바꿔주면 된다.
			}
			//
		}
		if (companionPrint == 1) {
			orderItem.setPreferClass(7); // 동반할인으로 변경
			companionPrint = 0;
		}
		save.savedInforms(orderItem, orderList);
	}

}
