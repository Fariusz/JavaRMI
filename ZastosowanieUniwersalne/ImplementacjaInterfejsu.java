import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.concurrent.Callable;

public class ImplementacjaInterfejsu implements Interfejs{

    @Override
    public void wyslij(String s) throws RemoteException {
        System.out.println("Odebrałem " + s);
    }
    @Override
    public void dodaj(double a, double b) throws RemoteException{
        System.out.println("Dodawanie " + a + " i " + b + " wynik: " + (a+b) );
    }
    @Override
    public void odejmij(double a, double b) throws RemoteException{
        System.out.println("Odejmowanie " + a + " i " + b + " wynik: " + (a-b) );
    }
    @Override
    public void pomnoz(double a, double b) throws RemoteException{
        System.out.println("Mnożenie " + a + " i " + b + " wynik: " + (a*b) );
    }
    @Override
    public void podziel(double a, double b) throws RemoteException{
        System.out.println("Dzielenie " + a + " i " + b + " wynik: " + (a/b) );
    }
    @Override
    public <T extends Callable> Object zadanie(T task) throws Exception {
        return task.call();

    }
}