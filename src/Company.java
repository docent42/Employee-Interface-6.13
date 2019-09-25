import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Company
{
    private double monthlyIncome;// поле для расчета зарплаты у Топ менеджера
    public TreeMap<Integer,Employee> staff = new TreeMap<>(); // список сотрудников

    private Company ()
    {

    }
    public static Company getInstance() throws IOException
    {
        Company company = new Company();
        company.init();
        return company;
    }

    private void init() throws IOException // заряжаем компанию сотрудниками
    {
        monthlyIncome = (double)Math.round(Math.random() * 1000000000)/100 + 5000000;
        ArrayList<String> nameBase = new ArrayList<>(nameBase()); // читаем базу 270 фамилий из txt

        for (int i = 1; i <= 270; i++)
        {
            int rnd = random(); // кто у нас будет ???
            if (rnd < 3) addEmployee(Proff.TOP_MANAGER,i,nameBase.get(i)); // топ менеджер родился
            else
            {
                rnd = random();
                if (rnd < 5) addEmployee(Proff.SALES_MANAGER,i,nameBase.get(i));// продажник родился
                else addEmployee(Proff.OPERATOR,i,nameBase.get(i)); // Свободная касса !!!
            }
        }
    }

    public void addEmployee(Proff prof,int key,String name)// универсальный наниматель сотрудников
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
        String name, prof; double salary;int key;
        for (Integer k : staff.keySet())
            {
                name = staff.get(k).name; prof = staff.get(k).profession.name;
                salary = staff.get(k).getMonthSalary();
                System.out.printf("%n%03d  %-13s %-22s %,.2f",k,name, prof, salary);
            }

    }

    public void getLowestSalaryStaff(int count) // домашнее задание
    {
        System.out.printf("%n===================== ТОП - < %d > худших зарплат =====================%n",count);
        ArrayList<Employee> sortedList = new ArrayList<>(staff.values());
        Collections.sort(sortedList);
        for (int i = 0; i < count ; i++)
            System.out.printf("%n  %-3d %-13s %-20s %,.2f %s",i + 1,
                    sortedList.get(i).name,
                    sortedList.get(i).profession.name,
                    sortedList.get(i).getMonthSalary(),"руб.");
    }

    public void getTopSalaryStaff(int count) // домашнее задание
    {
        System.out.printf("%n%n===================== ТОП - < %d > лучших зарплат =====================%n",count);
        ArrayList<Employee> sortedList = new ArrayList<>(staff.values());
        Collections.sort(sortedList);
        for (int i = 0; i < count ; i++)
            System.out.printf("%n  %-3d %-13s %-20s %,.2f %s",i + 1,
                    sortedList.get(staff.size() - i - 1).name,
                    sortedList.get(staff.size() - i - 1).profession.name,
                    sortedList.get(staff.size() - i - 1).getMonthSalary(),"руб.");
    }

    private int random() {
        return (int) Math.round(Math.random() * 10);
    }

    private ArrayList<String> nameBase() throws IOException//== получаем базу и мешаем ========
    {
        String contents = readTextFile("family_base.txt");
        ArrayList<String> base = new ArrayList<>();
        Collections.addAll(base, contents.split("\\s+"));Collections.shuffle(base);
        return base;
    }

    private static String readTextFile(String fileName) throws IOException// читаем базу из txt
    {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }


}
