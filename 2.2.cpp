#include <iostream>
using namespace std;
class Date {
private:
    int date;
    int month;
    int year;
public:
    inline void display() const {
        cout << "Enter date(DD MM YY): ";
        std::cin>>date>>month>>year;
    }

    inline bool leap() const {
        if (year%100==0) {
            return (year%400==0);
        } else {
            return (year%4== 0);
        }
    }

    void due(int dueDays=15) const;
    static int daysInMonth(int month,bool isLeapYear) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear ? 29 : 28;
            default:
                return 31;
        }
    }
};

void Date::due(int dueDays) const {
    int daysInCurMonth = daysInMonth(month, leap());
    int dueDate = date + dueDays;
    int dueMonth = month;
    int dueYear = year;
    while (dueDate > daysInCurMonth) {
        dueDate -= daysInCurMonth;
        dueMonth++;

        if (dueMonth > 12) {
            dueMonth = 1;
            dueYear++;
        }

        daysInCurMonth = daysInMonth(dueMonth,(dueYear%4==0));
    }
    cout << "The due date is: " << (dueDate < 10 ? "0" : "") << dueDate << "-"
         << (dueMonth < 10 ? "0" : "") << dueMonth << "-" << dueYear << endl;
}

int main() {
    Date d;
    d.display();
    int dueDays;
    cout << "Enter the number of days after which the book is due: ";
    cin >> dueDays;
    d.due(dueDays);  
    return 0;
}