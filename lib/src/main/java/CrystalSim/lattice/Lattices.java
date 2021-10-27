package CrystalSim.lattice;

import java.util.HashMap;
import java.util.Map;

public class Lattices {
    private static final Map<String, Lattice.LatticeFactory<?>> REGISTRY = new HashMap<>();

    static {
        register("SC", SC::new);
        register("BCC", BCC::new);
        register("FCC", FCC::new);
        register("HCP", HCP::new);
    }

    public static void register(String latticeType, Lattice.LatticeFactory<?> latticeFactory) {
        REGISTRY.put(latticeType, latticeFactory);
    }

    public static Lattice.LatticeFactory<?> get(String latticeType) {
        return REGISTRY.get(latticeType);
    }
}
