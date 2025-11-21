class Weapon {
public String baseName;
public int baseDamage;
public int level = 1;
public int turnsCost;
public int totalDamage;
public String fullName;
public int baseCritChance;
public int critChance;
public String sideEffect;

    public Weapon(String name, int basedamage, int turnscost, int critchance, String sideEffect) {
        this.turnsCost = turnscost;
        this.baseDamage = basedamage;
        this.baseName = name;
        this.baseCritChance = critchance;
        this.critChance = this.baseCritChance;
        this.totalDamage = this.baseDamage;
        this.fullName = this.baseName + this.level;
    }

    public void lvlUp() {
        this.totalDamage = this.baseDamage * this.level;
        int critMultiplier = 0; //find equasion for this eventually
        this.critChance = this.baseCritChance * critMultiplier + this.baseCritChance;
    }
}