package model;

public class Pokemon {

    private String name;

    private int health;

    private int damage;

    private TypeEnum typeEnum;

    private SpecialPower specialPower;

    private int maxHealth;

    public Pokemon(String name, int health, int damage, TypeEnum typeEnum, SpecialPower specialPower, int maxHealth) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.typeEnum = typeEnum;
        this.specialPower = specialPower;
        this.maxHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public SpecialPower getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(SpecialPower specialPower) {
        this.specialPower = specialPower;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int specialAttack() {
        if (this.specialPower.getRemainRight() > 0) {
            this.specialPower.setRemainRight(this.specialPower.getRemainRight() - 1);
            return  this.damage + this.specialPower.getExtraDamage();
        } else {
            System.out.println("You cannot use special power.");
            return this.damage;
        }
    }

    @Override
    public String toString() {
        return "Adı : " + name + '\n'
                + "Sağlığı : " + health + '\n'
                + "Gücü : " + damage + '\n'
                + "Tipi : " + typeEnum;
    }
}
