package hva.tree;

import hva.state.Season;
import hva.state.SeasonState;
import hva.state.PrimaveraState;
import hva.state.VeraoState;
import hva.state.OutonoState;
import hva.state.InvernoState;

import java.io.Serial;

public class CaducaTree extends Tree {

    @Serial
    private static final long serialVersionUID = 202410081411L;

    public CaducaTree(String id, String name, int age, int difficulty, Season season) {
        super(id, name, age, difficulty, season);
    }

    @Override
    public String getType() {
        return "CADUCA";
    }

    @Override
    public int getSpecificSeasonalEffort(SeasonState seasonState) {
        if (seasonState instanceof PrimaveraState) {
            return 1;
        } else if (seasonState instanceof VeraoState) {
            return 2;
        } else if (seasonState instanceof OutonoState) {
            return 5;
        } else if (seasonState instanceof InvernoState) {
            return 0;
        }
        return 0;
    }

    @Override
    public String getSpecificBiologicalCycle(SeasonState seasonState) {
        if (seasonState instanceof PrimaveraState) {
            return "GERARFOLHAS";
        } else if (seasonState instanceof VeraoState) {
            return "COMFOLHAS";
        } else if (seasonState instanceof OutonoState) {
            return "LARGARFOLHAS";
        } else if (seasonState instanceof InvernoState) {
            return "SEMFOLHAS";
        }
        return "";
    }
}
