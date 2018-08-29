package db.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.jboss.logging.Logger;

import db.exception.ExceptionDescription;

/**
 * Class to get all fields from class.
 * 
 * @author Mateusz Mucha
 *
 */
public final class ClassFields {
	/**
	 * Method to get all fields and their values from specific class and
	 * superclass.
	 * 
	 * @param objectToRetrieveFields
	 *            class object to retrieve fields
	 * @return fields and their values map
	 * @throws IllegalArgumentException
	 *             The specified object is not an instance of the class or
	 *             interface declaring the underlying field. Possible problem
	 *             with superclass.
	 * @throws IllegalAccessException
	 *             Field of object is enforcing Java language access control and
	 *             the underlying field is inaccessible.
	 */
	public static Map<Object, Object> getClassFields(final Object objectToRetrieveFields) {
		Class<?> object = objectToRetrieveFields.getClass();
		Map<Object, Object> fieldMap = new HashMap<Object, Object>();

		try {
			Field[] fields = object.getDeclaredFields();
			putRetrievedFieldsIntoMap(objectToRetrieveFields, fieldMap, fields);

			object = objectToRetrieveFields.getClass().getSuperclass();
			fields = object.getDeclaredFields();
			putRetrievedFieldsIntoMap(objectToRetrieveFields, fieldMap, fields);
		} catch (IllegalArgumentException e) {
			Logger.getLogger(ClassFields.class).error(ExceptionDescription.CLASS_FIELDS_ARGUMENT.fullDescription());
		} catch (SecurityException e) {
			Logger.getLogger(ClassFields.class).error(ExceptionDescription.CLASS_FIELDS_SECURITY.fullDescription());
		}

		return fieldMap;
	}

	/**
	 * Method to filtering and put all found fields into map.
	 * 
	 * @param objectToRetrieveFields
	 *            class object to retrieve fields
	 * @param fieldMap
	 *            fields and their values map
	 * @param fields
	 *            existing fields in passed object to retrieve these fields
	 */
	private static void putRetrievedFieldsIntoMap(final Object objectToRetrieveFields, Map<Object, Object> fieldMap, Field[] fields) {
		Stream.of(fields).filter(field -> !"serialVersionUID".equals(field.getName())).forEach(field -> {
			try {
				field.setAccessible(true);
				fieldMap.put(field.getName(), field.get(objectToRetrieveFields));
			} catch (IllegalAccessException e) {
				Logger.getLogger(ClassFields.class).error(ExceptionDescription.CLASS_FIELDS_ACCESS.fullDescription());
			}
		});
	}
}