import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Company
{
    private double monthlyIncome;// поле для расчета зарплаты у Топ менеджера
    private TreeMap<Integer,Employee> staff = new TreeMap<>(); // список сотрудников
    private int empCount;


    private Company (int empCount)
    {
        this.empCount = empCount;
    }
    static Company getInstance(int empCount) throws IOException
    {
        Company company = new Company(empCount);
        company.init();
        return company;
    }

    private void init() throws IOException // заряжаем компанию сотрудниками
    {
        monthlyIncome = (double)Math.round(Math.random() * 1000000000)/100 + 5000000;
        ArrayList<String> nameBase = new ArrayList<>(nameBase()); // читаем базу 270 фамилий из txt
        String surname;

        for (int i = 1; i <= empCount; i++)
        {
            surname = nameBase.get((int)(Math.random() * nameBase.size()));
            int rnd = random(); // кто у нас будет ???
            if (rnd < 3) addEmployee(Proff.TOP_MANAGER,i,surname); // топ менеджер родился
            else
            {
                rnd = random();
                if (rnd < 5) addEmployee(Proff.SALES_MANAGER,i,surname);// продажник родился
                else addEmployee(Proff.OPERATOR,i,surname); // Свободная касса !!!
            }
        }
    }

    private void addEmployee(Proff prof, int key, String name)// универсальный наниматель сотрудников
    {
        switch (prof)
        {
            case TOP_MANAGER: { staff.put(key, TopManager.getInstance(name,monthlyIncome)); break; }
            case SALES_MANAGER:{ staff.put(key, SalesManager.getInstance(name));break; }
            case OPERATOR:  { staff.put(key, Operator.getInstance(name)); }
        }
    }

    public void fireEmployee(int key) // не реализована в main но по условию ДЗ быть должна
    {
        staff.remove(key); // кого уволить можно узнать посмотрев весь список сотрудников
    }

    public void listStuff() // вывод всего штата списком по порядку личных номеров
    {
        for (Integer k : staff.keySet())
            {
                System.out.printf("%n%03d %s %,.2f",k,
                        staff.get(k).toString(),
                        staff.get(k).getMonthSalary());
            }
    }

    public void getLowestSalaryStaff(int count) // домашнее задание
    {
        if (count > staff.size()) count = staff.size();

        System.out.printf("%n===================== ТОП - < %d > худших зарплат =====================%n",count);
        ArrayList<Employee> sortedList = new ArrayList<>(staff.values());
        Collections.sort(sortedList);
        for (int i = 0; i < count ; i++)
            System.out.printf("%n  %-3d %s %,.2f %s",i + 1,
                    sortedList.get(i).toString(),
                    sortedList.get(i).getMonthSalary(),"руб.");
    }

    public void getTopSalaryStaff(int count) // домашнее задание
    {
        if (count > staff.size()) count = staff.size();

        System.out.printf("%n%n===================== ТОП - < %d > лучших зарплат =====================%n",count);
        ArrayList<Employee> sortedList = new ArrayList<>(staff.values());
        Collections.sort(sortedList);
        for (int i = 0; i < count ; i++)
            System.out.printf("%n  %-3d %s %,.2f %s",i + 1,
                    sortedList.get(staff.size() - i - 1).toString(),
                    sortedList.get(staff.size() - i - 1).getMonthSalary(),"руб.");
    }

    private int random() {
        return (int) Math.round(Math.random() * 10);
    }

    private ArrayList<String> nameBase() throws IOException//== получаем базу и мешаем ========
    {
        String contents = readTextFile("family_base.txt");
        ArrayList<String> base = new ArrayList<>();
        Collections.addAll(base, contents.split("\\s+"));
        return base;
    }

    private static String readTextFile(String fileName) throws IOException// читаем базу из txt
    {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }


}
