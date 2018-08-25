package db.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

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
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				fieldMap.put(fields[i].getName(), fields[i].get(objectToRetrieveFields));
			}

			object = objectToRetrieveFields.getClass().getSuperclass();
			fields = object.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				fieldMap.put(fields[i].getName(), fields[i].get(objectToRetrieveFields));
			}
		} catch (IllegalArgumentException e) {
			Logger.getLogger(ClassFields.class).error(ExceptionDescription.CLASS_FIELDS_ARGUMENT.fullDescription());
		} catch (IllegalAccessException e) {
			Logger.getLogger(ClassFields.class).error(ExceptionDescription.CLASS_FIELDS_ACCESS.fullDescription());
		} catch (SecurityException e) {
			Logger.getLogger(ClassFields.class).error(ExceptionDescription.CLASS_FIELDS_SECURITY.fullDescription());
		}

		return fieldMap;
	}
}