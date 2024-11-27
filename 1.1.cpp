#include <iostream>
struct mystruct{
    int weight=0;
    double price=0;
    double extra=0;
};
int main(){
int a;    
std::cout<<"enter the weight of letters in gms:";
std::cin>>a;
if(a>400){
    double b=a/1000;
    std::cout<<"price is"<<b*25;
}
else{
    mystruct s1,s2,s3;
    if(a<=50){
         s1.weight=a;
         s1.price=0.05;
    }
    else if(a>50 && a<=150){
        s1.weight=a-50;
        s1.price=0.04;
        s1.extra=2.5;
    }
    else if(a>150 && a<=400){
        s1.weight=a-150;
        s1.price=0.025;
        s1.extra=6.5;
    }
    else{
        s1.weight=a-400;
        s1.price=0.025;
        s1.extra=12.75;
    }
    std::cout<<"the price is"<<s1.weight*s1.price+s1.extra;
    }

}
