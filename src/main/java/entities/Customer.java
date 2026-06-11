package entities;


public class Customer extends MainAbstract {
    private String name;
    private int tier;

    public Customer(long id, String name, int tier) {
        super(id);
        this.name = name;
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    public int getTier() {
        return tier;
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}