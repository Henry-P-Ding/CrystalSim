package CrystalSim.lattice;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class SC extends StackingLattice {

    protected SC(double latticeConst) {
        super(latticeConst);
    }

    @Override
    public Vector3D[] calculatePrimitiveVectors(double latticeConst) {
        return new Vector3D[] {
                new Vector3D(latticeConst, 0, 0),
                new Vector3D(0, latticeConst, 0),
                new Vector3D(0, 0, latticeConst)
        };
    }

    @Override
    public double calculatePrimitiveVolume(double latticeConst) {
        return latticeConst * latticeConst * latticeConst;
    }
}
