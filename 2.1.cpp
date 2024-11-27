#include <iostream>

using namespace std;

class Store {
public:
    const int minerPrice = 1500;
    const int toasterPrice = 200;
    const int fanPrice = 450;
    static int numMiners;
    static int numToasters;
    static int numFans;
Store(int n=0,int m=0,int p=0) {
        numMiners=n;
        numToasters=m;
        numFans=p;
    }
void cost() const {
        double totalCost = 0.95*minerPrice*numMiners+0.9*toasterPrice*numToasters+0.85*fanPrice*numFans;
        cout <<"Total cost is:"<<1.1*totalCost<<endl;
    }
};


int Store::numMiners = 0;
int Store::numToasters = 0;
int Store::numFans = 0;

int main() {
int n,m,p;
cout << "Enter the number of miners, toasters, and fans respectively: ";
cin >> n>>m>>p;
Store store1(n,m,p);
store1.cost();
return 0;
}
