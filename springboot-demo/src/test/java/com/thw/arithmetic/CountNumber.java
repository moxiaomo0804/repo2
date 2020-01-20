package com.thw.arithmetic;

import com.poi.Member;

import javax.xml.bind.ValidationEvent;
import java.util.*;

public class CountNumber {
	public static void main(String[] args) {
		String one = "KCCPKBGUFDPHQTYAVINRRTMVGRKDNBVFDETDGILTXRGUDDKOTFMBPVGE";
		String two = "GLTGCKQRACQCWDNAWCRXIZAKFTLEWRPTYCQKYVXCHKFTPONCQQRHJVAJ";
		String three = "UWETMCMSPKQDYHJVDAHCTRLSVSKCGCZQQDZXGSFRLSWCWSJTBHAFSIAS";
		String oldOne = "CHREEVOAHMAERATBIAXXWTNXBEEOPHBSBQMQEQERBWRVXUOAKXAOSXXWEAHBWG";
		String four = "PRJAHKJRJUMVGKMITZHFPDISPZLVLGWTFPLKKEBDPGCEBSHCTJRWXBAF";
		String five = "SPEZQNRWXCVYCGAONWDDKACKAWBBIKFTIOVKCGGHJVLNHIFFSQESVYCL";
        String six = "ACNVRWBBIREPBBVFEXOSCDYGZWPFDTKFQIYCWHJVLNHIQIBTKHJVNPIST";
		Map<Character, Integer> map = new HashMap<>();
		char[] chars = six.toCharArray();
		int coutn = 0;
		for (int i = 0; i < chars.length; i++) {

			if (map.get(chars[i])==null){
				map.put(chars[i],coutn+1);
			}else {
				map.put(chars[i],map.get(chars[i])+1);
			}
		}
		Set<Map.Entry<Character, Integer>> entries = map.entrySet();
		Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
		int sum = 0;
		while (iterator.hasNext()) {
			Map.Entry<Character, Integer> next = iterator.next();
			Integer value = next.getValue();
			Double aDouble = Double.valueOf(value);
			System.out.println(aDouble/62.0);
			sum +=aDouble;
		}
		System.out.println(sum);
		System.out.println(map);
		Object object = new Object();
	}
}
