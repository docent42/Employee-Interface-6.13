public abstract class Employee implements Salary,Comparable<Employee>
{
    String name;   // имя
    Proff profession; // професссия

    abstract double initSalary(double money);// генератор зарплаты

}
