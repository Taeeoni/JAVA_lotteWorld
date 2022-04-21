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

		File file = new File("C:\\test\\lotteworldreport\\lotteReport.csv");
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

		// String path = "C:\\test\\seoulapart\\listout.csv";
		// BufferedReader br = new BufferedReader(new FileReader(path));
		File file = new File("C:\\test\\lotteworldreport\\lotteReport.csv");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); // append

		if (orderList.get(position).getTicketClass() == 33) {
			System.out.println("���α׷��� �����մϴ�.");
			return 1;
		} else {

			System.out.println("Ƽ�� �߱��� �����մϴ�. �����մϴ�.");
			System.out.println("---------------------�Ե�����-----------------------------");

			for (int column = 0; column <= position; column++) {

				String ticketClass = convert.convertTicketClass(orderList.get(column).getTicketClass());
				String ticketType = convert.convertTicketType(orderList.get(column).getTicketType());
				String ageGroup = convert.convertAgeGroup(orderList.get(column).getAgeGroup());
				String preferClass = convert.convertPreferClass(orderList.get(column).getPreferClass());
				// ticketClass ticketType ageGroup ticketCount price preferClass
				System.out.println(ticketClass + "\t" + ticketType + "\t" + ageGroup + "\t"
						+ orderList.get(column).getTicketCount() + "��\t" + orderList.get(column).getPrice() + "��\t*"
						+ preferClass);

				bw.write(nowTime + "," + ticketClass + "," + ticketType + "," + ageGroup + ","
						+ orderList.get(column).getTicketCount() + "," + orderList.get(column).getPrice() + ","
						+ preferClass);
				bw.newLine();

			}

			bw.flush();
			bw.close();
			printCsv(); // lotteReport.csv ������ ��Ȳ�� ����ϱ� ���� �޼ҵ�� �̵�

			return 2;
		}
	}

	void printCsv() throws IOException { //lotteReport.csv ������ ��Ȳ�� ��
		
		File file = new File("C:\\test\\lotteworldreport\\lotteReport.csv");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		System.out.println("");
		System.out.println("--------------------- lotteReport --------------------------");
		
		while((line = br.readLine()) != null) {
			String[] lineSplit = line.split(",");	
			for(int i = 0; i < lineSplit.length; i++) {
				System.out.printf("%8s", lineSplit[i]);	
			}		
			System.out.println("");
		}
		System.out.println("------------------------------------------------------------");
		salesAnalysis();
	}
	
	
	void salesAnalysis() throws NumberFormatException, IOException {
		System.out.println("---------------------�̿�� �� �Ǹ� ��Ȳ-------------------------");
		int count1 = 0;
		int dayCount = 0;
		int after4Count = 0;
		int littleCount = 0;
		int babyCount = 0;
		int kidCount = 0;
		int teenCount = 0;
		int adultCount = 0;
		int oldCount = 0;
		int priceSum = 0;
		
		int count1P = 0;
		int dayCountP = 0;
		int after4CountP = 0;
		int littleCountP = 0;
		int babyCountP = 0;
		int kidCountP = 0;
		int teenCountP = 0;
		int adultCountP = 0;
		int oldCountP = 0;
		int priceSumP = 0;
		
		File file = new File("C:\\test\\lotteworldreport\\lotteReport.csv");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		int readLineCount = 0;
		
		while((line = br.readLine()) != null) {
			
			if(readLineCount >= 1) {
				String[] lineSplit2 = line.split(",");
	
				if(lineSplit2[1].equals("�����̿��")) {
					count1++;
					
					if(lineSplit2[2].equals("1Day")) {
						dayCount++;
					} else if(lineSplit2[2].equals("After4")) {
						after4Count++;
					}
					
					if(lineSplit2[3].equals("������")) {
						littleCount++;
					} else if(lineSplit2[3].equals("����")) {
						babyCount++;
					} else if(lineSplit2[3].equals("���")) {
						kidCount++;
					} else if(lineSplit2[3].equals("û�ҳ�")) {
						teenCount++;
					} else if(lineSplit2[3].equals("����")) {
						adultCount++;
					} else if(lineSplit2[3].equals("����")) {
						oldCount++;
					}
					
					priceSum += Integer.parseInt(lineSplit2[5]);
					
				} else if(lineSplit2[1].equals("��ũ�̿��")) {
					count1P++;
					
					if(lineSplit2[2].equals("1Day")) {
						dayCountP++;
					} else if(lineSplit2[2].equals("After4")) {
						after4CountP++;
					}
					
					if(lineSplit2[3].equals("������")) {
						littleCountP++;
					} else if(lineSplit2[3].equals("����")) {
						babyCountP++;
					} else if(lineSplit2[3].equals("���")) {
						kidCountP++;
					} else if(lineSplit2[3].equals("û�ҳ�")) {
						teenCountP++;
					} else if(lineSplit2[3].equals("����")) {
						adultCountP++;
					} else if(lineSplit2[3].equals("����")) {
						oldCountP++;
					}
					
					priceSumP += Integer.parseInt(lineSplit2[5]);
				}
	
			}
			readLineCount++;
		}
		System.out.println("�����̿�� �� " + count1 + "��");
		System.out.println("1Day : " + dayCount + "�� , After4 : " + after4Count + "��");
		System.out.println("������ " + littleCount + " ���� " + babyCount + " ��� " 
				+ kidCount + " û�ҳ� " + teenCount + " ���� " + adultCount + " ���� " + oldCount);
		System.out.println("�����̿�� �� ���� : " + priceSum + "��");
		System.out.println("");
		System.out.println("��ũ�̿�� �� " + count1P + "��");
		System.out.println("1Day : " + dayCountP + "�� , After4 : " + after4CountP + "��");
		System.out.println("������ " + littleCountP + " ���� " + babyCountP + " ��� " 
				+ kidCountP + " û�ҳ� " + teenCountP + " ���� " + adultCountP + " ���� " + oldCountP);
		System.out.println("��ũ�̿�� �� ���� : " + priceSumP + "��");
		
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
		}
		return 0;
	}

	void companionPossible() {
		System.out.println("���������� ���� �� �ֽ��ϴ�.\n");
	}

}
