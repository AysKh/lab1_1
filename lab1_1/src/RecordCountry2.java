import java.util.Scanner;
class Strana {
    String name;
    double square;
}
public class RecordCountry2 {
    public static strana[] setCountryArr(int k) {
        Scanner sc = new Scanner(System.in, "cp1251");
        strana country[] = new strana[k];

        System.out.println("Введите информацию о странах: ");
        for (int i = 0; i < country.length; i++) {
            country[i] = new strana();
            System.out.print("Название " + (i + 1) + "-й страны => ");
            country[i].name = sc.nextLine();
            System.out.print("Площадь " + (i + 1) + "-й страны => ");
            country[i].square = sc.nextDouble();
            sc.nextLine(); // очистка буфера
        }
        return country;
    }

    public static void showArray(strana[] cntr) {
        for (int i = 0; i < cntr.length; i++) {
            System.out.println("" + cntr[i].name + " \t" + cntr[i].square + " млн кв. км");
        }
    }

    public static void showCountry(strana cntr) {
        System.out.println("" + cntr.name + "\t" + cntr.square + " млн кв. км");
    }

    public static int NomMax(strana[] st) {
        int nommax = 0;
        double max = st[nommax].square;
        for (int i = 0; i < st.length; i++)
            if (st[i].square > max) {
                max = st[i].square;
                nommax = i;
            }
        return nommax;
    }

    public static void sortSquare(strana[] cntr) {
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - 1 - i; j++)
                if (cntr[j].square > cntr[j + 1].square) {
                    strana rab = cntr[j];
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }

    public static void sortName(strana[] cntr) {
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - i - 1; j++)
                if (cntr[j].name.compareTo(cntr[i + 1].name) > 0) {
                    strana rab = cntr[j];
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }

    public static double avgSquare(strana[] cntr) {
        double s = 0;
        for (int i = 0; i < cntr.length; i++)
            s += cntr[i].square;
        double sr = s / cntr.length;
        return sr;
    }

    public static strana[] Bigger(strana cntr[]) {
        double sred = avgSquare(cntr);
        int kol = 0;
        for (int i = 0; i < cntr.length; i++) {
            if (cntr[i].square > sred)
                ++kol;
        }
        if (kol != 0) {
            strana[] bigCountry = new strana[kol];
            int n = -1;
            for (int i = 0; i < cntr.length; i++)
                if (cntr[i].square > sred) {
                    bigCountry[++n] = cntr[i];
                }
            return bigCountry;
        } else return null;
    }

    public static strana findForName(strana cntr[], String name) {
        int n = -1;
        for (int i = 0; i < cntr.length; i++)
            if (name.equals(cntr[i].name))
                n = i;
        if (n != -1) {
            return cntr[n];
        } else return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Введите количество стран=> ");
        int n = sc.nextInt();
        strana country[] = setCountryArr(n);
        System.out.println("\nХарактеристики стран:");
        showArray(country);

        int nommax = NomMax(country);
        System.out.println("\nСтрана с максимальной площадью:");
        showCountry(country[nommax]);
        sortSquare(country);
        System.out.println("\nОтсортированный список по площади:");
        showArray(country);
        sortName(country);
        System.out.println("\nОтсортированный список по названиям:");
        showArray(country);
        System.out.println("Средняя площадь =" + avgSquare(country));
        System.out.println("\nСтраны, с площадью больше средней");
        strana[] larger = Bigger(country);
        showArray(larger);
        System.out.println("\nПОИСК СТРАНЫ \n Введите название страны => ");
        sc.nextLine();
        String sname = sc.nextLine();
        strana sfind = findForName(country, sname);
        if (sfind != null) {
            showCountry(sfind);
        } else {
            System.out.println("Такой страны нет в списке!");
        }
    }
}