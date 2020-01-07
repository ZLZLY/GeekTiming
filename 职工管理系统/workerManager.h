#pragma once
#include<iostream>
#include "worker.h"
#include "employee.h"
#include "boss.h"
#include "manager.h"
#include <fstream>
#define  FILENAME "empFile.txt"
using namespace std;

class WorkerManager
{
public:
	WorkerManager();
	//展示菜单
	void Show_Menu();
	//退出功能
	void exitSystem();
	//所有功能
	void Add_Emp();
	void Show_Emp();
	void Del_Emp();
	void Mod_Emp();
	void Find_Emp();
	void Sort_Emp();
	void Clean_File();
	~WorkerManager();
	

	
private:
	void save();
	int get_EmpNum();
	void init_Emp();
	int IsExist(int id);
	Worker** m_EmpArray;
	int m_EmpNum;
	bool m_FileIsEmpty;

	
};