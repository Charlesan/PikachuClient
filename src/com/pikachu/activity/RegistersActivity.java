package com.pikachu.activity;

import com.pikachu.res.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegistersActivity extends Activity {
	private EditText edname1;
	private EditText edpassword1;
	private Button btregister1;
	private Button btreturn;

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		edname1 = (EditText) findViewById(R.id.edname1);
		edpassword1 = (EditText) findViewById(R.id.edpassword1);
		btregister1 = (Button) findViewById(R.id.btregister1);
		btreturn = (Button) findViewById(R.id.btreturn);
		
		btregister1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name = edname1.getText().toString();
				String password = edpassword1.getText().toString();
				if (!(name.equals("") && password.equals(""))) {
					if ( true ) {
						DialogInterface.OnClickListener ss = new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								// ��ת����¼����
								Intent in = new Intent();
								in.setClass(RegistersActivity.this,
										LoginActivity.class);
								startActivity(in);
								// ���ٵ�ǰactivity
								RegistersActivity.this.onDestroy();
							}
						};
						new AlertDialog.Builder(RegistersActivity.this)
								.setTitle("ע��ɹ�").setMessage("ע��ɹ�")
								.setPositiveButton("ȷ��", ss).show();

					} else {
						new AlertDialog.Builder(RegistersActivity.this)
								.setTitle("ע��ʧ��").setMessage("ע��ʧ��")
								.setPositiveButton("ȷ��", null);
					}
				} else {
					new AlertDialog.Builder(RegistersActivity.this)
							.setTitle("�ʺ����벻��Ϊ��").setMessage("�ʺ����벻��Ϊ��")
							.setPositiveButton("ȷ��", null);
				}

			}
		});
		
		btreturn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// ��ת����¼����
				Intent in = new Intent();
				in.setClass(RegistersActivity.this, LoginActivity.class);
				startActivity(in);
				// ���ٵ�ǰactivity
				RegistersActivity.this.onDestroy();
			}
		});
	}
}
