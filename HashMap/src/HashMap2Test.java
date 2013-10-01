import static org.junit.Assert.*;

import org.junit.Test;


public class HashMap2Test {

	@Test
	public void setTest() {
		HashMap2 hashMap = new HashMap2();
		hashMap.set("hello", "world");
		assertEquals(true, hashMap.contains("hello"));
		assertEquals(false, hashMap.contains("Hello"));
	}

}
