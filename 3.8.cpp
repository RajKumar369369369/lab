#include <iostream>
using namespace std;
class Class2;
class Class1{
    int num1;
    public:
    Class1(int x){
    num1=x;
    }
    void get(){
        cout<<num1<<","<<endl;

    }
    friend void exchange(Class1* a,Class2* b);
};
class Class2{
    int num2;
    public:
    Class2(int x){
    num2=x;
    }
    void get(){
        cout<<num2<<","<<endl;

    }
    friend void exchange(Class1* a,Class2* b);
};
void exchange(Class1* a,Class2* b){
    int c=a->num1;
    a->num1=b->num2;
    b->num2=c;

}
int main(){
Class1 a(5);
Class2 b(6);
cout<<"numbers before:";
exchange(&a,&b);
cout<<"numbers after:";
a.get();
b.get();
}