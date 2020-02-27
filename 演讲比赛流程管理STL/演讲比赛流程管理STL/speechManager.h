#pragma once
#include<iostream>
#include<vector>
#include<map>
#include "speaker.h"
using namespace std;

//�ݽ�������
class SpeechManager
{
public:
	SpeechManager();

	//����ѡ�� ����  12��
	vector<int>v1;

	//��һ�ֽ�������  6��
	vector<int>v2;

	//ʤ��ǰ��������  3��
	vector<int>vVictory;

	//��ű�� �Լ���Ӧ�� ����ѡ�� ����
	map<int, Speaker> m_Speaker;

	int m_Index;
	void initSpeech();
	//�˵�չʾ
	void show_Menu();
	void exitSystem();

	void createSpeaker();

	~SpeechManager();
};