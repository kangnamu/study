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
	public void add_null_�Ǵ�_����() {
		assertEquals(0, cal.add(""));
		assertEquals(0, cal.add(null));

	}
	@Test
	public void add_1�ڸ���() {
		assertEquals(3, cal.add("3"));
	}
	@Test
	public void add_�����ڸ���() {
		assertEquals(6, cal.add("1,2,3"));
		assertEquals(6, cal.add("1:2:3"));
		assertEquals(6, cal.add("1,2:3"));
	}
	@Test
	public void add_������() {
		assertEquals(6, cal.add("//;\n1;2;3"));
		System.out.println(cal.add("//;\n1;2;3"));
	}
	@Test(expected=RuntimeException.class)
	public void add_��������() {
		cal.add("-1,2,3");
	}
	
}