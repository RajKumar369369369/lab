#include<bits/stdc++.h>
using namespace std;
    class Employee{
        private:
        long long id;
        string name;
        int age;
        public:
        Employee(long long id,string name,int age){
            this->id=id;
            this->name=name;
            this->age=age;
        }
        ~Employee(){
            cout<<"employee deconstructor"<<endl;
        }
        void print(){
            cout<<"ID : "<<id<<endl;
            cout<<"Name : "<<name<<endl;
            cout<<"Age : "<<id<<endl;
        }
        long long get_ID(){
            return id;
        }
    };
int main(){
    int n;
    cout<<"enter the number of employees gto be registerd"<<endl;
    cin>>n;
    vector<Employee*> employee(n);
    for(int i=0;i<n;i++){
        long long id;
        string name;
        int age;
        cout<<"enter id"<<endl;
        cin>>id;
        cout<<"enter name"<<endl;
        cin>>name;
        cout<<"enter age"<<endl;
        cin>>age;
        employee[i]=new Employee(id,name,age);
    }
    long long search_id;
    cout<<"enter the id to be searched"<<endl;
    cin>>search_id;
    bool found=false;
    for(int i=0;i<n;i++){
        if(employee[i]->get_ID()==search_id){
            employee[i]->print();
            found=true;
            break;
        }
    }
    if(found==false){
        cout<<"There is no such employee with that employee id"<<endl;
    }
    for(int i=0;i<n;i++) delete employee[i];
return 0;
}