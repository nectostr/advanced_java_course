public class Pokemon {
    private int health = 100;
    private int[] attack = {10};
    private int level = 1;
    private int[] defend = {5};
    private int energy = 3;
    private int restLevel = (health/10)-level*5 > 0 ? (health/10)-level*5 : 0;

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int[] attack) {
        this.attack = attack;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDefend(int[] defend) {
        this.defend = defend;
    }

    public int getHealth() {
        return health;
    }

    public int[] getAttack() {
        return attack;
    }

    public int getLevel() {
        return level;
    }

    public int[] getDefend() {
        return defend;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getRestLevel() {
        return restLevel;
    }

    public void setRestLevel(int restLevel) {
        this.restLevel = restLevel;
    }
}
