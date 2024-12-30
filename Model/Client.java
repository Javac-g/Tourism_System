package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Client implements Client_pattern {

    protected Long id;
    protected String First_name, Last_name, Iban_number;
    protected Set<VACCINATIONS> vaccinations;
    protected List<Order> orders = new ArrayList<>();

    public Client(Long id, String first_name, String last_name, String iban_number, Set<VACCINATIONS> vaccinations) {
        this.id = id;
        First_name = first_name;
        Last_name = last_name;
        Iban_number = iban_number;
        this.vaccinations = vaccinations;
    }

    public int getDiscount(){
        return 1;
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public String getFirst_name() {
        return First_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public String getIban_number() {
        return Iban_number;
    }

    @Override
    public Set<VACCINATIONS> getVaccinations() {
        return vaccinations;
    }
}
