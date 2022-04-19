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
			orderItem.setTicketClass(scan.nextInt());

			if (orderItem.getTicketClass() > 2 || orderItem.getTicketClass() < 1) {
				system.errorMessagePrint();
				errorIndex = 0;
			}
		}

		return orderItem.getTicketClass();

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
			orderItem.setTicketType(scan.nextInt());
			if (orderItem.getTicketType() > 2 || orderItem.getTicketType() < 1) {
				system.errorMessagePrint();
				errorIndex = 0;
			}
		}
		return orderItem.getTicketType();

	}

	String orderCitizenNum() { // �ֹι�ȣ �Է�
		int returnIndex = 0;
		Scanner scan = new Scanner(System.in);
		OrderData orderItem = new OrderData();

		while (returnIndex == 0) {
			System.out.println("�ֹι�ȣ�� ���ڸ� ù°�ڸ����� �Է��ϼ��� (ex:9304081) : ");
			orderItem.setCitizenNum(scan.nextLine());
			returnIndex++;
			int citizenMil = Integer.parseInt(orderItem.getCitizenNum().substring(6, 7));
			int citizenDay = Integer.parseInt(orderItem.getCitizenNum().substring(4, 6));
			int citizenMonth = Integer.parseInt(orderItem.getCitizenNum().substring(2, 4));
			int citizenYear = Integer.parseInt(orderItem.getCitizenNum().substring(0, 2));

			if (citizenDay < 1 || citizenDay > 31) {
				returnIndex = 0;
				system.errorMessagePrint();
			}
			if (citizenMonth < 1 || citizenMonth > 12) {
				returnIndex = 0;
				system.errorMessagePrint();
			}
		}
		return orderItem.getCitizenNum();
	}

	int orderTicketCount(int ticketCount) { // Ƽ�� ��� �Է�

		Scanner scan = new Scanner(System.in);
		OrderData orderItem = new OrderData();
		int errorIndex = 0;
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("��� �ֹ��Ͻðڽ��ϱ�?(�ִ� 10��)");
			orderItem.setTicketCount(scan.nextInt());
			if (orderItem.getTicketCount() > 10 || orderItem.getTicketCount() < 1) {
				system.errorMessagePrint();
				errorIndex = 0;
			}
		}
		return orderItem.getTicketCount();

	}

	int orderPreferClass(int preferClass) { // ������ �Է�

		Scanner scan = new Scanner(System.in);
		OrderData orderItem = new OrderData();
		while (orderItem.getPreferClass() < 1 || orderItem.getPreferClass() > 6) {
			System.out.println("�������� �����ϼ���.");
			System.out.println("1. ���� (���� ���� �ڵ�ó��)");
			System.out.println("2. ����� ���"); // ����1��
			System.out.println("3. ���������� ���"); // ����1��
			System.out.println("4. �ް��庴 ���"); // ����1��
			System.out.println("5. �ӻ�� ���");
			System.out.println("6. �ٵ��� �ູī�� ���");
			orderItem.setPreferClass(scan.nextInt());
			if (orderItem.getPreferClass() < 1 || orderItem.getPreferClass() > 6) {
				system.errorMessagePrint();
			}
		}
		return orderItem.getPreferClass();
	}

	
}
