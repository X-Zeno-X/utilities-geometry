package zeno.util.geom.transformables;

import zeno.util.algebra.linear.vector.Vector;
import zeno.util.geom.collidables.affine.Point;
import zeno.util.geom.transformables.affine.IScalable;
import zeno.util.geom.transformables.affine.IVantage;
import zeno.util.geom.transformables.projective.IProjectable;
import zeno.util.geom.transforms.Camera;
import zeno.util.geom.utilities.spin.Spin;

/**
 * The {@code IProjector} interface defines an object
 * operating like a generalized pinhole camera.
 *
 * @author Zeno
 * @since Feb 10, 2019
 * @version 1.0
 * 
 * 
 * @see IProjectable
 * @see IScalable
 * @see IVantage
 */
public interface IProjector extends IProjectable, IScalable, IVantage
{
	/**
	 * Returns the camera of the {@code IProjector}.
	 * 
	 * @return  a projection camera
	 * 
	 * 
	 * @see Camera
	 */
	public abstract Camera Camera();
	
	
	@Override
	public default void rotateTo(Spin s)
	{
		Camera().setSpin(s);
	}
	
	@Override
	public default void projectTo(Vector o)
	{
		Camera().setOculus(o);
	}
		
	@Override
	public default void scaleTo(Vector s)
	{
		Camera().setSize(new Point(s, 0f));
	}
	
	@Override
	public default void moveTo(Vector o)
	{
		Camera().setOrigin(new Point(o, 1f));
	}
	
	
	@Override
	public default Spin Spin()
	{
		return Camera().Spin();
	}
			
	@Override
	public default Vector Origin()
	{
		return Camera().Origin();
	}

	@Override
	public default Vector Oculus()
	{
		return Camera().Oculus();
	}
		
	@Override
	public default Vector Size()
	{
		return Camera().Size();
	}
}