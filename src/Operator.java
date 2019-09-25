class Operator implements Employee
{
    private String name;   // имя
    private Proff profession; // професссия
    private double salary; // зарплата

    static Operator getInstance(String name)
    {
        return new Operator(name);
    }

    private Operator(String name)
    {
        this.name = name;
        this.profession = Proff.OPERATOR;
        this.salary = initSalary();
    }

    @Override // Домашнее задание
    public double getMonthSalary() {
        return salary;
    }

    private double initSalary() {
        return (double)Math.round(Math.random() * 2500000)/100 + 25000;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getProfession() {
        return profession.name;
    }
    @Override
    public String toString()
    {
        return String.format("%-13s%-22s",getName(),getProfession());
    }
}
