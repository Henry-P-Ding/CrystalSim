package CrystalSim.basis;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public abstract class Particle {
    public Vector3D relativePos;
    public String name;

    public Particle(Vector3D relativePos, String name) {
        this.relativePos = relativePos;
        this.name = name;
    }
}
