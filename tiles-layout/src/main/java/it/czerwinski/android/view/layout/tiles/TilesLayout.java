package it.czerwinski.android.view.layout.tiles;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

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

	public int getColsCount() {
		return colsCount;
	}

	public void setColsCount(int colsCount) {
		this.colsCount = colsCount;
	}

	public int getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}

	public int getInnerHorizontalPadding() {
		return innerHorizontalPadding;
	}

	public void setInnerHorizontalPadding(int innerHorizontalPadding) {
		this.innerHorizontalPadding = innerHorizontalPadding;
	}

	public int getInnerVerticalPadding() {
		return innerVerticalPadding;
	}

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
