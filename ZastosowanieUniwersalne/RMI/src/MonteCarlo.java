import java.io.Serializable;
import java.util.concurrent.Callable;

public class MonteCarlo implements Callable<Double>, Serializable  {
    @Override
    public Double call() throws Exception {
        int x =0;
        int y=0;
        double x1,y1;
        for(; x <100000; x++)
        {
            x1 = Math.random();
            y1 = Math.random();
            if(x1*x1 + y1*y1 <=1)
                y++;
        }
        double pi = 4*(double)y/(double)x;
        return pi;
    }
}
