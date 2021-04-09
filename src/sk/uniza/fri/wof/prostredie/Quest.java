package sk.uniza.fri.wof.prostredie;

import sk.uniza.fri.wof.hra.Hrac;

public class Quest {

    private String nazovQuestu;
    private boolean jeDokonceny;
    private Miestnost miestnostVykonavania;
    private String spravaPriVstupDoMiestnosti;

    public Quest(String nazovQuestu, Miestnost miestnostVykonavania, String spravaPriVstupDoMiestnosti) {
        this.nazovQuestu = nazovQuestu;
        this.spravaPriVstupDoMiestnosti = spravaPriVstupDoMiestnosti;
        this.jeDokonceny = false;
        this.miestnostVykonavania = miestnostVykonavania;
    }

    public void overDokoncenieVstupomDoMiestnosti(Hrac hrac) {
        if (hrac.getAktualnaMiestnost() == this.miestnostVykonavania && !this.jeDokonceny) {
            this.jeDokonceny = true;
            System.out.printf("Prave si dokoncil quest %s.%n", this.nazovQuestu);
            hrac.odstranQuest(this);
        }
    }






    public boolean jeDokonceny() {
        return this.jeDokonceny;
    }

    public String getNazovQuestu() {
        return this.nazovQuestu;
    }

    public void vstupDoMiestnosti(Hrac hrac) {
        if (hrac.getAktualnaMiestnost() == this.miestnostVykonavania && !this.jeDokonceny) {
            System.out.println(this.spravaPriVstupDoMiestnosti);
        }
    }
}
