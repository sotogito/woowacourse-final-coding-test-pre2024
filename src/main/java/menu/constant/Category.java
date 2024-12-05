package menu.constant;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식:", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private final String name;
    private final int value;
    public final int MIN = 1;
    public final int MAX = 5;

    Category(String name, int value) {
        this.name = name;
        this.value = value;
    }

    //note 1
    public static Category findByName(String name) {
        for (Category category : Category.values()) {
            if (category.name.equals(name)) {
                return category;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 카테고리");
    }

    //note 1
    public static String findByNumber(int number) {
        for (Category category : Category.values()) {
            if (category.value == number) {
                return category.name;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 카테고리");
    }


}
