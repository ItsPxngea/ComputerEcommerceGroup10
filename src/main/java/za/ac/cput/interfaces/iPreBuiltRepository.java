package za.ac.cput.interfaces;

import za.ac.cput.domain.PreBuilt;

import java.util.Set;

public interface iPreBuiltRepository {
    Set<PreBuilt> getAll();
}
