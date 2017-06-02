package com.techfly.demo.activity.demo;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.techfly.demo.R;
import com.techfly.demo.activity.base.BaseActivity;
import com.techfly.demo.selfview.GuideMaskView;
import com.techfly.demo.selfview.SearchView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class Demo11Activity extends BaseActivity {

    @InjectView(R.id.top_title_tv)
    TextView top_title_tv;
    @InjectView(R.id.demo_style_sv)
    SearchView demo_style_sv;

    private GuideMaskView top_right_guideview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo11);

        ButterKnife.inject(this);

        setTranslucentStatus(R.color.main_bg);

        initBaseView();
        setBaseTitle("Demo11", 0);
        initBackButton(R.id.top_back_iv);

//        initGuidView();
        initDialog();

    }

    private void initDialog(){
//        demo_style_sv.setShakeAnimation();
    }

    private void initGuidView(){

        // 使用图片
        final ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.icon_new_task_guide);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        iv.setLayoutParams(params);

        top_right_guideview = GuideMaskView.Builder
                .newInstance(this)
                .setTargetView(top_title_tv)//设置目标
                .setCustomGuideView(iv)
                .setRadius(80)
                .setDirction(GuideMaskView.Direction.LEFT_BOTTOM)
                .setShape(GuideMaskView.MyShape.CIRCULAR)   // 设置圆形显示区域，
                .setBgColor(getResources().getColor(R.color.shadow))
                .setOnclickListener(new GuideMaskView.OnClickCallback() {
                    @Override
                    public void onClickedGuideView() {
                        top_right_guideview.hide();
                    }
                })
                .build();

        top_right_guideview.show();

        /*if(PreferenceUtil.getBooleanSharePreference(this, Constant.CONFIG_PREFERENCE_IS_SHOW_GUIDEVIEW, false)){
            //
        }else{
            //第一次显示蒙版即可
            top_right_guideview.show();
            PreferenceUtil.putBooleanSharePreference(this, Constant.CONFIG_PREFERENCE_IS_SHOW_GUIDEVIEW,true);
        }*/
    }

    /*@OnClick(R.id.demo_change_bg_tv)
    public void changeBg(){
//        ToastUtil.DisplayToast(this,"点击了按钮");
    }*/


}