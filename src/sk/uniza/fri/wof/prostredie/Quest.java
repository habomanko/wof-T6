package sk.uniza.fri.wof.prostredie;

import sk.uniza.fri.wof.hra.Hrac;

public class Quest {

    private String nazovQuestu;
    private boolean jeDokonceny;
    private Miestnost miestnostVykonavania;

    public Quest(String nazovQuestu, Miestnost miestnostVykonavania) {
        this.nazovQuestu = nazovQuestu;
        this.jeDokonceny = false;
        this.miestnostVykonavania = miestnostVykonavania;
    }

    public void overDokoncenie(Hrac hrac) {
        if (hrac.getAktualnaMiestnost() == this.miestnostVykonavania && !this.jeDokonceny) {
            this.jeDokonceny = true;
            System.out.printf("Prave si dokoncil quest %s.", this.nazovQuestu);
        }
    }

    public boolean isJeDokonceny() {
        return this.jeDokonceny;
    }

    public String getNazovQuestu() {
        return this.nazovQuestu;
    }
}
