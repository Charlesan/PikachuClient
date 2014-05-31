package com.pikachu.activity;

import com.pikachu.res.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	// �ʺź�����
	private EditText edname;
	private EditText edpassword;

	private Button btregister;
	private Button btlogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		edname = (EditText) findViewById(R.id.edname);
		edpassword = (EditText) findViewById(R.id.edpassword);
		btregister = (Button) findViewById(R.id.btregister);
		btlogin = (Button) findViewById(R.id.btlogin);

		// ��ת��ע�����
		btregister.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, RegistersActivity.class);
				startActivity(intent);
				// ���ٵ�ǰactivity
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
			String name = edname.getText().toString();
			String password = edpassword.getText().toString();
			if (name.equals("") || password.equals("")) {
				// ������Ϣ��
				new AlertDialog.Builder(LoginActivity.this).setTitle("����")
						.setMessage("�ʺŻ����벻�ܿ�")
						.setPositiveButton("ȷ��", null).show();
			} else {
				//isUserinfo(name, password);
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, SlidingActivity.class);
				startActivity(intent);
				// ���ٵ�ǰactivity
				LoginActivity.this.onDestroy();
			}
		}

	}
}
