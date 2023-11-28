public class Dungeon extends FightArena {

    public Dungeon(Character_detail character_detail)
    {
        super(character_detail, "Dungeon", 1, 1);
        //Character_detail character_detail, String name, int minMonster, int maxMonster
    }

    //Create Org monster array in random number at specific interval
    @Override
    public void createMonster() throws Exception{
        this.setMonsterNo(this.createRandomNum());
        this.setMonster(new Org[this.getMonsterNo()]);
        for (int i = 0; i < this.getMonsterNo(); i++) {
            this.getMonster()[i] = new Org();
            throw new Exception("Monster are not 0\n");
        }
    }
}
