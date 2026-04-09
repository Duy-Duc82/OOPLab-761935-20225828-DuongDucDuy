#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$ROOT_DIR"

export GIT_AUTHOR_NAME="Dương Đức Duy"
export GIT_AUTHOR_EMAIL="duongducduy825@gmail.com"
export GIT_COMMITTER_NAME="$GIT_AUTHOR_NAME"
export GIT_COMMITTER_EMAIL="$GIT_AUTHOR_EMAIL"

SRC_DIR="lab02/AimsProject/src"
mkdir -p "$SRC_DIR"
mkdir -p "lab02/Requirement" "lab02/Design" "lab02/ReadingAssignment"

write_step1_files() {
cat <<'EOF' > "$SRC_DIR/DigitalVideoDisc.java"
public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }
}
EOF

cat <<'EOF' > "$SRC_DIR/Aims.java"
public class Aims {
    public static void main(String[] args) {
    }
}
EOF
}

write_step2_files() {
cat <<'EOF' > "$SRC_DIR/Cart.java"
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc == null) {
            return;
        }

        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc == null) {
            return;
        }

        int foundIndex = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {
            System.out.println("The disc was not found");
            return;
        }

        for (int i = foundIndex; i < qtyOrdered - 1; i++) {
            itemsOrdered[i] = itemsOrdered[i + 1];
        }

        itemsOrdered[qtyOrdered - 1] = null;
        qtyOrdered--;
        System.out.println("The disc has been removed");
    }

    public float totalCost() {
        float totalCost = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }
}
EOF

cat <<'EOF' > "$SRC_DIR/Aims.java"
public class Aims {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Animation", "Star Wars", 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Quentin Tarantino", "Drama", "Pulp Fiction", 14.99f);

        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        System.out.println("Total cost: " + cart.totalCost());

        cart.removeDigitalVideoDisc(dvd2);

        System.out.println("Total cost after removal: " + cart.totalCost());
    }
}
EOF
}

write_step3_files() {
cat <<'EOF' > "$SRC_DIR/Cart.java"
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc == null) {
            return;
        }

        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (dvdList == null) {
            return;
        }

        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc == null) {
            return;
        }

        int foundIndex = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {
            System.out.println("The disc was not found");
            return;
        }

        for (int i = foundIndex; i < qtyOrdered - 1; i++) {
            itemsOrdered[i] = itemsOrdered[i + 1];
        }

        itemsOrdered[qtyOrdered - 1] = null;
        qtyOrdered--;
        System.out.println("The disc has been removed");
    }

    public float totalCost() {
        float totalCost = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }
}
EOF
}

write_step4_files() {
cat <<'EOF' > "$SRC_DIR/DigitalVideoDisc.java"
public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
EOF

cat <<'EOF' > "$SRC_DIR/TestPassingParameter.java"
public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungle = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderella = new DigitalVideoDisc("Cinderella");

        System.out.println("Before swap:");
        System.out.println("Jungle title: " + jungle.getTitle());
        System.out.println("Cinderella title: " + cinderella.getTitle());

        swap(jungle, cinderella);

        System.out.println("After swap:");
        System.out.println("Jungle title: " + jungle.getTitle());
        System.out.println("Cinderella title: " + cinderella.getTitle());

        changeTitle(jungle, "The Jungle Book");

        System.out.println("After changeTitle:");
        System.out.println("Jungle title: " + jungle.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
EOF
}

write_step5_files() {
cat <<'EOF' > "$SRC_DIR/DigitalVideoDisc.java"
public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0;

    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public DigitalVideoDisc(String title) {
        this.title = title;
        assignId();
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        assignId();
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        assignId();
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        assignId();
    }

    private void assignId() {
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
EOF
}

step1() {
    git checkout -B feature/initial-aims master
    write_step1_files
    git add "$SRC_DIR/DigitalVideoDisc.java" "$SRC_DIR/Aims.java"
    git commit -m "Add Aims and DVD classes"
    git checkout master
    git merge feature/initial-aims
}

step2() {
    git checkout -B feature/manage-cart master
    write_step2_files
    git add "$SRC_DIR/Cart.java" "$SRC_DIR/Aims.java"
    git commit -m "Add Cart class and test in Aims"
    git checkout master
    git merge feature/manage-cart
}

step3() {
    git checkout -B topic/method-overloading master
    write_step3_files
    git add "$SRC_DIR/Cart.java"
    git commit -m "Overload addDigitalVideoDisc method in Cart"
    git checkout master
    git merge topic/method-overloading
}

step4() {
    git checkout -B topic/passing-parameters master
    write_step4_files
    git add "$SRC_DIR/DigitalVideoDisc.java" "$SRC_DIR/TestPassingParameter.java"
    git commit -m "Add TestPassingParameter to demonstrate pass by value"
    git checkout master
    git merge topic/passing-parameters
}

step5() {
    git checkout -B topic/classifier-and-instance-member master
    write_step5_files
    git add "$SRC_DIR/DigitalVideoDisc.java"
    git commit -m "Add class and instance members for ID generation"
    git checkout master
    git merge topic/classifier-and-instance-member
}

step6() {
    git checkout -B release/lab02 master
    : > lab02/answers.txt
    git add lab02/answers.txt
    git commit -m "Final release for Lab 02"
}

step1
step2
step3
step4
step5
step6

echo "Lab 02 release flow completed. Current branch: $(git branch --show-current)"
