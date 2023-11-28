public abstract class Weapon extends Item {

    private int weaponDamage;

    public Weapon(int weaponDamage, int id, int price, String name) {
        super(id, price, name);
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
}