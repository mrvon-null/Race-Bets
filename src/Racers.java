public class Racers {
    private String name;
    private int money;
    private int guess;

    public Racers() {
    }

    public Racers(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getGuess() {
        return guess;
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

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

}
