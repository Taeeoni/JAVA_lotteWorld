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

	// �����̿�� ����
	final int ALL_1D_ADULT = 62000, ALL_1D_TEEN = 54000, ALL_1D_KID = 47000, ALL_1D_BABY = 15000;
	final int ALL_A4_ADULT = 50000, ALL_A4_TEEN = 43000, ALL_A4_KID = 36000, ALL_A4_BABY = 15000;

	// ��ũ�̿�� ����
	final int PARK_1D_ADULT = 59000, PARK_1D_TEEN = 52000, PARK_1D_KID = 46000, PARK_1D_BABY = 15000;
	final int PARK_A4_ADULT = 47000, PARK_A4_TEEN = 41000, PARK_A4_KID = 35000, PARK_A4_BABY = 15000;

	// �ֹε�Ϲ�ȣ �м�
	final int PROTECT_CITIZEN_NUM = 10000000;
	final int OLD_GENERATION = 18000000, NEW_GENERATION = 19000000;

	// ���̿� ���� ����
	final int MIN_BABY = 1, MIN_KID = 3, MIN_TEEN = 12, MIN_ADULT = 18, MIN_OLD = 65;

	// ������
	final double DISABLED = 0.5, NATIONAL_MERIT = 0.5, SOLDIER = 0.49, PREGNANT = 0.5, MANY_CHILDREN = 0.3;

	// ����ó��
	void errorMessagePrint() {

	}

	// �Էº�
	int orderTicketClass(int ticketClass) {

		while (ticketClass != 1 && ticketClass != 2) { // ticketClass 1,2�� �ƴ϶�� �ݺ�

			System.out.println("�̿�� ������ �����ϼ��� : ");
			System.out.println("1. �����̿�� (�Ե����� + �μӹڹ���)");
			System.out.println("2. ��ũ�̿�� (�Ե�����)");
			Scanner scan = new Scanner(System.in);
			ticketClass = scan.nextInt();

		}
		return ticketClass;
	}

	int orderTicketType(int ticketType) {

		while (ticketType != 1 && ticketType != 2) { // 1, 2�� �ƴ϶�� �ݺ�

			System.out.println("������ �����ϼ��� : ");
			System.out.println("1. 1Day");
			System.out.println("2. After4 (���� 4�ú��� ����)");
			Scanner scan = new Scanner(System.in);
			ticketType = scan.nextInt();

		}
		return ticketType;
	}

	int orderCitizenNum(int citizenNum) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�ֹι�ȣ�� ���ڸ� ù°�ڸ����� �Է��ϼ��� (ex:9304081) : ");
		citizenNum = scan.nextInt();
		citizenNum += PROTECT_CITIZEN_NUM;
		return citizenNum;
	}

	int orderTicketCount(int ticketCount) {
		Scanner scan = new Scanner(System.in);
		System.out.println("��� �ֹ��Ͻðڽ��ϱ�?(�ִ� 10��)");
		ticketCount = scan.nextInt();
		return ticketCount;
	}

	int orderPreferClass(int preferClass) {
		Scanner scan = new Scanner(System.in);
		while (preferClass < 1 || preferClass > 6) {
			System.out.println("�������� �����ϼ���.");
			System.out.println("1. ���� (���� ���� �ڵ�ó��)");
			System.out.println("2. ����� ���"); // ����1��
			System.out.println("3. ���������� ���"); // ����1��
			System.out.println("4. �ް��庴 ���"); // ����1��
			System.out.println("5. �ӻ�� ���");
			System.out.println("6. �ٵ��� �ູī�� ���");
			preferClass = scan.nextInt();
		}
		return preferClass;
	}

	// ó����
	int calcAge(int citizenNum) {

		int gender = citizenNum % 10; // �ֹι�ȣ ���ڸ� 1, 2, 3, 4
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
			ageGroup = 0; // ������
		} else if (manAge >= MIN_BABY && manAge < MIN_KID) {
			ageGroup = 1; // ����
		} else if (manAge >= MIN_KID && manAge <= MIN_TEEN) {
			ageGroup = 2; // ���
		} else if (manAge > MIN_TEEN && manAge <= MIN_ADULT) {
			ageGroup = 3; // û�ҳ�
		} else if (manAge > MIN_ADULT && manAge < MIN_OLD) {
			ageGroup = 4; // �
		} else if (manAge >= MIN_OLD) {
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

	// �迭 ����
	void savedInforms(int ticketClass, int ticketType, int ageGroup, int ticketCount, int price, int preferClass,
			int position, int inputList[][]) {

		inputList[position][0] = ticketClass;
		inputList[position][1] = ticketType;
		inputList[position][2] = ageGroup;
		inputList[position][3] = ticketCount;
		inputList[position][4] = price;
		inputList[position][5] = preferClass;

	}

	// ui �����
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
		if (preferClass != 1) { // ���� �������� �ִٸ� ���αݾ����� ����

			price = calcDiscount(price, preferClass, ticketClass);
			companionIndex = preferClass; // �����׿� ���� ������ ���

		} else { // �������� ���°��
			if (companionIndex == 2 || companionIndex == 3 || companionIndex == 4) {
				// ����1�ε� ������ �Ǵ� ������ (�����, ����������, �ް��庴)
				companionPossible(); // ���������� �����ϴٴ� �ȳ� ���
				companionPrint = 1; // ������ ĭ�� �������� ����ϴ� index ����
				price = calcDiscount(price, companionIndex, ticketClass); // �������αݾ����� ����
				companionIndex = 0; // ���������� ���� 1�α����� �ǹǷ� index�� �ٷ� 0���� �ٲ��ָ� �ȴ�.
			}
			//
		}
		if (companionPrint == 1) {
			preferClass = 7; // ������������ ����
			companionPrint = 0;
		}
		savedInforms(ticketClass, ticketType, ageGroup, ticketCount, price, preferClass, position, inputList);
	}

	// int -> char* ��ȯ
	static String convertTicketClass(int input) {
		String ticketClass = "";
		if (input == 1) {
			ticketClass = "�����̿��";
		} else if (input == 2) {
			ticketClass = "��ũ�̿��";
		}
		return ticketClass;
	}

	static String convertTicketType(int input) {
		String ticketType = "";
		if (input == 1) {
			ticketType = "1Day";
		} else if (input == 2) {
			ticketType = "After4";
		}
		return ticketType;
	}

	static String convertAgeGroup(int input) {
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

	static String convertPreferClass(int input) {
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

	static int entrancePrint(int inputList[][], int position, int companionPrint) {

		int totalPrice = 0;
		System.out.println("Ƽ�� �߱��� �����մϴ�. �����մϴ�.");
		System.out.println("---------------------�Ե�����-----------------------------");
		for (int column = 0; column <= position; column++) {

			String ticketClass = convertTicketClass(inputList[column][0]);
			String ticketType = convertTicketType(inputList[column][1]);
			String ageGroup = convertAgeGroup(inputList[column][2]);
			String preferClass = convertPreferClass(inputList[column][5]);
			// ticketClass ticketType ageGroup ticketCount price preferClass
			System.out.println(ticketClass + "\t" + ticketType + "\t" + ageGroup + "\t" + inputList[column][3] + "��\t"
					+ inputList[column][4] + "��\t*" + preferClass);
			totalPrice += inputList[column][4];
		}

		System.out.println("����� �Ѿ��� " + totalPrice + "�� �Դϴ�.");
		return 2;
	}

	static int continuePrint(int inputList[][], int position, int companionPrint) {

		System.out.println("��� �߱� �Ͻðڽ��ϱ�?");
		System.out.println("1. Ƽ�� �߱�");
		System.out.println("2. ����");
		Scanner scan = new Scanner(System.in);
		int continueSelect = scan.nextInt();

		if (continueSelect == 1) {
			return 0;
		} else if (continueSelect == 2) {
			int reset;
			reset = entrancePrint(inputList, position, companionPrint);
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
		int[][] inputList = new int[100][6]; // �ֹ����� ����
		int exitIndex = 0;
		int companionPrint = 0; // �������� ����Ʈ ���� index

		LotteTicket lt = new LotteTicket();
		while (true) {
			lt.inputData(position, inputList, companionPrint);
			// ������ ����
			int exitIndex1 = continuePrint(inputList, position, companionPrint);
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
