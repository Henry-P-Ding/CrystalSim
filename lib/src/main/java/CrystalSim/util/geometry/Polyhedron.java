package CrystalSim.util.geometry;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.ArrayList;

public class Polyhedron {
    private ArrayList<Plane> boundingPlanes = new ArrayList<>();

    public boolean containsPoint(Vector3D point) {
        for (Plane plane : boundingPlanes) {
            if (!plane.hasInside(point)) return false;
        }

        return true;
    }

    public void translate(Vector3D T) {
        boundingPlanes.stream().forEach(s -> s.translate(T));
    }

    public ArrayList<Plane> getBoundingPlanes() {
        return this.boundingPlanes;
    }

    public void addBoundingPlane(Plane p) {
        this.boundingPlanes.add(p);
    }

}
