import java.io.*;
import java.rmi.RemoteException;
import java.util.*;

public class KsiazkaTelefoniczna implements IksiazkaTelefoniczna {

   private Map<String, Integer> map = new TreeMap<>();

    KsiazkaTelefoniczna(){wczytajDoPamieci();}

    void wczytajDoPamieci(){
        map.clear();
        try(Scanner scanner = new Scanner(new File("src\\baza.txt"));) {
            while(scanner.hasNext())
            {
                String word = scanner.nextLine();
                String[] splitWord = new String[]{};
                splitWord = word.split(";",2);
                map.put(splitWord[0], Integer.valueOf(splitWord[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //map.forEach((k,v) -> System.out.println(k+"   "+v));
    }

    void zapiszDoPliku()
    {
        try(PrintWriter out = new PrintWriter(new FileWriter("src\\baza.txt", false));)
        {
            map.forEach((k,v) -> out.println(k + ";" + v));
        }
        catch (FileNotFoundException fnfe){ System.out.println(fnfe);}
        catch (Exception e){ System.out.println("Błąd w writerze metody zapiszDoPliku"); }
    }

    @Override
    public void wyslij(String s) throws RemoteException {
        System.out.println("Odebrałem " + s);
    }
    @Override
    public void dodaj(String osoba, String nrTelefonu) throws RemoteException {
        map.put(osoba, Integer.valueOf(nrTelefonu));
        zapiszDoPliku();
    }

    @Override
    public String odczytaj(String osoba) throws RemoteException {
       wczytajDoPamieci();
       return String.valueOf(map.get(osoba));
    }

    @Override
    public void usun(String osoba) throws RemoteException {
        map.remove(osoba);
        zapiszDoPliku();
    }

    @Override
    public List<String> listaOsob() throws RemoteException {
        wczytajDoPamieci();
        List<String> lista = new ArrayList<>();
        map.forEach((k,v) -> lista.add(k+"   "+v));
        return lista;
    }
}
