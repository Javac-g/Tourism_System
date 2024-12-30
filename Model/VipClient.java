package Model;

public class VipClient  extends Client implements Client_pattern{

    private int discount;

    public VipClient(Client_pattern client, int discount){
        super(client.getId(), client.getFirst_name(), client.getLast_name(), client.getIban_number(), client.getVaccinations());
        super.orders = client.getOrders();
        this.discount = discount;
    }
    public int getDiscount(){
        return discount;
    }
}
