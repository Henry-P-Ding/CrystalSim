package CrystalSim.lattice;


import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public abstract class Lattice {
    private final double LATTICE_CONST;
    private final Vector3D[] PRIMITIVE_VEC;
    private final Double PRIMITIVE_VOLUME;

    protected Lattice(double latticeConst) {
        this.LATTICE_CONST = latticeConst;
        this.PRIMITIVE_VEC = this.calculatePrimitiveVectors(latticeConst);
        this.PRIMITIVE_VOLUME = this.calculatePrimitiveVolume(latticeConst);
    }

    public double getLatticeConstant() {
        return this.LATTICE_CONST;
    }
    public double setLatticeConstant() { return this.LATTICE_CONST; }

    public Vector3D[] getPrimitiveVectors() {
        return this.PRIMITIVE_VEC;
    }

    public abstract Vector3D[] calculatePrimitiveVectors(double latticeConst);

    public double getPrimitiveVolume() {
        return this.PRIMITIVE_VOLUME;
    }

    protected abstract double calculatePrimitiveVolume(double latticeConst);

    @FunctionalInterface
    public interface LatticeFactory<T extends Lattice> {
        T create(double latticeConst);
    }
}
