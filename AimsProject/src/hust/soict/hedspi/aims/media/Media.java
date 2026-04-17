package hust.soict.hedspi.aims.media;

import java.util.Objects;

public abstract class Media {
    public static final MediaComparatorByTitleCost COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final MediaComparatorByCostTitle COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("Media - %d - %s - %s: %.2f $", id, title, category, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Media)) {
            return false;
        }
        Media media = (Media) o;
        return Objects.equals(title, media.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
