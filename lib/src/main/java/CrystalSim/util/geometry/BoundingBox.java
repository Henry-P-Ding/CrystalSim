package CrystalSim.util.geometry;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.ArrayList;

public class BoundingBox extends Polyhedron {

    public double x0;
    public double y0;
    public double z0;
    public double x1;
    public double y1;
    public double z1;

    public BoundingBox(double x0, double y0, double z0, double x1, double y1, double z1) {
        this.x0 = x0;
        this.y0 = y0;
        this.z0 = z0;
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.addBoundingPlane(new Plane(new Vector3D(1, 0, 0), new Vector3D(this.x0, this.y0, this.z0)));
        this.addBoundingPlane(new Plane(new Vector3D(0, 1, 0), new Vector3D(this.x0, this.y0, this.z0)));
        this.addBoundingPlane(new Plane(new Vector3D(0, 0, 1), new Vector3D(this.x0, this.y0, this.z0)));
        this.addBoundingPlane(new Plane(new Vector3D(-1, 0, 0), new Vector3D(this.x1, this.y1, this.z1)));
        this.addBoundingPlane(new Plane(new Vector3D(0, -1, 0), new Vector3D(this.x1, this.y1, this.z1)));
        this.addBoundingPlane(new Plane(new Vector3D(0, 0, -1), new Vector3D(this.x1, this.y1, this.z1)));
    }

    public BoundingBox(Vector3D v1, Vector3D v2) {
        this(Math.min(v1.getX(), v2.getX()), Math.min(v1.getY(), v2.getY()), Math.min(v1.getZ(), v2.getZ()),
            Math.max(v1.getX(), v2.getX()), Math.max(v1.getY(), v2.getY()), Math.max(v1.getZ(), v2.getZ()));
    }

    public BoundingBox(double s) {
        this(-s/2, -s/2, -s/2, s/2, s/2, s/2);
    }

    public static BoundingBox empty() {
        return new BoundingBox(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override
    public String toString() {
        return "BoundingBox{" +
                "x0=" + this.x0 +
                ", y0=" + this.y0 +
                ", z0=" + this.z0 +
                ", x1=" + this.x1 +
                ", y1=" + this.y1 +
                ", z1=" + this.z1 +
                '}';
    }
}
