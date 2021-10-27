package CrystalSim.lattice;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class BCC extends StackingLattice {

    public BCC(double latticeConst) {
        super(latticeConst);
    }

    @Override
    public Vector3D[] calculatePrimitiveVectors(double latticeConst) {
        return new Vector3D[] {
                new Vector3D(0.5 * latticeConst, 0.5 * latticeConst, -0.5 * latticeConst),
                new Vector3D(0.5 * latticeConst, 0.5 * latticeConst, 0.5 * latticeConst),
                new Vector3D(0.5 * latticeConst, -0.5 * latticeConst, -0.5 * latticeConst)
        };
    }

    @Override
    public double calculatePrimitiveVolume(double latticeConst) {
        return latticeConst * latticeConst * latticeConst / 2;
    }

}
