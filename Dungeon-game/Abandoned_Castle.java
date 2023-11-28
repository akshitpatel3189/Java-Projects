public class Abandoned_Castle extends FightArena {

    public Abandoned_Castle(Character_detail character_detail)
    {
        super(character_detail, "Abandoned Castle", 1, 1);
        //Character_detail character_detail, String name, int minMonster, int maxMonster
    }

    //Create Goblin monster array in random number at specific interval
    @Override
    public void createMonster() throws Exception{
        this.setMonsterNo(this.createRandomNum());
        this.setMonster(new Goblin[this.getMonsterNo()]);
        for (int i = 0; i < this.getMonsterNo(); i++) {
            this.getMonster()[i] = new Goblin();
            throw new Exception("Monster are not 0\n");
        }
    }
}
