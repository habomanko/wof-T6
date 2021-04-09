package sk.uniza.fri.wof.prostredie;

import sk.uniza.fri.wof.hra.Hrac;
import sk.uniza.fri.wof.prostredie.predmety.IPredmet;

public class PredmetUSB implements IPredmet {

    private Quest prezentaciaQuest;
    public PredmetUSB(Quest prezentaciaQuest) {

        this.prezentaciaQuest = prezentaciaQuest;
    }


    @Override
    public String getNazov() {
        return "usb";
    }

    @Override
    public void pouziSa(Hrac hrac) {
        if (hrac.getAktualnaMiestnost().getPopis().startsWith("RA006")) {
            prezentaciaQuest.overDokoncenieVstupomDoMiestnosti(hrac);
        } else {
            System.out.println("Mozes ma pouzit len v RA006");
        }
    }


}
