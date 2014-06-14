package com.pikachu.dao;

public class CommonSetting {
	
	public final static double accuracy = 0.048;
	
	final static String MYURL = "http://blaveam.sinaapp.com/pikachu/";
	static String[] strMonsterName = new String[152]; //151ֻ����
	
	public static String getMonsterNameByNumber(int num)
	{
		if (num>=1 && num <=151)
			return strMonsterName[num];
		else
			return "ȱʡ";
	}
	
	static
	{
		
		strMonsterName[0] = "";
		strMonsterName[1] = "��������";
		strMonsterName[2] = "���ܲ�";
		strMonsterName[3] = "���ܻ�";
		strMonsterName[4] = "С����";
		strMonsterName[5] = "�����";
		strMonsterName[6] = "�����";
		strMonsterName[7] = "�����";
		strMonsterName[8] = "�����";
		strMonsterName[9] = "ˮ����";
		strMonsterName[10] = "��ë��";
		strMonsterName[11] = "����Ӽ";
		strMonsterName[12] = "�ʹ��";
		strMonsterName[13] = "���ǳ�";
		strMonsterName[14] = "������";
		strMonsterName[15] = "�����";
		strMonsterName[16] = "����";
		strMonsterName[17] = "�ȱ���";
		strMonsterName[18] = "�ȵ�";
		strMonsterName[19] = "С����";
		strMonsterName[20] = "����";
		strMonsterName[21] = "��ȸ";
		strMonsterName[22] = "����ȸ";
		strMonsterName[23] = "������";
		strMonsterName[24] = "���ع�";
		strMonsterName[25] = "Ƥ����";
		strMonsterName[26] = "����";
		strMonsterName[27] = "��ɽ��";
		strMonsterName[28] = "��ɽ��";
		strMonsterName[29] = "�����";
		strMonsterName[30] = "�����";
		strMonsterName[31] = "���";
		strMonsterName[32] = "�����";
		strMonsterName[33] = "�����ŵ";
		strMonsterName[34] = "�����";
		strMonsterName[35] = "ƤƤ";
		strMonsterName[36] = "Ƥ��";
		strMonsterName[37] = "��β";
		strMonsterName[38] = "��β";
		strMonsterName[39] = "�ֶ�";
		strMonsterName[40] = "�ֶ�";
		strMonsterName[41] = "������";
		strMonsterName[42] = "������";
		strMonsterName[43] = "��·��";
		strMonsterName[44] = "������";
		strMonsterName[45] = "������";
		strMonsterName[46] = "����˹";
		strMonsterName[47] = "����˹��";
		strMonsterName[48] = "ë��";
		strMonsterName[49] = "ĩ���";
		strMonsterName[50] = "����";
		strMonsterName[51] = "������";
		strMonsterName[52] = "����";
		strMonsterName[53] = "è�ϴ�";
		strMonsterName[54] = "��Ѽ";
		strMonsterName[55] = "���Ѽ";
		strMonsterName[56] = "���";
		strMonsterName[57] = "�𱬺�";
		strMonsterName[58] = "���ٹ�";
		strMonsterName[59] = "���ٹ�";
		strMonsterName[60] = "�������";
		strMonsterName[61] = "������";
		strMonsterName[62] = "��Ӿ��";
		strMonsterName[63] = "����";
		strMonsterName[64] = "�¼���";
		strMonsterName[65] = "����";
		strMonsterName[66] = "����";
		strMonsterName[67] = "����";
		strMonsterName[68] = "����";
		strMonsterName[69] = "����ѿ";
		strMonsterName[70] = "�ڴ���";
		strMonsterName[71] = "��ʳ��";
		strMonsterName[72] = "���ˮĸ";
		strMonsterName[73] = "����ˮĸ";
		strMonsterName[74] = "Сȭʯ";
		strMonsterName[75] = "¡¡ʯ";
		strMonsterName[76] = "¡¡��";
		strMonsterName[77] = "С����";
		strMonsterName[78] = "������";
		strMonsterName[79] = "������";
		strMonsterName[80] = "������";
		strMonsterName[81] = "С�Ź�";
		strMonsterName[82] = "���ϴŹ�";
		strMonsterName[83] = "���Ѽ";
		strMonsterName[84] = "��";
		strMonsterName[85] = "����";
		strMonsterName[86] = "С��ʨ";
		strMonsterName[87] = "�׺�ʨ";
		strMonsterName[88] = "����";
		strMonsterName[89] = "������";
		strMonsterName[90] = "���౴";
		strMonsterName[91] = "���ױ�";
		strMonsterName[92] = "��˹";
		strMonsterName[93] = "��˹ͨ";
		strMonsterName[94] = "����";
		strMonsterName[95] = "������";
		strMonsterName[96] = "������";
		strMonsterName[97] = "������";
		strMonsterName[98] = "��ǯз";
		strMonsterName[99] = "��ǯз";
		strMonsterName[100] = "�׵���";
		strMonsterName[101] = "��Ƥ��";
		strMonsterName[102] = "����";
		strMonsterName[103] = "Ҭ����";
		strMonsterName[104] = "����";
		strMonsterName[105] = "��������";
		strMonsterName[106] = "ɳ����";
		strMonsterName[107] = "������";
		strMonsterName[108] = "����ͷ";
		strMonsterName[109] = "��˹��";
		strMonsterName[110] = "˫����˹";
		strMonsterName[111] = "����Ϭţ";
		strMonsterName[112] = "���ױ���";
		strMonsterName[113] = "������";
		strMonsterName[114] = "���ٹ�";
		strMonsterName[115] = "����";
		strMonsterName[116] = "ī����";
		strMonsterName[117] = "������";
		strMonsterName[118] = "�ǽ���";
		strMonsterName[119] = "������";
		strMonsterName[120] = "������";
		strMonsterName[121] = "��ʯ����";
		strMonsterName[122] = "����ħż";
		strMonsterName[123] = "�������";
		strMonsterName[124] = "�Դ��";
		strMonsterName[125] = "�����";
		strMonsterName[126] = "Ѽ�����";
		strMonsterName[127] = "���";
		strMonsterName[128] = "��̩��";
		strMonsterName[129] = "������";
		strMonsterName[130] = "������";
		strMonsterName[131] = "����";
		strMonsterName[132] = "�ٱ��";
		strMonsterName[133] = "����";
		strMonsterName[134] = "ˮ����";
		strMonsterName[135] = "�׾���";
		strMonsterName[136] = "����";
		strMonsterName[137] = "3D��";
		strMonsterName[138] = "��ʯ��";
		strMonsterName[139] = "��̾�ʯ��";
		strMonsterName[140] = "��ʯ��";
		strMonsterName[141] = "������";
		strMonsterName[142] = "��ʯ����";
		strMonsterName[143] = "������";
		strMonsterName[144] = "������";
		strMonsterName[145] = "������";
		strMonsterName[146] = "������";
		strMonsterName[147] = "����";
		strMonsterName[148] = "������";
		strMonsterName[149] = "����";
		strMonsterName[150] = "����";
		strMonsterName[151] = "�λ�";

	}

}
