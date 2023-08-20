public class Abandoned_CastleTest
{
    public void createmonster()
    {
        Abandoned_Castle tst = new Abandoned_Castle(new Character_detail(10,100,40,100,1,"Mage"));
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
