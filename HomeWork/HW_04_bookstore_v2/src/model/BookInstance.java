package model;

import java.util.List;

public class BookInstance {
    private int id;
    private boolean inStock;
    private List<Branch> branches;

    public BookInstance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    @Override
    public String toString() {
        return "BookInstance{" +
                "id=" + id +
                ", inStock=" + inStock +
                ", branches=" + branches +
                '}';
    }
}
