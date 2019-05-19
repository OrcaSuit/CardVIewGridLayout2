package com.example.cardview_gridlayout2;

import android.graphics.Rect;
import android.view.View;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private int spanCount;
    private int spacing;
    private boolean includeEdge;

    public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge){
        this.spanCount = spanCOunt;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
        int position = parent.getChildAdapterPosition(view);

        int spanIndex = ((StaggeredGridLayoutManager.LayoutParams)view.getLayoutParams()).getSpanIndex();

        if(includeEdge){
            if(spanIndex == 0){
                outRect.left = spacing;
                outRect.right = spacing/spanCount;
            }else{
                outRect.left = spacing/spanCount;
                outRect.right = spacing;
            }

            if(position < spanCount) {
                outRect.top = spacing;
            }

            outRect.bottom = spacing;
        }
    }
}
