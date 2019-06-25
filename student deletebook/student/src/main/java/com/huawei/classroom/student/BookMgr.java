package com.huawei.classroom.student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	   	System.out.println("0. 删 除 图 书");    
	   	System.out.println("1. 退         出 ");
	   	System.out.print("--------------------------------------\n");
	   	System.out.print("请选择： ");
        //输入0时，删除图书；输入1时，则退出
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch(choice){
            case 0://删除图书
                delete();
                break;
            case 1://退出
                //System.out.println("\n谢谢 使 用！");
                break;
        }
    }
    /**
     * 返回主菜单
     */
    public void returnMain(){
        Scanner input = new Scanner(System.in);
		System.out.print("输入0返回：");
        //输入0开始启动菜单，即回到主菜单
        if(input.nextInt() == 0){
            startMenu();
        }
    }
    /**
     * 删除图书
     */
    public void delete(){
		System.out.println("---> 删除图书\n");
    	System.out.print("请输入图书名称： ");
        String name = getInputData();
        //为方便测试用例，抽出一个方法
        deleteBook(name);
        returnMain();
    }
    /**
     * 删除图书核心方法
     */
    public void deleteBook(String name) {
        boolean flag=false;//标识删除成功与否
        //遍历数组，查找匹配信息
        for(int i = 0 ; i < book.name.length; i++){
            //查找到，每个元素前移一位
      		if(/*TODO 判断书籍是否满足删除条件*/name==book.name[i]
               &&book.state[i]==1){
                /*TODO 完成删除操作*/
      			int j=i;
                for(;j<book.name.length;j++){
                    if(book.name[j+1]!=null){
                        book.name[j]=book.name[j+1];
                        book.state[j]=book.state[j+1];
                        book.date[j]=book.date[j+1];
                        book.count[j]=book.count[j+1];
                    }else{
                        break;
                    }
                }
                //最后一个不为空的元素置空
                book.name[j]=null;
                book.date[j]=null;
				System.out.println("删除《"+name+"》成功！");
                flag=true;//置位，表示删除成功
                break;
            }else if(/*TODO 判断查询到的书籍已被借出*/name==book.name[i]
                     &&book.state[i]==0){
				System.out.println("《"+name+"》为借出状态，不能删除！"); 
                flag=true;//置位
                break;
            }
        }
        if(!flag){
			System.out.println("没有找到匹配信息！");
        }
		System.out.println("**************************");
    }
    /**
     * 获得键盘输入
     */
    private String getInputData() {
        Scanner input = new Scanner(System.in);
        //输入图书的名称，用于删除图书
        String name = input.next();
        return name;
    }
}
