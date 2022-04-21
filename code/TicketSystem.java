package LotteTicket;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TicketSystem {
	
	//필드변수 선언
	int exitIndex;
	int position;
	int companionPrint;
	boolean indexTitlePrint;
	int manAge;
	int companionIndex;

	
	public TicketSystem() { // 기본 생성자 , 인스턴스를 초기화
		
		exitIndex = 0; // 프로그램 종료 index
		position = 0; // inputList 행 추가시 사용
		companionPrint = 0; // 동반할인 프린트 여부 index
		indexTitlePrint = true; // csv 파일 기록저장시 제목부분 write index
		manAge = 0; // 만나이 
		companionIndex = 0; // 동행할인 index
		
	} 

	void main() throws IOException {
		
		do {

			ArrayList<OrderData> orderList = new ArrayList<OrderData>(); // arraylist reset
			Print print = new Print(); 
			position = 0;
			
			while (exitIndex != 2 && exitIndex != 1) { // exitIndex 0은 새로운사람 발권 , 1은 시스템종료, 2는 계속발권 

				logic(position, orderList);
				// 고객정보 저장
				
				if(indexTitlePrint == true) { // 시스템 처음 시작했다는 index
					print.printTitle(); // csv파일 항목들(맨윗줄) 작성 메쏘드
					indexTitlePrint = false;
				}
				
				exitIndex = print.continuePrint(position, orderList); // 고객이 입력한 정보 print 
				position++; // 배열위치 변경
				System.out.println("\n");

			}
			
			if(exitIndex != 1) {
				exitIndex = 0; // 0으로 바꿔주어야 다시 while 안으로 들어간다.
			}
			
		} while (exitIndex != 1);

	}
	
	void logic(int position, ArrayList<OrderData> orderList) {
		


		OrderData orderItem = new OrderData();
		InputData input = new InputData(); // 입력부
		InputCalculate cal = new InputCalculate(); // 처리부
		Print print = new Print(); // 출력부

		orderItem.setTicketClass(input.orderTicketClass()); // 이용권
		orderItem.setTicketType(input.orderTicketType()); // 권종
		orderItem.setCitizenNum(input.orderCitizenNum()); // 주민번호
		manAge = cal.calcAge(orderItem.getCitizenNum()); // 주민번호 -> 만나이
		orderItem.setAgeGroup(cal.calcAgeGroup(manAge)); // 만나이 -> 나이그룹
		
		orderItem.setPrice(cal.calcPriceProcess(orderItem.getAgeGroup(), orderItem.getTicketClass(), orderItem.getTicketType()));
		orderItem.setTicketCount(input.orderTicketCount()); // 3
		orderItem.setPrice(cal.calcTicketCount(orderItem.getTicketCount(), orderItem.getPrice())); // 4
		orderItem.setPreferClass(input.orderPreferClass()); // 5
		
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
			
		}
		
		if (companionPrint == 1) {
			orderItem.setPreferClass(7); // 동반할인으로 변경
			companionPrint = 0;
		}
		
		savedInforms(orderItem, orderList); // 배열 저장
	}
	
	
	void savedInforms(OrderData orderItem, ArrayList<OrderData> orderList) {

		orderList.add(orderItem); // orderItem 의 내용들을 orderList에 저장 
	}

	

}
