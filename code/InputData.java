package LotteTicket;

import java.util.Scanner;

public class InputData { // �Էº�
	
	int errorIndex;
	int ticketClass;
	int ticketType;
	String citizenNum;
	int ticketCount;
	int preferClass;
	
	public InputData() {
		errorIndex = 0;
		ticketClass = 0;
		ticketType = 0;
		citizenNum = "";
		ticketCount = 0;
		preferClass = 0;
	}
	
		
	int orderTicketClass() { // �̿�� ���� �Է�
		
		ErrorProcess error = new ErrorProcess();
		Scanner scan = new Scanner(System.in);
		
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("�̿�� ������ �����ϼ��� : ");
			System.out.println("1. �����̿�� (�Ե����� + �μӹڹ���)");
			System.out.println("2. ��ũ�̿�� (�Ե�����)");
			
			ticketClass = scan.nextInt();

			if (ticketClass > 2 || ticketClass < 1) {
				error.errorMessagePrint();
				errorIndex = 0;
			}
		}

		return ticketClass;
	}

	int orderTicketType() { // ���� ���� �Է�
	
		ErrorProcess error = new ErrorProcess();
		Scanner scan = new Scanner(System.in);
		
		do {
			errorIndex = 1;
			System.out.println("������ �����ϼ��� : ");
			System.out.println("1. 1Day");
			System.out.println("2. After4 (���� 4�ú��� ����)");
			
			ticketType = scan.nextInt();
			if (ticketType > 2 || ticketType < 1) {
				error.errorMessagePrint();
				errorIndex = 0;
			}
		} while (errorIndex == 0);
		
		return ticketType;

	}

	String orderCitizenNum() { // �ֹι�ȣ �Է�
		
		Scanner scan = new Scanner(System.in);
		ErrorProcess error = new ErrorProcess();
		
		
		do { 
			errorIndex = 1;
			System.out.println("�ֹι�ȣ�� ���ڸ� ù°�ڸ����� �Է��ϼ��� (ex:9304081) : ");
			citizenNum = scan.nextLine();
			int citizenMil = Integer.parseInt(citizenNum.substring(6, 7));
			int citizenDay = Integer.parseInt(citizenNum.substring(4, 6));
			int citizenMonth = Integer.parseInt(citizenNum.substring(2, 4));
			int citizenYear = Integer.parseInt(citizenNum.substring(0, 2));

			if (citizenDay < 1 || citizenDay > 31) {
				errorIndex = 0;
				error.errorMessagePrint();
			}
			if (citizenMonth < 1 || citizenMonth > 12) {
				errorIndex = 0;
				error.errorMessagePrint();
			}
		} while (errorIndex == 0);
		 
		return citizenNum;
	}

	int orderTicketCount() { // Ƽ�� ��� �Է�

		Scanner scan = new Scanner(System.in);
		ErrorProcess error = new ErrorProcess();
	
		do {
			errorIndex = 1;
			System.out.println("��� �ֹ��Ͻðڽ��ϱ�?(�ִ� 10��)");
			ticketCount = scan.nextInt();
			if (ticketCount > 10 || ticketCount < 1) {
				error.errorMessagePrint();
				errorIndex = 0;
			}
		} while (errorIndex == 0);
		
		return ticketCount;

	}

	int orderPreferClass() { // ������ �Է�

		Scanner scan = new Scanner(System.in);
		ErrorProcess error = new ErrorProcess();
		
		
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
