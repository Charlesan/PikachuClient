package com.pikachu.activity;

import java.util.List;

import com.pikachu.bean.LoginUserInfo;
import com.pikachu.bean.UserBean;
import com.pikachu.dao.MonsterDao;
import com.pikachu.dao.UserDao;
import com.pikachu.res.R;
import com.pikachu.util.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	// 帐号和密码
	private EditText edname;
	private EditText edpassword;

	private Button btregister;
	private Button btlogin;
	
	public ProgressDialog dialog = null;
	
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if ( msg.what == 1 ) {
				edname.setText("");
				edpassword.setText("");
				dialog.dismiss();
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this,
						SlidingActivity.class);
				startActivity(intent);
				// 销毁当前activity
				LoginActivity.this.onDestroy();
			}
			else if ( msg.what == 0 ){
				dialog.dismiss();
				// 弹出消息框
				new AlertDialog.Builder(LoginActivity.this).setTitle("错误")
						.setMessage("帐号或密码错误，请重新输入！")
						.setPositiveButton("确定", null).show();
			}
			else {
				dialog.dismiss();
				// 弹出消息框
				new AlertDialog.Builder(LoginActivity.this).setTitle("错误")
						.setMessage("网络异常，请检查您的网络！")
						.setPositiveButton("确定", null).show();
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		edname = (EditText) findViewById(R.id.edname);
		edpassword = (EditText) findViewById(R.id.edpassword);
		btregister = (Button) findViewById(R.id.btregister);
		btlogin = (Button) findViewById(R.id.btlogin);

		// 跳转到注册界面
		btregister.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, RegistersActivity.class);
				startActivity(intent);
				// 销毁当前activity
				LoginActivity.this.onDestroy();
			}
		});
		btlogin.setOnClickListener(new LoginListener());
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	class LoginListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			final String name = edname.getText().toString();
			final String password = edpassword.getText().toString();
			if (name.equals("") || password.equals("")) {
				// 弹出消息框
				new AlertDialog.Builder(LoginActivity.this).setTitle("错误")
						.setMessage("帐号或密码不能空")
						.setPositiveButton("确定", null).show();
			} else {			
				dialog = ProgressDialog.show(LoginActivity.this, "请稍等", "正在登陆中...", true);
				new Thread() {
					public void run() {
						UserDao userDao = new UserDao();
						MonsterDao monsterDao = new MonsterDao();
						int result = userDao.login(name, password);
						Message msg = new Message();
						if ( result == 1 ) {
							LoginUserInfo loginUserInfo = LoginUserInfo.getInstance();
							if (loginUserInfo != null) {
								UserBean loginUser = userDao.getUserBean(name);
								if (loginUser != null) {
									loginUserInfo.setLoginUser(loginUser);
								}
								List<UserBean> topRank = userDao.getTopRank();
								loginUserInfo.setTopRank(topRank);
								loginUserInfo.setAllMonster(monsterDao.getAllMonster());
							}
							msg.what = 1;
						}
						else if (result == 11 ){ //密码或账户名错误
							msg.what = 0;
						}
						else {
							msg.what = -1;
						}
						handler.sendMessage(msg);
					}
				}.start();
			}
		}

	}
}
