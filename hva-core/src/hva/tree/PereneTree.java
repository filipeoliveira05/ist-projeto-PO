package hva.tree;

import hva.state.Season;
import hva.state.SeasonState;
import hva.state.PrimaveraState;
import hva.state.VeraoState;
import hva.state.OutonoState;
import hva.state.InvernoState;

import java.io.Serial;

public class PereneTree extends Tree {

    @Serial
    private static final long serialVersionUID = 202410081403L;

    public PereneTree(String id, String name, int age, int difficulty, Season season) {
        super(id, name, age, difficulty, season);
    }

    @Override
    public String getType() {
        return "PERENE";
    }

    @Override
    public int getSpecificSeasonalEffort(SeasonState seasonState) {
        if (seasonState instanceof PrimaveraState || seasonState instanceof VeraoState || seasonState instanceof OutonoState) {
            return 1;
        } else if (seasonState instanceof InvernoState) {
            return 2;
        }
        return 0;
    }

    @Override
    public String getSpecificBiologicalCycle(SeasonState seasonState) {
        if (seasonState instanceof PrimaveraState) {
            return "GERARFOLHAS";
        } else if (seasonState instanceof VeraoState || seasonState instanceof OutonoState) {
            return "COMFOLHAS";
        } else if (seasonState instanceof InvernoState) {
            return "LARGARFOLHAS";
        }
        return "";
    }
}
