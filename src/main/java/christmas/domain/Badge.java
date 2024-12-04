package christmas.domain;

public enum Badge {
    START("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    NOTHING("없음", 0);

    private final String name;
    private final int amount;

    Badge(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public static Badge findByPurchaseAmount(int amount) {
        if (amount >= SANTA.amount) {
            return SANTA;
        } else if (amount >= TREE.amount) {
            return TREE;
        } else if (amount >= START.amount) {
            return SANTA;
        }
        return NOTHING;
    }

    @Override
    public String toString() {
        return name;
    }

}
