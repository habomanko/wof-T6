package sk.uniza.fri.wof.prostredie.predmety;

import sk.uniza.fri.wof.hra.Hrac;

public class PortalGun implements IPredmet {

    private final Portal modry;
    private final Portal oranzovy;
    private String aktualnyPortal;


    public PortalGun() {
        this.aktualnyPortal = "Modry";
        this.modry = new Portal(null, null);
        this.oranzovy = new Portal(null, null);
    }

    @Override
    public String getNazov() {
        return "PortalGun";
    }

    @Override
    public void pouziSa(Hrac hrac) {

        if (this.aktualnyPortal.equals("Modry")) {
            if (this.modry.getNachadzaSaV() != null) {
                this.modry.getNachadzaSaV().zmazVychod("modryPortal");
            }

            this.modry.setNachadzaSaV(hrac.getAktualnaMiestnost());
            hrac.getAktualnaMiestnost().nastavVychod("modryPortal", null);
            System.out.println("Polozil si modry portal v miestnosti " + hrac.getAktualnaMiestnost().getPopis());
            this.aktualnyPortal = "Oranzovy";
            if (this.oranzovy.getNachadzaSaV() != null) {
                this.modry.setSmerujeDo(this.oranzovy.getNachadzaSaV());
                hrac.getAktualnaMiestnost().nastavVychod("modryPortal", this.oranzovy.getNachadzaSaV());
                this.oranzovy.getNachadzaSaV().nastavVychod("oranzovyPortal", this.modry.getNachadzaSaV());
            }
        } else {
            if (this.oranzovy.getNachadzaSaV() != null) {
                this.oranzovy.getNachadzaSaV().zmazVychod("oranzovyPortal");
            }

            this.oranzovy.setNachadzaSaV(hrac.getAktualnaMiestnost());
            this.oranzovy.setSmerujeDo(this.modry.getNachadzaSaV());
            hrac.getAktualnaMiestnost().nastavVychod("oranzovyPortal", this.modry.getNachadzaSaV());
            System.out.println("Polozil si oranzovy portal v miestnosti " + hrac.getAktualnaMiestnost().getPopis());
            this.aktualnyPortal = "Modry";
            this.modry.getNachadzaSaV().nastavVychod("modryPortal", this.oranzovy.getNachadzaSaV());
        }
    }
}
