package Vinnsla;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Leikmadur {
    private SimpleIntegerProperty stada = new SimpleIntegerProperty();
    private final SimpleStringProperty nafn = new SimpleStringProperty();

    public Leikmadur(String nafn) {
        this.nafn.set(nafn);
        stada.set(1);
    }

    public void move(int kast) {
        this.stada.set(this.stada.get() + kast);
    }

    public void reset() {
        this.stada.set(1);
    }

    public int getStada() {
        return stada.get();
    }

    public String getNafn() {
        return nafn.get();
    }

    public static void main(String[] args) {
        Leikmadur lm = new Leikmadur("Hans");
        lm.move(3);
        System.out.println(lm.getNafn() + " færðist á reit " + lm.getStada());
        lm.move(5);
        System.out.println(lm.getNafn() + " færðist á reit " + lm.getStada());
        lm.reset();
        System.out.println(lm.getNafn() + " færðist á reit " + lm.getStada());
    }
}
