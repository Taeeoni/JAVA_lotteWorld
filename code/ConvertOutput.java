package LotteTicket;

public class ConvertOutput { // int 데이터들 알맞게 String 으로 변환
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

}
