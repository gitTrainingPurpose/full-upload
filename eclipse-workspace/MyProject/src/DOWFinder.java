/*Exercise  - Java Syntax
Find the day of the week of a given date

Create a class DOWFinder and Implement a Java-method called findDOW(int day,int month,int year)that prints out the day of the week for a given day (1..31), month (1..12) and year.

The day of the week of dates between March 1900 and February 2100 can be calculated as follows:

First, you have to calculate the total number of days from 1900/1/1 to the given date (see below, for details). Secondly, you divide this number by 7 with integer remainder: this now is the day of the week, with 0 as sunday, 1 as monday, etc.

To calculate the total number of days you have to implement the following steps:

Subtract 1900 from the given year and multiply the result by 365
Add the missing leaps years by adding (year - 1900) / 4.
If the year itself is a leap year and the month is January or February, you have to subtract 1 from the previous result.
Now add the all days of the year up to the given one to the result (in case of february always 28, because the additional day for a leap year already have been added).
*/


public class DOWFinder {
	
	public void findDOW( int day, int month, int year) {
		int days = (year-1900)*365;
		days+=(year-1900)/4;
		if(year%4==0 && (month <=2))
			days-=1;
		int [] monthArr = {31,28,31,30,31,30,31,31,30,31,30,31};
		for (int i = 0; i < month-1; i++) {
			days+=monthArr[i];
		}
		if(year>2000) {
			days-=(year-2000)/100;			
			days+=(year-2000)/400;
		}
		if(month<=2 && year%400!=0 && year%100 == 0) {
			days+=1;
		}
		else if(month<=2 && year%400==0) {
			days-=1;
		}
		days+=day;
		days=days%7;
		switch (days) {
		case 0:
			System.out.println("Sunday");
			break;
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		default:
			break;
		}
		return;
	}



}
