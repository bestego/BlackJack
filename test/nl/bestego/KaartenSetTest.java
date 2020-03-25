package nl.bestego;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KaartenSetTest {

    @org.junit.jupiter.api.Test
    void erbijTestBoer() {
        KaartenSet ks = new KaartenSet();
        Kaart k = new Kaart(KaartKleuren.kleur[0], KaartSoorten.soort[10][0], Integer.valueOf(KaartSoorten.soort[10][1]));
        ks.erbij(k);
        ks.berekenTotaal();
        assertEquals(10, ks.getTotaal());
    }

    @org.junit.jupiter.api.Test
    void erbijTestHeerVijf() {
        KaartenSet ks = new KaartenSet();
        ks.erbij(new Kaart(KaartKleuren.kleur[0], KaartSoorten.soort[10][0], Integer.valueOf(KaartSoorten.soort[10][1])));
        ks.erbij(new Kaart(KaartKleuren.kleur[0], KaartSoorten.soort[3][0], Integer.valueOf(KaartSoorten.soort[3][1])));
        ks.berekenTotaal();
        assertEquals(15, ks.getTotaal());
    }

    @org.junit.jupiter.api.Test
    void erbijTestHeerVijfAas() {
        KaartenSet ks = new KaartenSet();
        ks.erbij(new Kaart(KaartKleuren.kleur[0], KaartSoorten.soort[10][0], Integer.valueOf(KaartSoorten.soort[10][1])));
        ks.erbij(new Kaart(KaartKleuren.kleur[0], KaartSoorten.soort[3][0], Integer.valueOf(KaartSoorten.soort[3][1])));
        ks.erbij(new Kaart(KaartKleuren.kleur[0], KaartSoorten.soort[12][0], Integer.valueOf(KaartSoorten.soort[12][1])));
        ks.berekenTotaal();
        assertEquals(16, ks.getTotaal());
    }

    @org.junit.jupiter.api.Test
    void erbijTestHeerAas() {
        KaartenSet ks = new KaartenSet();
        ks.erbij(new Kaart(KaartKleuren.kleur[0], KaartSoorten.soort[10][0], Integer.valueOf(KaartSoorten.soort[10][1])));
        ks.erbij(new Kaart(KaartKleuren.kleur[0], KaartSoorten.soort[12][0], Integer.valueOf(KaartSoorten.soort[12][1])));
        ks.berekenTotaal();
        assertEquals(21, ks.getTotaal());
    }

    @org.junit.jupiter.api.Test
    void erbijAasAasAas() {
        KaartenSet ks = new KaartenSet();
        ks.erbij(new Kaart(KaartKleuren.kleur[0], KaartSoorten.soort[12][0], Integer.valueOf(KaartSoorten.soort[12][1])));
        ks.erbij(new Kaart(KaartKleuren.kleur[0], KaartSoorten.soort[12][0], Integer.valueOf(KaartSoorten.soort[12][1])));
        ks.erbij(new Kaart(KaartKleuren.kleur[0], KaartSoorten.soort[12][0], Integer.valueOf(KaartSoorten.soort[12][1])));
        ks.berekenTotaal();
        assertEquals(13, ks.getTotaal());
    }

    @org.junit.jupiter.api.Test
    void erbijTweeAasAas() {
        KaartenSet ks = new KaartenSet();
        ks.erbij(new Kaart(KaartKleuren.kleur[0], KaartSoorten.soort[0][0], Integer.valueOf(KaartSoorten.soort[0][1])));
        ks.erbij(new Kaart(KaartKleuren.kleur[0], KaartSoorten.soort[12][0], Integer.valueOf(KaartSoorten.soort[12][1])));
        ks.erbij(new Kaart(KaartKleuren.kleur[0], KaartSoorten.soort[12][0], Integer.valueOf(KaartSoorten.soort[12][1])));
        ks.berekenTotaal();
        assertEquals(14, ks.getTotaal());
    }

}