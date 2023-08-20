public class Character_detailTest
{
    public void attackTest()
    {
        Character_detail tst = new Character_detail(10,100,40,100,1,"Mage");
        try{
            tst.attack(new Monster(20,20,90,1,"Org"));
            System.out.println("Test-Success\n");
        }catch (Exception e){
            System.out.println("Test-Failed\n");
        }
    }
}
