import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IksiazkaTelefoniczna extends Remote {
    public void wyslij(String s) throws RemoteException;
    void dodaj(String osoba, String nrTelefonu) throws RemoteException;
    String odczytaj(String osoba) throws RemoteException;
    void usun(String osoba) throws RemoteException;
    List<String> listaOsob() throws RemoteException;
}
