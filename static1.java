public class static1 {
    public static void main(String args[])
    {
        std s1 = new std();
        s1.SchoolName = "JVM";

        std s2 = new std();
        s2.SchoolName = "abc";
        
        System.out.println(s2.SchoolName);
        System.out.println(s1.SchoolName);
        
        
    }
}

class std{
    String name;
    int roll;

    static String SchoolName;

    void setName(String name)
    {
        this.name = name;
    }
    String getName(){
            return this.name; 
    }
    
    
}