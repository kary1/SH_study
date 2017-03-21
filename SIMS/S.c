#include <stdio.h>
#include "sims.h"


int main(int argc, char const *argv[])
{	
	Node * temp, * temp1, * temp2, * temp3;
	Grade * pgrade;
	char choice, choice2, choice3, choice4, choice5;
	char password[PASSLEN], checkPassword[PASSLEN];
	classes * classes1, * classes2, * classes3;
	FILE * fp;

	
	loginMenuGreet();
	printf("ID : ");
	while(scanf("%s", temp->student.ID) == 1)
	{
		if (seekStudent(temp, pgrade) == NULL)
		{
			puts("Your enter is wrong enter again.");
		}
		else
			break;
	}	
	printf("Password : ");
	while(scanf("%s", temp->student.password) == 1)
	{
		if (seekStudent(temp, pgrade)->student.password != password)
		{
			puts("Your enter is wrong enter again.");
		}
		else
			break;
	}
	temp = seekStudent(temp, pgrade);
	if (isAdmin(temp))
	{
		puts("You have the admin permissions.")
		while((choice = adminMenu()) != 'q')
		{
			switch(choice)
			{
				case a:
					while((choice2 = seekMenu()) != 'q')
					{
						switch(choice2)
						{
							case a:
								Student * seek;
								printf("entet the ID number.\nID : ");
								while(scanf("%s", seek->ID) == 1
									&& seek->ID != '\n')
								{
									if (seekStudent(seek, pgrade) == NULL)
									{
										puts("Wrong ID  Enter again.");
										continue;
									}
									else
									{
										showStudent(seekStudent(seek, pgrade));
										printf("enter new ID to continue\n"
										"and press Enter to stop.\n ID = ");
									}
									eatline();
								}								
								break;
							case b:								
								printf("Enter the class ID\n"
									"Class ID = ")
								while(scanf("%s", classes1->classes) == 1
									&& classes1->classes != '\n')
								{								
									if (seekClasses(classes1, pgrade) == NULL)
									{
										puts("Wrong class ID enter again");
										continue;
									}
									else
									{
										showClasses(classes1, pgrade);
										printf("enter new ID to continue\n"
										"and press Enter to stop.\n ID = ");
									}
									eatline();
								}								
								break;
							default:
								puts("ERROE 1");
						}						
					}break;
				case b:
					while((choice6 = addMenu()) != 'q')
					{
						switch(choice6)
						{
							case a:
								puts("Press enter to add and q to quit.");
								while(getchar() != 'q')
								{
									puts("Enter student information:");
									temp1 = creatStudent(void);
									if (!addStudent(temp1, pgrade))
									{
										puts("ERROE 2");
									}								
									puts("Press enter to add and q to quit.");
								}break;
							case b:
								puts("Press enter to add and q to quit.");
								while(getchar() != 'q')
								{
									classes3 = creatClass(void);
									if (!addClasses(classes3, pgrade))
									{
										puts("ERROE  6");
									}
									puts("Press enter to add and q to quit.");
								}
							default:
								puts("ERROE 7");
						}
					}					
				case c:
					printf("Enter the ID NO. of the student that you want to modify\n");
					printf(" ID = ");
					while(scanf("%s", temp2->student.ID) == 1 && strcmp(temp2->student.ID, "\n"))
					{	
						if(seekStudent(temp2, pgrade) == NULL)
						{
							puts("Your enter is wrong enter again.");
							continue;
						}
						else
						{
							modifyStudent(temp2, pgrade);
							puts("Enter next student's ID NO. or  press enter to quit.");
						}
					}break;
				case d:
					while((choice4 = deletMenu()) != 'q')
						switch(choice4)
						{
							case a:
								printf("Enter the ID NO. of the student\n ID = ");
								while(scanf("%s", temp3->student.ID) == 1 
									&& strcmp(temp3->student.ID, '\n'))
								{
									if (!deletStudent(temp3, pgrade))
									{
										puts("Your enter is wrong enter again.");
										continue;
									}
									else
										puts("Enter next student's ID NO. or  press enter to quit.");
								}break;							
							case b:
								printf("Enter the class ID NO.\n ID = ");
								while(scanf("%s", classes2->ID) == 1 
									&& strcmp(classes2->ID, '\n'))
								{
									if (!deletClasses(classes2, pgrade))
									{
										puts("Your enter is wrong enter again.");
										continue;
									}
									else
										puts("Enter next class's ID NO. or  press enter to quit.");
								}break;
							default:
								puts("ERROE 3");

						}
				case e:
					while(choice5 = showMenu() != 'q')
					{
						switch(choice5)
						{
							case a:
								showOrderMath();
								break;
							case b:
								showOrderLiteraure();
								break;
							case c:
								showOrderC();
								break;
							case d:
								showOrderTtl();
								break;
							default:
								puts("ERROE 4");
						}
					}

				default:
					puts("ERROE 5");				
			}
		}
	}
	else
	{
		while((choice3 = studentMenu()) != 'q')
		{
			switch(choice3)
			{
				case a:
					showStudent (temp);
					break;
				case b:
					printf("Enter the new password.\n"" password : ");
					while(scanf("%s",password))
					{
						printf("enter again.\n password :");
						scanf("%s",checkPassword);
						if (!strcmp(password, checkPassword))
						{
							temp->password = password;
							break;
						}
						printf("Your enter is wrong .\n"
							"Please enter again.\n password : ");
					}
					break;
				case q:
					studentToFile(temp, fp);
					exit(1);
			}
		}
	}
	quitGreet();	
	return 0;
}