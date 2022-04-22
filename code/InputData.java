package LotteTicket;

import java.io.IOException;
import java.util.Scanner;

public class InputData { // �Էº�
	
	int errorIndex;
	int ticketClass;
	int ticketType;
	String citizenNum;
	int ticketCount;
	int preferClass;
	int citizenMil;
	int citizenDay;
	int citizenMonth;
	int citizenYear;
	
	public InputData() {
		errorIndex = 0;
		ticketClass = 0;
		ticketType = 0;
		citizenNum = "";
		ticketCount = 0;
		preferClass = 0;
		citizenMil = 0;
		citizenDay = 0;
		citizenMonth = 0;
		citizenYear = 0;
	}
	
		
	int orderTicketClass() throws IOException { // �̿�� ���� �Է�
		
		ErrorProcess error = new ErrorProcess();
		Scanner scan = new Scanner(System.in);
		Print print = new Print();
		
		while (errorIndex == 0) {
			errorIndex = 1;
			System.out.println("�̿�� ������ �����ϼ��� : ");
			System.out.println("1. �����̿�� (�Ե����� + �μӹڹ���)");
			System.out.println("2. ��ũ�̿�� (�Ե�����)");
			
			ticketClass = scan.nextInt();

			if (ticketClass > 2 || ticketClass < 1) {
				if(ticketClass == 33) {
					errorIndex = 1;
				} else if (ticketClass == 0) {
					print.printCsv();// lotteReport.csv ������ ��Ȳ�� ����ϱ� ���� �޼ҵ�� �̵�
				} else {
					error.errorMessagePrint();
					errorIndex = 0;
				}
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
		OrderData order = new OrderData();
		
		
		do { 
			errorIndex = 1;
			System.out.println("�ֹι�ȣ�� ���ڸ� ù°�ڸ����� �Է��ϼ��� (ex:9304081) : ");
			citizenNum = scan.nextLine();
			
			if(citizenNum.length() != 7) { // �ֹι�ȣ�� 7�ڸ��Է��� �ȵǾ��� ��� ���� ���
				errorIndex = 0;
				error.errorMessagePrint();
			}
			
				
			if(errorIndex == 1) {
				citizenMil = Integer.parseInt(citizenNum.substring(6, 7));
				citizenDay = Integer.parseInt(citizenNum.substring(4, 6));
				citizenMonth = Integer.parseInt(citizenNum.substring(2, 4));
				citizenYear = Integer.parseInt(citizenNum.substring(0, 2));
			
				if (citizenDay < 1 || citizenDay > 31) { // ���ڰ� 1~31���� �ƴҰ�� ���� ���
					errorIndex = 0;
					error.errorMessagePrint();
				}
				if (citizenMonth < 1 || citizenMonth > 12) { // ���� 1~12���� �ƴҰ�� ���� ���
					errorIndex = 0;
					error.errorMessagePrint();
				}
				
				if (citizenYear < 2000 && citizenMil >=3) { // 1900�����ε� ���ڸ�ù°�ڸ��� 3�̻��� �� ���� ���
					errorIndex = 0;
					error.errorMessagePrint();
				}
				
				if (citizenYear >= 2000 && citizenMil < 3) { // 2000�����ε� ���ڸ� ù°�ڸ��� 3�̸��� �� ���� ���
					errorIndex = 0;
					error.errorMessagePrint();
				}

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
