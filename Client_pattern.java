import java.util.List;
import java.util.Set;

public interface Client_pattern {


    List<Order> getOrders();
    Long getId();
    String getFirst_name();
    String getLast_name();
    String getIban_number();
    Set<VACCINATIONS> getVaccinations();
    int getDiscount();

}
