package com.manager.direct.blockchalleng.utils;




import com.manager.direct.blockchalleng.model.enums.IKeyEnum;

import org.slf4j.LoggerFactory;

/**
 * Utils class which provided methods to manipulate Enum
 */
public final class EnumUtils {

	/**
	 * Class logger
	 */
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(EnumUtils.class);

	/**
	 * Get the value of and enum from his key
	 * 
	 * @param pKey
	 *            key to find
	 * @param pClass
	 *            Enum class
	 * @return Enum instance of the specified key or null otherwise
	 */
	@SuppressWarnings("unchecked")
	public static <T extends IKeyEnum> T getValue(final int pKey, final Class<T> pClass) {
		for (IKeyEnum val : pClass.getEnumConstants()) {
			if (val.getKey() == pKey) {
				return (T) val;
			}
		}
		LOGGER.error("Unknow value:" + pKey + " for Enum:" + pClass.getName());
		return null;
	}

	/**
	 * Private constructor
	 */
	private EnumUtils() {
	}
}
