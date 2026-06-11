package entities;

public abstract class MainAbstract {
    protected long Id;

    public MainAbstract(long id) {
        this.Id = id;
    }

    public long getId() {
        return Id;
    }
}