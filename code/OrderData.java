package LotteTicket;

public class OrderData {
	private int ticketClass; // 권종 int (1. 종합이용권 , 2. 파크이용권)
	private int ticketType; // 티켓타입 int (1. 1일권, 2. After4)
	private String citizenNum; // 주민번호 String 
	private int ticketCount; // 주문개수 int (최대 10개)
	private int price;
	private int preferClass; // 우대사항 int 
	private int ageGroup;
	
	private String ticketClassS;
	private String ticketTypeS;
	private String ageGroupS;
	private String preferClassS;
	
	
	public int getTicketClass() { // 은닉된 변수의 값을 읽는 getter
		return ticketClass;
	}
	public void setTicketClass(int ticketClass) { // 은닉된 변수에 값을 넣는 setter
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
			ticketClassS = StaticValue.ALL; // static으로 되어있어서 객체생성 없이 바로 호출 가능
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
