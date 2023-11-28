public class SafeHouse extends Location {

    public SafeHouse(Character_detail character_detail) {
        super(character_detail);
    }

    @Override
    //The player's health is full.
    public void run() {
        this.getCharacter_detail().setHp(this.getCharacter_detail().getConstHp());
        System.out.println("Your Hp is regain.");
    }
}