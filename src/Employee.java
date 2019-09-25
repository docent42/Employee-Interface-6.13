public interface Employee extends Comparable<Employee>
{

    double getMonthSalary();
    String getName();
    String getProfession();

    default int compareTo(Employee o)
    {
        return Double.compare(getMonthSalary(), o.getMonthSalary());
    }

}
