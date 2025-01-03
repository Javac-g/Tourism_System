package Services;

import Model.Tour;
import Model.VACCINATIONS;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TourService {
    private static  final List<Tour> tours = new ArrayList<>();
    private long tourNamber = 0;

    public List<Tour> getTours(){
        return tours;
    }
    public Tour findTourByNumber(Long number){
        for (Tour tour:tours ){
            if (tour.getId().equals(number)){
                return tour;
            }
        }
        return null;
    }
    public Tour addTour( String from,String where,int cost,Set<VACCINATIONS> vaccinations){

        Tour tour = new Tour(tourNamber,from,where,cost,vaccinations);

        tours.add(tour);
        tourNamber++;
        return tour;

    }

}