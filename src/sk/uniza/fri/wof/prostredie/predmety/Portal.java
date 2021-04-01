package sk.uniza.fri.wof.prostredie.predmety;

import sk.uniza.fri.wof.prostredie.Miestnost;

public class Portal {
    private Miestnost smerujeDo;
    private Miestnost nachadzaSaV;

    public Portal(Miestnost smerujeDo, Miestnost nachadyaSaV) {
        this.smerujeDo = smerujeDo;
        this.nachadzaSaV = nachadyaSaV;
    }

    public Miestnost getSmerujeDo() {
        return this.smerujeDo;
    }

    public void setSmerujeDo(Miestnost smerujeDo) {
        this.smerujeDo = smerujeDo;
    }

    public Miestnost getNachadzaSaV() {
        return this.nachadzaSaV;
    }

    public void setNachadzaSaV(Miestnost nachadzaSaV) {
        this.nachadzaSaV = nachadzaSaV;
    }
}
