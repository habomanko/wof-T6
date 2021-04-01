package sk.uniza.fri.wof.prostredie.predmety;

import sk.uniza.fri.wof.hra.Hrac;
public class PredmetRusko implements IPredmet, IKontrolaPolozenia {
    private boolean nasadene;

    public PredmetRusko() {
        this.nasadene = false;
    }

    @Override
    public String getNazov() {
        return "rusko";
    }

    @Override
    public void pouziSa(Hrac hrac) {
        if (this.nasadene) {
            System.out.println("Zlozil si si rusko");
            this.nasadene = false;
        } else {
            System.out.println("Nasadil si si rusko");
            this.nasadene = true;
        }
    }

    @Override
    public boolean getDaSaPolozit() {
        return !this.nasadene;
    }
}
