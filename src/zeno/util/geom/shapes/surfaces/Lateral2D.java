package zeno.util.geom.shapes.surfaces;

import zeno.util.algebra.vectors.fixed.Vector2;
import zeno.util.geom.shapes.Geometry2D;
import zeno.util.geom.IGeometry;

/**
 * The {@code Lateral2D} class defines a two-dimensional four-edged shape.
 *
 * @author Zeno
 * @since Aug 22, 2015
 * @see Geometry2D
 */
public class Lateral2D extends Geometry2D
{
	/**
	 * The {@code OrderBy} class defines vertex order methods.
	 *
	 * @author Zeno
	 * @since Apr 9, 2016
	 */
	public class OrderBy extends IGeometry.OrderBy
	{
		/**
		 * Creates a new {@code OrderBy}.
		 * 
		 * @param geom  a target geometry
		 * @see Lateral2D
		 */
		public OrderBy(Lateral2D geom)
		{
			super(geom);
		}
		
		

		@Override
		public int[] LineStripAdjacency()
		{
			return new int[]
			{
				2,
				0, 1,
				1, 3,
				3, 2,
				2, 0,
				1
			};
		}
		
		@Override
		public int[] LinesAdjacency()
		{
			return new int[]
			{
				2, 0, 1, 3,
				0, 1, 3, 2,
				1, 3, 2, 0,
				3, 2, 0, 1
			};
		}
		
		
		@Override
		public int[] TriangleStrip()
		{
			return new int[]
			{
				0, 1, 2, 3
			};
		}
		
		@Override
		public int[] Triangles()
		{
			return new int[]
			{
				0, 1, 3,
				0, 2, 3
			};
		}
		
		
		@Override
		public int[] LineStrip()
		{
			return new int[]
			{
				0, 1, 3, 2, 0
			};
		}
		
		@Override
		public int[] LineLoop()
		{
			return new int[]
			{
				0, 1, 3, 2
			};
		}
			
		@Override
		public int[] Lines()
		{
			return new int[]
			{
				0, 1,
				1, 3,
				3, 2,
				2, 0
			};
		}
	}
	
		
	/**
	 * Creates a new {@code Lateral2D}.
	 * 
	 * @param x  a center x-co�rdinate
	 * @param y  a center y-co�rdinate
	 * @param w  a width
	 * @param h  a height
	 */
	public Lateral2D(float x, float y, float w, float h)
	{
		super(x, y, w, h);
	}
	
	/**
	 * Creates a new {@code Lateral2D}.
	 */
	public Lateral2D()
	{
		this(0, 0, 1, 1);
	}
	
	
	/**
	 * Indicates if the {@code Lateral2D} intersects a rectangle.
	 * 
	 * @param x1  the rectangle's first x-co�rdinate
	 * @param y1  the rectangle's first y-co�rdinate
	 * @param x2  the rectangle's second x-co�rdinate
	 * @param y2  the rectangle's second y-co�rdinate
	 * @return  {@code true} if the rectangle intersects
	 */
	@Override
	public boolean intersects(float x1, float y1, float x2, float y2)
	{
		return x1 <= XMax()
			&& x2 >= XMin()
			&& y1 <= YMax()
			&& y2 >= YMin();
	}

	/**
	 * Indicates if the {@code Lateral2D} contains a rectangle.
	 * 
	 * @param x1  the rectangle's first x-co�rdinate
	 * @param y1  the rectangle's first y-co�rdinate
	 * @param x2  the rectangle's second x-co�rdinate
	 * @param y2  the rectangle's second y-co�rdinate
	 * @return  {@code true} if the rectangle contains
	 */
	@Override
	public boolean contains(float x1, float y1, float x2, float y2)
	{
		return contains(x1, y1)
			&& contains(x2, y2);
	}
	
	/**
	 * Indicates if the {@code Lateral2D} contains a point.
	 * 
	 * @param x  the point's x-co�rdinate
	 * @param y  the point's y-co�rdinate
	 * @return  {@code true} if the point is contained
	 */
	@Override
	public boolean contains(float x, float y)
	{
		return XMin() < x && x < XMax()
			&& YMin() < y && y < YMax();
	}
	
		
	@Override
	public OrderBy OrderBy()
	{
		return new OrderBy(this);
	}

	@Override
	public Vector2[] Vertices()
	{
		float xmin = XMin();
		float xmax = XMax();
		float ymin = YMin();
		float ymax = YMax();
		
		return new Vector2[]
		{
			new Vector2(xmin, ymin),
			new Vector2(xmin, ymax),
			new Vector2(xmax, ymin),
			new Vector2(xmax, ymax)
		};
	}

	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Lateral2D)
		{
			return super.equals(o);
		}
		
		return false;
	}
	
	@Override
	public int VertexCount()
	{
		return 4;
	}
}