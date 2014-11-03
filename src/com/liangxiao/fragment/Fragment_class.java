package com.liangxiao.fragment;

import com.liangxiao.weixin2.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_class extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View fragment_class_layout = inflater.inflate(R.layout.fragment_class,
				container, false);
		return fragment_class_layout;
	}
}
