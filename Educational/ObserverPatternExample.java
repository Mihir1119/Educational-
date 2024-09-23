import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(Stock stock);
}

class Stock {
    private String name;
    private double price;
    private List<Observer> observers = new ArrayList<>();

    public Stock(String name) {
        this.name = name;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(Stock stock) {
        System.out.println(name + " notified! New price of " + stock.getName() + " is " + stock.getPrice());
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        Stock stock = new Stock("AAPL");
        Investor investor1 = new Investor("John");
        Investor investor2 = new Investor("Jane");

        stock.addObserver(investor1);
        stock.addObserver(investor2);

        stock.setPrice(150.0); // Both investors are notified
    }
}
