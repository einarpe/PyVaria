package info.kubarek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrentPractise
{
    
    static int baseSteps = 1000;

    public static void main(String[] args) throws Exception
    {
        assert(args != null);
        
        // TODO Auto-generated method stub
        final int THREADZ = 1000;
        List<Thread> threads = new ArrayList<Thread>(THREADZ);
        for (int i = 0; i < THREADZ; i++)
        {
            Thread t = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        ConcurrentPractise cp = new ConcurrentPractise();
                        Thread a = new Thread(cp::adder);
                        Thread b = new Thread(cp::subtracter);
                        a.start();
                        b.start();
                        a.join();
                        b.join();
                        
                        if (cp.value != 0)
                            throw new Exception("Some value is " + cp.value + "!");
                    }
                    catch (Exception ex)
                    {
                        System.out.println(ex);
                    }
                }
            });
            threads.add(t);
        }
        
        System.out.println("Starting.");
        
        for (Thread x : threads)
            x.start();
        
        for (Thread x : threads)
            x.join();
        
        System.out.println("Done.");
        
    }
    
    public static <T> void exchange(T[] array, int pos1, int pos2) 
    {
        T tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;
    }
    
    public static void print(List<? extends Number> list) 
    {
        for (Number n : list)
            System.out.print(n + " ");
        System.out.println();
    }
    
    int steps = 100; // (int)(Math.random() * 1000 + 5000);
    
    void adder()
    {
        for (int i = 0; i < steps; i++)
        {
//            value++;
            synchronized(this) 
            {
                value++;
            }
        }
    }
    
    void subtracter()
    {
        for (int i = 0; i < steps; i++)
        {
//            value--;
            synchronized(this) 
            {
                value--;
            }
        }
    }
    
    
    int value = 0;

}
