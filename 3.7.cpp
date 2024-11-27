#include <iostream>
using namespace std;
#include <cmath>
class Cuboid{
    int l,b,h;
    public:
    Cuboid(int x,int y,int z){
        l=x;
        b=y;
        h=z;
    }
    void Area(){
        double a=2*(l*b+b*h+h*l);
        cout<<"Surface area is:"<<a;
    }
    friend class Cube;
};
class Cube{
    double a;
    public:
    Cube(Cuboid &c){
        a = pow((c.l)*(c.b)*(c.h),1/3);
    }
    void get(){
        cout<<"length of cube is:"<<a;
    }
    

};
int main(){
Cuboid c(1,2,3);
c.Area();
Cube b(c);
b.get();

}
