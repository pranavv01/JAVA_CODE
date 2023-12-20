public class oop1 {
    public static void main(String args[])
    {
        Pen p1=new Pen();
        p1.setColor("Blue");
        System.out.println(p1.color);
        p1.setTips(5);
        System.out.println(p1.tip);

    }

}
 
class Pen
{
    String color;
    int tip;
    void setColor(String newColor)
    {
        color=newColor;
    }
        void setTips(int newTips)
    {
        tip=newTips;
    }
}

class std
{
     String name;
     int age;
     float percentage;

     void calcPercent(int s1,int s2,int s3)
     {
        percentage=(s1+s2+s3)/3;
     }
}