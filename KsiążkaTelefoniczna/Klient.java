import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class Klient {
    public static void main(String[] args) {
        try {
            //Klient łączy się z serwerem:
            String name = "Moj Zdalny Przyklad";
            Registry registry = LocateRegistry.getRegistry();
            IksiazkaTelefoniczna zdalnyObiekt = (IksiazkaTelefoniczna) registry.lookup(name);
            System.out.println("Przygotowano klienta do dzialania");
            zdalnyObiekt.wyslij("HELLO WORLD!!!");

            //Dodaje trzy osoby
            try(Scanner scanner = new Scanner(System.in);)
            {
                String osoba = "";
                String numer = "";
                for(int i=0; i<3; i++){
                    do{
                        System.out.println("Proszę podać imie i nazwisko: ");
                        System.out.println();
                        osoba = scanner.nextLine();
                    }while(!(osoba.matches("[A-ZŻŹĆĄŚĘŁÓŃ][a-zżźćńółęąś]* [A-ZŻŹĆĄŚĘŁÓŃ][a-zżźćńółęąś]*")));
                    do{
                        System.out.println("Proszę podać numer telefonu: ");
                        numer = scanner.nextLine();
                    }while(!(numer.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")));
                    zdalnyObiekt.dodaj(osoba,numer);
                }
            }catch (Exception e){ e.printStackTrace(); }

            //Pobiera z serwera listę osób i dla każdej z pobranych osób w pętli odczytuje z sewera nr telefonu i wyświetla go
            System.out.println("=====LISTA OSÓB======");
            zdalnyObiekt.listaOsob().forEach((k-> System.out.println(k.toString())));
        } catch (Exception e) { e.printStackTrace(); }
    }
}
