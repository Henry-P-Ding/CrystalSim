package CrystalSim.crystal;

import CrystalSim.basis.Basis;
import CrystalSim.lattice.Lattice;
import CrystalSim.basis.Particle;
import CrystalSim.util.geometry.BoundingBox;
import CrystalSim.util.geometry.Polyhedron;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Crystal {
    private Polyhedron boundingShape;
    private Lattice lattice;
    private Basis basis;
    protected Set<Basis> bases = new HashSet<>();
    private final int latticePointNumber;

    protected Crystal(Lattice lattice, int latticePointNumber, Basis basis) {
        this.lattice = lattice;
        this.latticePointNumber = latticePointNumber;
        double totalVolume = this.lattice.getPrimitiveVolume() * latticePointNumber;
        double l = Math.cbrt(totalVolume);
        this.boundingShape = new BoundingBox(l);
        this.basis = basis;
        this.bases.add(this.basis);
    }

    protected Crystal(Lattice lattice, int latticePointNumber) {
        this(lattice, latticePointNumber, new Basis(new ArrayList<>()));
    }

    public Basis setBasis(Basis newBasis) {
        return this.basis = newBasis;
    }

    public Basis getBasis() {
        return this.basis;
    }

    public Polyhedron setBoundingShape(Polyhedron newBoundingShape) {
        return this.boundingShape = newBoundingShape;
    }

    public Polyhedron getBoundingShape() {
        return this.boundingShape;
    }

    public Lattice getLattice() {
        return this.lattice;
    }

    public Lattice setLattice(Lattice newLattice) {
        return this.lattice = newLattice;
    }

    public int getLatticePointNumber() {
        return this.latticePointNumber;
    }

    public abstract List<Particle> getAllParticles();
}
