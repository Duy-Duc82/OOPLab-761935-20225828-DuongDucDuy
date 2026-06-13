package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {

    // ================= COMPARATORS =================

    public static final Comparator<Media>
            COMPARE_BY_TITLE_COST =
            new MediaComparatorByTitleCost();

    public static final Comparator<Media>
            COMPARE_BY_COST_TITLE =
            new MediaComparatorByCostTitle();

    // ================= ATTRIBUTES =================

    private int id;
    private String title;
    private String category;
    private float cost;

    // ================= CONSTRUCTOR =================

    public Media(int id,
                 String title,
                 String category,
                 float cost) {

        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // ================= GETTER =================

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    // ================= EQUALS =================

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (obj instanceof Media) {

            Media media = (Media) obj;
            if (this.title == null || media.title == null) {
                return false;
            }

            return this.title.equals(
                    media.title
            );
        }

        return false;
    }

    // ================= TOSTRING =================

    @Override
    public String toString() {

        return title + " - "
                + category + " - "
                + cost + "$";
    }
}