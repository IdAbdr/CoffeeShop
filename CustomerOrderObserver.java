public class CustomerOrderObserver implements OrderObserver{
    private String name;
    public CustomerOrderObserver(String name){
        this.name=name;
    }

    @Override
    public void update(CoffeeOrder order) {
        System.out.println(name+": Order for"+order.getCoffeeType()+"is ready.");
    }
}
