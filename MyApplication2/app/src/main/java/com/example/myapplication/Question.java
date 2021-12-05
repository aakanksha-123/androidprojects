package com.example.myapplication;


import androidx.annotation.NonNull;

public class Question {
    String Question;
    String A, B, C, D;
    String Ans;

    public Question(){

    }
public Question(String Question,String A,String B,String C,String D,String Ans){
    this.Question=Question;
    this.A=A;
    this.B=B;
    this.C=C;
    this.D=D;
    this.Ans=Ans;
}
    @NonNull


    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question=Question;
    }
    public String getA(){
        return A;
    }

    public void setA(String a) {
        this.A=a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        this.B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        this.C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        this.D=d;
    }

    public String getAns() {
        return Ans;
    }

    public void setAns(String ans) {
        Ans = ans;
    }
}
