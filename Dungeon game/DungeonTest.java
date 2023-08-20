public class DungeonTest
{
    public void createmonster()
    {
        Dungeon tst = new Dungeon(new Character_detail(1,1,1,1,1,"Mage"));
        try{
            tst.createMonster();
            System.out.println("Test-Success");
        }
        catch (Exception e)
        {
            System.out.println("Test-Failed\n");
        }
    }
}
