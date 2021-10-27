package CrystalSim;

import CrystalSim.crystal.AtomicCrystal;
import CrystalSim.lattice.BCC;
import CrystalSim.lattice.Lattice;
import CrystalSim.lattice.Lattices;
import CrystalSim.lattice.SC;
import CrystalSim.util.geometry.BoundingBox;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtomicCrystalTest {

    @Test void floodAndFillTest() {
        System.out.println("\nFLOOD AND FILL TEST\n");
        Lattice.LatticeFactory<?> latticeFactory = Lattices.get("SC");
        assertTrue(latticeFactory != null);
        Lattice scLattice = latticeFactory.create(1.0);
        assertTrue(scLattice instanceof SC);
        AtomicCrystal atomicCrystal = new AtomicCrystal(scLattice, 1000, "A");
        assertTrue(scLattice.getPrimitiveVolume() == 1.0);
        System.out.println(atomicCrystal.getBoundingShape());
        atomicCrystal.setBoundingShape(new BoundingBox(-2.5, -2.5, -2.5, 2.5, 2.5, 2.5));
        System.out.println(atomicCrystal.getBoundingShape());
        atomicCrystal.updateBasis();
    }
}
