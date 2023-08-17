package za.ac.cput.repository.impl;
/*
    Author: Michael Johnson
    This is Pre-Built Repository
    Date: 02 - 04 - 2022
 */

import java.util.HashSet;
import java.util.Set;

public class PreBuiltRepositoryImpl implements za.ac.cput.repository.PreBuiltRepository {
    private Set<za.ac.cput.domain.PreBuilt> preBuiltDB = null;
    private static PreBuiltRepositoryImpl repo = null;

    private PreBuiltRepositoryImpl() {
        preBuiltDB = new HashSet<za.ac.cput.domain.PreBuilt>();
    }

    public static PreBuiltRepositoryImpl getRepo() {
        if (repo == null) {
            repo = new PreBuiltRepositoryImpl();
        }
        return repo;
    }

    public za.ac.cput.domain.PreBuilt create(za.ac.cput.domain.PreBuilt preBuilt) {
        boolean success = preBuiltDB.add(preBuilt);
        if (!success) {
            return null;
        }
        return preBuilt;
    }

    public za.ac.cput.domain.PreBuilt read(String preBuiltID) {
        za.ac.cput.domain.PreBuilt p = preBuiltDB.stream()
                .filter(e -> e.getBuildID().equals(preBuiltID))
                .findAny()
                .orElse(null);
        return p;
    }

    public za.ac.cput.domain.PreBuilt update(za.ac.cput.domain.PreBuilt preBuilt) {
        za.ac.cput.domain.PreBuilt previousBuild = read(preBuilt.getBuildID());
        if (previousBuild != null) {
            preBuiltDB.remove(previousBuild);
            preBuiltDB.add(preBuilt);
            return preBuilt;
        }
        return null;
    }

    public boolean delete(String preBuiltID) {
        za.ac.cput.domain.PreBuilt preBuiltDelete = read(preBuiltID);
        if (preBuiltDelete == null) {
            return false;
        }
        preBuiltDB.remove(preBuiltDelete);
        return true;
    }

    @Override
    public Set<za.ac.cput.domain.PreBuilt> getAll() {
        return preBuiltDB;
    }
}
