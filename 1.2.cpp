#include <iostream>
using namespace std;
struct mystruct{
    int count;
    int cost;
    double discount;
    double finprice(){
int price=count*cost;
return price*(1-discount);
    }
};
int main(){
    int m,n,p;
    double totprice;
    cout<<"enter no of miners,toasters,fans respectively:";
    cin>>m>>n>>p;
    mystruct miner,toaster,fan;
    miner.count=m;
    miner.cost=1500;
    miner.discount=0.05;
    toaster.count=n;
    toaster.cost=200;
    toaster.discount=0.01;
    fan.count=p;
    fan.cost=450;
    fan.discount=0.15;
 totprice=1.1*(miner.finprice()+toaster.finprice()+fan.finprice());
    cout<<"final price is:"<<totprice;
}
