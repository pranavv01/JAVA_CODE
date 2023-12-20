import java.util.Scanner;

class inhe
{
 void show1()
 {
	System.out.println("hello");

 }
}

class inhe1 extends inhe
{
 void show2()
 {
	System.out.println("hello world");

 
 }
}
class prac extends inhe1
{
 void show3()
 {
	System.out.println("hello qwe");

 } 


public static void main(String k[])
{
	prac s=new prac();
	s.show1();
	s.show2();
    s.show3();
}

}
