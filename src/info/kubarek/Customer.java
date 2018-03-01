package info.kubarek;


public class Customer
{
   public Customer(String firstName, String lastName, int age, int salary)
   {
      FirstName = firstName;
      LastName = lastName;
      Age = age;
      Salary = salary;
      Email = firstName + "." + lastName + "@example.com";
   }

   public String FirstName;
   
   public String LastName;
   
   public int Age;
   
   public int Salary;
   
   public String Email;
   
   public String toString()
   {
      return String.format("[%s %s %d %d %s]", FirstName, LastName, Age, Salary, Email);
   }
   
}
