package db.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * Class to tess class ClassFields.
 * 
 * @author Mateusz Mucha
 *
 */
public class ClassFieldsTest {
	/**
	 * Testing class with 3 testing parameters to check if method of ClassFields
	 * works well.
	 * 
	 * @author Mateusz Mucha
	 *
	 */
	private static class ClassTest {
		private String stringField;
		private int integerField, count;

		public ClassTest() {
		}
	}

	private ClassTest classTest;

	/**
	 * Method to create new object of ClassTest.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.classTest = new ClassTest();
	}

	/**
	 * Method to test if getCllassFields from ClassFields returned all fields
	 * names from class independent than access type.
	 */
	@Test
	public void getClassFieldsTest() {
		Map<Object, Object> fieldMap = ClassFields.getClassFields(classTest);
		List<Object> objectFields = new ArrayList<Object>();

		assertEquals(3, fieldMap.size());
		for (Object obj : fieldMap.keySet()) {
			objectFields.add(obj);
		}

		assertTrue(objectFields.contains("stringField"));
		assertTrue(objectFields.contains("integerField"));
		assertTrue(objectFields.contains("count"));
	}

}
