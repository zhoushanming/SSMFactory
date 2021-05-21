package cn.edu.usts.cs2018.main;

public class Main {

    public static void main(String[] args) {
	// write your code here
        for(int i=1;i<=20;i++){
            DMSimulator simulator=new DMSimulator(i);
        }
        for(int i=1;i<=15;i++){
            CMSimulator simulator=new CMSimulator(i);
        }
    }
}
