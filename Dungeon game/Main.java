public class Main {

    public static void main(String[] args)
    {
        System.out.println("For Testing methods type 'test' after 'java Main' in terminal\nLike java Main test\nFor  run program simply type java Main\n");

        if(args.length>0 && args[0].equalsIgnoreCase("test"))
        {//call test
            System.out.println("Tests...");
            OverlordTest.runTest();
            OverlordTest.createPlaceTest();
            CharacterTest.constructorTest();
            Character_detailTest tst1 = new Character_detailTest();
            tst1.attackTest();
            Abandoned_CastleTest tst2 = new Abandoned_CastleTest();
            tst2.createmonster();
            DungeonTest tst3 = new DungeonTest();
            tst3.createmonster();
            MonsterTest tst4 = new MonsterTest();
            tst4.attackTest();
        }
        else
        {
            System.out.println("!!Welcome to Overlord!!\nIsekai Adventure Game\n\n");
            Overlord.run();
        }


    }
}
