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
    	
    	book.name[3] = "计算机基础";
    	book.state[3] = 1;
    	book.count[3]=2;
    }	
	/**
	 * 开始菜单
	 */
	public void startMenu(){
		 System.out.println("欢迎使用图书借阅系统");
	   	 System.out.println("-------------------------------------");
	   	 System.out.println("0. 借出排行榜");     
	   	 System.out.println("1. 退         出 ");
	   	 
	   	 System.out.print("--------------------------------------\n");
	
	   	 System.out.print("请选择： ");
	   	 Scanner input = new Scanner(System.in);
	   	 int choice = input.nextInt();
	   	 switch(choice){
	   	 	case 0://借出排行榜
	   	    	list();
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
     * 借出排行榜
     */
    public String[] list(){
    	//定义新数组，用来存放排序后图书信息
        String[] newname = new String[50];      
        int[] newcount=new int[50]; 

        for(int k=0;k<book.name .length;k++){
        	 newname[k]=book.name[k];
             newcount[k]=book.count[k];
        }
          	
    	//利用冒泡排序算法进行排序
    	for(int i=0;i<newname.length;i++){
    		for(int j=i+1;j<newname.length;j++){
    			if(newcount[i]>newcount[j]){
    				//TODO 通过数组操作完成顺序交替
    				int temp;
    				temp=newcount[i];
    				newcount[i]=newcount[j];
    				newcount[j]=temp;
    				String tempname;
    				tempname=newname[i];
    				newname[i]=newname[j];
    				newname[j]=tempname;
    		 	}    			
    		}    		
    	}
    	System.out.println("---> 排行榜\n");
    	System.out.println("**************************");
    	System.out.println("次数\t名称");
    	//显示排行榜信息
    	for(int i=newname.length-1;i>=0;i--){
    		if(newname[i]!=null){
				System.out.println(newcount[i]+"\t<<"+ newname[i]+ ">>" );
    		}
    	}
      	 System.out.println("**************************");
      	 //returnMain();
      	 return newname;
       }
}
