/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 
 * @author ����1201�� ����� �������ƥ���㷨
 */
public class ���� {

	int m_maxLen;
	int m_posIndex;
	String m_result = " ";
	HashSet<String> set;

	public ����(int MaxLen) throws FileNotFoundException, IOException {
		m_maxLen = MaxLen;
		m_posIndex = 0;
		set = new HashSet<String>();
		BufferedReader buff = new BufferedReader(new InputStreamReader(
				new FileInputStream("F://ChineseDic.txt"), "GBK"));
		for (String line = buff.readLine(); line != null; line = buff
				.readLine()) { // while (!buff.readLine().isEmpty())
			set.add(line.split(",")[0]);
		}
		buff.close();
	}

	// �������ƥ���㷨
	public void MM(String source, int len, int frompos) throws IOException {

		if (m_posIndex >= source.length() - 1) {
			return;
		}
		String tmp;
		tmp = SubString(source, len, frompos);

		if (Match(tmp)) { // ƥ��
			m_result = m_result + tmp + "/";
			m_posIndex = m_posIndex + m_maxLen;
			m_maxLen = 3;
			MM(source, m_maxLen, m_posIndex);
		} else { // ��ƥ��
			if (m_maxLen > 1) {
				m_maxLen = m_maxLen - 1;
				MM(source, m_maxLen, m_posIndex);
			} else {
				m_result = m_result + "�ֵ���û��'" + tmp + "'��/";
				m_posIndex = m_posIndex + 1;
				m_maxLen = 3;
				MM(source, m_maxLen, m_posIndex);
			}

		}
	}

	public String SubString(String source, int len, int frompos) {
		// �������жϣ�����ȡ�������ַ����Ѿ�������Դ��ʣ�µ��Ӵ�������
		String tmp;
		int sxLen, Len;
		sxLen = source.length() - frompos; // ʣ�µ��Ӵ��ĳ���
		if (len > sxLen) { // ��ȡ���ȴ���ʣ���ִ��ĳ���
			Len = sxLen;
		} else {
			Len = len;
		}
		tmp = source.substring(frompos, frompos + Len);
		return tmp;
	}

	// ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���

	public boolean Match(String str) {
		// if(set.contains(str)) return true;
		// else return false ;
		return set.contains(str);
	}

	public static void main(String args[]) throws IOException {
		Runtime run = Runtime.getRuntime(); 
		long s = System.currentTimeMillis();
		System.out.println(run.totalMemory());
		���� mm = new ����(3);
		String conString = "�׶�԰�ؽ�Ŀȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���ȡ�����Ӵ�str�󣬾�Ҫ���ı��ļ����ֵ�D����ѭ����ȡ�ֵ�D���з���Ӵ������򷵻���ȷ�����򷵻ش���";
		mm.MM(conString, 3, 0);
		System.out.println(mm.m_result);
		System.out.println(conString.length());
		long e = System.currentTimeMillis();
		System.out.println(e - s);
		bufferLoop: for (;;) {
			for (;;) {
				break bufferLoop;
			}
		}
		System.out.println(run.totalMemory());
	}
}
