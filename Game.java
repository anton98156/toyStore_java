package toystore;

import java.io.FileWriter;
import java.util.Random;

public class Game {

    protected static boolean play(Toy toy) {
        System.out.println("\nРазыгрывается игрушшка - " + toy);
        Random r = new Random();
        if (toy.chance > r.nextInt(100) + 1) {
            return true;
        }
        else {
            return false;
        }
    }

    protected static void note(String toyName) throws Exception {
        FileWriter writer = new FileWriter("issues.txt", true);
        writer.write("\n" + toyName);
        writer.close();
    }
}
