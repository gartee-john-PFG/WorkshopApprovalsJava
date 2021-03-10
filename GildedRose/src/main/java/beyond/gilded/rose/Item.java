package beyond.gilded.rose;

public class Item {
    public static final String WEAPONS = "weapons";
    public static final String APPAREL = "apparel";
    public static final String POTIONS = "potions";
    public static final String SCROLLS = "scrolls";
    public static final String FOOD = "food";
    public static final String INGREDIENTS = "ingredients";
    public static final String BOOKS = "books";
    public static final String KEYS = "keys";
    public static final String MISC = "misc";

    private String name;
    private int sellIn;
    private int quality;
    private String type;
    private int weight;
    private int value;
    private Character owner;
    private Realm realm;

    public Item(String name, int sellIn, int quality, String type, int weight, int value, Character owner, Realm realm) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.type = type;
        this.weight = weight;
        this.value = value;
        this.owner = owner;
        this.realm = realm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Character getOwner() {
        return owner;
    }

    public void setOwner(Character owner) {
        this.owner = owner;
    }

    public Realm getRealm() {
        return realm;
    }

    public void setRealm(Realm realm) {
        this.realm = realm;
    }
}
