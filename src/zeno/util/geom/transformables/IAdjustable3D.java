package zeno.util.geom.transformables;

import zeno.util.algebra.linear.vector.fixed.Vector3;
import zeno.util.geom.transformables.affine.IScalable3D;
import zeno.util.geom.transformables.affine.IVantage3D;
import zeno.util.geom.utilities.spin.Spin3D;

/**
 * The {@code IAdjustable3D} interface defines an object
 * capable of being fully adjusted in three-dimensional affine space.
 *
 * @author Zeno
 * @since Feb 10, 2019
 * @version 1.0
 * 
 * 
 * @see IAdjustable
 * @see IScalable3D
 * @see IVantage3D
 */
public interface IAdjustable3D extends IAdjustable, IScalable3D, IVantage3D
{
	@Override
	public default Spin3D Spin()
	{
		return (Spin3D) Transform().Spin();
	}
	
	@Override
	public default Vector3 Origin()
	{
		return (Vector3) Transform().Origin();
	}
	
	@Override
	public default Vector3 Size()
	{
		return (Vector3) Transform().Size();
	}
	

	@Override
	public default float Depth()
	{
		return IScalable3D.super.Depth();
	}

	@Override
	public default float Height()
	{
		return IScalable3D.super.Height();
	}

	@Override
	public default float Width()
	{
		return IScalable3D.super.Width();
	}
	
	
	@Override
	public default float X()
	{
		return IVantage3D.super.X();
	}

	@Override
	public default float Y()
	{
		return IVantage3D.super.Y();
	}

	@Override
	public default float Z()
	{
		return IVantage3D.super.Z();
	}
}