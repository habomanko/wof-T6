package sk.uniza.fri.wof.prostredie;

import sk.uniza.fri.wof.hra.Hrac;
import sk.uniza.fri.wof.prostredie.npc.INpcDialogVrchol;

public class NpcDialogQuest implements INpcDialogVrchol {


    private String replikaNpc;
    private Quest quest;

    public NpcDialogQuest(String replikaNpc, Quest quest) {

        this.replikaNpc = replikaNpc;
        this.quest = quest;
    }

    public INpcDialogVrchol vykonaj(Hrac hrac) {
        System.out.println(this.replikaNpc);
        hrac.addQuest(this.quest);
        return null;
    }

}
