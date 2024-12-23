package com.dairy.app.exceptions;


public class DairyExceptionAsserts {

	
	public static void notNullorEmpty(String orgumentValue, String orgumentName) throws DairyServiceExceptions {
		if (orgumentValue == null || orgumentValue.isEmpty()) {
			throw new DairyServiceExceptions(orgumentName + " should not be null or empty");
		}
	}

	/**
	 * Not nullor empty.
	 *
	 * @param object       the object
	 * @param orgumentName the orgument name
	 * @throws DairyServiceExceptions the dairy  service exception
	 */
	public static void notNullorEmpty(Object object, String orgumentName) throws DairyServiceExceptions {
		if (object == null) {
			throw new DairyServiceExceptions(orgumentName);
		}
	}

	/**
	 * Not nullor empty.
	 *
	 * @param size         the size
	 * @param orgumentName the orgument name
	 * @throws DairyServiceExceptions the dairy service exception
	 */
	public static void notNullorEmpty(int size, String orgumentName) throws DairyServiceExceptions {
		if (size == 0) {
			throw new DairyServiceExceptions(orgumentName + "not found");
		}
	}
}
