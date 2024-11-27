#include <iostream>
using namespace std;

class Bank {
private:
    string name;
    int accno;
    double balance;
public:
    Bank() {
        name=" ";
        accno=0;
        balance=0;
    }
    Bank(string name, int accno, double balance) {
        this->name=name;
        this->accno=accno;
        this->balance = balance;
    }
    Bank(const Bank &B) {
        this->name = B.name;
        this->accno = B.accno;
        this->balance = B.balance;
    }
    void Balance() const {
        cout<<"current balance is "<<balance<<endl;
    }
    void deposit(double amount) {
        balance += amount;
        cout<<"current balance is "<<balance<<endl;
    }
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            cout<<"current balance is "<<balance<<endl;
        } else {
            cout<<"insufficient balance" <<endl;
        }
    }
    void print() const {
        cout<<"Name "<<name<<endl;
        cout<<"Account number"<<accno<<endl;
        cout<<"Balance"<<balance<<endl;
    }
};

int main() {
    Bank customer1;
    Bank customer2("Rahul", 123456, 1000);
    customer2.deposit(500);
    customer2.withdraw(200);
    Bank customer3(customer2);
    customer3.print();
    return 0;
}
