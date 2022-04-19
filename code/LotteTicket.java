package LotteTicket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//여러가지 클래스로 쪼개기
// 1. 상수를 클래스로 만든다. -> StaticValue
// 2. 자주 이용하는 static 함수를 찾고 만든다. (ex. 식 계산해주는 것들 ) , 여기선 없다.
// 3. 데이터를 저장할 클래스를 만든다.

public class LotteTicket {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	Date today = new Date();
	int nowTime = Integer.parseInt(format.format(today));
	int companionIndex = 0;
	OrderData orderItem; 
	ArrayList<OrderData> orderList;
	

	// 오류처리
	void errorMessagePrint() {

	}

	// 입력부
	int orderTicketClass() {
		
		OrderData orderItem = new OrderData(); 
		System.out.println("이용권 종류를 선택하세요 : ");
		System.out.println("1. 종합이용권 (롯데월드 + 민속박물관)");
		System.out.println("2. 파크이용권 (롯데월드)");
		Scanner scan = new Scanner(System.in);
		orderItem.ticketClass = scan.nextInt();
		return orderItem.ticketClass;
	}

	int orderTicketType() {
		
		OrderData orderItem = new OrderData(); 
		System.out.println("권종을 선택하세요 : ");
		System.out.println("1. 1Day");
		System.out.println("2. After4 (오후 4시부터 입장)");
		Scanner scan = new Scanner(System.in);
		orderItem.ticketType = scan.nextInt();
		return orderItem.ticketType;
		
	}

	String orderCitizenNum() {
		int returnIndex = 0;
		Scanner scan = new Scanner(System.in);
		OrderData orderItem = new OrderData(); 

		while (returnIndex == 0) {
			System.out.println("주민번호를 뒷자리 첫째자리까지 입력하세요 (ex:9304081) : ");
			orderItem.citizenNum = scan.nextLine();
			returnIndex++;
			int citizenMil = Integer.parseInt(orderItem.citizenNum.substring(6, 7));
			int citizenDay = Integer.parseInt(orderItem.citizenNum.substring(4, 6));
			int citizenMonth = Integer.parseInt(orderItem.citizenNum.substring(2, 4));
			int citizenYear = Integer.parseInt(orderItem.citizenNum.substring(0, 2));

			if (citizenDay < 1 || citizenDay > 31) {
				returnIndex = 0;
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
			if (citizenMonth < 1 || citizenMonth > 12) {
				returnIndex = 0;
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
		}
		return orderItem.citizenNum;
	}

	int orderTicketCount(int ticketCount) {
		
		Scanner scan = new Scanner(System.in);
		OrderData orderItem = new OrderData(); 
		System.out.println("몇개를 주문하시겠습니까?(최대 10개)");
		orderItem.ticketCount = scan.nextInt();
		return orderItem.ticketCount;
		
	}

	int orderPreferClass(int preferClass) {
		
		Scanner scan = new Scanner(System.in);
		OrderData orderItem = new OrderData(); 
		while (orderItem.preferClass < 1 || orderItem.preferClass > 6) {
			System.out.println("우대사항을 선택하세요.");
			System.out.println("1. 없음 (나이 우대는 자동처리)");
			System.out.println("2. 장애인 우대"); // 동반1인
			System.out.println("3. 국가유공자 우대"); // 동반1인
			System.out.println("4. 휴가장병 우대"); // 동반1인
			System.out.println("5. 임산부 우대");
			System.out.println("6. 다둥이 행복카드 우대");
			orderItem.preferClass = scan.nextInt();
		}
		return orderItem.preferClass;
	}

	// 처리부
	int calcAge(String citizenNum) {
		OrderData orderItem = new OrderData(); // 9304081
		int gender = Integer.parseInt(citizenNum.substring(6, 7)); // 주민번호 뒷자리 1, 2, 3, 4
		int birthDay = Integer.parseInt(citizenNum) / 10;
		if (gender >= 3) {
			birthDay += StaticValue.NEW_GENERATION; // + 2000.00.00
		} else {
			birthDay += StaticValue.OLD_GENERATION; // + 1900.00.00
		}
		int age = (nowTime - birthDay) / 10000;
		return age;

	}

	int calcAgeGroup(int manAge) {
		int ageGroup = 0;
		if (manAge < StaticValue.MIN_BABY) {
			ageGroup = 0; // 영유아
		} else if (manAge >= StaticValue.MIN_BABY && manAge < StaticValue.MIN_KID) {
			ageGroup = 1; // 유아
		} else if (manAge >= StaticValue.MIN_KID && manAge <= StaticValue.MIN_TEEN) {
			ageGroup = 2; // 어린이
		} else if (manAge > StaticValue.MIN_TEEN && manAge <= StaticValue.MIN_ADULT) {
			ageGroup = 3; // 청소년
		} else if (manAge > StaticValue.MIN_ADULT && manAge < StaticValue.MIN_OLD) {
			ageGroup = 4; // 어른
		} else if (manAge >= StaticValue.MIN_OLD) {
			ageGroup = 5;// 노인
		} else {
			System.out.println("Error");
		}
		return ageGroup;
	}

	int calcPriceProcess(int ageGroup, int ticketClass, int ticketType) {
		if (ticketClass == 1) { // ALL
			if (ticketType == 1) { // 1D
				if (ageGroup == 4) {
					return StaticValue.ALL_1D_ADULT;
				} else if (ageGroup == 3) {
					return StaticValue.ALL_1D_TEEN;
				} else if (ageGroup == 2 || ageGroup == 5) {
					return StaticValue.ALL_1D_KID;
				} else if (ageGroup == 1) {
					return StaticValue.ALL_1D_BABY;
				} else if (ageGroup == 0) {
					return 0;
				} else {
					System.out.println("Error");
				}
			} else if (ticketType == 2) { // A4
				if (ageGroup == 4) {
					return StaticValue.ALL_A4_ADULT;
				} else if (ageGroup == 3) {
					return StaticValue.ALL_A4_TEEN;
				} else if (ageGroup == 2 || ageGroup == 5) {
					return StaticValue.ALL_A4_KID;
				} else if (ageGroup == 1) {
					return StaticValue.ALL_A4_BABY;
				} else if (ageGroup == 0) {
					return 0;
				} else {
					System.out.println("Error");
				}
			} else {
				System.out.println("Error");
			}

		} else if (ticketClass == 2) { // PARK
			if (ticketType == 1) { // 1D
				if (ageGroup == 4) {
					return StaticValue.PARK_1D_ADULT;
				} else if (ageGroup == 3) {
					return StaticValue.PARK_1D_TEEN;
				} else if (ageGroup == 2 || ageGroup == 5) {
					return StaticValue.PARK_1D_KID;
				} else if (ageGroup == 1) {
					return StaticValue.PARK_1D_BABY;
				} else if (ageGroup == 0) {
					return 0;
				} else {
					System.out.println("Error");
				}
			} else if (ticketType == 2) { // A4
				if (ageGroup == 4) {
					return StaticValue.PARK_A4_ADULT;
				} else if (ageGroup == 3) {
					return StaticValue.PARK_A4_TEEN;
				} else if (ageGroup == 2 || ageGroup == 5) {
					return StaticValue.PARK_A4_KID;
				} else if (ageGroup == 1) {
					return StaticValue.PARK_A4_BABY;
				} else if (ageGroup == 0) {
					return 0;
				} else {
					System.out.println("Error");
				}
			} else {
				System.out.println("Error");
			}
		}
		return 0;
	}

	int calcTicketCount(int ticketCount, int price) {
		price *= ticketCount;
		return price;
	}

	int calcDiscount(int price, int preferClass, int ticketClass) {
		if (preferClass == 2) {
			price *= StaticValue.DISABLED;
		} else if (preferClass == 3) {
			price *= StaticValue.NATIONAL_MERIT;
		} else if (preferClass == 4 && ticketClass == 1) {
			price *= StaticValue.SOLDIER;
		} else if (preferClass == 5 && ticketClass == 1) {
			price *= StaticValue.PREGNANT;
		} else if (preferClass == 6 && ticketClass == 1) {
			price *= StaticValue.MANY_CHILDREN;
		}
		return price;
	}

	// 배열 저장
	void savedInforms(OrderData orderItem, ArrayList<OrderData> orderList) {

		orderList.add(orderItem);
	}
	
	// ui 진행부
	void inputData(int position, int companionPrint, ArrayList<OrderData> orderList) {

		int manAge = 0;
		

		OrderData orderItem = new OrderData();

		orderItem.ticketClass = orderTicketClass(); // 0
		orderItem.ticketType = orderTicketType(); // 1
		orderItem.citizenNum = orderCitizenNum();
		manAge = calcAge(orderItem.citizenNum);
		orderItem.ageGroup = calcAgeGroup(manAge); // 2
		orderItem.price = calcPriceProcess(orderItem.ageGroup, orderItem.ticketClass, orderItem.ticketType);
		orderItem.ticketCount = orderTicketCount(0); // 3
		orderItem.price = calcTicketCount(orderItem.ticketCount, orderItem.price); // 4
		orderItem.preferClass = orderPreferClass(0); // 5
		if (orderItem.preferClass != 1) { // 만약 우대사항이 있다면 할인금액으로 변경

			orderItem.price = calcDiscount(orderItem.price, orderItem.preferClass, orderItem.ticketClass);
			companionIndex = orderItem.preferClass; // 우대사항에 대한 정보를 기록

		} else { // 우대사항이 없는경우
			if (companionIndex == 2 || companionIndex == 3 || companionIndex == 4) {
				// 동반1인도 할인이 되는 우대사항 (장애인, 국가유공자, 휴가장병)
				companionPossible(); // 동반할인이 가능하다는 안내 출력
				companionPrint = 1; // 우대사항 칸에 동반할인 출력하는 index 변경
				orderItem.price = calcDiscount(orderItem.price, companionIndex, orderItem.ticketClass); // 동반할인금액으로 변경
				companionIndex = 0; // 동반할인은 전부 1인까지만 되므로 index를 바로 0으로 바꿔주면 된다.
			}
			//
		}
		if (companionPrint == 1) {
			orderItem.preferClass = 7; // 동반할인으로 변경
			companionPrint = 0;
		}
		savedInforms(orderItem, orderList);
	}


	// int -> String 변환
	String convertTicketClass(int input) {
		String ticketClass = "";
		if (input == 1) {
			ticketClass = "종합이용권";
		} else if (input == 2) {
			ticketClass = "파크이용권";
		}
		return ticketClass;
	}

	String convertTicketType(int input) {
		String ticketType = "";
		if (input == 1) {
			ticketType = "1Day";
		} else if (input == 2) {
			ticketType = "After4";
		}
		return ticketType;
	}

	String convertAgeGroup(int input) {
		String ageGroup = "";
		if (input == 0) {
			ageGroup = "영유아";
		} else if (input == 1) {
			ageGroup = "유아";
		} else if (input == 2) {
			ageGroup = "어린이";
		} else if (input == 3) {
			ageGroup = "청소년";
		} else if (input == 4) {
			ageGroup = "어른";
		} else if (input == 5) {
			ageGroup = "노인";
		}
		return ageGroup;
	}

	String convertPreferClass(int input) {
		String preferClass = "";
		if (input == 1) {
			preferClass = "없음";
		} else if (input == 2) {
			preferClass = "장애인";
		} else if (input == 3) {
			preferClass = "국가유공자";
		} else if (input == 4) {
			preferClass = "휴가장병";
		} else if (input == 5) {
			preferClass = "임산부";
		} else if (input == 6) {
			preferClass = "다둥이";
		} else if (input == 7) {
			preferClass = "동반할인";
		}
		return preferClass;
	}

	// 출력부
	int entrancePrint(int position, int companionPrint, ArrayList<OrderData> orderList) {
		
		OrderData orderItem = new OrderData();
		int totalPrice = 0;
		System.out.println("티켓 발권을 종료합니다. 감사합니다.");
		System.out.println("---------------------롯데월드-----------------------------");
		
		System.out.println(orderList.get(position).preferClass);

		
		for (int column = 0; column <= position; column++) {

			String ticketClass = convertTicketClass(orderList.get(column).ticketClass);
			String ticketType = convertTicketType(orderList.get(column).ticketType);
			String ageGroup = convertAgeGroup(orderList.get(column).ageGroup);
			String preferClass = convertPreferClass(orderList.get(column).preferClass);
			//ticketClass ticketType ageGroup ticketCount price preferClass
			System.out.println(ticketClass + "\t" + ticketType + "\t" + ageGroup + "\t" + orderList.get(column).ticketCount + "장\t"
					+ orderList.get(column).price + "원\t*" + preferClass);
		}
		
		
		return 2;
	}

	int continuePrint(int position, int companionPrint, ArrayList<OrderData> orderList) {
		LotteTicket lt = new LotteTicket();
		System.out.println("계속 발권 하시겠습니까?");
		System.out.println("1. 티켓 발권");
		System.out.println("2. 종료");
		Scanner scan = new Scanner(System.in);
		int continueSelect = scan.nextInt();

		if (continueSelect == 1) { 
			return 0;
		} else if (continueSelect == 2) {
			int reset;
			reset = lt.entrancePrint(position, companionPrint, orderList);
			return reset;
		} else if (continueSelect == 33) { // 숨겨진 번호 33을 누르면 시스템 종료
			return 1;
		}
		return 0;
	}

	void companionPossible() {
		System.out.println("동반할인을 받을 수 있습니다.\n");
	}

	public static void main(String[] args) {
		int totalPrice = 0; // 주문 총액
		int position = 0; // inputList 행 추가시 사용
		int filePosition = 0; // 파일 출력 첫줄 구분
		int exitIndex = 0;
		int companionPrint = 0; // 동반할인 프린트 여부 index
		OrderData orderItem = new OrderData(); 
		ArrayList<OrderData> orderList = new ArrayList<OrderData>();
		
		LotteTicket lt = new LotteTicket(); // void main 애들은 바깥세상을 모른다 , 알려주어야 함

		while (true) {
			
			orderItem = new OrderData();
			
			lt.inputData(position, companionPrint, orderList);
			// 고객정보 저장
			int exitIndex1 = lt.continuePrint(position, companionPrint, orderList);
			position++; // 배열위치 변경
			if (exitIndex1 == 1) {
				break;
			} else if (exitIndex1 == 2) {
				position = 0;
			}
			System.out.println("\n");
		}
	}
}
