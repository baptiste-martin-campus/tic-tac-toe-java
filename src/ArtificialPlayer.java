import java.util.concurrent.ThreadLocalRandom;

public class ArtificialPlayer extends Player {

    public ArtificialPlayer(){
        super("| A ");
    }

    public int getRandom(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
