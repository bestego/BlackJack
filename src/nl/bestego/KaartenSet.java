package nl.bestego;

import java.util.ArrayList;
import java.util.Random;

/**
 * bevat set van kaarten
 * laatst onvangen kaart ligt boven op stapel
 */
public class KaartenSet {
    private ArrayList<Kaart> set = new ArrayList<>();
    private int totaal;

    public void nieuweStok(int aantal) {
        set.clear();
        for (int i = 1; i <= aantal; i++) {
            for (String[] soort : KaartSoorten.soort) {
                for (String kleur : KaartKleuren.kleur) {
                    set.add(new Kaart(kleur, soort[0], Integer.parseInt(soort[1])));
                    //totaal += Integer.parseInt(soort[1]);
                }
            }
        }
        berekenTotaal();
    }

    public void toon() {
        toon(false);
    }

    public void toon(boolean laatsteVerbergen) {
        int i = laatsteVerbergen ? 1 : 0;
        for (int k = 0; k < set.size() - i; k++) {
            System.out.println(set.get(k));
        }
        if (laatsteVerbergen) {
            System.out.println("omgekeerde kaart");
        }
    }

    public int getAantal() {
        return set.size();
    }

    public int getTotaal() {
        return totaal;
    }

    public void berekenTotaal() { //ToDo: error in calc, e.g. B/H/V geeft 20 punten!
        int azen = 0, standaard = 0, volleAzen, resultaat;
        for (Kaart kaart : set) {
            if (kaart.waarde == 11) {
                azen += kaart.waarde / 11;
            } else {
                standaard += kaart.waarde;
            }
        }

        if (azen == 0) {
            totaal = standaard;
        } else {
//            resultaat = standaard + (azen - 1);
//            rest = 21 - standaard - (azen - 1);
//            totaal = rest > 11 ? resultaat = resultaat + 11 : resultaat + 1;
            volleAzen = (21 - standaard) / 11;
            totaal = standaard + volleAzen * 11 + (azen - volleAzen) * 1;

        }
    }

    public void schud() {
        schud(1);
    }

    public void schud(int keer) {
        for (int k = 1; k <= keer; k++) {
            ArrayList<Kaart> geschud = new ArrayList<>();
            Random rnd = new Random();
            while (set.size() > 0) {
                int i = set.size() > 1 ? rnd.nextInt(set.size()) : 0; // nextInt(>0)
                geschud.add(set.remove(i));
            }
            set = geschud;
        }
    }

    public void erbij(Kaart kaart) {
        set.add(kaart);
        //totaal += kaart.waarde;
        berekenTotaal();
    }

    public Kaart eraf() {
        Kaart kaart = null;
        if (set.size() > 0) {
            kaart = set.remove(set.size() - 1);
            berekenTotaal();
        }
        return kaart;
    }


}
