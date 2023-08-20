import java.util.Scanner;

public abstract class Location {

    private Character_detail character_detail;
    private int select;
    Scanner sc = new Scanner(System.in);

    public Location(Character_detail character_detail) {
        this.character_detail = character_detail;
    }

    public abstract void run();

    public Character_detail getCharacter_detail() {
        return character_detail;
    }

    public void setCharacter_detail(Character_detail character_detail) {
        this.character_detail = character_detail;
    }

    public int getSelect() {
        return select;
    }

    public void setSelect(int select) {
        this.select = select;
    }
}