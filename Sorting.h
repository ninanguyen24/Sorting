/*Nina Nguyen
CSC 212
May 28, 2017
Program 4*/

#ifndef SORTING_H
#define SORTING_H

#include <iostream>
#include <string>

using namespace std;

class UCASEstring : public string {
public:
	UCASEstring();
	UCASEstring(const string& str);
	UCASEstring(const char* s);
	UCASEstring(UCASEstring&);


	bool operator<(UCASEstring&);
	bool operator<=(UCASEstring&);
	bool operator>(UCASEstring&);
	bool operator>=(UCASEstring&);
	bool operator==(UCASEstring&);
	
};

string upperCase(UCASEstring);

UCASEstring::UCASEstring(): string() {

}


UCASEstring::UCASEstring(const string& str): string(str) {
	
}

UCASEstring::UCASEstring(const char* s) : string(s) {

}

UCASEstring::UCASEstring(UCASEstring& s): string(s.data()){
	
}

bool UCASEstring::operator<(UCASEstring& s) {
	return upperCase(*this) < upperCase(s);
}

bool UCASEstring::operator<=(UCASEstring& s) {
	return upperCase(*this) <= upperCase(s);
}

bool UCASEstring::operator>(UCASEstring& s) {
	return upperCase(*this) > upperCase(s);
}

bool UCASEstring::operator>=(UCASEstring& s) {
	return upperCase(*this) >= upperCase(s);
}

bool UCASEstring::operator==(UCASEstring& s) {
	return upperCase(*this) == upperCase(s);
}

string upperCase(UCASEstring s) {
	for (int i = 0; i < s.length(); i++) {
		s[i] = toupper(s[i]);
	} 
	return s.data();//Print out data
}

//Method to sort 
template<typename T>
void sort(T s[], int arraySize) {
	for (int i = 0; i < arraySize; i++) {
		//Find the minimum in the list
		T currentMin = s[i];
		int currentMinIndex = i;

		for (int j = i + 1; j < arraySize; j++) {
			if (currentMin > s[j]) {
				currentMin = s[j];
				currentMinIndex = j;
			}
		}

		//Swap s[i] with s[currentMinIndex] if necessary.
		if (currentMinIndex != i) {
			s[currentMinIndex] = s[i];
			s[i] = currentMin;
		}
	}
}

//method to print out array
template<typename T>
void printArray(T s[], int arraySize) {
	for (int i = 0; i < arraySize; i++) {
		cout << s[i] << " ";
	}
	cout << endl;
}

#endif