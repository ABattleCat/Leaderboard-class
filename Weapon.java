class Weapon extends Item{
public int baseDamage;
public int level = 1;
public int turnsCost;
public int totalDamage;
public int baseCritChance;
public float critChance;

    public Weapon(String name, int basedamage, int turnscost, int critchance, int sideeffectID) {
        this.turnsCost = turnscost;
        this.baseDamage = basedamage;
        this.baseName = name;
        this.baseCritChance = critchance;
        this.critChance = this.baseCritChance;
        this.totalDamage = this.baseDamage;
        this.fullName = this.baseName + this.level;
        this.sideEffectID = sideeffectID;
    }

    public void lvlUp() {
        this.level++;
        this.totalDamage = this.baseDamage * this.level;
        this.critChance = this.level * this.baseCritChance / 10 + this.baseCritChance + this.level * this.baseCritChance;
        this.fullName = this.baseName + Integer.toString(this.level);
    }
}