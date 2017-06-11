package it.czerwinski.android.view.layout.tiles;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * A layout that arranges its children into tiles of equal size.
 *
 * @attr ref R.styleable#TilesLayout_tilesLayout_colsCount
 * @attr ref R.styleable#TilesLayout_tilesLayout_rowsCount
 * @attr ref R.styleable#TilesLayout_tilesLayout_innerHorizontalPadding
 * @attr ref R.styleable#TilesLayout_tilesLayout_innerVerticalPadding
 */
public class TilesLayout extends ViewGroup {

	private int colsCount = 1;
	private int rowsCount = 1;

	private int innerHorizontalPadding = 0;
	private int innerVerticalPadding = 0;

	public TilesLayout(Context context) {
		super(context);
	}

	public TilesLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		initFromAttrs(attrs);
	}

	public TilesLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initFromAttrs(attrs);
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public TilesLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		initFromAttrs(attrs);
	}

	private void initFromAttrs(AttributeSet attrs) {
		if (attrs == null) {
			return;
		}
		TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.TilesLayout);
		colsCount = attributes.getInteger(R.styleable.TilesLayout_tilesLayout_colsCount, 1);
		rowsCount = attributes.getInteger(R.styleable.TilesLayout_tilesLayout_rowsCount, 1);
		innerHorizontalPadding = attributes.getDimensionPixelSize(R.styleable.TilesLayout_tilesLayout_innerHorizontalPadding, 0);
		innerVerticalPadding = attributes.getDimensionPixelSize(R.styleable.TilesLayout_tilesLayout_innerVerticalPadding, 0);
		attributes.recycle();
	}

	/**
	 * Gets the number of columns in the tiles arrangement.
	 *
	 * @return Number of columns.
	 *
	 * @attr ref R.styleable#TilesLayout_tilesLayout_colsCount
	 */
	public int getColsCount() {
		return colsCount;
	}

	/**
	 * Sets the number of columns in the tiles arrangement.
	 *
	 * @param colsCount Number of columns.
	 *
	 * @attr ref R.styleable#TilesLayout_tilesLayout_colsCount
	 */
	public void setColsCount(int colsCount) {
		this.colsCount = colsCount;
	}

	/**
	 * Gets the number of rows in the tiles arrangement.
	 *
	 * @return Number of rows.
	 *
	 * @attr ref R.styleable#TilesLayout_tilesLayout_rowsCount
	 */
	public int getRowsCount() {
		return rowsCount;
	}

	/**
	 * Sets the number of rows in the tiles arrangement.
	 *
	 * @param rowsCount Number of rows.
	 *
	 * @attr ref R.styleable#TilesLayout_tilesLayout_rowsCount
	 */
	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}

	/**
	 * Gets the inner horizontal padding between the tiles.
	 *
	 * @return Inner horizontal padding.
	 *
	 * @attr ref R.styleable#TilesLayout_tilesLayout_innerHorizontalPadding
	 */
	public int getInnerHorizontalPadding() {
		return innerHorizontalPadding;
	}

	/**
	 * Sets the inner horizontal padding between the tiles.
	 *
	 * @param innerHorizontalPadding Inner horizontal padding.
	 *
	 * @attr ref R.styleable#TilesLayout_tilesLayout_innerHorizontalPadding
	 */
	public void setInnerHorizontalPadding(int innerHorizontalPadding) {
		this.innerHorizontalPadding = innerHorizontalPadding;
	}

	/**
	 * Gets the inner vertical padding between the tiles.
	 *
	 * @return Inner vertical padding.
	 *
	 * @attr ref R.styleable#TilesLayout_tilesLayout_innerVerticalPadding
	 */
	public int getInnerVerticalPadding() {
		return innerVerticalPadding;
	}

	/**
	 * Sets the inner vertical padding between the tiles.
	 *
	 * @param innerVerticalPadding Inner vertical padding.
	 *
	 * @attr ref R.styleable#TilesLayout_tilesLayout_innerVerticalPadding
	 */
	public void setInnerVerticalPadding(int innerVerticalPadding) {
		this.innerVerticalPadding = innerVerticalPadding;
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		int measuredWidth = getMeasuredWidth();
		int measuredHeight = getMeasuredHeight();

		int paddingLeft = getPaddingLeft();
		int paddingRight = getPaddingRight();
		int paddingTop = getPaddingTop();
		int paddingBottom = getPaddingBottom();

		int totalInnerHorizontalPadding = innerHorizontalPadding * (colsCount - 1);
		int totalInnerVerticalPadding = innerVerticalPadding * (rowsCount - 1);

		int childWidth = (measuredWidth - paddingLeft - paddingRight - totalInnerHorizontalPadding) / colsCount;
		int childHeight = (measuredHeight - paddingTop - paddingBottom - totalInnerVerticalPadding) / rowsCount;

		int layoutLeft = (measuredWidth - childWidth * colsCount - totalInnerHorizontalPadding) / 2;
		int layoutTop = (measuredHeight - childHeight * rowsCount - totalInnerVerticalPadding) / 2;

		for (int index = 0; index < getChildCount(); index++) {
			layoutChild(childWidth, childHeight, layoutLeft, layoutTop, index);
		}
	}

	private void layoutChild(int childWidth, int childHeight, int layoutLeft, int layoutTop, int index) {
		View child = getChildAt(index);
		int col = index % colsCount;
		int row = index / colsCount;

		int childLeft = layoutLeft + col * (childWidth + innerHorizontalPadding);
		int childRight = childLeft + childWidth;
		int childTop = layoutTop + row * (childHeight + innerVerticalPadding);
		int childBottom = childTop + childHeight;

		child.measure(exactMeasureSpec(childWidth), exactMeasureSpec(childHeight));
		child.layout(childLeft, childTop, childRight, childBottom);
	}

	private int exactMeasureSpec(int size) {
		return MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY);
	}
}
