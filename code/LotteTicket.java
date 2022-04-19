package LotteTicket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//�������� Ŭ������ �ɰ���
// 1. ����� Ŭ������ �����. -> StaticValue
// 2. ���� �̿��ϴ� static �Լ��� ã�� �����. (ex. �� ������ִ� �͵� ) , ���⼱ ����.
// 3. �����͸� ������ Ŭ������ �����.

public class LotteTicket {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	Date today = new Date();
	int nowTime = Integer.parseInt(format.format(today));
	int companionIndex = 0;
	OrderData orderItem; 
	ArrayList<OrderData> orderList;
	

	// ����ó��
	void errorMessagePrint() {

	}

	// �Էº�
	int orderTicketClass() {
		
		OrderData orderItem = new OrderData(); 
		System.out.println("�̿�� ������ �����ϼ��� : ");
		System.out.println("1. �����̿�� (�Ե����� + �μӹڹ���)");
		System.out.println("2. ��ũ�̿�� (�Ե�����)");
		Scanner scan = new Scanner(System.in);
		orderItem.ticketClass = scan.nextInt();
		return orderItem.ticketClass;
	}

	int orderTicketType() {
		
		OrderData orderItem = new OrderData(); 
		System.out.println("������ �����ϼ��� : ");
		System.out.println("1. 1Day");
		System.out.println("2. After4 (���� 4�ú��� ����)");
		Scanner scan = new Scanner(System.in);
		orderItem.ticketType = scan.nextInt();
		return orderItem.ticketType;
		
	}

	String orderCitizenNum() {
		int returnIndex = 0;
		Scanner scan = new Scanner(System.in);
		OrderData orderItem = new OrderData(); 

		while (returnIndex == 0) {
			System.out.println("�ֹι�ȣ�� ���ڸ� ù°�ڸ����� �Է��ϼ��� (ex:9304081) : ");
			orderItem.citizenNum = scan.nextLine();
			returnIndex++;
			int citizenMil = Integer.parseInt(orderItem.citizenNum.substring(6, 7));
			int citizenDay = Integer.parseInt(orderItem.citizenNum.substring(4, 6));
			int citizenMonth = Integer.parseInt(orderItem.citizenNum.substring(2, 4));
			int citizenYear = Integer.parseInt(orderItem.citizenNum.substring(0, 2));

			if (citizenDay < 1 || citizenDay > 31) {
				returnIndex = 0;
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���");
			}
			if (citizenMonth < 1 || citizenMonth > 12) {
				returnIndex = 0;
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���");
			}
		}
		return orderItem.citizenNum;
	}

	int orderTicketCount(int ticketCount) {
		
		Scanner scan = new Scanner(System.in);
		OrderData orderItem = new OrderData(); 
		System.out.println("��� �ֹ��Ͻðڽ��ϱ�?(�ִ� 10��)");
		orderItem.ticketCount = scan.nextInt();
		return orderItem.ticketCount;
		
	}

	int orderPreferClass(int preferClass) {
		
		Scanner scan = new Scanner(System.in);
		OrderData orderItem = new OrderData(); 
		while (orderItem.preferClass < 1 || orderItem.preferClass > 6) {
			System.out.println("�������� �����ϼ���.");
			System.out.println("1. ���� (���� ���� �ڵ�ó��)");
			System.out.println("2. ����� ���"); // ����1��
			System.out.println("3. ���������� ���"); // ����1��
			System.out.println("4. �ް��庴 ���"); // ����1��
			System.out.println("5. �ӻ�� ���");
			System.out.println("6. �ٵ��� �ູī�� ���");
			orderItem.preferClass = scan.nextInt();
		}
		return orderItem.preferClass;
	}

	// ó����
	int calcAge(String citizenNum) {
		OrderData orderItem = new OrderData(); // 9304081
		int gender = Integer.parseInt(citizenNum.substring(6, 7)); // �ֹι�ȣ ���ڸ� 1, 2, 3, 4
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
			ageGroup = 0; // ������
		} else if (manAge >= StaticValue.MIN_BABY && manAge < StaticValue.MIN_KID) {
			ageGroup = 1; // ����
		} else if (manAge >= StaticValue.MIN_KID && manAge <= StaticValue.MIN_TEEN) {
			ageGroup = 2; // ���
		} else if (manAge > StaticValue.MIN_TEEN && manAge <= StaticValue.MIN_ADULT) {
			ageGroup = 3; // û�ҳ�
		} else if (manAge > StaticValue.MIN_ADULT && manAge < StaticValue.MIN_OLD) {
			ageGroup = 4; // �
		} else if (manAge >= StaticValue.MIN_OLD) {
			ageGroup = 5;// ����
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

	// �迭 ����
	void savedInforms(OrderData orderItem, ArrayList<OrderData> orderList) {

		orderList.add(orderItem);
	}
	
	// ui �����
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
		if (orderItem.preferClass != 1) { // ���� �������� �ִٸ� ���αݾ����� ����

			orderItem.price = calcDiscount(orderItem.price, orderItem.preferClass, orderItem.ticketClass);
			companionIndex = orderItem.preferClass; // �����׿� ���� ������ ���

		} else { // �������� ���°��
			if (companionIndex == 2 || companionIndex == 3 || companionIndex == 4) {
				// ����1�ε� ������ �Ǵ� ������ (�����, ����������, �ް��庴)
				companionPossible(); // ���������� �����ϴٴ� �ȳ� ���
				companionPrint = 1; // ������ ĭ�� �������� ����ϴ� index ����
				orderItem.price = calcDiscount(orderItem.price, companionIndex, orderItem.ticketClass); // �������αݾ����� ����
				companionIndex = 0; // ���������� ���� 1�α����� �ǹǷ� index�� �ٷ� 0���� �ٲ��ָ� �ȴ�.
			}
			//
		}
		if (companionPrint == 1) {
			orderItem.preferClass = 7; // ������������ ����
			companionPrint = 0;
		}
		savedInforms(orderItem, orderList);
	}


	// int -> String ��ȯ
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

	// ��º�
	int entrancePrint(int position, int companionPrint, ArrayList<OrderData> orderList) {
		
		OrderData orderItem = new OrderData();
		int totalPrice = 0;
		System.out.println("Ƽ�� �߱��� �����մϴ�. �����մϴ�.");
		System.out.println("---------------------�Ե�����-----------------------------");
		
		System.out.println(orderList.get(position).preferClass);

		
		for (int column = 0; column <= position; column++) {

			String ticketClass = convertTicketClass(orderList.get(column).ticketClass);
			String ticketType = convertTicketType(orderList.get(column).ticketType);
			String ageGroup = convertAgeGroup(orderList.get(column).ageGroup);
			String preferClass = convertPreferClass(orderList.get(column).preferClass);
			//ticketClass ticketType ageGroup ticketCount price preferClass
			System.out.println(ticketClass + "\t" + ticketType + "\t" + ageGroup + "\t" + orderList.get(column).ticketCount + "��\t"
					+ orderList.get(column).price + "��\t*" + preferClass);
		}
		
		
		return 2;
	}

	int continuePrint(int position, int companionPrint, ArrayList<OrderData> orderList) {
		LotteTicket lt = new LotteTicket();
		System.out.println("��� �߱� �Ͻðڽ��ϱ�?");
		System.out.println("1. Ƽ�� �߱�");
		System.out.println("2. ����");
		Scanner scan = new Scanner(System.in);
		int continueSelect = scan.nextInt();

		if (continueSelect == 1) { 
			return 0;
		} else if (continueSelect == 2) {
			int reset;
			reset = lt.entrancePrint(position, companionPrint, orderList);
			return reset;
		} else if (continueSelect == 33) { // ������ ��ȣ 33�� ������ �ý��� ����
			return 1;
		}
		return 0;
	}

	void companionPossible() {
		System.out.println("���������� ���� �� �ֽ��ϴ�.\n");
	}

	public static void main(String[] args) {
		int totalPrice = 0; // �ֹ� �Ѿ�
		int position = 0; // inputList �� �߰��� ���
		int filePosition = 0; // ���� ��� ù�� ����
		int exitIndex = 0;
		int companionPrint = 0; // �������� ����Ʈ ���� index
		OrderData orderItem = new OrderData(); 
		ArrayList<OrderData> orderList = new ArrayList<OrderData>();
		
		LotteTicket lt = new LotteTicket(); // void main �ֵ��� �ٱ������� �𸥴� , �˷��־�� ��

		while (true) {
			
			orderItem = new OrderData();
			
			lt.inputData(position, companionPrint, orderList);
			// ������ ����
			int exitIndex1 = lt.continuePrint(position, companionPrint, orderList);
			position++; // �迭��ġ ����
			if (exitIndex1 == 1) {
				break;
			} else if (exitIndex1 == 2) {
				position = 0;
			}
			System.out.println("\n");
		}
	}
}
