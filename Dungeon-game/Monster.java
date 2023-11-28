public class Monster extends Character {

    private int prize;
    private int ap;

    public Monster(int prize, int ap, int hp, int id, String name) {
        super(ap, hp, id, name);
        this.prize = prize;
    }
    //the monster attacks the player
    public void attack(Character_detail character_detail) throws Exception{
        ap = this.getAp();
        if (ap < 0) {//ap is not allow to below 0.
            ap = 0;
            throw new Exception("ap is not negative\n");
        }
        character_detail.setHp(character_detail.getHp() - ap);
        if (character_detail.getHp() < 0) {//player hp not goes to in -ve.
            character_detail.setHp(0);
            throw new Exception("player hp is not negative\n");
        }
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
}