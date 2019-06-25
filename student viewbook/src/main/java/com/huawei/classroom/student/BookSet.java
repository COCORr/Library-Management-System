package com.huawei.classroom.student;

public class BookSet {
	String[] name = new String[50];   //数组1存储图书名称数组
    int[] state = new int[50];        //数组2存储图书借出状态：0已借出/1可借
    String[] date=new String[50];     //数组3存储图书借出日期
    int[] count=new int[50];         //如果状态为0，则表示已借出图书数量，状态为1，则表示可借出图书数量。
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
	public int[] getState() {
		return state;
	}
	public void setState(int[] state) {
		this.state = state;
	}
	public String[] getDate() {
		return date;
	}
	public void setDate(String[] date) {
		this.date = date;
	}
	public int[] getCount() {
		return count;
	}
	public void setCount(int[] count) {
		this.count = count;
	}
   
}
