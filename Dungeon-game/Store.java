public class Store extends Location {

    private final Weapon[] weapons;

    public Store(Character_detail character_detail) {
        super(character_detail);
        weapons = new Weapon[1];
    }
    public void createWeapons() {
        weapons[0] = new Special_Weapon();

    }

    @Override
    public void run() {
        boolean t = true;
        this.createWeapons();
        do {
            System.out.println("=================STORE===================");
            this.showInventory();//show inventory before purchase
            System.out.println("1. Special Weapon");
            System.out.println("2. Exit the store");
            System.out.print("Make your choice: ");
            this.setSelect(sc.nextInt());
            if (this.getSelect() == 1) {
                for (Weapon weapon : weapons) {
                    if (weapon.getId() == this.getSelect()) {
                        if (this.getCharacter_detail().getCoin() >= weapon.getPrice()) {
                            this.getCharacter_detail().setWeapon(weapon);
                            this.getCharacter_detail().setAp(this.getCharacter_detail().getAp() + this.getCharacter_detail().getWeapon().getWeaponDamage());//add special weapon Ap into player's Ap
                            this.getCharacter_detail().setCoin(this.getCharacter_detail().getCoin() - weapon.getPrice());
                            System.out.println("You bought a Special Weapon");
                        } else {
                            //player don't have enough coin.
                            System.out.println("You need " + (weapon.getPrice() - this.getCharacter_detail().getCoin()) + " more coins to buy!!!");
                        }
                    }
                }
            } else if (this.getSelect() == 2) {
                t = false;
            } else {
                System.out.println("Wrong Value!!!");
            }
        } while (t);
    }

    public void showInventory() {
        System.out.println("Your Coins : " + this.getCharacter_detail().getCoin() + " coins");
        String weapon = "-";
        if (this.getCharacter_detail().getWeapon() != null) {
            weapon = this.getCharacter_detail().getWeapon().getName();
        }
        System.out.println("Your Weapon : " + weapon);
    }
}