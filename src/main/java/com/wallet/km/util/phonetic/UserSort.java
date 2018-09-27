package com.wallet.km.util.phonetic;

public class UserSort implements Comparable<UserSort>{
	
	private String id;
	
	private String nickName;
	
	

	public UserSort() {
		super();
	}
	
	

	public UserSort(String id, String nickName) {
		super();
		this.id = id;
		this.nickName = nickName;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



	@Override
	public int compareTo(UserSort o) {
		
		String str1 = PhoneticUtil.getAlphabet(nickName);
		String str2 = PhoneticUtil.getAlphabet(o.nickName);
		return str1.compareTo(str2);
	}
	
	
	
	

}
