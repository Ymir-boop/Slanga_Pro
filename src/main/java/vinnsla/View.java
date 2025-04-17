package vinnsla;


/**
 * View enum sem geymir mismunandi fxml skrár svo auðvelt sé að ná í þær
 */
public enum View {
    START_VIEW("/vidmot/slanga_pro/start-view.fxml"),
    EASY_VIEW("/vidmot/slanga_pro/easy-view.fxml"),
    MEDIUM_VIEW("/vidmot/slanga_pro/medium-view.fxml"),
    HARD_VIEW("/vidmot/slanga_pro/hard-view.fxml"),
    SETTING_VIEW("/vidmot/slanga_pro/setting-view.fxml"),
    END_VIEW("/vidmot/slanga_pro/end-view.fxml");

    /**
     * tilviksbreyta sem geymir nafn skrár
     */
    private String fileName;

    /**
     * smiður sem setur nafn skrár
     * @param fileName nafn skrár
     */
    View(String fileName) {
        this.fileName = fileName;
    }

    /**
     * getter fyrir nafn skráar
     * @return skilar nafni skráar
     */
    public String getFileName() {
        return fileName;
    }
}
