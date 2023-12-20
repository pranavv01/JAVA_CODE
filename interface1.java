import java.util.*;
public class interface1 {

    public static void main(String args[])
    {
        Queen q=new Queen();
        q.moves();
    }
    
}

interface chessplayer 
{
    void moves();
}

class Queen implements chessplayer{
    
    public void moves()
    {
        System.out.println("up,down");
    }
}

class Rook implements chessplayer{
    
    public void moves()
    {
        System.out.println("left,right");
    }
}
class king implements chessplayer{
    
    public void moves()
    {
        System.out.println("u,d,r,l");
    }
}

