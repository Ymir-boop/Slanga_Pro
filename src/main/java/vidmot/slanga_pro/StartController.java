package vidmot.slanga_pro;

import vinnsla.ViewSwitcher;

public class StartController {

    /**
     * handler fyrir takka "Spila" í upphafsskjá
     * opnar leikinn
     */
    public void onSpila() {
        ViewSwitcher.switchTo(SlangaController.view);
    }
}
