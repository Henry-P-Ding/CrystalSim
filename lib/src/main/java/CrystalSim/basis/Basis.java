package CrystalSim.basis;


import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.List;

public class Basis {
    public List<Particle> basis;
    public Vector3D origin;

    public Basis(List<Particle> particles, Vector3D origin) {
        this.basis = particles;
        this.origin = origin;
    }

    public Basis(List<Particle> particles) {
        this(particles, Vector3D.ZERO);
    }

    public List<Particle> getBasis() {
        return this.basis;
    }

    public List<Particle> setBasis(List<Particle> newBasis) {
        return this.basis = newBasis;
    }

    public void addParticleToBasis(Particle p) {
        this.basis.add(p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Basis) {
            Basis b = (Basis) o;
            return (b.origin.equals(this.origin) && b.basis.equals(this.basis));
        }

        return false;
    }

}
