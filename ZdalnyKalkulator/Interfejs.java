import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interfejs extends Remote{
    public void wyslij(String e) throws RemoteException;
    public void dodaj(double a, double b) throws RemoteException;
    public void odejmij(double a, double b) throws RemoteException;
    public void pomnoz(double a, double b) throws RemoteException;
    public void podziel(double a, double b) throws RemoteException;
}


