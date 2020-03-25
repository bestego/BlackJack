package nl.bestego;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * BlackJack spel enekel gebruik makend van de 'OCA functionaliteit'
 */
public class Blackjack {

    final int stokGrootte = 1;
    int ronde = 0;
    ArrayList<Speler> spelers = new ArrayList<>();
    Speler bank = new Speler("bank");
    Croupier croupier = new Croupier();
    Scanner input = new Scanner(System.in);
    KaartenSet dealer = new KaartenSet();

    public static void main(String[] args) {

        Blackjack bj = new Blackjack();

        /* schud kaart een toon resultaat */
        bj.dealer.nieuweStok(bj.stokGrootte);
        bj.dealer.schud(2);
        bj.dealer.toon();

        System.out.printf("\n *** START SPEL ***\n\n");

        /* definieer speler(s)
         * geeft ieder speler 2 kaarten
         * geef bank 1 kaart */
        bj.maakSpelers();
        for (Speler speler : bj.spelers) {
            bj.croupier.deel(bj.dealer, 2, speler);
        }
        bj.bank.setBank();
        bj.croupier.deel(bj.dealer, 1, bj.bank);

        // deelnamers spelen

        for (Speler speler : bj.spelers) {
            speler.printSpeler();
            switch (speler.vraagActie()) {
                case 'K':
                    do {
                        bj.croupier.deel(bj.dealer, 1, speler);
                        speler.printSpeler();
                    } while (speler.getKaartenSet().getTotaal() < 21 && speler.isJa(", wil je nog een kaart? (J)a of (N)ee"));
                    break;
                case 'P':
                    speler.printSpeler();
                    break;
                default:
                    System.out.printf("\n%s", "Onverwachte actie ... programma wordt gestopt");
                    return;
            } // switch vraagActie
        } // for speler

        // bank speelt
        while (bj.bank.getKaartenSet().getTotaal() < 17) {
            bj.croupier.deel(bj.dealer, 1, bj.bank);
        }
        bj.bank.printSpeler();

        // eind evaluatie
        bj.eindEvaluatie();

    } // main

    private void maakSpelers() {
        do {
            System.out.println("Voer naam in van speler: " + (spelers.size() + 1) + " (geen naam om verder te gaan)");
            String naam = input.nextLine();
            if (naam.length() == 0) {
                if (spelers.size() == 0) {
                    continue;
                } else {
                    break;
                }
            }
            spelers.add(new Speler(naam));
        } while (true);

        System.out.print("Spelers zijn: ");
        for (Speler s : spelers) {
            System.out.print(s.getNaam() + " ");
        }
        System.out.println();
    }


    private void eindEvaluatie() {
        /* bepaal winnaar */
        int bankTotaal = bank.getKaartenSet().getTotaal();

        // bank heeft bj
        if (bank.getKaartenSet().getTotaal() == 21) {
            for (Speler speler : spelers) {
                if (speler.getKaartenSet().getTotaal() > bankTotaal)
                    System.out.printf("\n%s verliest inzet", speler.getNaam());
                if (speler.getKaartenSet().getTotaal() == bankTotaal)
                    System.out.printf("\n%s behoudt inzet", speler.getNaam());
                if (speler.getKaartenSet().getTotaal() < bankTotaal)
                    System.out.printf("\n%s verliest inzet", speler.getNaam());
            }
        }

        // bank <21
        if (bankTotaal < 21) {
            for (Speler speler : spelers) {
                int spelerTotaal = speler.getKaartenSet().getTotaal() > 21 ? 0 : speler.getKaartenSet().getTotaal();
                if (spelerTotaal > bankTotaal) System.out.printf("\n%s krijgt uitbetaald", speler.getNaam());
                if (spelerTotaal == bankTotaal) System.out.printf("\n%s behoudt inzet", speler.getNaam());
                if (spelerTotaal < bankTotaal) System.out.printf("\n%s verliest inzet", speler.getNaam());
            }
        }

        if (bankTotaal > 21) {
            for (Speler speler : spelers) {
                if (speler.getKaartenSet().getTotaal() <= 21) {
                    System.out.printf("\n%s krijgt inzet uitbetaald", speler.getNaam());
                } else {
                    System.out.printf("\n%s verliest inzet", speler.getNaam());
                }
            }
        }

    } // eindEvaluatie

}
