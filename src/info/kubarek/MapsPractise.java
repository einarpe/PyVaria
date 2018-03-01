package info.kubarek;

import java.util.HashMap;

public class MapsPractise
{
    public static void main(String[] args) throws Exception
    {
        HashMap<Node, String> map = new HashMap<>();
        
        map.put(new Node(1), "jeden");
        map.put(new Node(2), "dwa");
        map.put(new Node(3), "trzy");
        
        System.out.println(map);
    }
    
    
    static class Node
    {
        public int Value;
        
        public Node(int value)
        {
            Value = value;
        }
        
        public int hashCode()
        {
            return 0;
        }
        
        public boolean equals(Object other)
        {
            return (other instanceof Node) && ((Node)other).Value == Value;
        }
        
        public String toString()
        {
            return String.format("[Node %d]", Value);
        }
    }

}
