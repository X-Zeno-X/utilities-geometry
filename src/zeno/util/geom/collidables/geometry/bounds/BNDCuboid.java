package zeno.util.geom.collidables.geometry.bounds;

import zeno.util.algebra.linear.vector.Vector;
import zeno.util.geom.ITransformation;
import zeno.util.geom.collidables.affine.Point;
import zeno.util.geom.collidables.bounds.Bounds;
import zeno.util.geom.collidables.geometry.generic.ICuboid;
import zeno.util.geom.collidables.geometry.higher.NCuboid;
import zeno.util.geom.utilities.Transforms;

/**
 * The {@code BNDCuboid} class defines the bounds of a transformed {@link NCuboid}.
 *
 * @author Zeno
 * @since Sep 11, 2019
 * @version 1.0
 * 
 *
 * @see Bounds
 */
public class BNDCuboid implements Bounds
{
	private ICuboid cube;
	private ITransformation map;
	
	/**
	 * Creates a new {@code BNDCuboid}.
	 * 
	 * @param c  a target cuboid
	 * @param m  an affine map
	 * 
	 * 
	 * @see ITransformation
	 * @see ICuboid
	 */
	public BNDCuboid(ICuboid c, ITransformation m)
	{
		cube = c;
		map = m;
	}
	
	
	@Override
	public float Radius()
	{
		return Size().times(0.5f).norm();
	}
	
	@Override
	public Vector Center()
	{
		Point p = new Point(cube.Center(), 1f);
		return ((Point) map.map(p)).asVector();
	}
	
	@Override
	public Vector Size()
	{
		Point p = new Point(cube.Size(), 0f);
		ITransformation abs = Transforms.abs(map);
		return ((Point) abs.map(p)).asVector();
	}
}