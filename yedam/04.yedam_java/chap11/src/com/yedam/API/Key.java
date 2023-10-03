package com.yedam.API;

public class Key {
	public int key;
	
	public Key(int key) {
		this.key = key;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key) {
			Key compare = (Key)obj;
			if(this.key == compare.key) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return key; //숫자의 해시코드
	}
}
