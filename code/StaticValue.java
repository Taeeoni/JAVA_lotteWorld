package LotteTicket;

public class StaticValue {
	// 종합이용권 가격
	static final int ALL_1D_ADULT = 62000, ALL_1D_TEEN = 54000, ALL_1D_KID = 47000, ALL_1D_BABY = 15000;
	static final int ALL_A4_ADULT = 50000, ALL_A4_TEEN = 43000, ALL_A4_KID = 36000, ALL_A4_BABY = 15000;

	// 파크이용권 가격
	static final int PARK_1D_ADULT = 59000, PARK_1D_TEEN = 52000, PARK_1D_KID = 46000, PARK_1D_BABY = 15000;
	static final int PARK_A4_ADULT = 47000, PARK_A4_TEEN = 41000, PARK_A4_KID = 35000, PARK_A4_BABY = 15000;

	// 주민등록번호 분석
	static final int OLD_GENERATION = 19000000, NEW_GENERATION = 20000000;

	// 나이에 따른 범위
	static final int MIN_BABY = 1, MIN_KID = 3, MIN_TEEN = 12, MIN_ADULT = 18, MIN_OLD = 65;

	// 할인율
	static final double DISABLED = 0.5, NATIONAL_MERIT = 0.5, SOLDIER = 0.49, PREGNANT = 0.5, MANY_CHILDREN = 0.3;
}
