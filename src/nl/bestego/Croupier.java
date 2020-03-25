package nl.bestego;

public class Croupier {

    public void deel(KaartenSet stapel, int aantal, Speler speler) {
        for (int i = 1; i <= aantal; i++) {
            Kaart kaart = stapel.eraf();
            if (kaart != null) {
                speler.ontvangKaart(kaart);
            }
        }
    }
}
