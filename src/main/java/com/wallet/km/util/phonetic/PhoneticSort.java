package com.wallet.km.util.phonetic;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

public class PhoneticSort {
	
	public static void main(String[] args) {
		String[] arrays = new String[] { "gyu", "sdf", "zf", "大同", "收到", "地方", "三等分", "的人", "反对高铁", "泛代数", "上的投入", "和国家" };
		/*设置语言环境*/
		Comparator<Object> com = Collator.getInstance(java.util.Locale.CHINA);
		Arrays.sort(arrays, com);
		for (String item:arrays) {
		 System.out.print(item+" ");
		}
	}

}
