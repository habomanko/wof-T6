package sk.uniza.fri.wof.prostredie;

import sk.uniza.fri.wof.prostredie.npc.*;
import sk.uniza.fri.wof.prostredie.predmety.PortalGun;
import sk.uniza.fri.wof.prostredie.predmety.Predmet;
import sk.uniza.fri.wof.prostredie.predmety.PredmetRusko;

public class Prostredie {
    private final Miestnost startovaciaMiestnost;

    public Prostredie() {
        // vytvorenie miestnosti
        Miestnost ra6 = new Miestnost("RA006 - krasna ucebna, plna pocitacov, mysi a potkanov");
        Miestnost chodbaA = new Miestnost("chodba a - dlha chodba so svetlom monitorov na konci");
        Miestnost wcA = new Miestnost("wc - nezabudni si zobrat mobil, nech sa nenudis");
        Miestnost jedalen = new Miestnost("jedalen - rozvoniava tu jedlo z krabicky");
        Miestnost chodbaC = new Miestnost("chodba c - podzemna chodba");
        Miestnost vestibula = new Miestnost("vestibula - tu zacinas svoju put");
        Miestnost ic = new Miestnost("ic - vdaka mnozstvu knih naokolo tu kazdy vyzera kusok inteligentnejsie");
        Miestnost wcC = new Miestnost("wc - ked musis, tak musis - aj v podzemi");
        Miestnost aula = new Miestnost("aula - nieco ako muciaren");
        Miestnost chodbaB = new Miestnost("chodba b - temna chodba");
        Miestnost chillZone = new Miestnost("chill zone - ak niekto nema internet zo sebou, tu nejaky najde vzdy");

        // inicializacia miestnosti = nastavenie vychodov
        ra6.nastavVychod("vychod", chodbaA);

        chodbaA.nastavVychod("zapad", ra6);
        chodbaA.nastavVychod("vychod", wcA);
        chodbaA.nastavVychod("juh", vestibula);
        chodbaA.nastavVychod("dole", chodbaC);

        wcA.nastavVychod("zapad", chodbaA);

        jedalen.nastavVychod("vychod", chodbaC);

        chodbaC.nastavVychod("zapad", jedalen);
        chodbaC.nastavVychod("zapad2", wcC);
        chodbaC.nastavVychod("juh", aula);
        chodbaC.nastavVychod("hore", chodbaA);

        vestibula.nastavVychod("sever", chodbaA);
        vestibula.nastavVychod("vychod", ic);
        vestibula.nastavVychod("juh", chodbaB);
        vestibula.polozPredmet(new PortalGun());

        NpcDialogVrchol vsetkoMaBoli = new NpcDialogVrchol("Vsetko ma boli, tak nezavadzaj.");
        NpcDialogVrchol padajPrec = new NpcDialogVrchol("Joj, tak padaj prec.");
        NpcDialogVrchol zlaty = new NpcDialogVrchol("Ach to budes zlaty.");
        NpcDialogVrchol donesAspirin = new NpcDialogVrchol(
                "Tak ja neviem, dones mi aspirin.",
                new NpcDialogHrana("Lekarne zavreli kvoli covid", padajPrec),
                new NpcDialogHrana("Skusim nejaky najst", zlaty)
        );
        NpcDialogVrchol uvod = new NpcDialogVrchol(
                "Tak cau.",
                new NpcDialogHrana("Ako sa mas?", vsetkoMaBoli),
                new NpcDialogHrana("Nemas pre mna nejaku ulohu?", donesAspirin)
        );
        NpcDialogVstup korenDialogovehoStromuVratnicka = new NpcDialogVstup("Ahoj, ja som tu nejaka vratnicka. A ty si?", uvod);

        vestibula.postavNpc(new NpcDialogove("vratnicka", korenDialogovehoStromuVratnicka));

        NpcDialogVrchol korenDialogovehoStromuBufetarka = new NpcDialogVrchol("Zatial nemas naprogramovane predmety, tak sa s tebou nebavim");
        vestibula.postavNpc(new NpcDialogove("bufetarka", korenDialogovehoStromuBufetarka));



        NpcDialogQuest korenDialogovehoStromuUcitel = new NpcDialogQuest("Uz meskas na prezentaciu", new Quest("prezentacia", ra6));

        vestibula.postavNpc(new NpcDialogove("ucitel", korenDialogovehoStromuUcitel));

        //vestibula.polozPredmet(new PredmetRusko());
        vestibula.polozPredmet(new Predmet("index"));

        vestibula.postavNpc(new NpcObchodnik("fero", new PredmetRusko(), new Predmet("borovicka")));

        ic.nastavVychod("zapad", vestibula);

        wcC.nastavVychod("vychod", chodbaC);

        aula.nastavVychod("sever", chodbaC);

        chodbaB.nastavVychod("sever", vestibula);
        chodbaB.nastavVychod("juh", chillZone);

        chillZone.nastavVychod("sever", chodbaB);

        this.startovaciaMiestnost = vestibula;
    }



    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}
