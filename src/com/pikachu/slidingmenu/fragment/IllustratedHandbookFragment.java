package com.pikachu.slidingmenu.fragment;

import java.util.List;
import java.util.Set;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.pikachu.activity.SlidingActivity;
import com.pikachu.bean.LoginUserInfo;
import com.pikachu.bean.MonsterBean;
import com.pikachu.dao.CommonSetting;
import com.pikachu.res.R;
import com.pikachu.util.Utils;

/**
 * 用于显示图鉴的fragment
 * @author Wang Chao
 *
 */
public class IllustratedHandbookFragment extends Fragment{
	
	private Button illustratedHandbookHeadButton;
	
	private TableLayout handbookTable;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.illustrated_handbook_fragment, null);
		illustratedHandbookHeadButton = (Button)view.findViewById(R.id.illustratedHandbookHeadButton);
		
		handbookTable = (TableLayout)view.findViewById(R.id.handbookTable);
		
		Set<Integer> userHandBook = LoginUserInfo.getInstance().getLoginUserHandBook();
		boolean[] hasCatched = new boolean[152];
		for (int i = 1; i < 152; i++ )
			hasCatched[i] = false;
		if ( userHandBook != null ) {
			for ( Integer one : userHandBook ) {
				hasCatched[one.intValue()] = true;
			}
		}
//		hasCatched[5] = true;
		
		for ( int i = 1; i <= 151; i++ ) {
			addOneRow(i, hasCatched[i]);
		}
		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		illustratedHandbookHeadButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((SlidingActivity) getActivity()).showLeft();
			}});
	}
	
	private void addOneRow(int order, boolean hasCatched) {
		TableRow row = new TableRow(getActivity());
		
		TextView view1 = new TextView(getActivity());
		addOneViewStyle(view1, hasCatched);
		view1.setText("" + order);
		row.addView(view1);
		TextView view2 = new TextView(getActivity());
		addOneViewStyle(view2, hasCatched);
		if ( hasCatched )
			view2.setText(CommonSetting.getMonsterNameByNumber(order));
		else
			view2.setText("?");
		row.addView(view2);
		
		ImageView view3 = new ImageView(getActivity());
//		TableRow.LayoutParams params = (TableRow.LayoutParams) view3.getLayoutParams();
//		params.width = 120;
//		params.height = 120;
//		view3.setLayoutParams( params ); 
			
//		view3.setLayoutParams(new TableRow.LayoutParams(500, 500));
		view3.setScaleType(ScaleType.FIT_CENTER);
		if ( hasCatched )
			view3.setImageResource(Utils.getImageID("big_" + order));
		else 
			view3.setImageResource(R.drawable.unknown);
		row.addView(view3);

		
		TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(  
                ViewGroup.LayoutParams.WRAP_CONTENT,  
                ViewGroup.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(0, 0, 0, 20);
		handbookTable.addView(row, layoutParams);
	}
	
	private void addOneViewStyle(TextView textView, boolean hasCatched) {
		textView.setGravity(Gravity.CENTER);
		textView.setTextSize(25);
		if (hasCatched)
			textView.setHeight(200);
		else
			textView.setHeight(270);
	}
}
