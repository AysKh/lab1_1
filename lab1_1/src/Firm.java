import java.util.Scanner;

class Employe{
    String surname, name, patronymic, position;
    int salary;
}
public class Firm {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in,"cp1251");
        System.out.println("Введите количество сотрудников => ");
        int kol=sc.nextInt();
        sc.nextLine();
        Employe []sotr=new Employe[kol];

        System.out.println("Введите информацию о каждом сотруднике: ");
        for (int i = 0; i < sotr.length; i++) {
            sotr[i]=new Employe();

            System.out.print("Введите фамилию "+(i+1)+" сотрудника => ");
            sotr[i].surname= sc.nextLine();

            System.out.print("Введите его имя => ");
            sotr[i].name=sc.nextLine();

            System.out.print("Введите его отчество => ");
            sotr[i].patronymic=sc.nextLine();

            System.out.print("Введите его должность => ");
            sotr[i].position=sc.nextLine();

            System.out.print("Введите его оклад => ");
            sotr[i].salary=sc.nextInt();
            sc.nextLine();
        }

        System.out.println ("\nСотрудники фирмы: \n фам \t имя \t отч +\t должность \t Оклад");
        for (Employe e : sotr) {
            System.out.println(e.surname + "\t" + e.name + "\t" + e.patronymic + "\t" + e.position + "\t\t" + e.salary);
        }
    }
}