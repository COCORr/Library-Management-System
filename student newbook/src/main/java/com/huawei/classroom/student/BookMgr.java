package com.huawei.classroom.student;

import java.util.Scanner;
public class BookMgr {
	/**
	 * 创建图书对象
	 */
	BookSet book = new BookSet();
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
	   	 System.out.println("0. 新 增 图 书");     
	   	 System.out.println("1. 退         出 ");
	   	 
	   	 System.out.print("--------------------------------------\n");
	
	   	 System.out.print("请选择： ");
	   	 Scanner input = new Scanner(System.in);
	   	 int choice = input.nextInt();
	   	 switch(choice){
	   	 	case 0://新增图书
	   	    	add();
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
     * 新增图书
     */
    public void add(){
     //为方便测试，拆分方法为键盘输入方法和核心追加书籍方法
     String name = getInputData();
   	 addBook(name);
   	 System.out.println("**************************");
   	 returnMain();
    }
    /**
     * 追加图书
     */    
    public BookSet addBook(String name) {
		for(int i = 0; i < book.name.length; i++){   		 
	   		 if(/*TODO 1.判断待插入信息在数组中位置*/book.name[i]==null){    
	    		//TODO 2.完成新增动作
	   			 book.name[i]=name;
	   			 book.state[i]=1;
				System.out.println("新增《"+name+"》成功！");
				break;
			 }
		 }
		return book;
	}
    /**
     * 键盘输入数据
     */
	private String getInputData() {
		Scanner input = new Scanner(System.in);
		 System.out.println("---> 新增图书\n");    	
		 System.out.print("请输入图书名称： ");
		 String name = input.next();
		return name;
	}
}
