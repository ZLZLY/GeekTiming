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

//演讲管理类
class SpeechManager
{
public:
	SpeechManager();

	//比赛选手 容器  12人
	vector<int>v1;

	//第一轮晋级容器  6人
	vector<int>v2;

	//胜利前三名容器  3人
	vector<int>vVictory;

	//存放编号 以及对应的 具体选手 容器
	map<int, Speaker> m_Speaker;

	int m_Index;
	void initSpeech();
	//菜单展示
	void show_Menu();
	void exitSystem();

	void createSpeaker();

	//开始比赛 - 比赛流程控制
	void startSpeech();
	//抽签
	void speechDraw();
	//比赛
	void speechContest();

	void showScore();
	~SpeechManager();
	//保存记录
	void saveRecord();
	void loadRecord();
	bool fileIsEmpty;
	map<int, vector<string>> m_Record;
	void showRecord();
};