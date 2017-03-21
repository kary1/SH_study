#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>
#include "sims.h"

static int studentCountClass(const Classes * classes);
static int studentCountTtl(const Grade * grade);


char loginGreet (void)
{
	puts("****************************************************************");
	puts("Hello! Welcome to use the Student Infofmation Mangement System!" );
	puts("Please Enter you ID number and your password.");
	puts("****************************************************************");
}

void quitGreet (void)
{
	puts("****************************************************************");
	puts("Thanks for your trust, Welcome to your next time use!");
	puts("****************************************************************");
}

char adminMenu (void)
{
	char ch;

	puts("Now! You have Adiminstrative privileges.");
	puts("Please enter the letter for your choice:");
	puts("a)seek         b)add messige");
	puts("c)modify       d)delet");
	puts("e)show         q)quit");
	while(scanf("%c", &ch) == 1)
	{
		ch = tolower(ch);
		if (ch != 'a' && ch != 'b' && ch != 'c' && ch != 'd' 
			&& ch != 'e' && ch != 'q')
		{
			puts("Please enter again ,and q to quit.");
		}
		eatline();
		return ch;
	}
}

char studentMenu (void)
{
	char ch;
	puts("Hello! You can modify or scanf your own message only.");
	puts("Please enter the letter for your choice:");
	puts("a)scanf           b)modify");
	puts("Enter the letter q to quit.");
	while(scanf("%c", &ch) == 1)
	{
		ch = tolower(ch);
		if (ch != 'a' && ch != 'b' && ch != 'q' )
		{
			puts("Please enter again ,and I know a b and q only.");
		}
		eatline();
		return ch;
	}
}

char seekMenu (void)
{
	char ch;
	puts("Choose the seek rule you want. ");
	puts("a)baise of ID   b)baise of classes");
	puts("Enter the letter q to quit.")
	while(scanf("%c", &ch) == 1)
	{
		ch = tolower(ch);
		if (ch != 'a' && ch != 'b' && ch != 'q' )
		{
			puts("Please enter again ,and I know a b and q only.");
		}
		eatline();
		return ch;
	}
}

bool isAdmin(const Node * temp)
{
	bool isadmin = false;
	if (strcmp("admin", temp->student.ID) == 0)
	{
		isadmin = true;
	}
	return isadmin;
}

char deletMenu(void)
{
	char ch;
	puts("Choose the seek rule you want. ");
	puts("a)delet student   b)delet class");
	puts("Enter the letter q to quit.")
	while(scanf("%c", &ch) == 1)
	{
		ch = tolower(ch);
		if (ch != 'a' && ch != 'b' && ch != 'q' )
		{
			puts("Please enter again ,and I know a b and q only.");
		}
		eatline();
		return ch;
	}
}

char showMenu(viod)
{
	char ch;
	puts("Choose the seek rule you want. ");
	puts("a)baise on math  b)baise on Literature");
	puts("c)baise on C     d)baise on Ttl")
	puts("Enter the letter q to quit.")
	while(scanf("%c", &ch) == 1)
	{
		ch = tolower(ch);
		if (ch != 'a' && ch != 'b' && ch != 'c' && ch != 'd' && ch != 'q')
		{
			puts("Please enter again ,and q to quit.");
		}
		eatline();
		return ch;
	}
}

void initializeGrade (Grade * pgrade)
{
	pgrade->head = NULL;
	pgrade->tail = NULL;
	pgrade->ttlMember = 0;

}

bool gradeIsEmpty (const Grade * pgrade)
{
	if (pgrade->head == NULL)
	{
		return true;
	}
	else
		return false;
}

bool gradeIsFull (const Grade * pgrade)
{
	if (pgrade->ttlMember == MAX_STUDENT)
	{
		return true;
	}
	else
		return false;
}

int studentCountTtl (const Grade * pgrade)
{
	return pgrade->ttlMember;
}

int studentCountClass(const Classes * classes)
{
	return classes->member;
}

Node * seekStudent (const Node * node, const Grade * pgrade)
{
	Node * temp;

	if (gradeIsEmpty())
	{
		puts("Grade is empty.");
	}
	for (temp = pgrade->head; temp != NULL; temp = temp->next)
	{
		if (!strcmp(temp->student.ID, node->student.ID))
		{
			return temp;
		}
	}	
	return NULL;
}

//bool addStudent (const Node * node, Grade * pgrade)
{
	Node * temp, * after;
	if (gradeIsFull(pgrade))
	{
		fpintf(stderr, "grade is full.");
		return false;
	}
	if (node->student.sorce.totalSorce > pgrade->head->student.sorce.totalSorce)
	{
		pgrade->tail = pgrade->head;
		node->next = pgrade->head;
		pgrade->head = node;
		pgrade->ttlMember++;
		return true;
	}
	for ( temp = pgrade->head, after = pgrade->head->next; after != NULL && 
		after->student.sorce.totalSorce > node->student.sorce.totalSorce ; 
		temp = temp->next, after = after->next)
	{
		continue;
	}
	if (after == NULL)
	{
		temp->next = node;
		pgrade->tail = node;
		pgrade->ttlMember++;
		return true;				
	}
	else
	{
		node->next = after;
		temp->next = node;
		pgrade->ttlMember++;
		return true;
	}	
}

bool deletStudent (const Node * node, Grade * pgrade)
{
	Node * temp, *before;

	if ((temp = seekStudent(node, pgrade)) != NULL)
	{
		if (temp == pgrade->head)
		{
			pgrade->head = temp->next;
			free(temp);
		}
		for (before = pgrade->head; before != NULL ; before = before->next)
		{
			if (before->next == temp)
			{
				before->next = temp->next;
				free(temp);				
				return true;
			}
		}
	}
	else
		return false;
}

bool modifyStudent (const Node * temp, Grade * pgrade)
{
	char ch[PASSLEN];

	printf("ID = %s", temp->student.ID);
	scanf("%s",ch);
	if (strcmp(ch, "\n"))
	{
		strcpy(temp->student.ID, ch);
	}
	printf("name = %s\n",temp->student.name );
	if (strcmp(ch, "\n"))
	{
		strcpy(temp->student.name, ch);
	}
	printf("password = %s", temp->student.password);
	scanf("%s",ch);
	if (strcmp(ch, "\n"))
	{
		strcpy(temp->student.password, ch);
	}
	printf("sex = %s", temp->student.sex);
	scanf("%s",ch);
	if (strcmp(ch, "\n"))
	{
		strcpy(temp->student.sex, ch);
	}
	printf("class = %s", temp->student.classes);
	scanf("%s",ch);
	if (strcmp(ch, "\n"))
	{
		strcpy(temp->student.classes, ch);
	}
	printf("math = %d", temp->student.sorce.math);
	scanf("%s",ch);
	if (strcmp(ch, "\n"))
	{
		temp->student.sorce.math = (char) atoi(ch);
	}
	printf("Literature = %d", temp->student.sorce.literature);
	scanf("%s",ch);
	if (strcmp(ch, "\n"))
	{
		temp->student.sorce.literature = (char) atoi(ch);
	}
	printf("C = %d", temp->student.sorce.c);
	scanf("%s",ch);
	if (strcmp(ch, "\n"))
	{
		temp->student.sorce.c = (short short) atoi(ch);
	}
}

bool deletClasses (const Classes * pclasses, Grade *pgrade)
{
	
}

void showStudent (const Node * temp)
{
	printf("ID : %s name : %s age : %d sex : %s classes : %s"
 		"\nsorce ( math : %d lirerature : %d C : %d )ranked : %d \n",
		temp->student.ID, temp->student.name, temp->student.age,
		temp->student.sex, temp->student.classID, temp->student.sorce.math, 
		temp->student.sorce.literature, temp->student.sorce.c);
}

void showClasses(const classes * temp)
{
	const Node * node;
	if (temp->head == NULL)
	{
		puts("Class is empty.")
	}
	else
	{
		for (node = temp->head; node = temp->tail; node = node.next)
		{
			showStudent(node);
		}
		showStudent(node->next);
	}	
}

Node * creatStudent(void)
{
	Node * temp;
	temp = (Node *)malloc(sizeof(Node));
	if (temp == NULL)
	{
		puts("Can't creat student");
	}
	else
	{
		printf("ID = ");
		scanf("%s", temp->student.ID);
		printf("name = ");
		scanf("%s", temp->student.name);
		printf("password = ");
		scanf("%s", temp->student.password);
		printf("sex = ");
		scanf("%s", temp->student.sex);
		printf("class = ");
		scanf("%s", temp->student.classID);
		printf("math = ");
		scanf("%hhd", &temp->student.sorce.math);
		printf("literature = ");
		scanf("%hhd", &temp->student.sorce.literature);
		printf("c = ");
		scanf("%hhd", &temp->student.sorce.c);
	}
	temp->next = NULL;
	return temp;
}

Classes * creatClass(void)
{
	Classes * classes = NULL;
	int i, count = 0;
	Node * temp;
	char ID[IDLEN];

	classes->head = classes->tail = NULL;
	printf("Enter class name ID\n Class ID = ");
	scanf("%s", classes->classID);
	classes->head = temp = (Node * )malloc(sizeof(node));
	if (classes->head = NULL)
		{
			puts("There is not enough space.");
		}
	for ( i = 1; i < 31; ++i)
	{
		temp->next = (Node * )malloc(sizeof(node));
		if (temp->next = NULL)
		{
			puts("There is not enough space. at : %d.", count+1);
			break;
		}
		temp = temp->next;
		count++;
		sprintf(ID, "2014%s%02d", classID, count);
		strcpy(temp -> student.ID, ID);
		strcpy(temp -> student.classID, classes->classID);
		temp->next = NULL;
	}
	classes->tail = temp;
	classes->member = count;
	return classes;
}


void eatline(void)
{
	while(getchar() != '\n');
}