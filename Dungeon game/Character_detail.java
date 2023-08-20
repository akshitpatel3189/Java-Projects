public class Character_detail extends Character {

    private int coin;
    private Weapon weapon;
    private int constHp;

    public Character_detail(int coin, int constHp, int ap, int hp, int id, String name) {
        super(ap, hp, id, name);
        this.coin = coin;
        this.constHp = constHp;
    }

    //Player attacks the enemy.
    public void attack(Monster monster) throws Exception{
        monster.setHp(monster.getHp() - this.getAp());
        if (monster.getHp() < 0) {//monster hp not goes to in -ve.
            monster.setHp(0);
            throw new Exception("Monster hp is not negative");
        }
    }
    //Player go to the specific location
    public void go(Location location) {
        location.run();
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getConstHp() {
        return constHp;
    }

    public void setConstHp(int constHp) {
        this.constHp = constHp;
    }
}