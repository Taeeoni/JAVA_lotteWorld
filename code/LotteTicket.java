package LotteTicket;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class LotteTicket {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	Date today = new Date();
	int nowTime = Integer.parseInt(format.format(today));
	int companionIndex = 0;

	// 종합이용권 가격
	final int ALL_1D_ADULT = 62000, ALL_1D_TEEN = 54000, ALL_1D_KID = 47000, ALL_1D_BABY = 15000;
	final int ALL_A4_ADULT = 50000, ALL_A4_TEEN = 43000, ALL_A4_KID = 36000, ALL_A4_BABY = 15000;

	// 파크이용권 가격
	final int PARK_1D_ADULT = 59000, PARK_1D_TEEN = 52000, PARK_1D_KID = 46000, PARK_1D_BABY = 15000;
	final int PARK_A4_ADULT = 47000, PARK_A4_TEEN = 41000, PARK_A4_KID = 35000, PARK_A4_BABY = 15000;

	// 주민등록번호 분석
	final int PROTECT_CITIZEN_NUM = 10000000;
	final int OLD_GENERATION = 18000000, NEW_GENERATION = 19000000;

	// 나이에 따른 범위
	final int MIN_BABY = 1, MIN_KID = 3, MIN_TEEN = 12, MIN_ADULT = 18, MIN_OLD = 65;

	// 할인율
	final double DISABLED = 0.5, NATIONAL_MERIT = 0.5, SOLDIER = 0.49, PREGNANT = 0.5, MANY_CHILDREN = 0.3;

	// 오류처리
	void errorMessagePrint() {

	}

	// 입력부
	int orderTicketClass(int ticketClass) {

		while (ticketClass != 1 && ticketClass != 2) { // ticketClass 1,2가 아니라면 반복

			System.out.println("이용권 종류를 선택하세요 : ");
			System.out.println("1. 종합이용권 (롯데월드 + 민속박물관)");
			System.out.println("2. 파크이용권 (롯데월드)");
			Scanner scan = new Scanner(System.in);
			ticketClass = scan.nextInt();

		}
		return ticketClass;
	}

	int orderTicketType(int ticketType) {

		while (ticketType != 1 && ticketType != 2) { // 1, 2가 아니라면 반복

			System.out.println("권종을 선택하세요 : ");
			System.out.println("1. 1Day");
			System.out.println("2. After4 (오후 4시부터 입장)");
			Scanner scan = new Scanner(System.in);
			ticketType = scan.nextInt();

		}
		return ticketType;
	}

	int orderCitizenNum(int citizenNum) {
		int returnIndex = 0;
		Scanner scan = new Scanner(System.in);

		while (returnIndex == 0) {
			System.out.println("주민번호를 뒷자리 첫째자리까지 입력하세요 (ex:9304081) : ");
			citizenNum = scan.nextInt();
			citizenNum += PROTECT_CITIZEN_NUM; // +10000000
			returnIndex++;
			int citizenMil = citizenNum % 10;
			int citizenDay = (citizenNum / 10) % 100;
			int citizenMonth = (citizenNum / 1000) % 100;
			int citizenYear = (citizenNum / 100000) % 100;
			if (citizenDay < 1 || citizenDay > 31) {
				returnIndex = 0;
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
			if (citizenMonth < 1 || citizenMonth > 12) {
				returnIndex = 0;
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
		}
		return citizenNum;
	}

	int orderTicketCount(int ticketCount) {
		Scanner scan = new Scanner(System.in);
		System.out.println("몇개를 주문하시겠습니까?(최대 10개)");
		ticketCount = scan.nextInt();
		return ticketCount;
	}

	int orderPreferClass(int preferClass) {
		Scanner scan = new Scanner(System.in);
		while (preferClass < 1 || preferClass > 6) {
			System.out.println("우대사항을 선택하세요.");
			System.out.println("1. 없음 (나이 우대는 자동처리)");
			System.out.println("2. 장애인 우대"); // 동반1인
			System.out.println("3. 국가유공자 우대"); // 동반1인
			System.out.println("4. 휴가장병 우대"); // 동반1인
			System.out.println("5. 임산부 우대");
			System.out.println("6. 다둥이 행복카드 우대");
			preferClass = scan.nextInt();
		}
		return preferClass;
	}

	// 처리부
	int calcAge(int citizenNum) {

		int gender = citizenNum % 10; // 주민번호 뒷자리 1, 2, 3, 4
		int birthDay = citizenNum / 10;
		if (gender >= 3) {
			birthDay += NEW_GENERATION;
		} else {
			birthDay += OLD_GENERATION;
		}
		int age = (nowTime - birthDay) / 10000;
		return age;

	}

	int calcAgeGroup(int manAge) {
		int ageGroup = 0;
		if (manAge < MIN_BABY) {
			ageGroup = 0; // 영유아
		} else if (manAge >= MIN_BABY && manAge < MIN_KID) {
			ageGroup = 1; // 유아
		} else if (manAge >= MIN_KID && manAge <= MIN_TEEN) {
			ageGroup = 2; // 어린이
		} else if (manAge > MIN_TEEN && manAge <= MIN_ADULT) {
			ageGroup = 3; // 청소년
		} else if (manAge > MIN_ADULT && manAge < MIN_OLD) {
			ageGroup = 4; // 어른
		} else if (manAge >= MIN_OLD) {
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
					return ALL_1D_ADULT;
				} else if (ageGroup == 3) {
					return ALL_1D_TEEN;
				} else if (ageGroup == 2 || ageGroup == 5) {
					return ALL_1D_KID;
				} else if (ageGroup == 1) {
					return ALL_1D_BABY;
				} else if (ageGroup == 0) {
					return 0;
				} else {
					System.out.println("Error");
				}
			} else if (ticketType == 2) { // A4
				if (ageGroup == 4) {
					return ALL_A4_ADULT;
				} else if (ageGroup == 3) {
					return ALL_A4_TEEN;
				} else if (ageGroup == 2 || ageGroup == 5) {
					return ALL_A4_KID;
				} else if (ageGroup == 1) {
					return ALL_A4_BABY;
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
					return PARK_1D_ADULT;
				} else if (ageGroup == 3) {
					return PARK_1D_TEEN;
				} else if (ageGroup == 2 || ageGroup == 5) {
					return PARK_1D_KID;
				} else if (ageGroup == 1) {
					return PARK_1D_BABY;
				} else if (ageGroup == 0) {
					return 0;
				} else {
					System.out.println("Error");
				}
			} else if (ticketType == 2) { // A4
				if (ageGroup == 4) {
					return PARK_A4_ADULT;
				} else if (ageGroup == 3) {
					return PARK_A4_TEEN;
				} else if (ageGroup == 2 || ageGroup == 5) {
					return PARK_A4_KID;
				} else if (ageGroup == 1) {
					return PARK_A4_BABY;
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
			price *= DISABLED;
		} else if (preferClass == 3) {
			price *= NATIONAL_MERIT;
		} else if (preferClass == 4 && ticketClass == 1) {
			price *= SOLDIER;
		} else if (preferClass == 5 && ticketClass == 1) {
			price *= PREGNANT;
		} else if (preferClass == 6 && ticketClass == 1) {
			price *= MANY_CHILDREN;
		}
		return price;
	}

	// 배열 저장
	void savedInforms(int ticketClass, int ticketType, int ageGroup, int ticketCount, int price, int preferClass,
			int position, int inputList[][]) {

		inputList[position][0] = ticketClass;
		inputList[position][1] = ticketType;
		inputList[position][2] = ageGroup;
		inputList[position][3] = ticketCount;
		inputList[position][4] = price;
		inputList[position][5] = preferClass;

	}

	// ui 진행부
	void inputData(int position, int inputList[][], int companionPrint) {
		int ticketClass = 0;
		int ticketType = 0;
		int citizenNum = 0;
		int manAge = 0;
		int ageGroup = 0;
		int price = 0;
		int ticketCount = 0;
		int preferClass = 0;

		ticketClass = orderTicketClass(0);
		ticketType = orderTicketType(0);
		citizenNum = orderCitizenNum(0);
		manAge = calcAge(citizenNum);
		ageGroup = calcAgeGroup(manAge);
		price = calcPriceProcess(ageGroup, ticketClass, ticketType);
		ticketCount = orderTicketCount(0);
		price = calcTicketCount(ticketCount, price);
		preferClass = orderPreferClass(0);
		if (preferClass != 1) { // 만약 우대사항이 있다면 할인금액으로 변경

			price = calcDiscount(price, preferClass, ticketClass);
			companionIndex = preferClass; // 우대사항에 대한 정보를 기록

		} else { // 우대사항이 없는경우
			if (companionIndex == 2 || companionIndex == 3 || companionIndex == 4) {
				// 동반1인도 할인이 되는 우대사항 (장애인, 국가유공자, 휴가장병)
				companionPossible(); // 동반할인이 가능하다는 안내 출력
				companionPrint = 1; // 우대사항 칸에 동반할인 출력하는 index 변경
				price = calcDiscount(price, companionIndex, ticketClass); // 동반할인금액으로 변경
				companionIndex = 0; // 동반할인은 전부 1인까지만 되므로 index를 바로 0으로 바꿔주면 된다.
			}
			//
		}
		if (companionPrint == 1) {
			preferClass = 7; // 동반할인으로 변경
			companionPrint = 0;
		}
		savedInforms(ticketClass, ticketType, ageGroup, ticketCount, price, preferClass, position, inputList);
	}

	// int -> char* 변환
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

	int entrancePrint(int inputList[][], int position, int companionPrint) {

		int totalPrice = 0;
		System.out.println("티켓 발권을 종료합니다. 감사합니다.");
		System.out.println("---------------------롯데월드-----------------------------");
		for (int column = 0; column <= position; column++) {

			String ticketClass = convertTicketClass(inputList[column][0]);
			String ticketType = convertTicketType(inputList[column][1]);
			String ageGroup = convertAgeGroup(inputList[column][2]);
			String preferClass = convertPreferClass(inputList[column][5]);
			// ticketClass ticketType ageGroup ticketCount price preferClass
			System.out.println(ticketClass + "\t" + ticketType + "\t" + ageGroup + "\t" + inputList[column][3] + "장\t"
					+ inputList[column][4] + "원\t*" + preferClass);
			totalPrice += inputList[column][4];
		}

		System.out.println("입장료 총액은 " + totalPrice + "원 입니다.");
		return 2;
	}

	int continuePrint(int inputList[][], int position, int companionPrint) {
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
			reset = lt.entrancePrint(inputList, position, companionPrint);
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
		int[][] inputList = new int[100][6]; // 주문내역 저장
		int exitIndex = 0;
		int companionPrint = 0; // 동반할인 프린트 여부 index

		LotteTicket lt = new LotteTicket(); // void main 애들은 바깥세상을 모른다 , 알려주어야 함
		while (true) {
			lt.inputData(position, inputList, companionPrint);
			// 고객정보 저장
			int exitIndex1 = lt.continuePrint(inputList, position, companionPrint);
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
