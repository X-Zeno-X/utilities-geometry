package zeno.util.geom.shapes;

import zeno.util.algebra.tensors.vectors.Vector;
import zeno.util.algebra.tensors.vectors.fixed.Vector2;
import zeno.util.algebra.tensors.vectors.fixed.Vector3;
import zeno.util.geom.IGeometry;
import zeno.util.geom.shapes.lines.Line;
import zeno.util.geom.shapes.other.NEllipsoid;
import zeno.util.geom.shapes.solids.Ellipsoid;
import zeno.util.geom.shapes.surfaces.Ellipse;
import zeno.util.geom.tools.Containment;
import zeno.util.geom.tools.Intersection;

/**
 * The {IEllipsoid} interface defines the base for ellipsoid geometry.
 * 
 * @since Mar 24, 2017
 * @author Zeno
 * 
 * @see IGeometry
 */
public interface IEllipsoid extends IGeometry
{
	/**
	 * Creates a new {@code IEllipsoid}.
	 * 
	 * @param center  the ellipsoid's center
	 * @param size  the ellipsoid's size
	 * @return  a new ellipsoid
	 */
	public static IEllipsoid create(Vector center, Vector size)
	{
		if(center.size() == 2)
			return new Ellipse((Vector2) center, (Vector2) size);
		if(center.size() == 3)
			return new Ellipsoid((Vector3) center, (Vector3) size);
		
		return new NEllipsoid(center, size);
	}
	
	
	@Override
	public default boolean contains(Vector v)
	{
		return Containment.in(this, v);
	}
		
	@Override
	public default boolean contains(ISphere s)
	{
		return Containment.in(this, s);
	}
	
	@Override
	public default boolean contains(IEllipsoid e)
	{
		return Containment.in(this, e);
	}
	
	@Override
	public default boolean contains(ICuboid c)
	{
		return Containment.in(this, c);
	}
	
	@Override
	public default boolean contains(Line l)
	{
		return Containment.in(this, l);
	}

	
	@Override
	public default boolean intersects(ISphere s)
	{
		return Intersection.between(this, s);
	}

	@Override
	public default boolean intersects(IEllipsoid e)
	{
		return Intersection.between(this, e);
	}
	
	@Override
	public default boolean intersects(ICuboid c)
	{
		return Intersection.between(this, c);
	}
	
	@Override
	public default boolean intersects(Line l)
	{
		return Intersection.between(this, l);
	}
}