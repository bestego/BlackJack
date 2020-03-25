package nl.bestego;

import java.util.Scanner;

public class Speler {
    private boolean isBank = false;
    private boolean isDead = false;

    private String naam;
    private KaartenSet set = new KaartenSet();

    Speler(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setBank() {
        isBank = true;
    }

    public void setDead(){
        isDead = true;
    }

    public boolean isBank() {
        return isBank;
    }

    public boolean isDead(){
        return isDead;
    }

    public void ontvangKaart(Kaart kaart) {
        set.erbij(kaart);
    }

    public KaartenSet getKaartenSet() {
        return set;
    }

    public char vraagActie() {
        Scanner input = new Scanner(System.in);
        System.out.println(naam + ", wat wil je doen? (K)aart vragen, (P)assen");
        String line;
        char actie;
        do {
            line = input.nextLine().toUpperCase();
            actie = line.length() == 0 ? '0': line.charAt(0);
            if (actie == 'K' | actie == 'P') {
                break;
            } else {
                System.out.println("Ongeldige invoer, probeer opniew:");
            }
        } while (true);
        return actie;
    }

    public boolean isJa(String msg) {
        Scanner input = new Scanner(System.in);
        System.out.println(naam + msg);
        String line;
        char actie;
        do {
            line = input.nextLine().toUpperCase();
            actie = line.length() == 0 ? '0': line.charAt(0);
            if (actie == 'J' | actie == 'N') {
                break;
            } else {
                System.out.println("Ongeldige invoer, probeer opniew:");
            }
        } while (true);
        return actie == 'J';
    }


    public void printBank() {
        System.out.println();
        System.out.println(naam + ":");
        set.toon(isBank);
    }

    public void printSpeler() {
        System.out.println();
        System.out.println(naam + ": " + set.getTotaal() + " punten");
        set.toon();
    }

}
