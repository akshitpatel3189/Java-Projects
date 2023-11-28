public class SafeHouseTest
{
    public void runTest()
    {
        SafeHouse tst = new SafeHouse(new Character_detail(10,100,20,100,1,"Mage"));
        try{
            tst.run();
            System.out.println("Test-Success\n");
        }catch (Exception e){
            System.out.println("Test-Failed\n");
        }
    }
}
