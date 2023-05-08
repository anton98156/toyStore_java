package toystore;

public class Program {

    public static void main(String[] args) {
        while(true) {
            System.out.println("Введите команду: ");
            String command = ScCall.sc().nextLine();
            if(command.startsWith("добавить")){
                Toy.createToy();
            }
            else if(command.startsWith("вывод")){
                Toy.printAll();
            }
            else if(command.startsWith("удалить")){
                Toy toy = Toy.getToyById();
                Toy.toys.remove(toy.id);
            }
            else if(command.startsWith("разыграть")){
                Toy toy = Toy.getToyById();
                boolean x = Game.play(toy);
                if(x == true){
                    System.out.println("Поздравляем, вы выиграли игрушку - " + toy.name + "!");
                    try {
                        Game.note(toy.name);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toy.toys.remove(toy.id);
                }
                else if (x == false){
                    System.out.println("К сожалению, в этот раз вам не повезло, но игра продолжается :)\n");
                }
            }
            else if(command.startsWith("выход")){
                break;
            }
            else{
                System.out.println("\nТакой команды не существует. Попробуйте еще раз!\n");
            }
        }
    }
}