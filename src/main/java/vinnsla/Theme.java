package vinnsla;

public enum Theme {
    CLASSIC("Klassískt"),
    FOOTBALL("Fótbolta");

    private String message;

    Theme(String message)
    {
        this.message = message;
    }

    /**
     * aðferð sem sækir gildin á hverju þema enum og geymir það í array
     * @return skilar string lista
     */
    public static String[] getValues() {
        String[] list = new String[Theme.values().length];
        for (Theme d : Theme.values()) {
            list[d.ordinal()] = d.message;
        }
        return list;
    }

    public String getMessage() {
        return message;
    }
}

