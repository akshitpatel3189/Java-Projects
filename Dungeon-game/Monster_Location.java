public abstract class Monster_Location extends Location {

    private Monster[] monster;
    private int monsterNo;
    private String name;
    private int minMonster;
    private int maxMonster;

    private String monsterName;
    private int firstAttackNum;

    public Monster_Location(Character_detail character_detail, String name, int minMonster, int maxMonster) {
        super(character_detail);
        this.name = name;
        this.minMonster = minMonster;
        this.maxMonster = maxMonster;
    }

    public boolean fight(Character_detail character_detail, int i) {
        if (this.getFirstAttackNum() == 2) {
            this.askAttack(i);
            if (this.getSelect() == 1) {
                try {
                    this.getCharacter_detail().attack(this.getMonster()[i]);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("You attack " + this.getMonsterName());
                System.out.println(this.monsterName + " Hp: " + this.getMonster()[i].getHp());
                System.out.println(" Your Hp: " + this.getCharacter_detail().getHp());
                if (this.getMonster()[i].getHp() > 0) {
                    try {
                        this.getMonster()[i].attack(this.getCharacter_detail());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(this.getMonsterName() + " attack You");
                }
            } else {
                return false;
            }

        } else {
            try {
                this.getMonster()[i].attack(this.getCharacter_detail());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(this.getMonsterName() + " attack You");
            System.out.println("Your Hp: " + this.getCharacter_detail().getHp());
            if (this.getCharacter_detail().getHp() > 0) {
                this.askAttack(i);
                if (this.getSelect() == 1) {
                    try {
                        this.getCharacter_detail().attack(this.getMonster()[i]);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("You attack " + this.getMonsterName());
                    System.out.println(this.monsterName + " Hp: " + this.getMonster()[i].getHp());
                    System.out.println(" Your Hp: " + this.getCharacter_detail().getHp());
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean firstAttack(Character_detail character_detail, Monster monster, int i) {
        this.firstAttackNum = (int) (Math.random() * 2) + 1;
        System.out.println("<=============================>");
        System.out.println("You've encountered a " + monsterName + ". Will you fight it?");
        System.out.println("1. to fight");
        System.out.println("2. to flee");
        System.out.println(this.monsterName + " Hp: " + this.getMonster()[i].getHp());
        System.out.println(" Your Hp: " + this.getCharacter_detail().getHp());
        this.setSelect(sc.nextInt());
        if (this.getSelect() == 1) {
            if (this.firstAttackNum == 1) {
                try {
                    this.getCharacter_detail().attack(this.getMonster()[i]);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("You attack first");
            } else {
                try {
                    this.getMonster()[i].attack(this.getCharacter_detail());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Monster attack first");
            }
            return true;
        }
        return false;
    }

    public void askAttack(int i) {
        System.out.println("=============================");
        System.out.println(this.monsterName + " Hp: " + this.getMonster()[i].getHp());
        System.out.println(" Your Hp: " + this.getCharacter_detail().getHp());
        System.out.println("Will you keep fighting??");
        System.out.println("1. to fight");
        System.out.println("2. to flee");
        this.setSelect(sc.nextInt());
        System.out.println("\n============================");
    }

    public abstract void createMonster() throws Exception;

    public Monster[] getMonster() {
        return monster;
    }

    public int createRandomNum() {
        int range;
        range = this.getMaxMonster() - this.getMinMonster() + 1;
        return (int) (Math.random() * range) + this.getMinMonster();
    }

    public void setMonster(Monster[] monster) {
        this.monster = monster;
    }

    public int getMonsterNo() {
        return monsterNo;
    }

    public void setMonsterNo(int monsterNo) {
        this.monsterNo = monsterNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getFirstAttackNum() {
        return firstAttackNum;
    }

    public void setFirstAttackNum(int firstAttackNum) {
        this.firstAttackNum = firstAttackNum;
    }

    public int getMinMonster() {
        return minMonster;
    }

    public void setMinMonster(int minMonster) {
        this.minMonster = minMonster;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}