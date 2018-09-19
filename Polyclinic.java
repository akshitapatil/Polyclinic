//START OF THE PROGRAM  :-)
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class Polyclinic
{
    InputStreamReader read = new InputStreamReader(System.in);
    BufferedReader buf = new BufferedReader (read);
    int slno[]=new int[24];
    String name[]={" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
    String DEP[]={" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
    String phone_no[]={" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
    String qualification[]={" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
    String n_space[]={" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
    double revenue[]=new double[24];
    double totalsalary[]=new double[24];
    int n[]=new int[24];
    int count = 0;
    char ch;
    String dept[]={"Medicine","Obstetrics & Gynaecology","Pediatrics","Anesthesiology","Ophthalmology","Dentist"};
    String docqual[]={"MBBS, MD in ", "MBBS , Diploma in "};
    double bsal=30000;
    int k = 0 ;
    int choice = 0 ;
    int day, month, year, second, minute, hour;
    String dayofw = "";
    public  void accept()throws IOException
    {
        int k = 0;
        System.out.println ('\f');
        System.out.println ("1. To Enter Details Of The Doctor");
        System.out.println ("2. To Fix Appointment with Doctor ");
        System.out.println ("3. To Exit");
        System.out.println("Any Other Key To Go Back To The Menu");
        int a=0;
        try
        {
            a =Integer.parseInt(buf.readLine());
        }     
        catch(NumberFormatException obj)
        {
            doctorMenu();
        }
        if(a>3||a<1)doctorMenu();
        System.out.println ('\f');
        switch(a)
        {
            case 1:
            //Serial no generated automatically
            slno[count]=count+1;

            //Checking for name validity
            nameLoop:
            do
            {
                System.out.println("Enter the name of the doctor:");
                String SS = buf.readLine().trim();
                name[count]=Character.toUpperCase(SS.charAt(0)) + SS.substring(1);
                if(name[count].length()==0) continue;
                for( k=0;k<name[count].length();k++)
                {
                    char ch1=name[count].charAt(k);
                    if(Character.isLetter(ch1)|| ch1== ' '||ch=='.')
                        continue;
                    else
                    {
                        System.out.println("Please enter a valid name....");
                        continue nameLoop;
                    }
                }
                break;
            }while(true); 

            //Checking for Department
            int x=0;

            do
            {
                System.out.println("Enter the department of the doctor:");
                for(int i=0;i<dept.length;i++)
                {
                    System.out.println(i+1+". "+dept[i]);
                }
                try
                {
                    System.out.println("Enter Your choice");
                    x=Integer.parseInt(buf.readLine());
                }
                catch(NumberFormatException obj)
                {
                    System.out.println("Please enter digits only...");
                    continue;
                }
                if(x>=1 && x<=dept.length)
                {
                    DEP[count] = dept[x-1];

                    break;
                }
                System.out.println("Enter a valid digit from 1 to "+ dept.length);

            }while(true); 

            //Checking for qualification

            do
            {
                System.out.println("Enter the qualification of the doctor:");
                for(int i=0;i<docqual.length;i++)
                {
                    System.out.println(i+1+". "+docqual[i]+ DEP[count]);
                }
                try
                {
                    System.out.println("Enter Your choice");
                    x=Integer.parseInt(buf.readLine());
                }
                catch(NumberFormatException obj)
                {
                    System.out.println("Please enter digits only...");
                    continue;
                }
                if(x>=1 && x<=docqual.length)
                {
                    qualification[count] = docqual[x-1]+ DEP[count];

                    break;
                }
                System.out.println("Enter a valid digit from 1 to "+ docqual.length);

            }while(true); 

            //checking for phone number
            phoneloop:
            do
            {
                System.out.println("Please enter  PHONE number..");
                String ppno=buf.readLine().trim();
                if(ppno.length()!=10)
                {
                    System.out.println("Please enter a valid 10 digit PHONE number");
                    continue;
                }
                else 
                {
                    for(k=0;k<ppno.length();k++)
                    {

                        if(!Character.isDigit(ppno.charAt(k)))
                        {
                            System.out.println("Please enter a valid 10 digit PHONE number---Only digits");
                            continue phoneloop;
                        }
                    }
                    phone_no[count]=ppno;
                    break;
                }

            }while(true);

            //Checking for Surgeries
            do
            {
                try
                {

                    System.out.println("Enter the number of surgeries performed by "+name[count]);
                    n[count]=Integer.parseInt(buf.readLine());
                }
                catch(NumberFormatException obj)
                {
                    System.out.println("Please enter digits only...");
                    continue;
                }
                if(n[count]<=0)
                {
                    System.out.println("Enter a positive number...");
                    continue;
                }
                break;
            }while(true);
            calculating_revenue();
            System.out.println("The total salary is : "+totalsalary[count]);//Displaying total salary
            count++;
            time();
            System.out.print('\f');
            Database();
            System.out.print('\f');

            break;
            case 2:Appointment();
            break;
            case 3:Bye();return;

        }

    }

    public void calculating_revenue()
    {
        if(n[count]>=1&&n[count]<=5)
        {
            revenue[count]=(5/100.0)*bsal;
        }
        else if(n[count]>=6&&n[count]<=10)
        {
            revenue[count]=(10/100.0)*bsal;
        }
        else if(n[count]>=11&&n[count]<=15)
        {
            revenue[count]=(15/100.0)*bsal;
        }
        else if(n[count]>15)
        {
            revenue[count]=(20/100.0)*bsal;
        }
        totalsalary[count]=bsal+revenue[count];
    }

    public void main()throws IOException
    {

        System.out.print("T");STIME();
        System.out.print("h");STIME();
        System.out.print("i");STIME();
        System.out.print("s");STIME();
        System.out.print(" ");STIME();
        System.out.print("I");STIME();
        System.out.print("s");STIME();
        System.out.print(" ");STIME();
        System.out.print("A");STIME();
        System.out.print(" ");STIME();
        System.out.print("P");STIME();
        System.out.print("r");STIME();
        System.out.print("o");STIME();
        System.out.print("j");STIME();
        System.out.print("e");STIME();
        System.out.print("c");STIME();
        System.out.print("t");STIME();
        System.out.print(" ");STIME();
        System.out.print("B");STIME();
        System.out.print("y");STIME();
        System.out.print(" ");STIME();
        System.out.print("A");STIME();
        System.out.print("k");STIME();
        System.out.print("s");STIME();
        System.out.print("h");STIME();
        System.out.print("i");STIME();
        System.out.print("t");STIME();
        System.out.print("a");STIME();
        System.out.print(" ");STIME();
        System.out.print("P");STIME();
        System.out.print("a");STIME();
        System.out.print("t");STIME();
        System.out.print("i");STIME();
        System.out.print("l");STIME();        
        System.out.print(".");time();
        System.out.print('\f');
        System.out.println("       Akshita Polyclinic                ");  
        System.out.println("             ____                     " ) ;
        System.out.println("            |    |                     " ) ;
        System.out.println("         ___|    |___                  " ) ;
        System.out.println("        |            |             " ) ;
        System.out.println("        |___     ____|                     " ) ;
        System.out.println("            |    |                   " ) ;
        System.out.println("            |____|                      " ) ;
        System.out.println("     Saving Lives Since 1947.                          " ) ;
        System.out.println(" " ) ;

        time();
        System.out.print('\f');

        mainMenu();
    }

    public void mainMenu()throws IOException
    {
        mainMenu:
        while(true)
        {
            do
            {
                try
                {
                    System.out.print("W");STIME();
                    System.out.print("e");STIME();
                    System.out.print("l");STIME();
                    System.out.print("c");STIME();
                    System.out.print("o");STIME();
                    System.out.print("m");STIME();
                    System.out.print("e");STIME();
                    System.out.print(" ");STIME();
                    System.out.print("T");STIME();
                    System.out.print("O");STIME();
                    System.out.print(" ");STIME();
                    System.out.print("A");STIME();
                    System.out.print("k");STIME();
                    System.out.print("s");STIME();
                    System.out.print("h");STIME();
                    System.out.print("i");STIME();
                    System.out.print("t");STIME();
                    System.out.print("a");STIME();
                    System.out.print(" ");STIME();
                    System.out.print("P");STIME();
                    System.out.print("o");STIME();
                    System.out.print("l");STIME();
                    System.out.print("y");STIME();
                    System.out.print("c");STIME();
                    System.out.print("l");STIME();
                    System.out.print("i");STIME();
                    System.out.print("n");STIME();
                    System.out.print("i");STIME();
                    System.out.print("c");STIME();
                    System.out.print(".");

                    System.out.println("\n1.To Enter The Polyclinic");
                    System.out.println("2.To Go Home");
                    choice=Integer.parseInt(buf.readLine());
                }
                catch(NumberFormatException obj)
                {
                    System.out.println("Please enter digits only(1 or 2)");
                    continue;
                }

                break;
            }while(true);

            switch(choice)
            {
                case 1:
                doctorMenu();
                break;
                case 2:
                Bye();
                System.exit(0);
                default:
                System.out.println("Please enter a valid choice...");

            }

            Would();

        }
    }//end of mainMenu()
    public void doctorMenu()throws IOException
    {
        int p=0;  
        System.out.print('\f');  
        Calendar time = new GregorianCalendar();
        Calendar ca1 = Calendar.getInstance();
        GregorianCalendar date = new GregorianCalendar();   
        day = date.get(Calendar.DAY_OF_MONTH); 
        month = date.get(Calendar.MONTH); 
        year = date.get(Calendar.YEAR);   
        second = date.get(Calendar.SECOND); 
        minute = date.get(Calendar.MINUTE); 
        hour = date.get(Calendar.HOUR);  
        int DOW = time.get(GregorianCalendar.DAY_OF_WEEK);
        String dayofw = "";
        ca1.set(year, month, day);
        java.util.Date d = new java.util.Date(ca1.getTimeInMillis());
        int am_pm = time.get(GregorianCalendar.AM_PM);
        switch(DOW){ //switch statement to translate numeric value of DOW to string value
            case 1: dayofw = "Sunday";
            break;
            case 2: dayofw = "Monday";
            break;
            case 3: dayofw = "Tuesday";
            break;
            case 4: dayofw = "Wednesday";
            break;
            case 5: dayofw = "Thursday";
            break;
            case 6: dayofw = "Friday";
            break;
            case 7: dayofw = "Saturday";
            break;

        }
        if (hour == 0){
            hour = 12;
        }
        System.out.println("Today is a " + dayofw);
        if(day==1)
            System.out.println("Current date is "+day+"st "+new SimpleDateFormat("MMMM").format(d)+","+year);
        else if(day==2)
            System.out.println("Current date is "+day+"nd "+new SimpleDateFormat("MMMM").format(d)+","+year);
        else if(day==3)
            System.out.println("Current date is "+day+"rd "+new SimpleDateFormat("MMMM").format(d)+","+year);
        else
            System.out.println("Current date is "+day+"th "+new SimpleDateFormat("MMMM").format(d)+","+year); 

        switch (am_pm) {
            case  Calendar.AM:
            System.out.println("Time Of Logging In is "+hour+" : "+minute+" : "+second + " A.M");
            break;
            default:
            System.out.println("Time Of Logging In is "+hour+" : "+minute+" : "+second + " P.M");
            break;

        } 
        System.out.println("*******************       Akshita Polyclinic           *****************");
        System.out.println("*******************  Welcome To Akshita Polyclinic     *****************");
        System.out.println("*******************       ENJOY YOUR VISIT           *****************");
        doctorMenu:
        do
        {System.out.println("Enter 1 to accept the details of the doctor or fix an appointment with a Doctor");
            System.out.println("Enter 2 to arrange the doctors as per their final salary in ascending order ");
            System.out.println("Enter 3 to arrange the doctors as per their name in lexicographical manner ");
            System.out.println("Enter 4 to find the maximum and minimum salaries ");
            System.out.println("Enter 5 to find the salary of a particular doctor by searching for his name ");
            System.out.println("Enter 0 to go back to main menu And any other key to exit. ");
            while (true)  
            {
                try
                {
                    p = Integer.parseInt(buf.readLine());
                    if (p<0)  return;
                    System.out.println ('\f');break;

                }
                catch(NumberFormatException e )
                {
                    return;
                }
            }
            Loading();
            switch(p)
            {

                case 1: accept();break;
                case 2: Ascend();
                break;
                case 3: Lexico(); break;
                case 4: MaxMin(); break;
                case 5: Search(); break; 
                case 0:mainMenu();break ;
                default:return;
            }
            while(true)
            {
                System.out.println("Would you like to see Doctor Menu again...(Y/N).. ");
                char kch=buf.readLine().charAt(0);
                if(kch=='Y' || kch=='y')
                    continue doctorMenu;
                else if(kch=='N' || kch=='n')
                {Bye() ;return; }
                else
                    continue;
            }
        }
        while(true);
    }

    public void time()
    {
        for(double i=0;i<1000000000;i++)
        {
            ;
        }
    }

    public void Ascend()throws IOException
    {
        Loading();
        double t=0;
        String temp="";
        String temp1="";
        for(int i=1;i<count;i++)
        {
            for(int j=1;j<count-1-i;j++)
            {
                if(totalsalary[j]>totalsalary[j+1])
                {
                    temp=name[j];
                    name[j]=name[j+1];
                    name[j+1]=temp;
                    temp1=n_space[j];
                    n_space[j]=n_space[j+1];
                    n_space[j+1]=temp1;
                    t=totalsalary[j];
                    totalsalary[j]=totalsalary[j+1];
                    totalsalary[j+1]=t;
                }
            }
        }
        System.out.println("The salary in ascending order is : ");
        System.out.println("Name\t\t\t\t\t\t\tTotal Salary");
        for(int i=0;i<count;i++)
        {
            if(name[i]!=null)
                System.out.println(name[i]+"\t\t\t\t\t\t\t"+totalsalary[i]);
        }
        System.out.println();
        time();

    }

    public void Lexico()throws IOException
    {
        Loading();
        int m=0;
        String temp="";
        String temp1="";
        double t=0;
        for(int i=1;i<count-1;i++)
        {
            for(int j=1;j<count-1-i;j++)
            {
                m=name[j].compareTo(name[j+1]);
                if(m>0)
                {
                    temp=name[j];
                    name[j]=name[j+1];
                    name[j+1]=temp;
                    temp1=n_space[j];
                    n_space[j]=n_space[j+1];
                    n_space[j+1]=temp1;
                    t=totalsalary[j];
                    totalsalary[j]=totalsalary[j+1];
                    totalsalary[j+1]=t;
                }
            }
        }
        System.out.println("The names arranged lexicographically in ascending order are : ");
        System.out.println("Name\t\t\t\t\t\t\t\tTotal Salary ");
        for(int i=0;i<count;i++)
        {
            System.out.println(name[i]+"\t\t\t\t\t\t\t"+totalsalary[i]);
        }
        System.out.println();
        time();
    }

    public void MaxMin()throws IOException
    {  
        Loading(); 
        double min=0,max=0;
        String maxx="",minn="";
        for(int i=1;i<count;i++)
        {
            if(max<totalsalary[i])
            {
                max=totalsalary[i];

            }
        }
        min=max;
        for(int i=1;i<count;i++)
        {
            if(min>totalsalary[i])
            {
                min=totalsalary[i];

            }
        }

        System.out.println("DOCTORS WITH THE MAXIMUM SALARY OF "+max);
        for(int i=1;i<count;i++)
        {
            if(max==totalsalary[i])
            {
                System.out.println(name[i]);

            }
        }

        System.out.println("DOCTORS WITH THE MINIMUM SALARY OF "+min);
        for(int i=0;i<count;i++)
        {
            if(min==totalsalary[i])
            {
                System.out.println(name[i]);

            }
        }

        System.out.println();
        time();
    }

    public void Search()throws IOException  
    {

        Loading();
        boolean flag=false;        int i=0;
        String nm="";
        //Checking for name validity
        nameLoop:
        do
        {
            System.out.println("Enter the name of the doctor whose salary is to be displayed ");
            nm=buf.readLine();

            if(nm.trim().length()==0)   continue;
            for(int k=0;k<nm.length();k++)
            {
                char ch1=nm.charAt(k);
                if(Character.isLetter(ch1)|| ch1== ' ')
                    continue;
                else
                {
                    System.out.println("Please enter a valid name....");
                    continue nameLoop;
                }
            }
            break;
        }while(true); 

        for( i=0;i<count;i++)
        {
            if(name[i].equalsIgnoreCase(nm))
            {
                flag=true;
                break;
            }
        }
        searching();
        time();
        System.out.println();
        if(flag==true)
        {
            System.out.println("Name         Salary");
            System.out.println(name[i]+"           "+totalsalary[i]);
        }
        else if(flag==false)
        {
            System.out.println("Name not found");
        }

        time();

    }

    public void searching()
    {
        System.out.print("Searching.");
        time();
        System.out.print(".");
        time();
        System.out.print(".");
        time();
        System.out.print(".");
    }

    public void Loading()
    {
        System.out.println ('\f');
        System.out.print("Loading ");int k = 0;
        for (int n=0 ; true ; n++)
        {
            if (n%99999999==0){System.out.print(" . "); k++;}
            if(k%6==0) break;
        }
        System.out.println ('\f');
    }

    public void Bye()throws IOException
    {
        System.out.println ('\f');
        Calendar time = new GregorianCalendar();
        Calendar ca1 = Calendar.getInstance();
        GregorianCalendar date = new GregorianCalendar();   
        day = date.get(Calendar.DAY_OF_MONTH); 
        month = date.get(Calendar.MONTH); 
        year = date.get(Calendar.YEAR);   
        second = date.get(Calendar.SECOND); 
        minute = date.get(Calendar.MINUTE); 
        hour = date.get(Calendar.HOUR);  
        ca1.set(year, month, day);
        java.util.Date d = new java.util.Date(ca1.getTimeInMillis());
        int am_pm = time.get(GregorianCalendar.AM_PM);
        switch (am_pm) {
            case  Calendar.AM:
            System.out.println("Time Of Logging Out is "+hour+" : "+minute+" : "+second + " A.M");
            break;
            default:
            System.out.println("Time Of Logging Out is "+hour+" : "+minute+" : "+second + " P.M");
            break;

        } 
        System.out.println ();
        System.out.println ();
        System.out.println ();
        System.out.println ();
        System.out.println ();
        System.out.println ("Thank You For Your Precious Time");
        System.out.println ();
        System.out.println ("Hope You Give Us Another Chance To Service You Again");
        System.out.println ();
        System.out.println (" Bye! Be Healthy!");
        System.exit(0);
    }

    public void Appointment()throws IOException
    {
        System.out.println ('\f');
        Calendar ca1 = Calendar.getInstance();
        GregorianCalendar date = new GregorianCalendar();   
        day = date.get(Calendar.DAY_OF_MONTH); 
        month = date.get(Calendar.MONTH); 
        year = date.get(Calendar.YEAR);   
        second = date.get(Calendar.SECOND); 
        minute = date.get(Calendar.MINUTE); 
        hour = date.get(Calendar.HOUR);  int h = hour +3;
        String S;int x;int c=0; int kas=0;

        do

        {

            System.out.println("Enter the department of the doctor:");

            for(int i=0;i<dept.length;i++)

            {

                System.out.println(i+1+". "+dept[i]);

            }

            try

            {

                System.out.println("Enter Your choice");

                x=Integer.parseInt(buf.readLine());

            }

            catch(NumberFormatException obj)

            {

                System.out.println("Please enter digits only...");

                continue;

            }

            if(x>=1 && x<=dept.length)

            {

                S = dept[x-1];

                break;
            }
            System.out.println("Enter a valid digit from 1 to "+ dept.length);

        }while(true); 
        System.out.println('\f');

        Ab:

        for (int i =0 ; i<= 24 ; i ++)
        {  

            if(DEP[i] .equalsIgnoreCase(S)) 

            {

                System.out.println("Name = " + name[i]) ;
                System.out.println("Department = "+DEP[i]);
                System.out.println("Qualification = "+ qualification[i]);
                kas++;
                int qq;
                System.out.println("Enter 1 To Fix Appointment , 2 For Next Doctor , 3 to Go To Main");
                while (true)
                {
                    try
                    {
                        qq = Integer.parseInt(buf.readLine());
                        if (qq>3&& qq<1){System.out.println("Wrong Input");continue;}
                        break;
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("Wrong Input");
                    }
                }
                if (qq==1)
                {
                    System.out.println ("Time Slots Available are:-");
                    System.out.println ("Enter 1 for "+h+ ":00 hours ");
                    System.out.println ("Enter 2 for "+(h+1)+ ":00 hours ");
                    System.out.println ("Enter 3 for "+(h+2)+ ":00 hours ");
                    System.out.println ("Enter 4 for his/her Phone Number");
                    System.out.println ("Enter 0 to go back to list of doctors");
                    int pp = Integer.parseInt(buf.readLine());c++;
                    if(pp==1) System.out.println("Appointment Fixed at "+h+":00 hours");
                    if(pp==2) System.out.println("Appointment Fixed at "+(h+1)+":00 hours");
                    if(pp==3) System.out.println("Appointment Fixed at "+(h+2)+":00 hours");
                    if(pp==4) System.out.println("Phone Number Is "+phone_no[i]);
                    if(pp==0)  continue;

                }
                else if (qq==2)
                {
                    System.out.println ('\f');
                }
                else if(qq==3) 
                {
                    doctorMenu();
                }
                else
                {
                    System.out.println("Wrong Input");
                    continue Ab;
                }
            }

            if (c>0) break ;

            if(i==23&&kas==0) {System.out.println("NO DOCTOR"); }if(i==23&&kas!=0){i=0;System.out.println("NO MORE DOCTORS . DISPLAYING DOCTORS AGAIN.");}

        }
    }

    Polyclinic()throws IOException
    {

        bsal=30000;

        slno[6]=1;
        name[6]="Shraddha Kapoor";
        DEP[6]="Medicine";
        phone_no[6]="9767721286";
        qualification[0]="MBBS,MD Medicine";
        n[6]=2;
        revenue[6]=1500;
        totalsalary[6]=31500;

        slno[1]=2;
        name[1]="Ranbir Kapoor";
        DEP[1]="Pediatrics";
        phone_no[1]="986751222";
        qualification[1]="MBBS,MD Pediatrics";
        n[1]=2;
        revenue[1]=1500;
        totalsalary[1]=31500;

        slno[2]=3;
        name[2]="David Villa";
        DEP[2]="Obstetrics & Gynaecology";
        phone_no[2]="9999512345";
        qualification[2]="MBBS,MD Gynaecology";
        n[2]=2;
        revenue[2]=1500;
        totalsalary[2]=31500;
        count=3;

        slno[3]=4;
        name[3]="Alia Bhatt";
        DEP[3]="Ophthalmology";
        phone_no[3]="9967654705";
        qualification[3]="MBBS,MD Ophthalmology";
        n[3]=3;
        revenue[3]=1500;
        totalsalary[3]=31500;
        count=4;

        slno[4]=5;
        name[4]="Ravindra Shenoy";
        DEP[4]="Anesthesiology";
        phone_no[4]="9967651701";
        qualification[4]="MBBS,MD Anesthesiology";
        n[4]=2;
        revenue[4]=1500;
        totalsalary[4]=31500;
        count=5;

        slno[5]=6;
        name[5]="Wasim Akram";
        DEP[5]="Dentist";
        phone_no[5]="9967653282";
        qualification[5]="MBBS,MD Dentist";
        n[5]=2;
        revenue[5]=1500;
        totalsalary[5]=31500;
        count=7;
        main();
    }

    public void Database()
    {
        System.out.println ('\f');
        System.out.print("Storing details in the database. ");int k = 0;
        for (int n=0 ; true ; n++)
        {
            if (n%99999999==0){System.out.print(" . "); k++;}
            if(k%6==0) break;
        }
        System.out.println ('\f');
    }

    public void STIME()
    {
        int k = 0 ;
        for (int i = 0 ; i<=10000000;i++)
        {
            if (i%10000000==0)k++;if(k==99)break;
        };
    }

    public void Would()throws IOException
    {

        for(;true;)
        {
            System.out.println("Would you like to continue? ");
            System.out.println("Enter yes or no");
            String s=buf.readLine();

            if(s.toLowerCase().equals("no"))
            {
                System.out.print('\f');
                Bye();
                time();
                System.exit(0);

            }
            else if(s.toLowerCase().equals("yes"))
            {    
                break;
            }
            else
            {
                System.out.println("Wrong choice \nEnter again");
                continue;
            }
        }

    }
}