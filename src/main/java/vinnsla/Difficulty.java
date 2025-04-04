package vinnsla;

public enum Difficulty {
    EASY("Létt"),
    MEDIUM("Miðlungs"),
    HARD("Erfitt");

    private String message;

    Difficulty(String message)
    {
        this.message = message;
    }

    /**
     * aðferð sem sækir gildin á hverju Difficulty enum og geymir það í array
     * @return skilar string lista
     */
    public static String[] getValues() {
        String[] list = new String[Difficulty.values().length];
        for (Difficulty d : Difficulty.values()) {
            list[d.ordinal()] = d.message;
        }
        return list;
    }

    public String getMessage() {
        return message;
    }
}

