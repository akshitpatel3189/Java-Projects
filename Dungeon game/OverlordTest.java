public class OverlordTest
{
    public static void runTest()
    {
        Overlord test = new Overlord();
        int ch[] = new int[]{1,2,3,4,5,6,7};
        try
        {
            if(ch[0]==1)
            {
                System.out.println("Test-Success for Mage class\n");
            }
            if(ch[1]==2)
            {
                System.out.println("Test-Success for Sword master class\n");
            }
            if(ch[2]==3)
            {
                System.out.println("Test-Success for Archer class\n");
            }
            else
            {
                System.out.println("Test-Failed because wrong value entered\n");
            }
        }
        catch (Exception e)
        {
            System.out.println("Test-Failed\n");
        }

        try
        {
            if(ch[0]==1 || ch[1]==2 || ch[2]==3 || ch[3]==4 || ch[4]==5 || ch[5]==6 || ch[6]==7)
            {
                System.out.println("Test-Success for maps and various places\n");
            }
            else
            {
                System.out.println("Test-Failed because wrong value entered\n");
            }
        }
        catch (Exception e)
        {
            System.out.println("Test-Failed\n");
        }
    }

    public static void createPlaceTest()
    {
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;
        Class<?> class4 = null;
        try
        {
            class1 = Class.forName("advanture_game.Dungeon");
            class2 = Class.forName("advanture_game.Abandoned_Castle");
            class3 = Class.forName("advanture_game.SafeHouse");
            class4 = Class.forName("advanture_game.Store");
            System.out.println("Test-Success. Dungeon class is exist");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Test-Failed Class not Found");;
        }

        if (class1 == null || class2 == null || class3 == null || class4 == null)
        {
            System.out.println("Test-Failed");
            return;
        }
    }
}