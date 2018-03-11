import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
	
	private String[] falseRoyalFlush = {"AH", "KH", "JH", "QH", "TH"};
	private String[] falseStraightFlush = {"4H", "5H", "6H", "7H", "8H"};
	private String[] falseFour = {"4H", "4D", "4C", "7S", "4S"};
	private String[] falseFullHouse = {"4H", "4D", "4C", "5S", "5H"};
	private String[] falseFlush = {"2H", "5H", "KH", "7H", "8H"};
	private String[] falseStraight = {"4D", "5H", "6S", "7H", "8C"};
	private String[] falseThree = {"4H", "4D", "4C", "5S", "7H"};
	private String[] falseTwoPair = {"4H", "4D", "7C", "5S", "5H"};
	private String[] falsePair = {"KH", "7D", "2C", "5S", "5H"};
	private String[] falseHighCard = {"4H", "2D", "KD", "QC", "TH"};

	@Test
	public final void testStraight() {
		String handResult = Solution.main(falseStraight);
		assertEquals("straight", handResult, "4D, 5H, KH, 7H, 8C should return 'straight'");
	}
	@Test
	public final void testStraightFlush() {
		String handResult = Solution.main(falseStraightFlush);
		assertEquals("straight flush", handResult, "4H, 5H, 6H, 7H, 8H should return 'straight flush'");
	}
	@Test
	public final void testRoyalFlush() {
		String handResult = Solution.main(falseRoyalFlush);
		assertEquals("royal flush", handResult, "AH, KH, JH, QH, TH should return 'royal flush'");
	}
	@Test
	public final void testFourOfAKind() {
		String handResult = Solution.main(falseFour);
		assertEquals("four of a kind", handResult, "4H, 4D, 4C, 7S, 4S should return 'four of a kind'");
	}
	@Test
	public final void testThreeOfAKind() {
		String handResult = Solution.main(falseThree);
		assertEquals("three of a kind", handResult, "4H, 4D, 4C, 5S, 7H should return 'three of a kind'");
	}
	@Test
	public final void testFlush() {
		String handResult = Solution.main(falseFlush);
		assertEquals("flush", handResult, "2H, 5H, KH, 7H, 8H should return 'flush'");
	}
	@Test
	public final void testFullHouse() {
		String handResult = Solution.main(falseFullHouse);
		assertEquals("full house", handResult, "4H, 4D, 4C, 5S, 5H should return 'full house'");
	}
	@Test
	public final void testTwoPair() {
		String handResult = Solution.main(falseTwoPair);
		assertEquals("two pair", handResult, "4H, 4D, 7C, 5S, 5H should return 'two pair'");
	}
	@Test
	public final void testPair() {
		String handResult = Solution.main(falsePair);
		assertEquals("pair", handResult, "KH, 7D, 2C, 5S, 5H should return 'pair'");
	}
	@Test
	public final void testHighCard() {
		String handResult = Solution.main(falseHighCard);
		assertEquals("high card", handResult, "4H, 2D, KD, QC, TH should return 'high card'");
	}

}
