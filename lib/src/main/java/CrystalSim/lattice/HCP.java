package CrystalSim.lattice;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class HCP extends StackingLattice {

    private final double C_RATIO;

    public HCP(double latticeConst, double heightRatio) {
        super(latticeConst);
        this.C_RATIO = heightRatio;
    }

    public HCP(double latticeConst) {
        super(latticeConst);
        this.C_RATIO = 1.633;
    }

    @Override
    public Vector3D[] calculatePrimitiveVectors(double latticeConst) {
        return new Vector3D[] {
                new Vector3D(latticeConst/2, -Math.sqrt(3) * latticeConst / 2, 0),
                new Vector3D(latticeConst/2, Math.sqrt(3) * latticeConst / 2, 0),
                new Vector3D(0, 0, C_RATIO * latticeConst)
        };
    }

    @Override
    public double calculatePrimitiveVolume(double latticeConst) {
        return Math.sqrt(3) / 2 * latticeConst * latticeConst * latticeConst * this.C_RATIO;
    }
}
