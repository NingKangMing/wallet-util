package com.wallet.km.util.phonetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneticSortTest {

	/**
	 * 将字符串数字按首字母先后进行排序 
	 * 
	 * Java原生排序为 数字->英文->中文 
	 * 为了将英文和中文首字母相同的排列到一起 
	 * 先将字符串首字符为汉字的改为该汉字的首字母加上该字符串 
	 * 为了以示区分中间再加一个分割符& 
	 * 然后使用Java原生排序算法 
	 * 再将包含&字符的字符串中的&和首字母去除从而达到排序目的 
	 * */
	public static void main(String[] args) { 
		
		//对字符数组的拼音排序
		// String[] arrays = new String[] { "gyu", "sdf", "zf", "大同", "收到", "地方", "三等分", "的人", "反对高铁", "泛代数", "上的投入", "和国家" };
		//PhoneticUtil.sortByPhonetic(arrays);
		
		//对对象的拼音排序【只根据首字符来排序】
		List<UserSort> list=new ArrayList<>();
		list.add(new UserSort("2","大同"));
		list.add(new UserSort("7","曾经"));
		list.add(new UserSort("7","ef"));
		list.add(new UserSort("1","收到"));
		list.add(new UserSort("3","和国家"));
		//UserSort[] userarr=new UserSort[list.size()];
		//list.toArray(userarr);
		//PhoneticUtil.sortByPhonetic1(userarr);
		/*Collections.sort(list);
		for (UserSort userSort : list) {
			System.out.println(userSort.getNickName());
		}*/
	}


}
