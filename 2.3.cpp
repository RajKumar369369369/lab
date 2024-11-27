#include <iostream>
using namespace std;

class Data {
private:
    int day, month, year;
public:
    Data() {
        this->day = 12;
        this->month = 3;
        this->year = 1993;
    }

    Data(int day, int month, int year) {
        this->day = day;
        this->month = month;
        this->year = year;
    }
    Data(const Data &D) {
        this->day = D.day;
        this->month = D.month;
        this->year = D.year;
    }
    ~Data() {
        cout <<"destructor"<< endl;
    }
    void print() {
        cout <<"Date is"<<day<<"-"<<month<<"-"<<year<<endl;
    }
};

int main() {
    Data D1;
    D1.print();
    Data D2(22,1,2007);
    Data D3(20,4,2005);
    D2.print();
    D3.print();
    Data D4(D2);
    D4.print();
    return 0;
}
