import java.io.IOException;

public class Starter
{
    public static void main(String[] args) throws IOException
    {
        Company roga_i_copyta = Company.getInstance();
        // roga_i_copyta.listStuff(); - для вывода списка всех работников раскомментить эту строку

        roga_i_copyta.getLowestSalaryStaff(10);
        roga_i_copyta.getTopSalaryStaff(10);

    }
}
