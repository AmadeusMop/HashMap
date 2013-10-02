import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class HashMap2Test {

	@Test
	public void setTest() {
		HashMap2 hashMap = new HashMap2();
		hashMap.set("hello", "world");
		assertEquals(true, hashMap.exists("hello"));
		assertEquals(false, hashMap.exists("Hello"));
		hashMap.set("hello", "goodbye");
		assertEquals("goodbye", hashMap.get("hello"));
	}

	@Test
	public void getTest() {
		HashMap2 hashMap = new HashMap2();
		hashMap.set("hello", "world");
		assertEquals(true, hashMap.exists("hello"));
		assertEquals("world", hashMap.get("hello"));
		assertEquals(false, hashMap.exists("Hello"));
		assertEquals(null, hashMap.get("Hello"));
	}

	@Test
	public void getKeysTest() {
		HashMap2 hashMap = new HashMap2();
		hashMap.set("hello", "world");
		hashMap.set("strawberry", "fields");
		hashMap.set("Mozilla", "Firefox");
		List<String> keysList = Arrays.asList(new String[] {"hello", "strawberry", "Mozilla"});
		Collections.sort(keysList);
		assertEquals(keysList, hashMap.getKeys());
	}
	
	@Test
	public void existsTest() {
		HashMap2 hashMap = new HashMap2();
		hashMap.set("hello", "world");
		hashMap.set("strawberry", "fields");
		hashMap.set("Mozilla", "Firefox");
		assertEquals(true, hashMap.exists("hello"));
		assertEquals(false, hashMap.exists("Hello"));
		assertEquals(true, hashMap.exists("strawberry"));
		assertEquals(false, hashMap.exists("blueberry"));
		assertEquals(true, hashMap.exists("Mozilla"));
		assertEquals(false, hashMap.exists(""));
	}
	
	@Test
	public void sizeTest() {
		HashMap2 hashMap = new HashMap2();
		assertEquals(10, hashMap.size());
		hashMap.set("hello", "world");
		assertEquals(10, hashMap.size());
		
		hashMap = new HashMap2(12);
		assertEquals(12, hashMap.size());
		hashMap.set("strawberry", "fields");
		assertEquals(12, hashMap.size());
		
		hashMap = new HashMap2(30);
		assertEquals(30, hashMap.size());
		hashMap.set("Mozilla", "Firefox");
		assertEquals(30, hashMap.size());
	}
}
