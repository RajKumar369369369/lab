#include <iostream>
using namespace std;
class Fr {
    int num;
    int den;

public:
    Fr(int a, int b) {
        num = a;
        den = b;
    }
    int getNum() const {
        return num;
    }
    int getDen() const {
        return den;
    }
};

int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

int lcm(int a,int b) {
    return (a/gcd(a,b))*b;
}

void add(Fr fr1,Fr fr2) {
    int Den = lcm(fr1.getDen(),fr2.getDen());
    int Num = (Den/fr1.getDen())*fr1.getNum() +
                       (Den/fr2.getDen())*fr2.getNum();

    cout <<"The sum is:"<<Num<<"/"<<Den<<endl;
}
  
void subtract(const Fr& fr1,const Fr& fr2){
    int Den = lcm((fr1).getDen(),(fr2).getDen());

    int Num = (Den/fr1.getDen())* fr1.getNum() -
                       (Den/fr2.getDen())*fr2.getNum();

    cout <<"The difference is:"<<Num<<"/"<<Den<<endl;
}
 void multiply(const Fr* fr1,const Fr* fr2){
     int Num=(fr1->getNum())*(fr2->getNum());
     int Den=(fr1->getDen())*(fr2->getDen());
     cout <<"The product is:"<<Num << "/"<<Den<<endl;
 }
int main() {
    int a,b;
    cout<<"Enter numerator and denominator  respectively: ";
    cin >> a >> b;
    Fr fr1(a, b);
    cout<<"Enter numerator and denominator respectively: ";
    cin>>a >>b;
    Fr fr2(a,b);
    add(fr1,fr2);
    subtract(fr1,fr2);
    multiply(&fr1,&fr2);

    return 0;
}