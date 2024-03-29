package testingil.unittesting.examples.solution.ex4_refactoring.ex6.notify;

public abstract class StoredItem {
    protected Item item;
    protected String message;

    public StoredItem(Item item) {
        this.item = item;
        this.message = "";
    }

    public abstract void update();

    protected void decreaseSellIn() {
        this.item.sellIn = this.item.sellIn - 1;
    }

    protected void increaseQuality() {
        this.item.quality = this.item.quality + 1;
    }

    protected void decreaseQuality() {
        this.item.quality = this.item.quality - 1;
    }

    protected void updateMessage()
    {
        this.message = String.format("{0} Updated - Quality: {1}, SellIn: {2}"
                , item.name, item.quality, item.sellIn);
    }}

