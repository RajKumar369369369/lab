#include <iostream>
using namespace std;
class Class2;
class Class1{
int num;
friend void mean(Class1 &a,Class2 &b);
public:
Class1(int x){
num=x;
}
};

class Class2{
int num;
friend void mean(Class1 &a,Class2 &b);
public:
Class2(int x){
num=x;
}
};
void mean(Class1 &a,Class2 &b){
    cout<<"mean is"<<(a.num+b.num)/2;
}
int main(){
Class1 c(6);
Class2 b(7);
mean(c,b);
}