import java.util.Observable;

class CoffeeOrder extends Observable{
    private String coffeeType;
    private CoffeeDecorator coffee;
    private OrderState currentState;

    public CoffeeOrder(String coffeeType, CoffeeDecorator coffee){
        this.coffeeType=coffeeType;
        this.coffee=coffee;
        this.currentState=new WaitingState();
    }

    public void printOrder(){
        System.out.println("Coffee Type: "+coffeeType);
        System.out.println("Extras: "+coffee.getDescription());
        System.out.println("Cost: "+coffee.getCost());
        System.out.println("Order State: "+currentState.getClass().getSimpleName());
    }

    public void setState(OrderState state){
        currentState=state;
    }

    public void processOrder(){
        currentState.handle(this);
        setChanged();
        notifyObservers();
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }
}