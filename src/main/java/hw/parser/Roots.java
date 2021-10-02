package hw.parser;

public enum Roots {
    SUFFERING("^[Сс]трада(.*)");

    private final String pattern;

    Roots(String pattern) {
        this.pattern = pattern;
    }

    public String pattern() {
        return pattern;
    }
}
