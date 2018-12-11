import java.util.Random;

public class PersonThread implements Runnable {

    Random random = new Random();
    Double chance;
    Boolean choice = false;
    int i;

    PersonThread(Double chance, int i){
        this.chance = chance;
        this.i = i;
    }

    public synchronized void personWent(){
        Main.went += 1;
    }


    @Override
    public void run() {
        Integer waitTime = random.nextInt(4) + 1;
        try {
            Thread.sleep(waitTime*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random.nextDouble()<chance) {
            choice = true;
            System.out.println("*osoba idzie na film*");
            personWent();
        }
        else choice = false;

        Thread.yield();

        //System.out.println(choice + " " + i);
    }
}
