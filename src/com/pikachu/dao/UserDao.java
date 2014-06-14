package com.pikachu.dao;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.pikachu.bean.UserBean;
import com.pikachu.dao.CommonSetting;

public class UserDao {
	public UserDao() {
	}

	public int register(String strLoginId, String strLoginPwd, String strName) {
		String httpUrl = CommonSetting.MYURL + "register.php?uloginid="
				+ strLoginId + "&upwd=" + strLoginPwd + "&uname=" + strName;
		HttpGet httpRequest = new HttpGet(httpUrl);
		try {
			HttpClient httpcliet = new DefaultHttpClient();
			HttpResponse httpResponse = httpcliet.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResult = EntityUtils.toString(
						httpResponse.getEntity(), "UTF8");
				String tem[] = null;
				tem = strResult.split(" ");
				System.out.println("net return code:  " + tem[0]);
				int result = Integer.parseInt(tem[0]);

				for (int i = 0; i < tem.length; i++)
					System.out.println(i + ":  " + tem[i]);

				return result;
			} else {
				return -1;
			}
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public int login(String strLoginId, String strLoginPwd) {
		String httpUrl = CommonSetting.MYURL + "login.php?uloginid="
				+ strLoginId + "&upwd=" + strLoginPwd;
		HttpGet httpRequest = new HttpGet(httpUrl);
		try {
			HttpClient httpcliet = new DefaultHttpClient();
			HttpResponse httpResponse = httpcliet.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResult = EntityUtils.toString(
						httpResponse.getEntity(), "UTF8");
				String tem[] = null;
				tem = strResult.split(" ");
				System.out.println("net return code:  " + tem[0]);
				int result = Integer.parseInt(tem[0]);

				for (int i = 0; i < tem.length; i++)
					System.out.println(i + ":  " + tem[i]);

				return result;
			} else {
				return -1;
			}
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public UserBean getUserBean(String strLoginId) {
		String httpUrl = CommonSetting.MYURL + "getusermsg.php?uloginid="
				+ strLoginId;
		HttpGet httpRequest = new HttpGet(httpUrl);
		try {
			HttpClient httpcliet = new DefaultHttpClient();
			HttpResponse httpResponse = httpcliet.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResult = EntityUtils.toString(
						httpResponse.getEntity(), "UTF8");
				String tem[] = null;
				tem = strResult.split(" ");
				System.out.println("net return code:  " + tem[0]);
				int result = Integer.parseInt(tem[0]);
				for (int i = 0; i < tem.length; i++)
					System.out.println(i + ":  " + tem[i]);

				if (result == 1) {
					UserBean ub = new UserBean();
					ub.u_id = Integer.parseInt(tem[1]);
					ub.u_login_id = tem[2];
					ub.u_login_pwd = tem[3];
					ub.u_name = tem[4];
					ub.u_number = Integer.parseInt(tem[5]);
					ub.u_mark = Integer.parseInt(tem[6]);

					return ub;
				}
				return null;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public int getUserRank(String strLoginId) {
		String httpUrl = CommonSetting.MYURL + "getuserrank.php?uloginid="
				+ strLoginId;
		HttpGet httpRequest = new HttpGet(httpUrl);
		try {
			HttpClient httpcliet = new DefaultHttpClient();
			HttpResponse httpResponse = httpcliet.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResult = EntityUtils.toString(
						httpResponse.getEntity(), "UTF8");
				String tem[] = null;
				tem = strResult.split(" ");
				System.out.println("net return code:  " + tem[0]);
				int result = Integer.parseInt(tem[0]);

				for (int i = 0; i < tem.length; i++)
					System.out.println(i + ":  " + tem[i]);

				if (result == 1) {
					return Integer.parseInt(tem[1]);
				}

				return -1;
			} else {
				return -1;
			}
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public ArrayList<UserBean> getTopRank() {
		String httpUrl = CommonSetting.MYURL + "gettoprank.php";
		HttpGet httpRequest = new HttpGet(httpUrl);
		try {
			HttpClient httpcliet = new DefaultHttpClient();
			HttpResponse httpResponse = httpcliet.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResult = EntityUtils.toString(
						httpResponse.getEntity(), "UTF8");
				String tem[] = null;
				tem = strResult.split(" ");
				System.out.println("net return code:  " + tem[0]);
				int result = Integer.parseInt(tem[0]);

				for (int i = 0; i < tem.length; i++)
					System.out.println(i + ":  " + tem[i]);

				if (result == 1) {
					ArrayList<UserBean> ubs = new ArrayList<UserBean>();
					int count = 0;

					for (count = 0; count * 6 + 1 < tem.length; count++) {
						UserBean ub = new UserBean();
						ub.u_id = Integer.parseInt(tem[count * 6 + 1]);
						ub.u_login_id = tem[count * 6 + 2];
						ub.u_login_pwd = tem[count * 6 + 3];
						ub.u_name = tem[count * 6 + 4];
						ub.u_number = Integer.parseInt(tem[count * 6 + 5]);
						ub.u_mark = Integer.parseInt(tem[count * 6 + 6]);
						ubs.add(ub);
					}

					return ubs;
				}

				return null;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public ArrayList<UserBean> getAllUserBean() {
		String httpUrl = CommonSetting.MYURL + "getallusermsg.php";
		HttpGet httpRequest = new HttpGet(httpUrl);
		try {
			HttpClient httpcliet = new DefaultHttpClient();
			HttpResponse httpResponse = httpcliet.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResult = EntityUtils.toString(
						httpResponse.getEntity(), "UTF8");
				String tem[] = null;
				tem = strResult.split(" ");
				System.out.println("net return code: " + tem[0]);
				int result = Integer.parseInt(tem[0]);

				for (int i = 0; i < tem.length; i++)
					System.out.println(i + ": " + tem[i]);

				if (result == 1) {
					ArrayList<UserBean> ubs = new ArrayList<UserBean>();
					int count = 0;

					for (count = 0; count * 6 + 1 < tem.length; count++) {
						UserBean ub = new UserBean();
						ub.u_id = Integer.parseInt(tem[count * 6 + 1]);
						ub.u_login_id = tem[count * 6 + 2];
						ub.u_login_pwd = tem[count * 6 + 3];
						ub.u_name = tem[count * 6 + 4];
						ub.u_number = Integer.parseInt(tem[count * 6 + 5]);
						ub.u_mark = Integer.parseInt(tem[count * 6 + 6]);
						ubs.add(ub);
					}

					return ubs;
				}

				return null;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public Set<Integer> getUserHandbook(String strLoginId) {
		String httpUrl = CommonSetting.MYURL + "getuserhandbook.php?uloginid="
				+ strLoginId;
		HttpGet httpRequest = new HttpGet(httpUrl);
		try {
			HttpClient httpcliet = new DefaultHttpClient();
			HttpResponse httpResponse = httpcliet.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResult = EntityUtils.toString(
						httpResponse.getEntity(), "UTF8");
				String tem[] = null;
				tem = strResult.split(" ");
				System.out.println("net return code:  " + tem[0]);
				int result = Integer.parseInt(tem[0]);

				for (int i = 0; i < tem.length; i++)
					System.out.println(i + ":  " + tem[i]);

				if (result == 1) {
					Set<Integer> s = new TreeSet<Integer>();

					for (int i = 1; i < tem.length; i++) {
						int num = Integer.parseInt(tem[i]);
						s.add(num);
					}

					return s;
				}

				return null;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public int rename(String strLoginId, String strName) {
		String httpUrl = CommonSetting.MYURL + "rename.php?uloginid="
				+ strLoginId + "&uname=" + strName;
		HttpGet httpRequest = new HttpGet(httpUrl);
		try {
			HttpClient httpcliet = new DefaultHttpClient();
			HttpResponse httpResponse = httpcliet.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResult = EntityUtils.toString(
						httpResponse.getEntity(), "UTF8");
				String tem[] = null;
				tem = strResult.split(" ");
				System.out.println("net return code:  " + tem[0]);
				int result = Integer.parseInt(tem[0]);

				for (int i = 0; i < tem.length; i++)
					System.out.println(i + ":  " + tem[i]);

				return result;
			} else {
				return -1;
			}
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public int repassword(String strLoginId, String strLoginPwd,
			String strNewPwd) {
		String httpUrl = CommonSetting.MYURL + "repassword.php?uloginid="
				+ strLoginId + "&uloginpwd=" + strLoginPwd + "&newuloginpwd="
				+ strNewPwd;
		HttpGet httpRequest = new HttpGet(httpUrl);
		try {
			HttpClient httpcliet = new DefaultHttpClient();
			HttpResponse httpResponse = httpcliet.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResult = EntityUtils.toString(
						httpResponse.getEntity(), "UTF8");
				String tem[] = null;
				tem = strResult.split(" ");
				System.out.println("net return code:  " + tem[0]);
				int result = Integer.parseInt(tem[0]);

				for (int i = 0; i < tem.length; i++)
					System.out.println(i + ":  " + tem[i]);

				return result;
			} else {
				return -1;
			}
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public int catchMonster(int nUid, int nMid) {
		String httpUrl = CommonSetting.MYURL + "catchmonster.php?uid=" + nUid
				+ "&mid=" + nMid;
		HttpGet httpRequest = new HttpGet(httpUrl);
		try {
			HttpClient httpcliet = new DefaultHttpClient();
			HttpResponse httpResponse = httpcliet.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResult = EntityUtils.toString(
						httpResponse.getEntity(), "UTF8");
				String tem[] = null;
				tem = strResult.split(" ");
				System.out.println("net return code:  " + tem[0]);
				int result = Integer.parseInt(tem[0]);

				for (int i = 0; i < tem.length; i++)
					System.out.println(i + ":  " + tem[i]);

				return result;
			} else {
				return -1;
			}
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}
}
