import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Klient {
    public static void main(String[] args) {
        try {
            String name = "Moj Zdalny Przyklad";
            Registry registry = LocateRegistry.getRegistry();
            Interfejs zdalnyObiekt = (Interfejs)registry.lookup(name);
            System.out.println("Przygotowano klienta do dzialania");


            try(Scanner scanner = new Scanner(System.in);)
            {
                System.out.println("Podaj liczbe a: ");
                double a = Double.parseDouble(scanner.nextLine());
//                System.out.println("Podaj liczbe b: ");
//                double b = Double.parseDouble(scanner.nextLine());
//                zdalnyObiekt.dodaj(a,b);
//                zdalnyObiekt.odejmij(a,b);
//                zdalnyObiekt.pomnoz(a,b);
//                zdalnyObiekt.podziel(a,b);
                MonteCarlo obliczPi = new MonteCarlo();
                System.out.println("Liczba PI wynosi: " + zdalnyObiekt.zadanie(obliczPi));
            }
            catch (Exception e){ System.out.println("Błąd skanera"); }
        } catch (Exception e) { e.printStackTrace(); }
    }
}
