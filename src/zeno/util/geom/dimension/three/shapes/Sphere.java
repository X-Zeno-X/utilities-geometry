package zeno.util.geom.dimension.three.shapes;

import zeno.util.algebra.tensors.vectors.fixed.Vector3;
import zeno.util.geom.utilities.shapes.ISphere;

/**
 * The {@code Sphere} class defines a three-dimensional sphere shape.
 * 
 * @since Mar 21, 2017
 * @author Zeno
 * 
 * @see Ellipsoid
 * @see ISphere
 */
public class Sphere extends Ellipsoid implements ISphere
{
	/**
	 * Creates a new {@code Sphere}.
	 * 
	 * @param x  the sphere's center x-co�rdinate
	 * @param y  the sphere's center y-co�rdinate
	 * @param z  the sphere's center z-co�rdinate
	 * @param r  the sphere's radius
	 */
	public Sphere(float x, float y, float z, float r)
	{
		this(new Vector3(x, y, z), r);
	}
	
	/**
	 * Creates a new {@code Sphere}.
	 * 
	 * @param center  the sphere's center
	 * @param r  the sphere's radius
	 * @see Vector3
	 */
	public Sphere(Vector3 center, float r)
	{
		super(center, new Vector3(2 * r, 2 * r, 2 * r));
	}
	
	/**
	 * Creates a new {@code Sphere}.
	 * 
	 * @param r  the sphere's radius
	 */
	public Sphere(float r)
	{
		this(new Vector3(), r);
	}
	
	/**
	 * Creates a new {@code Sphere}.
	 */
	public Sphere()
	{
		this(1);
	}
}