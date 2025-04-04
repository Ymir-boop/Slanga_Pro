package vinnsla;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ViewSwitcher {

    private static final Map<View, Parent> cache = new HashMap<>();

    private static Scene scene;

    /**
     * Setur núverandi senu í ViewSwitcher sem scene - enginn breyting á glugga
     *
     * @param scene senan
     */
    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    /**
     * Skipta yfir í senu sem er lýst í view
     *
     * @param view view
     */
    public static void switchTo(View view) {
        if (scene == null) {
            System.out.println("No scene was set");
            return;
        }

        try {
            Parent root;
            if (cache.containsKey(view)) {
                System.out.println("Loading from cache");

                root = cache.get(view);
            } else {
                System.out.println("Loading from FXML");
                System.out.println("Trying to load: " + view.getFileName());
                System.out.println("Resolved path: " + ViewSwitcher.class.getResource(view.getFileName()));
                root = FXMLLoader.load(
                        ViewSwitcher.class.getResource(view.getFileName())
                );
                cache.put(view, root);
            }
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}

