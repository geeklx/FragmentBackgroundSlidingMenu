package com.liangxiao.weixin2;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.liangxiao.fragment.Fragment_chat;
import com.liangxiao.fragment.Fragment_class;
import com.liangxiao.fragment.Fragment_find;
import com.liangxiao.fragment.Fragment_me;
import com.liangxiao.slidingmenu.view.SlidingMenu;
import com.liangxiao.weixin2.R;

public class MainActivity extends FragmentActivity implements OnClickListener {
	SlidingMenu menu_content;
	TextView weixin_btn;
	ViewPager mViewPager;
	FragmentPagerAdapter mAdapter;
	List<Fragment> mDatas;
	TextView mChat;
	TextView mClass;
	TextView mFind;
	TextView mMe;
	ImageView mTabLine1;
	ImageView mTabLine2;
	ImageView mTabLine3;
	ImageView mTabLine4;
	int mScreen1_4;
	int mCurrentPageIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		menu_content = (SlidingMenu) findViewById(R.id.menu_content);
		weixin_btn = (TextView) findViewById(R.id.weixin_btn);
		mChat = (TextView) findViewById(R.id.mChat);
		mClass = (TextView) findViewById(R.id.mClass);
		mFind = (TextView) findViewById(R.id.mFind);
		mMe = (TextView) findViewById(R.id.mMe);
		weixin_btn.setOnClickListener(this);
		mChat.setOnClickListener(this);
		mClass.setOnClickListener(this);
		mFind.setOnClickListener(this);
		mMe.setOnClickListener(this);
		mTabLine1 = (ImageView) findViewById(R.id.id_tabLine1);
		mTabLine2 = (ImageView) findViewById(R.id.id_tabLine2);
		mTabLine3 = (ImageView) findViewById(R.id.id_tabLine3);
		mTabLine4 = (ImageView) findViewById(R.id.id_tabLine4);

		mViewPager = (ViewPager) findViewById(R.id.id_viewPager);
		mDatas = new ArrayList<Fragment>();
		Fragment_chat fragment_chat = new Fragment_chat();
		Fragment_class fragment_class = new Fragment_class();
		Fragment_find fragment_find = new Fragment_find();
		Fragment_me fragment_me = new Fragment_me();

		mDatas.add(fragment_chat);
		mDatas.add(fragment_class);
		mDatas.add(fragment_find);
		mDatas.add(fragment_me);

		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mDatas.size();
			}

			@Override
			public Fragment getItem(int position) {
				// TODO Auto-generated method stub
				return mDatas.get(position);
			}
		};

		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				control_top2(position);
			}

			@Override
			public void onPageScrolled(int position, float positionOffSet,
					int positionOffSetPx) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	/**
	 * 滚动条和字体整体部分操作
	 */
	private void control_top2(int position) {
		reset_text();
		reset_tabline_color();

		switch (position) {
		case 0:
			// mChat.setTextColor(Color.argb(100, 118, 170, 26));
			mChat.setTextColor(Color.parseColor("#008000"));
			break;
		case 1:
			mClass.setTextColor(Color.parseColor("#008000"));
			break;
		case 2:
			mFind.setTextColor(Color.parseColor("#008000"));
			break;
		case 3:
			mMe.setTextColor(Color.parseColor("#008000"));
			break;
		default:
			break;
		}

		switch (position) {
		case 0:

			mTabLine1.setVisibility(View.VISIBLE);
			break;
		case 1:

			mTabLine2.setVisibility(View.VISIBLE);
			break;
		case 2:

			mTabLine3.setVisibility(View.VISIBLE);
			break;
		case 3:

			mTabLine4.setVisibility(View.VISIBLE);
			break;

		default:
			break;
		}

		mCurrentPageIndex = position;
	}

	/**
	 * 滚动条部分 重置操作
	 */
	protected void reset_tabline_color() {
		mTabLine1.setVisibility(View.GONE);
		mTabLine2.setVisibility(View.GONE);
		mTabLine3.setVisibility(View.GONE);
		mTabLine4.setVisibility(View.GONE);
	}

	/**
	 * 字体变色部分 重置操作
	 */
	protected void reset_text() {
		mChat.setTextColor(Color.BLACK);
		mClass.setTextColor(Color.BLACK);
		mFind.setTextColor(Color.BLACK);
		mMe.setTextColor(Color.BLACK);

	}

	@Override
	public void onClick(View v) {
		if (v == mChat) {
			mCurrentPageIndex = 0;
		} else if (v == mClass) {
			mCurrentPageIndex = 1;
		} else if (v == mFind) {
			mCurrentPageIndex = 2;
		} else if (v == mMe) {
			mCurrentPageIndex = 3;
		} else if (v == weixin_btn) {
			// 点击微信显示左边部分
			menu_content.toggle();
		}
		mViewPager.setCurrentItem(mCurrentPageIndex);
		control_top2(mCurrentPageIndex);
	}

	// /**
	// * 点击微信显示左边部分
	// */
	// public void toggleMenu(View view) {
	// Toast.makeText(this, "什么情况啊", 3).show();
	// menu_content.toggle();
	// }
}
