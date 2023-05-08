package toystore;

import java.util.UUID;
import java.util.HashMap;

public class Toy {

    protected UUID id;
    protected String name;   
    protected int chance;
    protected static HashMap<UUID, Toy> toys = new HashMap<>();
    
    Toy(String name, int chance) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.chance = chance;
    }

    protected static int getNewChanceNumber() {
        System.out.println("\nВведите вероятность выпадения игрушки от 0 до 100: ");
        int x = ScCall.sc().nextInt();
        if (x < 0 || x > 100) {
            throw new IllegalArgumentException("Требуется ввести значения от 0 до 100. Попробуйте еще раз!");
        }
        return x;
    }

    protected static Toy createToy() {
        System.out.println("\nВведите название игрушки: ");
        String n = ScCall.sc().nextLine();
        int z = getNewChanceNumber();
        Toy t = new Toy(n, z);
        System.out.println(t.toString());
        
        toys.put(t.id, t);
        return t;
    }

    protected static Toy getToyById() {
        System.out.println("\nВведите ID игрушки: ");
        String str = ScCall.sc().nextLine();
        UUID id = UUID.fromString(str);
        return toys.get(id);
    }

    protected static void printAll() {
        System.out.println("\nВ настоящее время разыгрываются: \n");
        System.out.println(toys);
    }

    @Override
    public String toString() {
        return String.format("\nID: [%s] \nИмя: %s \tШанс: %d%%\n", 
                    id, name, chance);
    }

}