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

    //每一次的暂存租金
    private long charge;

    public long getCharge() {
        return charge;
    }

    public void setCharge(long charge) {
        this.charge = charge;
    }

    /**
     * 初始三个图书
     */
    public void initial() {

        book.name[0] = "数据结构";
        book.state[0] = 0;
        book.date[0] = "2018-7-1";
        book.count[0] = 15;

        book.name[1] = "数据库";
        book.state[1] = 1;
        book.count[1] = 12;

        book.name[2] = "离散数学";
        book.state[2] = 1;
        book.count[2] = 30;
    }

    /**
     * 开始菜单
     */
    public void startMenu() {
        System.out.println("欢迎使用图书借阅系统");
        System.out.println("-------------------------------------");
        System.out.println("0. 归 还 图 书");
        System.out.println("1. 退         出 ");

        System.out.print("--------------------------------------\n");

        System.out.print("请选择： ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case 0://归还图书
                returnbook();
                break;
            case 1://退出
                System.out.println("\n谢谢 使 用！");
                break;
        }
    }

    /**
     * 返回主菜单
     */
    public void returnMain() {
        Scanner input = new Scanner(System.in);
        System.out.print("输入0返回：");
        if (input.nextInt() == 0) {
            startMenu();
        } else {
            System.out.println("输入错误, 异常终止！");
        }
    }

    /**
     * 归还图书并计算租金
     */
    public void returnbook() {
        System.out.println("---> 归还图书\n");
        Scanner input = new Scanner(System.in);
        long loan = 0;//租金
        System.out.print("请输入图书名称： ");
        String want = input.next();
        System.out.print("请输入归还日期（年-月-日）：");
        String redate = input.next();
        //为方便测试，抽出方法
        returnbook(want, redate);
        System.out.println("**************************");
        returnMain();
    }

    /**
     * 归还图书并计算租金
     */
    public void returnbook(String want, String redate) {
        //初始化租金
        this.setCharge(0);
        long loan;
        for (int i = 0; i < book.name.length; i++) {
            if (book.name[i] == null) {    //无匹配
                System.out.println("没有找到匹配信息！");
                break;
			 }else if(book.name[i].equals(want)&&book.state[i]==0){  //找到匹配	 
                /*补全归还操作 1.设置为未借出状态 2.计算租金*/
				 book.state[i]=1;
				 loan=charge(book.date[i],redate);
                System.out.println("\n归还《" + want + "》成功!");
                System.out.println("借出日期为：" + book.date[i]);
                System.out.println("归还日期为：" + redate);
                System.out.println("应付租金（元）：" + loan);
                break;
			 }  else if(book.name[i].equals(want)&&book.state[i]==0){ //找到匹配但没有借出
                System.out.println("该图书没有被借出！无法进行归还操作。");
                break;
            }
        }
    }

    /**
     * 计算日期差
     *
     * @param dstr1 第一个日期
     * @param dstr2 第二个日期
     */
    public long charge(String dstr1, String dstr2) {
        long charge = 0;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = sd.parse(dstr1);
            Date d2 = sd.parse(dstr2);
            charge = (d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000);
            this.setCharge(charge);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return charge;
    }
}
