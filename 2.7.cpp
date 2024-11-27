#include <iostream>
using namespace std;

class ArrayMax {
private:
    int* arr;
    int size;

public:
    ArrayMax() {
        size = 0;
        arr = nullptr;
    }

    ArrayMax(int n) {
        size = n;
        arr = new int[size];
        cout << "Enter " << size << " elements: ";
        for (int i = 0; i < size; i++) {
            cin >> arr[i];
        }
    }

    int findMax() {
        if (size == 0) {
            return 0;
        } 
        int maxElement = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }
        return maxElement;
    }

    ~ArrayMax() {
        delete[] arr;
    }
};

int main() {
    int n;
    cout << "Enter the size: ";
    cin >> n;

    ArrayMax arrMax(n);
    cout << "The largest element is: " << arrMax.findMax() << endl;

    return 0;
}