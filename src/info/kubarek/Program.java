package info.kubarek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Program
{
    abstract static class Decorator
    {
        Decorator parent;
        
        public Decorator(Decorator parent)
        {
            this.parent = parent;
        }
        
        public abstract void doThat();
    }
    
    static class BaseFunc extends Decorator 
    {
        public BaseFunc()
        {
            super(null);
        }
        
        public void doThat()
        {
            System.out.println("BaseFunc::doThat");
        }
    }
    
    static class SuperBase extends Decorator
    {
        public SuperBase(Decorator parent)
        {
            super(parent);
        }

        public void doThat()
        {
            System.out.println("-------------SUPER!-----------");
            parent.doThat();
            System.out.println("------------------------------");
        }
    }
    
    
    static
    {
        System.out.println("Program static init");
    }
    
    private Program()
    {
        //throw new NullPointerException("siakis blad");
    }
    
    int s = 1;
    
    public static int add(int a, int b)
    {
        List<Object> lst = Collections.nCopies(a, new Object());
        lst.addAll(Collections.nCopies(b, new Object()));
        return lst.size();
    }
    
    public static Program getProgram()
    {
        System.out.println("Calling getProgram... ");
        return Holder.prog;
    }
    
    private void mainImpl()
    {
        System.out.println("Main implementation");
    }
    
    static ArrayList<Character> permResult = new ArrayList<Character>();
    
    static List<Character> permute(String text)
    {
        if (text.length() == 1)
        {
            permResult.add(text.charAt(0));
        }
        else if (text.length() == 2)
        {
            permResult.add(text.charAt(0));
            permResult.add(text.charAt(1));
        }
        else
        {
            permResult.add(text.charAt(0));
            permute(text.substring(1));
        }
        
        return permResult;
    }
    
    
    int dox(int a) { return 0; }
    
    double dox(int a, int b) { return 0.0; }
    

   public static void main(String[] args)
   {
       
       
       
       //System.out.println(add(3, 9));
//       
//       BaseFunc bf = new BaseFunc();
//       bf.doThat();
//       
//       System.out.println();
//       
//       
//       
//       SuperBase sb = new SuperBase(bf);
//       sb.doThat();
//       
//       
//       System.out.println("Permute!");
//       System.out.println(permute("qwerty"));
       
       /*
       
       try
       {
           Program prog = getProgram();
           prog.mainImpl();
       }
       catch (Throwable e)
       {
           System.out.println(e);
       }
       
       try
       {
           Program prog = getProgram();
           prog.mainImpl();
       }
       catch (Throwable e)
       {
           System.out.println(e);
       }
       
       */
       
       
      /*
      List<Customer> customerList = new ArrayList<Customer>();
      customerList.add(new Customer("Jan", "Kowalski", 87, 3000));
      customerList.add(new Customer("Antoniusz", "Wielki", 35, 23001));
      customerList.add(new Customer("Anna", "Kowalska", 91, 1000));
      customerList.add(new Customer("Jerzy", "Królewicz", 10, 0));
      customerList.add(new Customer("Katarzyna", "Wielka", 50, 11000));
      customerList.add(new Customer("Michał", "Kędzierzawy", 25, 400));
      
      String customers1 = customerList.stream()
        .filter(c -> c.Salary == 0)
        .map(c -> c.toString())
        .collect(Collectors.joining("\r\n"));
      System.out.println(customers1);
      
      
      int[] tempTable = new int[2000000];
      Random rnd = new Random();
      for (int i = 0; i < tempTable.length; i++)
         tempTable[i] = (int)(rnd.nextGaussian() * 1000);
      
      System.out.println(Arrays.stream(tempTable).filter(a -> a > 0).min().getAsInt());
      System.out.println(Arrays.stream(tempTable).filter(a -> a < 0).max().getAsInt());
      
      
      // Function<Integer, Boolean> grp = (Integer x) -> x % 10 == 0;
      
      System.out.println(Arrays.stream(tempTable).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
      */
       /*
       List<String> stringListA = new ArrayList<String>();
       List<String> stringListB = new ArrayList<String>();

       ArrayBuilder.addToList(stringListA, "Seven", "Eight", "Nine");
       ArrayBuilder.addToList(stringListB, "Ten", "Eleven", "Twelve");
       
       List<List<String>> listOfStringLists = new ArrayList<List<String>>();
       ArrayBuilder.addToList(listOfStringLists, stringListA, stringListB);

       ArrayBuilder.faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));
      */
   }
   
   
   private static class Holder
   {
       static
       {
           System.out.println("Holder static init");
       }
       public static final Program prog = new Program();
   }
   
   
   static List<?> doSth(List<?> lista)
   {
       return lista;
   }
   
   static <T> List<T> doSth1(List<T> lista)
   {
       if (lista instanceof ArrayList)
           return Collections.emptyList();
       return lista;
   }
           
   public static class ArrayBuilder {

       public static <T> void addToList (List<T> listArg, T... elements) {
         Object[] o = elements;
         o[0] = 1;
         for (T x : elements) {
           listArg.add(x);
         }
       }

       public static void faultyMethod(List<String>... l) {
         Object[] objectArray = l;     // Valid
         objectArray[0] = Arrays.asList(42);
         String s = l[0].get(0);       // ClassCastException thrown here
         System.out.println(s);
       }

     }

}
