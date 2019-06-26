package com.huawei.classroom.student;

import java.util.*;
public class BookMgr {
	/**
	 * 创建图书对象
	 */
	BookSet book = new BookSet();
	public BookSet getBook() {
		return book;
	}
	/**
	 * 初始三个图书	 
	 */
    public void initial() {
    	
    	book.name[0] = "数据结构";
    	book.state[0] = 0; 
    	book.date[0]="2018-7-1";
    	book.count[0]=15;
    	
    	book.name[1] = "数据库";
    	book.state[1] = 1;  
    	book.count[1]=12;
    	
    	book.name[2] = "离散数学";
    	book.state[2] = 1;
    	book.count[2]=30;
    }	
	/**
	 * 开始菜单
	 */
	public void startMenu(){
		 System.out.println("欢迎使用图书借阅系统");
	   	 System.out.println("-------------------------------------");
	   	 System.out.println("0. 借 出 图 书");    
	   	 System.out.println("1. 退         出 ");
	   	 
	   	 System.out.print("--------------------------------------\n");
	
	   	 System.out.print("请选择： ");
	   	 Scanner input = new Scanner(System.in);
	   	 int choice = input.nextInt();
	   	 switch(choice){
	   	 	case 0://借出图书
	   	    	lend();
	   	    	break;
	   	    case 1://退出
	   	    	System.out.println("\n谢谢 使 用！");
	   	    	break;
	   	 }
    }
	/**
     * 返回主菜单
     */
    public void returnMain(){
   	 Scanner input = new Scanner(System.in); 
   	 System.out.print("输入0返回：");
        if(input.nextInt() == 0){
       	 startMenu();
        }else{
       	 System.out.println("输入错误, 异常终止！");
        }
    }
    /**
     * 借出图书
     */
    public void lend(){
   	 System.out.println("---> 借出图书\n");
   	 Scanner input = new Scanner(System.in);
   	 System.out.print("请输入图书名称： ");
   	 String want = input.next();  //要借出的图书名称 
   	 System.out.print("请输入借出日期（年-月-日）：");
   	 String lendDate = input.next();  //借出日期
   	 //为方便测试，抽出方法
   	 lendBook(want, lendDate);
   	 System.out.println("**************************");
   	 returnMain();
    }
    /**
     * 借出图书核心方法
     */
	public void lendBook(String want, String lendDate) {
		for(int i = 0; i < book.name.length; i++){   		 
			 if(book.name[i] == null){    //无匹配
				 System.out.println("没有找到匹配信息！");
				 break;
			 }else if(book.name[i].equals(want)&&book.state[i]==1){  //找到匹配可借	 
				 /*TODO 补全借出操作*/
				 book.count[i]++;
				 book.state[i]=0;
				 book.date[i]=lendDate;
				 break;
			 }else if(book.name[i].equals(want)&&book.state[i]==0){  //找到匹配已被借出 			
				 System.out.println("《"+want+"》已被借出！");
				 break;
			 }   		 
		 }
	}
}
