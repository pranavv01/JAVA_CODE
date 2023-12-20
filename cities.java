import java.util.Scanner;

 class lab4 {

public void show1()
{
    System.out.println("earth have land and water");
}
    
}

class Land extends lab4
{
    void show2()
    {
        System.out.println("Land associte with earth and have continent,country,states");
    }
}

class water extends lab4
{
    void show3()
    {
        System.out.println("Water associte with earth");

    }
}

class conti extends Land
{
    void show4()
    {
        System.out.println("continent associte with land");

    }
}

class countary extends Land
{
    void show5()
    {
        System.out.println("country");

    }
}
class states extends Land
{
    void show6()
    {
        System.out.println("states");

    }
}
class cities extends states
{
    void show7()
    {
        System.out.println("cities");

    }

    public static void main(String [] args){
        
       
         Land f=new Land();
        f.show1();
        f.show2();

        water e=new water();
        e.show1();
        e.show3();

        conti b=new conti();
        b.show2();
        b.show4();

        countary c=new countary();
        c.show2();
        c.show5();

         states d=new states();
        d.show2();
        d.show6();

         cities a = new cities();
        a.show6();
        a.show7();


    }
}


