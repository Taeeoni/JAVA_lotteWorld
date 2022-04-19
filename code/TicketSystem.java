package LotteTicket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TicketSystem {

	Calendar cal = Calendar.getInstance();
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	Date today = new Date();
	int nowTime = Integer.parseInt(format.format(today));
	int companionIndex = 0;
	OrderData orderItem;
	ArrayList<OrderData> orderList;

	// 오류처리
	void errorMessagePrint() {
		System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
	}


	// 처리부

	// 배열 저장
	void savedInforms(OrderData orderItem, ArrayList<OrderData> orderList) {

		orderList.add(orderItem);
	}

	// process
	void inputData(int position, int companionPrint, ArrayList<OrderData> orderList) {

		int manAge = 0;

		OrderData orderItem = new OrderData();
		InputData input = new InputData(); // 입력부
		InputCalculate cal = new InputCalculate(); // 처리부
		Print print = new Print(); // 출력부

		orderItem.setTicketClass(input.orderTicketClass()); // 이용권
		orderItem.setTicketType(input.orderTicketType()); // 권종
		orderItem.setCitizenNum(input.orderCitizenNum()); // 주민번호
		manAge = cal.calcAge(orderItem.getCitizenNum(), nowTime); // 주민번호 -> 만나이
		orderItem.setAgeGroup(cal.calcAgeGroup(manAge)); // 만나이 -> 나이그룹
		
		orderItem.setPrice(cal.calcPriceProcess(orderItem.getAgeGroup(), orderItem.getTicketClass(), orderItem.getTicketType()));
		orderItem.setTicketCount(input.orderTicketCount(0)); // 3
		orderItem.setPrice(cal.calcTicketCount(orderItem.getTicketCount(), orderItem.getPrice())); // 4
		orderItem.setPreferClass(input.orderPreferClass(0)); // 5
		if (orderItem.getPreferClass() != 1) { // 만약 우대사항이 있다면 할인금액으로 변경

			orderItem.setPrice(cal.calcDiscount(orderItem.getPrice(), orderItem.getPreferClass(), orderItem.getTicketClass()));
			companionIndex = orderItem.getPreferClass(); // 우대사항에 대한 정보를 기록

		} else { // 우대사항이 없는경우
			if (companionIndex == 2 || companionIndex == 3 || companionIndex == 4) {
				// 동반1인도 할인이 되는 우대사항 (장애인, 국가유공자, 휴가장병)
				print.companionPossible(); // 동반할인이 가능하다는 안내 출력
				companionPrint = 1; // 우대사항 칸에 동반할인 출력하는 index 변경
				orderItem.setPrice(cal.calcDiscount(orderItem.getPrice(), companionIndex, orderItem.getTicketClass())); // 동반할인금액으로 변경
				companionIndex = 0; // 동반할인은 전부 1인까지만 되므로 index를 바로 0으로 바꿔주면 된다.
			}
			//
		}
		if (companionPrint == 1) {
			orderItem.setPreferClass(7); // 동반할인으로 변경
			companionPrint = 0;
		}
		savedInforms(orderItem, orderList);
	}


	void main() {
		int exitIndex = 0;
		do {

			int position = 0; // inputList 행 추가시 사용
			int companionPrint = 0; // 동반할인 프린트 여부 index
			OrderData orderItem = new OrderData();
			ArrayList<OrderData> orderList = new ArrayList<OrderData>();
			TicketSystem lt = new TicketSystem(); // void main 애들은 바깥세상을 모른다 , 알려주어야 함
			Print print = new Print();

			while (exitIndex != 2) {

				orderItem = new OrderData();
				lt.inputData(position, companionPrint, orderList);
				// 고객정보 저장
				exitIndex = print.continuePrint(position, companionPrint, orderList);
				position++; // 배열위치 변경
				System.out.println("\n");

			}

		} while (exitIndex != 1);

	}

}
