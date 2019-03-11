package stringcaltest;

import static org.junit.Assert.*;

import stringcal.stringcal;
import org.junit.Before;
import org.junit.Test;

public class stringcaltest {
	private stringcal cal;
	
	@Before
	public void setUp(){
		cal = new stringcal();
	}

	@Test
	public void add_null_또는_빈문자() {
		assertEquals(0, cal.add(""));
		assertEquals(0, cal.add(null));

	}
	@Test
	public void add_1자리수() {
		assertEquals(3, cal.add("3"));
	}
	@Test
	public void add_여러자리수() {
		assertEquals(6, cal.add("1,2,3"));
		assertEquals(6, cal.add("1:2:3"));
		assertEquals(6, cal.add("1,2:3"));
	}
	@Test
	public void add_구분자() {
		assertEquals(6, cal.add("//;\n1;2;3"));
		System.out.println(cal.add("//;\n1;2;3"));
	}
	@Test(expected=RuntimeException.class)
	public void add_음수예외() {
		cal.add("-1,2,3");
	}
	
}