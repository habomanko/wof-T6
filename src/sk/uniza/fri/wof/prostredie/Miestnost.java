package sk.uniza.fri.wof.prostredie;

import sk.uniza.fri.wof.prostredie.npc.Npc;
import sk.uniza.fri.wof.prostredie.predmety.IPredmet;

import java.util.Set;
import java.util.TreeMap;

/**
 * Trieda sk.uniza.fri.wof.prostredie.Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je z inymi miestnostami spojena vychodmi. 
 * Vychody z miestnosti su oznacovane svetovymi stranami sever, vychod, juh
 * a zapad. Pre kazdy vychod si miestnost pamata odkaz na susednu miestnost
 * alebo null, ak tym smerom vychod nema.
 *
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Miestnost {
    private final String popisMiestnosti;
    private final TreeMap<String, Miestnost> vychody;
    private final TreeMap<String, Npc> npccka;
    private final TreeMap<String, IPredmet> predmety;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */
    public Miestnost(String popis) {
        this.popisMiestnosti = popis;
        this.vychody = new TreeMap<>();
        this.npccka = new TreeMap<>();
        this.predmety = new TreeMap<>();
    }

    public void nastavVychod(String smer, Miestnost ciel) {
        this.vychody.put(smer, ciel);
    }

    public void zmazVychod(String smer) {
        this.vychody.remove(smer);
    }

    /**
     * @return textovy popis miestnosti.
     */
    public String getPopis() {
        return this.popisMiestnosti;
    }

    public void vypisPopisMiestnosti() {
        System.out.println("Teraz si v miestnosti " + this.getPopis());
        this.vypisPolozky("Vychody", this.vychody.keySet());
        this.vypisPolozky("NPC", this.npccka.keySet());
        this.vypisPolozky("Predmety", this.predmety.keySet());
    }

    private void vypisPolozky(String nadpis, Set<String> polozky) {
        if (!polozky.isEmpty()) {
            System.out.format("%s: ", nadpis);
            for (String smer : polozky) {
                System.out.printf("%s ", smer);
            }
            System.out.println();
        }
    }

    public Miestnost getMiestnostVSmere(String smer) {
        return this.vychody.get(smer);
    }

    public void postavNpc(Npc npc) {
        this.npccka.put(npc.getMeno(), npc);
    }

    public Npc getNpc(String meno) {
        return this.npccka.get(meno);
    }

    public void polozPredmet(IPredmet predmet) {
        this.predmety.put(predmet.getNazov(), predmet);
    }

    public IPredmet zoberPredmet(String nazov) {
        return this.predmety.remove(nazov);
    }

}
