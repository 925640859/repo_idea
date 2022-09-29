package com.lagou.controller;


import java.util.Scanner;
public class DaffodilsNum {
     int number, gewei, shiwei, baiwei;
     public void choose(int number) {
             if (number < 0 || number > 1000) {
                         System.out.println("输入的不是 0-1000的数字");
              }
              gewei = number%10;
              shiwei = number/10%10;
              baiwei = number/100;
              if ( ( gewei * gewei * gewei  +  shiwei* shiwei* shiwei + baiwei *baiwei* baiwei ) == number) {
                  System.out.println( number + " 是水仙花数");
              }
              else {
                  System.out.println( number + " 不是水仙花数");
              }
     }

public static void main(String[] args){
             DaffodilsNum Number = new DaffodilsNum();
             System.out.println ( " 请输入 0 - 1000 中间的数字 " ) ; 
             Scanner sc = new Scanner (System.in);
             Number. number = sc.nextInt( ) ;
             Number. choose( Number. number); ;
          }

}