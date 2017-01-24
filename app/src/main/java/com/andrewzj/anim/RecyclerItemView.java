package com.andrewzj.anim;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.andrewzj.recyclerviewanimation.R;
import com.squareup.picasso.Picasso;

/**
 * Created by AndrewZJ on 17/1/24.
 */
public class RecyclerItemView extends RelativeLayout{

    private ImageView mImageView;
    private Context mContext;

    public RecyclerItemView(Context context) {
        this(context,null);
    }

    public RecyclerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.recycler_item_view,this);
        this.mContext = context;
        initViews();
    }

    private void initViews() {
        mImageView = (ImageView) findViewById(R.id.id_iv);
    }

    public void setData(int resId){
        Picasso.with(mContext).load(resId).resize(690,720).into(mImageView);
    }

    public void updateImageTop() {
        int pic_height = 0;
        int cover_height = 0;

        int mScreenHeight = getResources().getDisplayMetrics().heightPixels;
        if (mImageView != null && mImageView.getDrawable() != null && mImageView.getDrawable() instanceof BitmapDrawable){
            int dw = mImageView.getDrawable().getIntrinsicWidth();
            int dh = mImageView.getDrawable().getIntrinsicHeight();

            int w = mImageView.getMeasuredWidth();
            int h = mImageView.getMeasuredHeight();

            //如果宽高比例不足以content滑动，则不显示滑动效果以填满imageView为主，否则显示滑动效果
            if ((1.0f * dh) / dw > (1.0f * h) / w){
                pic_height = w * dh / dw;
                cover_height = h;
                int top = getTop();

                float rate = (1.0f * top) / mScreenHeight;
                int offset = (int) (rate * (pic_height - cover_height));
                if (Math.abs(offset) <= (pic_height - cover_height)){
                    mImageView.setScrollY(offset);
                    Log.d("offset:",offset+"");
                }
            }else {
                mImageView.setScrollY(0);
            }
        }else {
            mImageView.setScrollY(0);
        }
    }
}
