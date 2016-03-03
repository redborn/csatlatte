package org.redborn.csatlatte.domain;

public class CountVo {

	private int key;
	private int count;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CountVo [key=" + key + ", count=" + count + "]";
	}

}