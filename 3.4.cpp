#include <iostream>
using namespace std;
#include <string.h>
class Customer{
    string name;
    int acc_no;
    string acc_type;
    double balance=0;
    public:
    Customer(string nam){
        name=nam;
    }
    void get(){
       cout<<"enter account number:";
       cin>>acc_no;
       cout<<"enter account type:";
       cin>>acc_type;
    }
    
    void deposit(int x){
        balance=balance+x;
        cout<<"deposited"<<x<<"sucessfully"<<endl;
    }
    
    void withdraw(int x){
        if(balance>x){
            balance=balance-x;
            cout<<"balance remained:"<<balance<<endl;
        }
        else{
            cout<<"transaction failed"<<endl;
        }

    }

    void show(){
            cout<<"name:"<<name<<endl;
            cout<<"accountno:"<<acc_no<<endl;
            cout<<"account type:"<<acc_type<<endl;
    }
    
};

int main(){
Customer emp1("ram");
emp1.get();
emp1.show();
Customer emp2("vaz");
emp2.get();
emp2.show();


}