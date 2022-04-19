package LotteTicket;

import java.util.Scanner;

public class InputData { // �Էº�
	
	TicketSystem system = new TicketSystem();
	
	int orderTicketClass() { // �̿�� ���� �Է�
		OrderData orderItem = new OrderData();
		int errorIndex = 0;
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("�̿�� ������ �����ϼ��� : ");
			System.out.println("1. �����̿�� (�Ե����� + �μӹڹ���)");
			System.out.println("2. ��ũ�̿�� (�Ե�����)");
			Scanner scan = new Scanner(System.in);
			orderItem.ticketClass = scan.nextInt();

			if (orderItem.ticketClass > 2 || orderItem.ticketClass < 1) {
				system.errorMessagePrint();
				errorIndex = 0;
			}
		}

		return orderItem.ticketClass;

	}

	int orderTicketType() { // ���� ���� �Է�
		OrderData orderItem = new OrderData();
		int errorIndex = 0;
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("������ �����ϼ��� : ");
			System.out.println("1. 1Day");
			System.out.println("2. After4 (���� 4�ú��� ����)");
			Scanner scan = new Scanner(System.in);
			orderItem.ticketType = scan.nextInt();
			if (orderItem.ticketType > 2 || orderItem.ticketType < 1) {
				system.errorMessagePrint();
				errorIndex = 0;
			}
		}
		return orderItem.ticketType;

	}

	String orderCitizenNum() { // �ֹι�ȣ �Է�
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
				system.errorMessagePrint();
			}
			if (citizenMonth < 1 || citizenMonth > 12) {
				returnIndex = 0;
				system.errorMessagePrint();
			}
		}
		return orderItem.citizenNum;
	}

	int orderTicketCount(int ticketCount) { // Ƽ�� ��� �Է�

		Scanner scan = new Scanner(System.in);
		OrderData orderItem = new OrderData();
		int errorIndex = 0;
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("��� �ֹ��Ͻðڽ��ϱ�?(�ִ� 10��)");
			orderItem.ticketCount = scan.nextInt();
			if (orderItem.ticketCount > 10 || orderItem.ticketCount < 1) {
				system.errorMessagePrint();
				errorIndex = 0;
			}
		}
		return orderItem.ticketCount;

	}

	int orderPreferClass(int preferClass) { // ������ �Է�

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
			if (orderItem.preferClass < 1 || orderItem.preferClass > 6) {
				system.errorMessagePrint();
			}
		}
		return orderItem.preferClass;
	}

	
}
