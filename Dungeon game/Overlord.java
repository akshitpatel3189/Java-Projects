import java.util.Scanner;

/*
*Citations
*
*
* https://www.w3schools.com/java/default.asp
* https://www.tutorialspoint.com/java/index.htm
* https://www.javatpoint.com/java-tutorial
*
*
* */
public class Overlord {//This class change the game's flow in accordance with the player's choices.

    public static Character_detail character_detail;
    public static boolean t;//to see if the game is still running
    private static Dungeon dungeon;
    private static Abandoned_Castle abandoned_castle;
    private static Store store;
    private static SafeHouse safeHouse;
    public static void run() {
        Scanner sc = new Scanner(System.in);
        do {
            t = false;
            System.out.print("Which type of character do you want?\n1. Mage\n2. Sword Master\n3. Archer\n");
            int ch = sc.nextInt();
            if (ch == 1) {
                character_detail = new Mage();
            } else if (ch == 2) {
                character_detail = new SwordMaster();
            } else if (ch == 3) {
                character_detail = new Archer();
            } else {
                System.out.println("You entered the wrong value!!!");
                t = true;
            }
        } while (t);
        t = true;
        System.out.println("=======Your choose: " + character_detail.getName()+"=======");

        Overlord.createPlace();
        do {

            if (t) {
                System.out.println("\nChoose Dungeon to fight with various monsters.\nIf you win you will get coins and through coin your can visit store and purchase items.");
                System.out.println("1. Dungeon");
                System.out.println("2. Abandoned Castle");
                System.out.println("3. Safe House");
                System.out.println("4. Store");
                System.out.println("5. Show Inventory");
                System.out.println("6. Restart the game");
                System.out.println("7. Leave the game");
                System.out.print("Make your choice: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        character_detail.go(dungeon);
                        break;
                    case 2:
                        character_detail.go(abandoned_castle);
                        break;
                    case 3:
                        character_detail.go(safeHouse);
                        break;
                    case 4:
                        character_detail.go(store);
                        break;
                    case 5:
                        System.out.println("======INVENTORY======");
                        System.out.println("Coins = " + character_detail.getCoin());
                        System.out.println("=====Weapons=====");
                        if (character_detail.getWeapon() != null) {
                            System.out.println("Weapon : \n" + character_detail.getWeapon().getName());
                        } else {
                            System.out.println("Weapon : -- \n");
                        }
                        break;
                    case 6:
                        run();
                        break;
                    case 7:
                        t = false;
                        break;
                }
            }

        } while (t);

    }

    public static void createPlace() {//maps and other places created.
        dungeon = new Dungeon(Overlord.character_detail);
        abandoned_castle = new Abandoned_Castle(Overlord.character_detail);
        safeHouse = new SafeHouse(Overlord.character_detail);
        store = new Store(Overlord.character_detail);
    }
}