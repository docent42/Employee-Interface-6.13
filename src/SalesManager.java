public class SalesManager extends Employee

{
    private double salary; // зарплата

    public static SalesManager getInstance(String name)
    {
        return new SalesManager(name,(double)Math.round(Math.random() * 50000000)/100 + 1000000);
    }

    private SalesManager(String name,double money)// конструктор
    {
        this.name = name;
        this.profession = Proff.SALES_MANAGER;
        this.salary = initSalary(money);
    }

    @Override // Домашнее задание
    public double getMonthSalary() {
        return salary;
    }

    @Override // создание зарплаты (у каждого свой метод)
    double initSalary(double money)
    {
        double fix, bonus;
        fix = (double)Math.round(Math.random() * 2500000)/100 + 25000;
        bonus = money * 0.05;
        return fix + bonus;
    }

    @Override // реализация Comparable
    public int compareTo(Employee o) {
        return Double.compare(getMonthSalary(),o.getMonthSalary()) ;
    }
}
