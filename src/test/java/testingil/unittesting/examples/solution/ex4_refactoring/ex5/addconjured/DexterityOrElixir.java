package testingil.unittesting.examples.solution.ex4_refactoring.ex5.addconjured;

public class DexterityOrElixir extends StoredItem {
    public DexterityOrElixir(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (this.item.quality > 0) {
            this.decreaseQuality();
        }
        this.decreaseSellIn();
        if (this.item.quality > 0) {
            if (this.item.sellIn < 0) {
                this.decreaseQuality();
            }
        }
    }
}
