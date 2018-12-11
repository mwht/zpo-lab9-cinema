import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

    public static int went = 0;
    public static int wentDuringFilm = 0;

    public static void main(String[] args) throws InterruptedException {

        double p1 = 0.05; //szansa na pojscie do kina
        double p2 = 0.3; //szansa na wyjscie z kina podczas seansu
        int N = 100; //ilosc osob ktore chca pojsc do kina

        Executor executor = Executors.newFixedThreadPool(N);
        for(int i=0; i<N; i++)
            executor.execute(new PersonThread(p1, i));


        System.out.println("Jest aktywnych: " + Thread.activeCount());
        Thread.sleep(5000);
        System.out.println("Poszlo: " + went);
        if(went < 5) {
            System.out.println("Przepraszamy, filmu nie bedzie!");
            System.exit(0);
        } else {
            Executor executor1 = Executors.newFixedThreadPool(went);
            for(int i = 0; i< went; i++)
                executor1.execute(new ViewerThread(p2,i));

            Thread.sleep(2100);

            if(went - wentDuringFilm < 5) {
                System.out.println("Tyle zostalo: " + (went - wentDuringFilm));
                System.out.println("Komunikat o frajerach i o tym, że pieniędzy nie oddamy!");
                System.out.println(Thread.activeCount());
                System.exit(0);
            } else {
                System.out.println("Tyle zostalo: " + (went - wentDuringFilm));
                System.out.println("FILM JEST KONTYNUOWANY");
                System.out.println(Thread.activeCount());
                System.exit(0);
            }

        }
    }
}
