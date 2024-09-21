public class Racers {
    private String name;
    private int money;

    public Racers() {
    }

    public Racers(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void subtractMoney(int amount) {
        this.money = this.money - amount;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

}
