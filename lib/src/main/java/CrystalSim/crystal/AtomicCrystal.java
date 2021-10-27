package CrystalSim.crystal;

import CrystalSim.basis.Atom;
import CrystalSim.basis.Basis;
import CrystalSim.basis.Particle;
import CrystalSim.lattice.Lattice;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.*;

public class AtomicCrystal extends Crystal {

    public AtomicCrystal(Lattice lattice, int latticePointNumber, Atom basisAtom) {
        super(lattice, latticePointNumber, new Basis(new ArrayList<>(List.of(basisAtom))));
    }

    public AtomicCrystal(Lattice lattice, int latticePointNumber, String atomicName) {
        this(lattice, latticePointNumber, new Atom(Vector3D.ZERO, atomicName));
    }

    // TODO
    @Override
    public List<Particle> getAllParticles() {
        return null;
    }

    public Set<Basis> updateBasis() {
        Queue<Basis> unvisitedBases = new LinkedList<>();
        for (Basis basis : this.bases) {
            if (this.getBoundingShape().containsPoint(basis.origin)) {
                unvisitedBases.add(basis);
            }
        }

        Vector3D[] v = this.getLattice().getPrimitiveVectors();
        while(!unvisitedBases.isEmpty()) {
            if (bases.size() >= this.getLatticePointNumber()) break;
            Basis n = unvisitedBases.poll();
            if (this.getBoundingShape().containsPoint(n.origin)) {
                this.bases.add(n);
                unvisitedBases.add(new Basis(n.getBasis(), n.origin.add(v[0])));
                unvisitedBases.add(new Basis(n.getBasis(), n.origin.add(v[1])));
                unvisitedBases.add(new Basis(n.getBasis(), n.origin.add(v[2])));
                unvisitedBases.add(new Basis(n.getBasis(), n.origin.subtract(v[0])));
                unvisitedBases.add(new Basis(n.getBasis(), n.origin.subtract(v[1])));
                unvisitedBases.add(new Basis(n.getBasis(), n.origin.subtract(v[2])));
            }
        }

        return this.bases;
    }
}
