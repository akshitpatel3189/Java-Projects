public class CharacterTest
{
    public static void constructorTest()
    {
        CharacterMock db = new CharacterMock();
        try
        {
            if(db.id==1)
            {
                System.out.println("Test-Success for id\n");
            }
            if(db.hp==100)
            {
                System.out.println("Test-Success for hp\n");
            }
            if(db.ap==20)
            {
                System.out.println("Test-Success for ap\n");
            }
            if(db.name=="Mage")
            {
                System.out.println("Test-Success for character name\n");
            }
            else
            {
                System.out.println("Test-Failed because wrong value entered\n");
            }
        }
        catch (Exception e)
        {
            System.out.println("Test-Failed for null value\n");
        }
    }
}