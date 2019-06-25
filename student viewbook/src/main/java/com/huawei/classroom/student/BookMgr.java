package com.huawei.classroom.student;

import java.util.Scanner;
public class BookMgr {
	/**
	 * 创建图书对象
	 */
	BookSet book = new BookSet();
	//已借出书籍数量
	private int lendCount = 0;
	//未借出书籍数量
	private int existCount = 0;
	public int getLendCount() {
		return lendCount;
	}
	public int getExistCount() {
		return existCount;
	}
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
	   	 System.out.println("0. 查 看 图 书");	     
	   	 System.out.println("1. 退         出 ");
	   	 
	   	 System.out.print("--------------------------------------\n");
	
	   	 System.out.print("请选择： ");
	   	 Scanner input = new Scanner(System.in);
	   	 int choice = input.nextInt();
	   	 switch(choice){
	   	 	case 0://查询图书
	   	    	search();
	   	    	returnMain();
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
     * 查看图书
     */
    public void search(){
    	System.out.println("---> 查看图书\n");
    	System.out.println("序号\t状 态\t名称\t\t借出日期");
    	//TODO 遍历图书信息并按顺序输出,序号从1开始，如果图书未借出，则借出日期用"----"表示，状态字段用"借出"和"未借出"标识
    	//TODO 打印已借出书籍，并设置lendCount
    	//TODO 打印已未借出书籍，并设置existCount
    	
    	for(int i=1;i<=book.name.length;i++) {
    		if (book.name[i-1]==null) {
    			break;
			}
    		if(book.state[i-1]==0) {
    			System.out.println(i+"\t借出\t"+book.name[i-1]+"\t\t"+book.date[i-1]);
    			lendCount++;
    		}else {
    			System.out.println(i+"\t未借出\t"+book.name[i-1]+"\t\t----");
    			existCount++;
    		}
			
		}
    	System.out.println("**************************"); 
    }
    /**
     * 追加图书
     */    
    public BookSet addNewBook(String name, int count) {
		for(int i = 0; i < book.name.length; i++){   		 
			 if(book.name[i] == null){    //查询最后一个空位置插入
				book.name[i]=name;
				book.state[i]=1;//更改新增的图书可借状态
				book.count[i]=count;
				System.out.println("新增《"+name+"》成功！");
				break;
			 }
		 }
		return book;
	}
}
