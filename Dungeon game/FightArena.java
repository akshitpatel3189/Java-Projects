public abstract class FightArena extends Monster_Location {

    public FightArena(Character_detail character_detail, String name, int minMonster, int maxMonster) {
        super(character_detail, name, minMonster, maxMonster);
    }

    @Override
    public void run() {
        try {
            this.createMonster();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.setMonsterName(this.getMonster()[0].getName());
        System.out.println("======" + this.getName() + "======");
        System.out.println("Number of " + this.getMonsterName() + " are " + this.getMonsterNo());
        int i = 0;
        boolean t = true;

        do {
            t = this.firstAttack(this.getCharacter_detail(), this.getMonster()[i], i);
            if (this.getSelect() == 1) {//1. Fight
                while (this.getCharacter_detail().getHp() > 0 && this.getMonster()[i].getHp() > 0 && t) {
                    t = this.fight(this.getCharacter_detail(), i);//Both attack each other
                }
                System.out.println("==========================================");
                if (this.getMonster()[i].getHp() <= 0) {
                    //If the Player kills monster, player get coins.
                    this.getCharacter_detail().setCoin(this.getCharacter_detail().getCoin() + this.getMonster()[i].getPrize());
                    System.out.println("You killed the " + this.getMonsterName());
                    System.out.println("Monster coin: " + this.getMonster()[i].getPrize() + "\tYour total coin are " + this.getCharacter_detail().getCoin() + " coins");
                } else if (t) {//if monster kills player
                    System.out.println(this.getMonsterName() + " kill you!!!");
                    System.out.println("===GAME OVER===");
                    t = false;
                    Overlord.t = false;//To terminate the game
                }
                i++;//next monster
            } else if (this.getSelect() == 2) {//2. Flee
                t = false;
            }
        } while (i < this.getMonsterNo() && t && this.getCharacter_detail().getHp() > 0);
        //If player is alive or flee, the loop continues until all monsters are killed.

        if (this.getSelect() != 2 && t) {//If player killed all the monster.
            System.out.println("You won by killing all the enemies");

        }
        System.out.println("===========================================\n");
    }
}
