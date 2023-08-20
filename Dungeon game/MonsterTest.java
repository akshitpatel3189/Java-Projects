public class MonsterTest
{
    public void attackTest()
    {
        Monster tst = new Monster(20,20,90,1,"Org");
        try{
            tst.attack(new Character_detail(10,100,40,100,1,"Mage"));
            System.out.println("Test-Success\n");
    }catch (Exception e){
    System.out.println("Test-Failed\n");
}
    }
}
