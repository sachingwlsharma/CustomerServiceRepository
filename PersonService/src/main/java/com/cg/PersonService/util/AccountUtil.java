package com.cg.PersonService.util;

import java.util.Map;

/**
 * 
 * @author sharsaca
 * 
 *
 */

public class AccountUtil {

	public static Integer createId(final Map<Integer,?> idMap) {
		int largestKey = 0;
		
		if (!idMap.entrySet().isEmpty()) {
			Map.Entry<Integer, ?> firstEntry = idMap.entrySet().iterator().next();
			largestKey = firstEntry.getKey();
			
			for (Map.Entry<Integer, ?> map : idMap.entrySet()) {
				int key = map.getKey();
				if (key > largestKey) {
					largestKey = key;
				}
			}
		}

		return largestKey + 1;
	}
}
