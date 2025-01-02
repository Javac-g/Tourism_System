package Services;

import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ClientService {

    private TourService tourService = new TourService();
    private static int orderCounter = 0;
    private static long clientCounter = 0;

    private static final List<Client_pattern> clients = new ArrayList<>();

    public ClientService(TourService tourService) {
        this.tourService = tourService;
    }
    public List<Client_pattern> getClients(){
        return clients;
    }

    public Client addClient(String firstName,String lastName, String ibanNumber,Set<VACCINATIONS> vaccinations){

        Client client = new Client(clientCounter,firstName,lastName,ibanNumber,vaccinations);
        clients.add(client);
        clientCounter++;
        return client;
    }
    public Client_pattern findByClientNumber(Long number){
        for(Client_pattern client: clients){
            if (client.getId().equals(number)){
                return client;
            }
        }
        return null;
    }
    private Client_pattern makeVip(Client_pattern client){
        int number = -1;
        for (int i = 0; i < clients.size(); i++){
            if (Objects.equals(client.getId(), clients.get(i).getId())){
                number = i;
                break;
            }
        }
        Client_pattern vipClient = new VipClient(clients.get(number),100);
        if(number != -1){
            clients.set(number, vipClient);
        }
        return vipClient;
    }
    public boolean addTourToClient(Long tourNumber,Long clientNumber,int daysCount,boolean nutrition,boolean excursion) {
        Client_pattern client = findByClientNumber(clientNumber);

        Tour tour = tourService.findTourByNumber(tourNumber);
        if(!client.getVaccinations().containsAll(tour.getVaccinations())){
            return false;
        };
        if (client.getOrders().size() == 3 ){
            client = makeVip(client);
        }
        Tour tourClone = tour.clone();
        tourClone.setDays((byte)daysCount);
        tourClone.setNutrition(nutrition);
        tourClone.setExcursion(excursion);
        tourClone.setFinal_cost(tourClone.getFinal_cost() - client.getDiscount());
        Order order = new Order(tourClone);


        if (client != null){
            client.getOrders().add(order);
            order.setId(orderCounter);
            orderCounter++;

            return true;
        }else{
            return false;
        }


    }
    public List<Order> findTourByClientNumber(int clientNumber){
        for(Client_pattern client : clients){
            if(client.getId() == clientNumber){
                return client.getOrders();
            }
        }
        return new ArrayList<>();
    }
    public boolean dropTourByNumber(long orderNum){
        int index = -1;
        for(Client_pattern client:clients){

            for(int i = 0; i <  client.getOrders().size();i++){
                if (client.getOrders().get(i).getId()  == orderNum){
                    index = i;
                    break;
                }
            }if (index != -1){
                client.getOrders().remove(index);
                return true;
            }
        }
        return false;
    }
}
