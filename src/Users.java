public class Users {
    private String name;
    private int money;

    public Users(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void subtractMoney(int amount) {
        this.money = this.money - amount;
    }

    public void addMoney(int amount) {
        this.money = this.money + amount;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public boolean doIHaveEnoughMoney(int amount) {
        return this.money >= amount;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

}
