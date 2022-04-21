package LotteTicket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Print { // ��º�
	
	int totalPrice;
	int nowTime;

	public Print() {
		
		totalPrice = 0;
		nowTime = 0;
	}
	
	void printTitle() throws IOException {
		
		File file = new File("C:\\test\\lotteworldreport\\lottereport.csv");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		bw.write("��¥, �̿��, ����, ���ɱ���, ����, ����, ������");
		bw.newLine();
		bw.flush();
		bw.close();
		
	}
	
	
	
	int entrancePrint(int position, ArrayList<OrderData> orderList) throws IOException {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date today = new Date();
		nowTime = Integer.parseInt(format.format(today));
		ConvertOutput convert = new ConvertOutput();
		
		//String path = "C:\\test\\seoulapart\\listout.csv";
		//BufferedReader br = new BufferedReader(new FileReader(path));
		File file = new File("C:\\test\\lotteworldreport\\lottereport.csv");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); // append
		
		


		
		System.out.println("Ƽ�� �߱��� �����մϴ�. �����մϴ�.");
		System.out.println("---------------------�Ե�����-----------------------------");

		for (int column = 0; column <= position; column++) {

			String ticketClass = convert.convertTicketClass(orderList.get(column).getTicketClass());
			String ticketType = convert.convertTicketType(orderList.get(column).getTicketType());
			String ageGroup = convert.convertAgeGroup(orderList.get(column).getAgeGroup());
			String preferClass = convert.convertPreferClass(orderList.get(column).getPreferClass());
			// ticketClass ticketType ageGroup ticketCount price preferClass
			System.out.println(ticketClass + "\t" + ticketType + "\t" + ageGroup + "\t"
					+ orderList.get(column).getTicketCount() + "��\t" + orderList.get(column).getPrice() + "��\t*" + preferClass);
			
			bw.write(nowTime + "," + ticketClass + "," + ticketType + "," + ageGroup + "," 
					+ orderList.get(column).getTicketCount() + "," + orderList.get(column).getPrice() + "," + preferClass);
			
		}
		
		
		bw.flush();
		bw.close();

		return 2;
	}

	int continuePrint(int position, ArrayList<OrderData> orderList) throws IOException {
		
		System.out.println("��� �߱� �Ͻðڽ��ϱ�?");
		System.out.println("1. Ƽ�� �߱�");
		System.out.println("2. ����");
		Scanner scan = new Scanner(System.in);
		int continueSelect = scan.nextInt();

		if (continueSelect == 1) {
			return 0;
		} else if (continueSelect == 2) {
			int reset;
			reset = entrancePrint(position, orderList);
			return reset;
		} else if (continueSelect == 33) { // ������ ��ȣ 33�� ������ �ý��� ����
			return 1;
		}
		return 0;
	}

	void companionPossible() {
		System.out.println("���������� ���� �� �ֽ��ϴ�.\n");
	}

	
}
