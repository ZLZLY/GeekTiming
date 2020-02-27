#pragma once
#include<iostream>
#include<vector>
#include<map>
#include "speaker.h"
#include<algorithm>
#include<deque>
#include<numeric>
#include <fstream>
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

	//��ʼ���� - �������̿���
	void startSpeech();
	//��ǩ
	void speechDraw();
	//����
	void speechContest();

	void showScore();
	~SpeechManager();
	//�����¼
	void saveRecord();
	void loadRecord();
	bool fileIsEmpty;
	map<int, vector<string>> m_Record;
	void showRecord();
};