import java.util.Scanner;

class Employee{
    String surname, name, patronymic, position;
    int kolDet;
    Rebenok []reb=null;
}
class Rebenok {
    String nameR;
    int ageR;
}
public class RecSotr1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in,"cp1251");
        System.out.println("Введите количество сотрудников => ");
        int kol=sc.nextInt();
        sc.nextLine();
        Employee []sotr=new Employee[kol];
        System.out.println("Введите информацию о каждом сотруднике: ");
        for (int i = 0; i < sotr.length; i++) {
            sotr[i]= new Employee();
            System.out.print("Введите фамилию "+(i+1)+" сотрудника => ");
            sotr[i].surname= sc.nextLine();

            System.out.print("Введите его имя => ");
            sotr[i].name=sc.nextLine();

            System.out.print("Введите его отчество => ");
            sotr[i].patronymic=sc.nextLine();

            System.out.print("Введите его должность => ");
            sotr[i].position=sc.nextLine();

            System.out.print("Введите количество детей => ");
            sotr[i].kolDet=sc.nextInt();
            sc.nextLine();

            if (sotr[i].kolDet!=0) {
                sotr[i].reb=new Rebenok[sotr[i].kolDet];
                System.out.println("Дети => ");
                for (int j = 0; j < sotr[i].reb.length; j++) {
                    sotr[i].reb[j]= new Rebenok();

                    System.out.print("Введите имя "+(j+1)+" ребенка => ");
                    sotr[i].reb[j].nameR = sc.nextLine();

                    System.out.print("Введите его возраст => ");
                    sotr[i].reb[j].ageR = sc.nextInt();
                    sc.nextLine();
                } } }

        System.out.println("\nСотрудники фирмы \n фам \t имя \t отч \t должность");
        for (Employee s : sotr) {
            System.out.print(s.surname+ "\t"+s.name + "\t"+ s.patronymic + "\t "+ s.position);
            System.out.println("\n Дети: ");
            for (Rebenok r : s.reb)
                System.out.println("\t\t\t"+ r.nameR+ "\t\t"+ r.ageR);
            System.out.println();
        }
    } }