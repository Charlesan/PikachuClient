package com.pikachu.slidingmenu.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.pikachu.activity.LoginActivity;
import com.pikachu.activity.RegistersActivity;
import com.pikachu.activity.SlidingActivity;
import com.pikachu.bean.LoginUserInfo;
import com.pikachu.dao.UserDao;
import com.pikachu.res.R;

/**
 * @author Wang Chao
 *
 */
public class SettingFragment extends Fragment{
	
	private EditText pwd;
	private EditText repwd;
	private Button settingHeadButton;
	private Button modifypwdButton;
	
	public ProgressDialog dialog = null;
	
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if ( msg.what == 1 ) {
				new AlertDialog.Builder(getActivity())
				.setTitle("��ʾ").setMessage("�����޸ĳɹ���")
				.setPositiveButton("ȷ��", null).show();
			}
			else {
				new AlertDialog.Builder(getActivity())
				.setTitle("��ʾ").setMessage("�����޸�ʧ�ܣ������²�����")
				.setPositiveButton("ȷ��", null).show();
			}
			pwd.setText("");
			repwd.setText("");
			dialog.dismiss();
		}
	};

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.setting_fragment, null);
		settingHeadButton = (Button)view.findViewById(R.id.settingHeadButton);
		modifypwdButton = (Button)view.findViewById(R.id.btmodifypwd);
		pwd = (EditText)view.findViewById(R.id.edpwd);
		repwd = (EditText)view.findViewById(R.id.edrepwd);
		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		settingHeadButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((SlidingActivity) getActivity()).showLeft();
			}});
		
		modifypwdButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				final String txtpwd = pwd.getText().toString();
				String txtrepwd = repwd.getText().toString();
				if ( !txtpwd.equals("") && !txtrepwd.equals("") ) {
					if ( hasSpace(txtpwd) || hasSpace(txtrepwd) ) {
						new AlertDialog.Builder(getActivity())
						.setTitle("��ʾ").setMessage("�����в��ܰ����ո�")
						.setPositiveButton("ȷ��", null).show();
						return;
					}
					if ( !txtpwd.equals(txtrepwd) ) {
						new AlertDialog.Builder(getActivity())
						.setTitle("����").setMessage("�������벻һ�£����������롣")
						.setPositiveButton("ȷ��", null).show();
						return;
					}
					dialog = ProgressDialog.show(getActivity(), "���Ե�", "�����ύ����...", true);
					new Thread() {
						public void run() {
							UserDao userDao = new UserDao();
							String userLoginId = LoginUserInfo.getInstance().getLoginUser().getU_login_id();
							String oldPwd = LoginUserInfo.getInstance().getLoginUser().getU_login_pwd();
							int result = userDao.repassword(userLoginId, oldPwd, txtpwd);
							Message msg = new Message();
							if ( result == 1 ) {
								msg.what = 1;
							}
							else {
								msg.what = -1;
							}
							handler.sendMessage(msg);
						}
					}.start();
				}
				else {
					new AlertDialog.Builder(getActivity())
					.setTitle("����").setMessage("���벻��Ϊ�գ�")
					.setPositiveButton("ȷ��", null).show();
				}
			}});
	}
	
    private boolean hasSpace(String str) {
    	for ( int i = 0; i < str.length(); i++ ) {
    		if ( str.charAt(i) == ' ' ) {
    			return true;
    		}
    	}
    	return false;
    }
}
