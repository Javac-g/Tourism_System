package Model;

public class Order {

    private boolean open;
    private Tour tour;
    private boolean liked;
    private int id;

    public Order(Tour tour){
        if(tour == null){
            throw new IllegalArgumentException("Wrong tour number");
        }
        this.tour = tour;
        open = true;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Model.Order{" +
                "open=" + open +
                ", tour=" + tour +
                ", liked=" + liked +
                ", id=" + id +
                '}';
    }
}
