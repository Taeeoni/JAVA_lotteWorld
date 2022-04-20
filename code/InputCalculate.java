package LotteTicket;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InputCalculate { // 처리부
	int calcAge(String citizenNum) {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date today = new Date();
		int nowTime = Integer.parseInt(format.format(today));
		
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

	
	
}
