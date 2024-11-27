#include <iostream>
using namespace std;
#include <string.h>
class Employee{
    string name;
    int earning;
    double bonus;
    public:
    Employee(string nam){
        name=nam;
    }
    void get(){
       cout<<"enter earning:";
       cin>>earning;
       return show();
    }
    double cal(){
        if( earning>=2000)
        return earning*0.1;
        else return 0;
    
    }
    void show(){
            cout<<"name:"<<name<<endl;
            cout<<"bonus:"<<cal()<<endl;
    }
    
};

int main(){
Employee emp1("ram");
emp1.get();
Employee emp2("vaz");
emp2.get();


}