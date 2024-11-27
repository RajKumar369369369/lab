#include<bits/stdc++.h>
using namespace std;
class Class_2;
class Class_1{
    private:
    int a;
    public:
    Class_1(int a){
        cout<<"class1 constructor"<<endl;
        this->a=a;
    }
    inline void display() const{
        cout<<"value in class1 is "<<a<<endl;
    }
    friend void exchange(Class_1 &obj1,Class_2 &obj2);
};
class Class_2{
    private:
    int b;
    public:
    Class_2(int b){
        cout<<"class2 constructor"<<endl;
        this->b=b;
    }
    inline void display() const{
        cout<<"value in class2 is "<<b<<endl;
    }
    friend void exchange(Class_1 &obj1,Class_2 &obj2);
};
void exchange(Class_1 &obj1,Class_2 &obj2){
    swap(obj1.a,obj2.b);
}
int main(){
    Class_1 obj1(10);
    Class_2 obj2(20);
    obj1.display();
    obj2.display();
    exchange(obj1,obj2);
    obj1.display();
    obj2.display();
return 0;
}