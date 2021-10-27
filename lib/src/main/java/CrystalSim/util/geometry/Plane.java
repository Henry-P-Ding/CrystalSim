package CrystalSim.util.geometry;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class Plane {
    public Vector3D NORMAL;
    public Vector3D POINT;

    public Plane(Vector3D normal, Vector3D point) {
        NORMAL = normal;
        POINT = point;
    }

    public boolean hasInside(Vector3D p) {
        Vector3D v = p.subtract(this.POINT);
        return v.dotProduct(NORMAL) > 0;
    }

    public void translate(Vector3D v) {
        this.POINT.add(v);
    }
}
