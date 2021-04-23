import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Serwer {
    public static void main(String[] args) {
        try{
            String name = "Moj Zdalny Przyklad";
            IksiazkaTelefoniczna implementacjaSerwera = new KsiazkaTelefoniczna();
            IksiazkaTelefoniczna stub = (IksiazkaTelefoniczna) UnicastRemoteObject.exportObject(implementacjaSerwera,0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind(name,stub);
            System.out.println("Uruchomiono i podpieto aplikacje");
        }
        catch(Exception e){
            System.err.println("Wyjatek podczas wlaczania");
            e.printStackTrace();
        }
    }
}
