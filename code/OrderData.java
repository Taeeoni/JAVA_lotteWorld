package LotteTicket;

public class OrderData {
	private int ticketClass; // ���� int (1. �����̿�� , 2. ��ũ�̿��)
	private int ticketType; // Ƽ��Ÿ�� int (1. 1�ϱ�, 2. After4)
	private String citizenNum; // �ֹι�ȣ String 
	private int ticketCount; // �ֹ����� int (�ִ� 10��)
	private int price;
	private int preferClass; // ������ int 
	private int ageGroup;
	
	private String ticketClassS;
	private String ticketTypeS;
	private String ageGroupS;
	private String preferClassS;
	
	
	public int getTicketClass() { // ���е� ������ ���� �д� getter
		return ticketClass;
	}
	public void setTicketClass(int ticketClass) { // ���е� ������ ���� �ִ� setter
		this.ticketClass = ticketClass;
	}

	public int getTicketType() {
		return ticketType;
	}
	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}
	public String getCitizenNum() {
		return citizenNum;
	}
	public void setCitizenNum(String citizenNum) {
		this.citizenNum = citizenNum;
	}
	public int getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPreferClass() {
		return preferClass;
	}
	public void setPreferClass(int preferClass) {
		this.preferClass = preferClass;
	}
	public int getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}
	
	public String getTicketClassS(int input) {
		if (input == 1) {
			ticketClassS = StaticValue.ALL; // static���� �Ǿ��־ ��ü���� ���� �ٷ� ȣ�� ����
		} else if (input == 2) {
			ticketClassS = StaticValue.PARK;
		}
		return ticketClassS;
	}
	
	public void setTicketClassS(String ticketClassS) {
		this.ticketClassS = ticketClassS;
	}
	
	public String getTicketTypeS(int input) {
		if (input == 1) {
			ticketTypeS = StaticValue.FULLDAY;
		} else if (input == 2) {
			ticketTypeS = StaticValue.AFTER4;
		}
		return ticketTypeS;
	}
	
	public void setTicketTypeS(String ticketTypeS) {
		this.ticketTypeS = ticketTypeS;
	}
	
	public String getAgeGroupS(int input) {
		if (input == 0) {
			ageGroupS = StaticValue.LITTLE;
		} else if (input == 1) {
			ageGroupS = StaticValue.BABY;
		} else if (input == 2) {
			ageGroupS = StaticValue.KID;
		} else if (input == 3) {
			ageGroupS = StaticValue.TEEN;
		} else if (input == 4) {
			ageGroupS = StaticValue.ADULT;
		} else if (input == 5) {
			ageGroupS = StaticValue.OLD;
		}
		return ageGroupS;
	}
	
	public void setAgeGroupS(String ageGroupS) {
		this.ageGroupS = ageGroupS;
	}
	public String getPreferClassS(int input) {
		if (input == 1) {
			preferClassS = StaticValue.NOTHING_STR;
		} else if (input == 2) {
			preferClassS = StaticValue.DISABLED_STR;
		} else if (input == 3) {
			preferClassS = StaticValue.NATIONAL_STR;
		} else if (input == 4) {
			preferClassS = StaticValue.SOLDIER_STR;
		} else if (input == 5) {
			preferClassS = StaticValue.PREGNANT_STR;
		} else if (input == 6) {
			preferClassS = StaticValue.MANYCHIRDREN_STR;
		} else if (input == 7) {
			preferClassS = StaticValue.COMPANION_STR;
		}
		return preferClassS;
	}
	public void setPreferClassS(String preferClassS) {
		this.preferClassS = preferClassS;
	}
	

}
