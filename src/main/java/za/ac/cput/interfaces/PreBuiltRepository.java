package za.ac.cput.interfaces;

import za.ac.cput.domain.PreBuilt;

import java.util.*;

public class PreBuiltRepository implements iPreBuiltRepository {
    private Set<PreBuilt> preBuiltDB = null;
    private static PreBuiltRepository repo = null;

    private PreBuiltRepository() {
        preBuiltDB = new HashSet<PreBuilt>();
    }

    public static PreBuiltRepository getRepo() {
        if (repo == null) {
            repo = new PreBuiltRepository();
        }
        return repo;
    }

    public PreBuilt create(PreBuilt preBuilt) {
        boolean success = preBuiltDB.add(preBuilt);
        if (!success) {
            return null;
        }
        return preBuilt;
    }

    public PreBuilt read(String preBuiltID) {
        PreBuilt p = preBuiltDB.stream()
                .filter(e -> e.getBuildID().equals(preBuiltID))
                .findAny()
                .orElse(null);
        return p;
    }

    public PreBuilt update(PreBuilt preBuilt) {
        PreBuilt previousBuild = read(preBuilt.getBuildID());
        if (previousBuild != null) {
            preBuiltDB.remove(previousBuild);
            preBuiltDB.add(preBuilt);
            return preBuilt;
        }
        return null;
    }

    public boolean delete(String preBuiltID) {
        PreBuilt preBuiltDelete = read(preBuiltID);
        if (preBuiltDelete == null) {
            return false;
        }
        preBuiltDB.remove(preBuiltDelete);
        return true;
    }

    @Override
    public Set<PreBuilt> getAll() {
        return preBuiltDB;
    }
}
