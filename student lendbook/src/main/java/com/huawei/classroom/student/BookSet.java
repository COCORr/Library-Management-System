package com.huawei.classroom.student;

public class BookSet {
	String[] name = new String[50];   //数组1存储图书名称数组
    int[] state = new int[50];        //数组2存储图书借出状态：0已借出/1可借
    String[] date=new String[50];     //数组3存储图书借出日期
    int[] count=new int[50];         //借出次数
	public String[] getName() {
		return name;
	}
	public int[] getState() {
		return state;
	}
	public String[] getDate() {
		return date;
	}
	public int[] getCount() {
		return count;
	}
   
}
