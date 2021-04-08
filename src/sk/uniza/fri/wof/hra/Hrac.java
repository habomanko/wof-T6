package sk.uniza.fri.wof.hra;

import sk.uniza.fri.wof.prostredie.Miestnost;
import sk.uniza.fri.wof.prostredie.Prostredie;
import sk.uniza.fri.wof.prostredie.Quest;
import sk.uniza.fri.wof.prostredie.predmety.IKontrolaPolozenia;
import sk.uniza.fri.wof.prostredie.predmety.IPredmet;

import java.util.ArrayList;
import java.util.TreeMap;

public class Hrac {
    private final TreeMap<String, IPredmet> inventar;
    private final ArrayList<Quest> questy;
    private Miestnost aktualnaMiestnost;

    public Hrac(Prostredie prostredie) {
        this.aktualnaMiestnost = prostredie.getStartovaciaMiestnost();
        this.inventar = new TreeMap<>();
        questy = new ArrayList<>();
    }


    public void addQuest(Quest quest) {
        this.questy.add(quest);
    }



    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    public void vypisPopisAktualnejMiestnosti() {
        this.aktualnaMiestnost.vypisPopisMiestnosti();
    }

    public boolean chodVSmere(String smer) {
        Miestnost novaMiestnost = this.aktualnaMiestnost.getMiestnostVSmere(smer);

        if (novaMiestnost == null) {
            return false;
        }

        this.aktualnaMiestnost = novaMiestnost;
        return true;
    }

    public boolean zoberPredmet(String nazov) {
        IPredmet predmet = this.aktualnaMiestnost.zoberPredmet(nazov);
        if (predmet == null) {
            return false;
        }
        this.inventar.put(predmet.getNazov(), predmet);
        return true;
    }

    public void zoberPredmet(IPredmet predmet) {
        this.inventar.put(predmet.getNazov(), predmet);
    }

    public boolean polozPredmet(String nazov) {
        IPredmet predmet = this.inventar.get(nazov);

        if (predmet == null) {
            return false;
        }

        if (predmet instanceof IKontrolaPolozenia) {
            if (!((IKontrolaPolozenia)predmet).getDaSaPolozit()) {
                return false;
            }
        }

        this.inventar.remove(nazov);

        this.aktualnaMiestnost.polozPredmet(predmet);
        return true;
    }

    public boolean pouziPredmet(String nazov) {
        IPredmet predmet = this.inventar.get(nazov);
        if (predmet == null) {
            return false;
        }


        predmet.pouziSa(this);
        return true;
    }
}
