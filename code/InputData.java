package LotteTicket;

import java.util.Scanner;

public class InputData { // �Էº�
	
	TicketSystem system = new TicketSystem();
	
	int orderTicketClass() { // �̿�� ���� �Է�
		
		ErrorProcess error = new ErrorProcess();
		Scanner scan = new Scanner(System.in);
		
		int errorIndex = 0;
		int TicketClass = 0;
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("�̿�� ������ �����ϼ��� : ");
			System.out.println("1. �����̿�� (�Ե����� + �μӹڹ���)");
			System.out.println("2. ��ũ�̿�� (�Ե�����)");
			
			TicketClass = scan.nextInt();

			if (TicketClass > 2 || TicketClass < 1) {
				error.errorMessagePrint();
				errorIndex = 0;
			}
		}

		return TicketClass;
	}

	int orderTicketType() { // ���� ���� �Է�
	
		ErrorProcess error = new ErrorProcess();
		Scanner scan = new Scanner(System.in);
		int errorIndex = 0;
		int TicketType = 0;
		
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("������ �����ϼ��� : ");
			System.out.println("1. 1Day");
			System.out.println("2. After4 (���� 4�ú��� ����)");
			
			TicketType = scan.nextInt();
			if (TicketType > 2 || TicketType < 1) {
				error.errorMessagePrint();
				errorIndex = 0;
			}
		}
		return TicketType;

	}

	String orderCitizenNum() { // �ֹι�ȣ �Է�
		
		int returnIndex = 0;
		Scanner scan = new Scanner(System.in);
		ErrorProcess error = new ErrorProcess();
		String citizenNum = "";
		
		while (returnIndex == 0) {
			System.out.println("�ֹι�ȣ�� ���ڸ� ù°�ڸ����� �Է��ϼ��� (ex:9304081) : ");
			citizenNum = scan.nextLine();
			returnIndex++;
			int citizenMil = Integer.parseInt(citizenNum.substring(6, 7));
			int citizenDay = Integer.parseInt(citizenNum.substring(4, 6));
			int citizenMonth = Integer.parseInt(citizenNum.substring(2, 4));
			int citizenYear = Integer.parseInt(citizenNum.substring(0, 2));

			if (citizenDay < 1 || citizenDay > 31) {
				returnIndex = 0;
				error.errorMessagePrint();
			}
			if (citizenMonth < 1 || citizenMonth > 12) {
				returnIndex = 0;
				error.errorMessagePrint();
			}
		}
		return citizenNum;
	}

	int orderTicketCount() { // Ƽ�� ��� �Է�

		Scanner scan = new Scanner(System.in);
		ErrorProcess error = new ErrorProcess();
		int errorIndex = 0;
		int ticketCount = 0;
		
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("��� �ֹ��Ͻðڽ��ϱ�?(�ִ� 10��)");
			ticketCount = scan.nextInt();
			if (ticketCount > 10 || ticketCount < 1) {
				error.errorMessagePrint();
				errorIndex = 0;
			}
		}
		return ticketCount;

	}

	int orderPreferClass() { // ������ �Է�

		Scanner scan = new Scanner(System.in);
		ErrorProcess error = new ErrorProcess();
		int preferClass = 0;
		
		do {
			System.out.println("�������� �����ϼ���.");
			System.out.println("1. ���� (���� ���� �ڵ�ó��)");
			System.out.println("2. ����� ���"); // ����1��
			System.out.println("3. ���������� ���"); // ����1��
			System.out.println("4. �ް��庴 ���"); // ����1��
			System.out.println("5. �ӻ�� ���");
			System.out.println("6. �ٵ��� �ູī�� ���");
			preferClass = scan.nextInt();
			if (preferClass < 1 || preferClass > 6) {
				error.errorMessagePrint();
			}
		} while (preferClass < 1 || preferClass > 6);
		
		return preferClass;
	}

	
}
