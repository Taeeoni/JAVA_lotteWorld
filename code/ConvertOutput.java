package LotteTicket;

public class ConvertOutput { // int �����͵� �˸°� String ���� ��ȯ
	String convertTicketClass(int input) {
		String ticketClass = "";
		if (input == 1) {
			ticketClass = "�����̿��";
		} else if (input == 2) {
			ticketClass = "��ũ�̿��";
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
			ageGroup = "������";
		} else if (input == 1) {
			ageGroup = "����";
		} else if (input == 2) {
			ageGroup = "���";
		} else if (input == 3) {
			ageGroup = "û�ҳ�";
		} else if (input == 4) {
			ageGroup = "�";
		} else if (input == 5) {
			ageGroup = "����";
		}
		return ageGroup;
	}

	String convertPreferClass(int input) {
		String preferClass = "";
		if (input == 1) {
			preferClass = "����";
		} else if (input == 2) {
			preferClass = "�����";
		} else if (input == 3) {
			preferClass = "����������";
		} else if (input == 4) {
			preferClass = "�ް��庴";
		} else if (input == 5) {
			preferClass = "�ӻ��";
		} else if (input == 6) {
			preferClass = "�ٵ���";
		} else if (input == 7) {
			preferClass = "��������";
		}
		return preferClass;
	}

}
