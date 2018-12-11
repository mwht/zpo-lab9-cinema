import java.util.Random;

public class ViewerThread implements Runnable {

    Double chance;
    int i;
    Random random = new Random();
    Boolean choice;

    ViewerThread(Double chance, int i){
        this.chance = chance;
        this.i = i;
    }

    public synchronized void viewerWentDuringFilm(){
        Main.wentDuringFilm += 1;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random.nextDouble()<chance) {
            choice = true;
            System.out.println("*osoba wyszła podczas filmu*");
            viewerWentDuringFilm();
        }
        else choice = false;

        Thread.yield();
    }
}
