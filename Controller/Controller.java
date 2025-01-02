package Controller;

import Services.ClientService;
import Services.TourService;
import View.View;
import Model.*;

import java.util.*;

public class Controller {

    private static final TourService tourService = new TourService();
    private static final ClientService clientService = new ClientService(tourService);

    public  void init_controller(){
        while (true){
            View.print_menu();
            int i = View.getNumber("Menu choose: ");
            if(!executeCommand(i)){
                break;
            }
        }
    }
    private static Set<VACCINATIONS> chooseVaccinations(){
        Set<VACCINATIONS> vaccinations = new HashSet<>();
        View.print_message("Enter exiting vaccinations from list o exit to end");

        for (VACCINATIONS x : VACCINATIONS.values()){
            View.print_message(x.name());
        }
        while(true){
            String str = View.getString("");
            if (str.equals("exit")){
                break;
            }else{
                vaccinations.add(VACCINATIONS.valueOf(str));
            }
        }
        return vaccinations;
    }
    private static boolean executeCommand(int command){
        return switch (command){
            case 1 ->{
                clientService.addClient(
                        View.getString("client name"),
                        View.getString("client last name"),
                        View.getString("client iban"),
                        chooseVaccinations()
                );
                yield true;

            }
            case 2 -> {
                View.print_message("Enter from Country: \n" + Arrays.toString(COUNTRIES.values()));
                String from = View.getString("Select and type");
                String where = View.getString("Select where and type");
                int cost = View.getNumber("Enter cost: ");
                Set<VACCINATIONS> vaccine = chooseVaccinations();
                tourService.addTour(from,where,cost,vaccine);
                yield true;
            }
            case 3 ->{
                View.print_message("Available tours: ");
                for(Tour tour: tourService.getTours()){
                    View.print_message(tour.getId() + " " + tour.getFrom() + " - " + tour.getWhere());
                }
                View.print_message("Available client: ");
                for (Client_pattern client:clientService.getClients()) {

                    View.print_message(client.getId() + ": " + client.getFirst_name() + " " + client.getLast_name());
                }
                long clientNum = View.getNumber(" client number");
                long tourNum = View.getNumber(" tour number");
                int days = View.getNumber(" tour days amount: ");
                boolean nutrition = View.getBoolean("Nutrition");
                boolean excursion = View.getBoolean(" Excursions");


                clientService.addTourToClient(tourNum,clientNum,days,nutrition,excursion);
                Client_pattern client = clientService.findByClientNumber(clientNum);
                View.print_message("Client: " + client.getFirst_name() + " " + client.getLast_name()
                        + " discount: " + client.getDiscount());

                for (Order order: client.getOrders()){
                    View.print_message("Order: " + order.getId() );

                }
                yield true;
            }
            case 4 -> {
                int orderNumber = View.getNumber(" client number to delete");
                clientService.dropTourByNumber(orderNumber);

                yield true;
            }
            case 5 -> {
                int clientNumber = View.getNumber(" client number to find");
                List<Order> orders = clientService.findTourByClientNumber(clientNumber);
                for(Order order : orders){
                    System.out.println(order);
                }
                yield true;
            }
            case 6 ->false;
            default -> throw new IllegalArgumentException("Unknown command");



        };
    }
}
