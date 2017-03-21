#ifndef SIMS_H_
#define SIMS_H_
#include <stdio.h>
#include <stdbool.h>
void eatline(void);

#define IDLEN 13
#define PASSLEN 16
#define CLASSLEN 7
#define NAMELEN 6
#define MAX_STUDENT 300

typedef char number;

typedef struct sorce  // 成绩
{
	number math;
	number literature;
	number c;
	int totalSorcr;
}Sorce;

typedef struct student //学生信息
{
	char ID[IDLEN];
	char name[NAMELEN];
	char sex[6];  //可用枚举，后面做更改
	char password[PASSLEN];
	char classID[CLASSLEN];
	Sorce sorce;
	number ranking;
}Student;

typedef struct node//节点
{
	Student student;
	struct node * next;
}Node;

typedef struct classes//班级
{
	char classID[CLASSLEN];
	Node * head;
	Node * tail;
	number member;
}Classes;

typedef struct cNode{//班级结构 节点
	Classes classes;
	struct cNode * next;
}CNode;

typedef struct clist{//班级链表
	CNode * cnode;
	int cnum；//班级人数
}CList;

typedef struct grade//学生链表
{
	Node * head;
	int ttlMember;
}Grade;

//登录菜单，确认身份权限
void loginGreet (void);

//管理员菜单 选择功能
char adminMenu (void);

//学生菜单 选择功能
char studentMenu (void);

//查找菜单 选择按什么查找
char seekMenu (void);

//管理员验证
bool isAdmin(const Node * temp);

//初始化队列
void InitializeGrade (Grade * pgrade);

//确认队列是否为空
bool GradeIsEmpty (const Grade * pgrade);

//确认队列是否为满
bool GradeIsFull (const Grade * pgrade);

//查找队列中的节点 并返回节点的指针
Node * SeekStudent (const Node * temp, const Grade * pgrade);

//选择增加方式
char addMenu(void);

//增加学生到队列
bool addStudent (const Node * temp, Grade * pgrade);

//从队列中删除节点
bool deletStudent (const Node * temp, Grade * pgrade);

//修改学生的内容
bool modifyStudent (const Node * temp, Grade * pgrade);

//删除班级
bool deletClasses (const Classes * pclasses, Grade *pgrade);

//显示信息
void showStudent(Node * temp);

//查找班级
Classes * seekClasses(Classes * classes, Grade * pgrade);

//显示班级全部信息
Node * creatStudent(void);

//显示菜单
char showMenu(void);

//按数学成绩显示
bool showOrderMath(void);

//按语文成绩显示
bool showOrderLiterature(void);

//按C成绩显示
bool showOrderC(void);

//按总成绩显示
bool showOrderTtl(void);

//保存在文件
bool studentToFile(void);

//删除菜单
char deletMenu(void);

//退出菜单
void quitGreet();

//创建班级
Classes * creatClass(void);

//添加班级到队列
bool addClass(const Classes * classes, Grade * pgrade);

//显示班级
void showClass(Classes * classes, Grade * grade);

void eatline(void)
{
	while(getchar() != '\n');
}

#endif