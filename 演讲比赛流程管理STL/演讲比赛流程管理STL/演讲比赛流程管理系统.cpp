#include<iostream>
using namespace std;
#include "speechManager.h"
#include<time.h>

int main() {
	srand((unsigned int)time(NULL));
	SpeechManager sm;

	int choice = 0; //�����洢�û���ѡ��

	while (true)
	{
		sm.show_Menu();

		cout << "����������ѡ�� " << endl;
		cin >> choice; // �����û���ѡ��

		switch (choice)
		{
		case 1:  //��ʼ����
			sm.startSpeech();
			break;
		case 2:  //�鿴��¼
			sm.showRecord();
			break;
		case 3:  //��ռ�¼
			break;
		case 0:  //�˳�ϵͳ
			sm.exitSystem();
			break;
		default:
			system("cls"); //����
			break;
		}
	}

	system("pause");

	return 0;
}