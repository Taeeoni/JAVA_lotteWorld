package LotteTicket;

public class ConvertOutput { // int �����͵� �˸°� String ���� ��ȯ
	
	String ticketClass;
	String ticketType;
	String ageGroup;
	String preferClass;

	public ConvertOutput() {
		
		ticketClass = "";
		ticketType = "";
		ageGroup = "";
		preferClass = "";
		
	}
	
	String convertTicketClass(int input) {
		if (input == 1) {
			ticketClass = StaticValue.ALL; // static���� �Ǿ��־ ��ü���� ���� �ٷ� ȣ�� ����
		} else if (input == 2) {
			ticketClass = StaticValue.PARK;
		}
		return ticketClass;
	}

	String convertTicketType(int input) {
		if (input == 1) {
			ticketType = StaticValue.FULLDAY;
		} else if (input == 2) {
			ticketType = StaticValue.AFTER4;
		}
		return ticketType;
	}

	String convertAgeGroup(int input) {
		if (input == 0) {
			ageGroup = StaticValue.LITTLE;
		} else if (input == 1) {
			ageGroup = StaticValue.BABY;
		} else if (input == 2) {
			ageGroup = StaticValue.KID;
		} else if (input == 3) {
			ageGroup = StaticValue.TEEN;
		} else if (input == 4) {
			ageGroup = StaticValue.ADULT;
		} else if (input == 5) {
			ageGroup = StaticValue.OLD;
		}
		return ageGroup;
	}

	String convertPreferClass(int input) {
		if (input == 1) {
			preferClass = StaticValue.NOTHING_STR;
		} else if (input == 2) {
			preferClass = StaticValue.DISABLED_STR;
		} else if (input == 3) {
			preferClass = StaticValue.NATIONAL_STR;
		} else if (input == 4) {
			preferClass = StaticValue.SOLDIER_STR;
		} else if (input == 5) {
			preferClass = StaticValue.PREGNANT_STR;
		} else if (input == 6) {
			preferClass = StaticValue.MANYCHIRDREN_STR;
		} else if (input == 7) {
			preferClass = StaticValue.COMPANION_STR;
		}
		return preferClass;
	}

}
