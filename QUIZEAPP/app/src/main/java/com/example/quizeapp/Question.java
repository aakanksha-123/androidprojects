package com.example.quizeapp;

public class Question {
   public String id;
    public String que;
    public   String op1,op2,op3,op4,op5;

public Question(){}

    public Question(String idno,String q,String a,String b,String c,String d,String ans){   //String idno
        id=idno;
        que=q;
        op1=a;
        op2=b;
        op3=c;
        op4=d;
        op5=ans;
    }

    public String getId() {
       return id;
    }


    public String getQue() {
        return que;
    }

    public String getOp1() {
        return op1;
    }

    public String getOp2() {
        return op2;
    }

    public String getOp3() {
        return op3;
    }

    public String getOp4() {
        return op4;
    }

    public String getOp5() {
        return op5;
    }


}
