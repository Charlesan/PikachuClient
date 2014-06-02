package com.pikachu.dao;

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.pikachu.bean.MonsterBean;
import com.pikachu.dao.CommonSetting;

public class MonsterDao {
	public MonsterDao(){}
	
	public ArrayList<MonsterBean> getAllMonster()
	{
		String httpUrl = CommonSetting.MYURL+"getallmonsterlist.php";
		HttpGet httpRequest = new HttpGet(httpUrl);
		try
		{
			HttpClient httpcliet = new DefaultHttpClient();
			HttpResponse httpResponse = httpcliet.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
			{
				String strResult = EntityUtils.toString(httpResponse.getEntity(),"UTF8");
				String tem[] = null;
				tem = strResult.split(" ");
				System.out.println("net return code:  "+tem[0]);
				int result = Integer.parseInt(tem[0]);
				
				for (int i=0;i<tem.length;i++)
					System.out.println(i +":  "+tem[i]);
				
				if (result == 1)
				{
					ArrayList<MonsterBean> mbs = new ArrayList<MonsterBean>();
					int count = 0;
					
					for (count=0; count*9+1<tem.length;count++)
					{
						MonsterBean mb = new MonsterBean();
						mb.m_id = Integer.parseInt(tem[count*9+1]);
						mb.m_number = Integer.parseInt(tem[count*9+2]);
						mb.m_name = tem[count*9+3];
						mb.m_mark = Integer.parseInt(tem[count*9+4]);
						mb.m_longitude = Double.parseDouble(tem[count*9+5]);
						mb.m_latitude = Double.parseDouble(tem[count*9+6]);
						mb.m_altitude = Double.parseDouble(tem[count*9+7]);
						mb.m_iscapatured = Integer.parseInt(tem[count*9+8]);
						mb.m_ownerid = Integer.parseInt(tem[count*9+9]);
						mbs.add(mb);
					}
					
					return mbs;
				}
				
				return null;
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	
	public ArrayList<MonsterBean> getLocalMonster(double fLon, double fLat, double fRange)
	{
		String httpUrl = CommonSetting.MYURL+"getlocalmonsterlist.php?ulongitude="+fLon+"&ulatitude="+fLat;
		if (fRange>=1e-6)
			httpUrl = httpUrl+"&udistance="+fRange;
		
		HttpGet httpRequest = new HttpGet(httpUrl);
		try
		{
			HttpClient httpcliet = new DefaultHttpClient();
			HttpResponse httpResponse = httpcliet.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
			{
				String strResult = EntityUtils.toString(httpResponse.getEntity(),"UTF8");
				String tem[] = null;
				tem = strResult.split(" ");
				System.out.println("net return code:  "+tem[0]);
				int result = Integer.parseInt(tem[0]);
				
				for (int i=0;i<tem.length;i++)
					System.out.println(i +":  "+tem[i]);
				
				if (result == 1)
				{
					ArrayList<MonsterBean> mbs = new ArrayList<MonsterBean>();
					int count = 0;
					
					for (count=0; count*9+1<tem.length;count++)
					{
						MonsterBean mb = new MonsterBean();
						mb.m_id = Integer.parseInt(tem[count*9+1]);
						mb.m_number = Integer.parseInt(tem[count*9+2]);
						mb.m_name = tem[count*9+3];
						mb.m_mark = Integer.parseInt(tem[count*9+4]);
						mb.m_longitude = Double.parseDouble(tem[count*9+5]);
						mb.m_latitude = Double.parseDouble(tem[count*9+6]);
						mb.m_altitude = Double.parseDouble(tem[count*9+7]);
						mb.m_iscapatured = Integer.parseInt(tem[count*9+8]);
						mb.m_ownerid = Integer.parseInt(tem[count*9+9]);
						mbs.add(mb);
					}
					
					return mbs;
				}
				
				return null;
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
}

