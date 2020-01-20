package com.thw.arithmetic;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.ArrayList;
import java.util.HashMap;

public class CodeTest {
	public static void main(String[] args) {
		String secertyCode = "CHREEVOAHMAERATBIAXXWTNXBEEOPHBSBQMQEQERBWRVXUOAKXAOSXXWEAHBWGJMMQMNKGRFVGXWTRZXWIAKLXFPSKAUTEMNDCMGTSXMXBTUIADNGMGPSRELXNJELXVRVPRTULHDNQWTWDTYGBPHXTFALJHASVBFXNGLLCHRZBWELEKMSJIKNBHWRJGNMGJSGLXFEYPHAGNRBIEQJTAMRVLCRREMNDGLXRRIMGNSNRWCHRQHAEYEVTAQEBBIPEEWEVKAKOEWADREMXMTBHHCHRTKDNVRZCHRCLQOHPWQAIIWXNRMGWOIIFKEE";
		String code = "KCCPKBGUFDPHQTYAVINRRTMVGRKDNBVFDETDGILTXRGUDDKOTFMBPVGEGLTGCKQRACQCWDNAWCRXIZAKFTLEWRPTYCQKYVXCHKFTPONCQQRHJVAJUWETMCMSPKQDYHJVDAHCTRLSVSKCGCZQQDZXGSFRLSWCWSJTBHAFSIASPRJAHKJRJUMVGKMITZHFPDISPZLVLGWTFPLKKEBDPGCEBSHCTJRWXBAFSPEZQNRWXCVYCGAONWDDKACKAWBBIKFTIOVKCGGHJVLNHIFFSQESVYCLACNVRWBBIREPBBVFEXOSCDYGZWPFDTKFQIYCWHJVLNHIQIBTKHJVNPIST";
		char[] chars = code.toCharArray();
		for (int i = 1; i <= chars.length-3; i++) {
			System.out.println();
			for (int j = 1; j <= chars.length-6; j++) {
				char a = chars[i-1];
				char b = chars[i];
				char c = chars[i+1];
				char a1 = chars[j+2];
				char b1 = chars[j+3];
				char c1 = chars[j+4];
				boolean boolean1 = a == a1;
				boolean boolean2 = b == b1;
				boolean boolean3 = c == c1;
				if (boolean1&&boolean2&&boolean3){
					//System.out.print(a1+" "+b1+" "+c1);
					int m = i-j;
					if (m!=3){
						System.out.print(i+" "+j+":");
					}

				}

			}
		}

	}
	// 再次使用重合指数法确定密钥
	public static void decryptCipher(int keyLength, String ciphertext) {
		int[] key = new int[keyLength];
		ArrayList<String> cipherGroup = new ArrayList<>();
		double[] probability = new double[]{0.082, 0.015, 0.028, 0.043, 0.127, 0.022, 0.02, 0.061, 0.07, 0.002, 0.008,
				0.04, 0.024, 0.067, 0.075, 0.019, 0.001, 0.06, 0.063, 0.091, 0.028, 0.01, 0.023, 0.001, 0.02, 0.001};

		// 1 先根据密钥长度分组
		for (int i = 0; i < keyLength; ++i) {
			StringBuilder temporaryGroup = new StringBuilder();
			for (int j = 0; i + j * keyLength < ciphertext.length(); ++j) {
				temporaryGroup.append(ciphertext.charAt(i + j * keyLength));
			}
			cipherGroup.add(temporaryGroup.toString());
		}

		// 2 确定密钥
		for (int i = 0; i < keyLength; ++i) {
			double MG; // 重合指数
			int flag; // 移动位置
			int g = 0; // 密文移动g个位置
			HashMap<Character, Integer> occurrenceNumber; // 字母出现次数
			String subCipher; // 子串

			while (true) {
				MG = 0;
				flag = 65 + g;
				subCipher = cipherGroup.get(i);
				occurrenceNumber = new HashMap<>();

				// 2.1 初始化字母及其次数
				for (int h = 0; h < 26; ++h) {
					occurrenceNumber.put((char) (h + 65), 0);
				}

				// 2.2 统计字母出现次数
				for (int j = 0; j < subCipher.length(); ++j) {
					occurrenceNumber.put(subCipher.charAt(j), occurrenceNumber.get(subCipher.charAt(j)) + 1);
				}

				// 2.3 计算重合指数
				for (int k = 0; k < 26; ++k, ++flag) {
					double p = probability[k];
					flag = (flag == 91) ? 65 : flag;
					double f = (double) occurrenceNumber.get((char) flag) / subCipher.length();
					MG += p * f;
				}

				// 2.4 判断退出条件
				if (MG >= 0.055) {
					key[i] = g;
					break;
				} else {
					++g;
				}
			} // while--end
		} // for--end

		// 3 打印密钥
		StringBuilder keyString = new StringBuilder();
		for (int i = 0; i < keyLength; ++i) {
			keyString.append((char) (key[i] + 65));
		}
		System.out.println("\n密钥为: " + keyString.toString());

		// 4 解密
		StringBuilder plainBuffer = new StringBuilder();
		for (int i = 0; i < ciphertext.length(); ++i) {
			int keyFlag = i % keyLength;
			int change = (int) ciphertext.charAt(i) - 65 - key[keyFlag];
			char plainLetter = (char) ((change < 0 ? (change + 26) : change) + 65);
			plainBuffer.append(plainLetter);
		}
		System.out.println("\n明文为：\n" + plainBuffer.toString().toLowerCase());
	}
}
