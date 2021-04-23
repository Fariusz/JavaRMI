import java.rmi.RemoteException;

public class ImplementacjaInterfejsu implements Interfejs{

    @Override
    public void wyslij(String s) throws RemoteException {
        System.out.println("Odebrałem " + s);
    }
    public void dodaj(double a, double b) throws RemoteException{
        System.out.println("Dodawanie " + a + " i " + b + " wynik: " + (a+b) );
    }
    public void odejmij(double a, double b) throws RemoteException{
        System.out.println("Odejmowanie " + a + " i " + b + " wynik: " + (a-b) );
    }
    public void pomnoz(double a, double b) throws RemoteException{
        System.out.println("Mnożenie " + a + " i " + b + " wynik: " + (a*b) );
    }
    public void podziel(double a, double b) throws RemoteException{
        System.out.println("Dzielenie " + a + " i " + b + " wynik: " + (a/b) );
    }
}
