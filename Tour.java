import java.util.HashSet;
import java.util.Set;

public class Tour {

    private Long number;
    private String from, where;
    private int cost, final_cost;
    private boolean nutrition, excursion;
    private byte days;
    private Set<VACCINATIONS> vaccinations;

    public Tour(Long number, String from, String where, int cost, Set<VACCINATIONS> vaccinations) {
        this.number = number;
        this.from = from;
        this.where = where;
        this.cost = cost;
        this.vaccinations = vaccinations;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isNutrition() {
        return nutrition;
    }

    public void setNutrition(boolean nutrition) {
        this.nutrition = nutrition;
    }

    public boolean isExcursion() {
        return excursion;
    }

    public void setExcursion(boolean excursion) {
        this.excursion = excursion;
    }

    public byte getDays() {
        return days;
    }

    public void setDays(byte days) {
        this.days = days;
    }

    public Set<VACCINATIONS> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(Set<VACCINATIONS> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public int getFinal_cost(){

        int final_prise = this.cost * this.days;
        final_prise = excursion ? final_prise + 200 : final_prise;
        final_prise = nutrition ? final_prise + 150 : final_prise;
        return final_prise;

    }
    @Override
    public Tour clone(){
        Set<VACCINATIONS> vaccinations1 = new HashSet<>(vaccinations);
        return new Tour(this.number,this.from , this.where,this.cost,vaccinations1);
    }
    @Override
    public String toString(){
        return "Tour{" +
                "number=" + number +
                "from = " + from +
                "where = " + where +
                "cost = " + cost +
                "final cost = " + final_cost +
                "nutrition = " + nutrition +
                "excursion = " + excursion +
                "days = " + days +
                "vaccination = " + vaccinations +
                "}";
    }
}
