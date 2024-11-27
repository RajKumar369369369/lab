#include <iostream>
#include<string>
struct publication{
    std::string title;
    int price;
    std::string authorname;
    void getDatd(){
        std::cout<<"enter tittle"<<std::endl;
        std::cin>>title;
        std::cout<<"enter price"<<std::endl;
        std::cin>>price;
        std::cout<<"enter authorname"<<std::endl;
        std::cin>>authorname;
    }
    void display(){
        std::cout<<"tittle is"<<title<<std::endl;
        std::cout<<"price is"<<price<<std::endl;
        std::cout<<"authorname is"<<authorname<<std::endl;
        
    }
};
int main(){
publication pu;
pu.getDatd();
pu.display();
return 0;
}