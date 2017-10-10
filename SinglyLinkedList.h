/*
链表的建立和函数
*/
#include<iostream>
#include<stdio.h>
#include<math.h>
#include<string>
#include<list>
using namespace std;

//class List;
struct LinkNode{
	int data;
	LinkNode *link;
	LinkNode(LinkNode *ptr = NULL){
		link = ptr;
	}
	LinkNode(const int& item, LinkNode *ptr = NULL){
		data = item;
		link = ptr;
	}
};

class List {
public :
	List(){ first = new LinkNode; }
	List(const int& x){ first = new LinkNode(x); }
	void makeEmpty();
	int Length()const;
	LinkNode *Search(int x);
	LinkNode *Locate(int i);
	bool getData(int i, int& x);
	bool setData(int i, int& x);
	bool Insert(int i, int& x);
	bool Remove(int i, int& x);
	bool isEmpty()const;
	bool isFull()const;
	void Sort();
	void inputFront(int endTag);// 前插法
	void inputRear(int endTag);//后插法
	void output();

protected:
	LinkNode *first;
};

void List::makeEmpty(){
	LinkNode *q;
	while (first->link != NULL){
		q = first->link;
		first->link = q->link;
		delete q;
	}
};

int List::Length()const {
	int length = 0;
	LinkNode *q = first->link;
	while (q != NULL){
		length++;
		q = q->link;
	}
	return length;
}

//搜索值等于x的结点，如果不存在，返回NULL
LinkNode *List::Search(int x){
	LinkNode *p = first->link;
	while (p != NULL){
		if (p->data == x){
			break;
		}
		else{
			p = p->link;
		}
	}
	return p;
}

//返回表中第i个元素的地址
LinkNode *List::Locate(int i){
	if (i < 0) return NULL;
	int ind = 0;
	LinkNode *p = first;
	while (p != NULL){
		if (ind == i) break;
		else p = p->link;
	}
}

//取出链表中第i个元素的值
bool List::getData(int i, int& x){
	if (i <= 0) return NULL;
	LinkNode *p = Locate(i);
	if (p == NULL) return false;
	else{
		x = p->data;
		return true;
	}
}

//将x插入到第i个结点之后
bool List::Insert(int i, int& x){
	LinkNode *p = Locate(i);
	if (p == NULL) return false;
	LinkNode *newNode = new LinkNode(x);
	if (newNode == NULL) {
		cerr << "内存分配错误";
		exit(1);
	}
	newNode->link = p->link;
	p->link = newNode;
	return true;
};

//删去第i个元素，通过x返回该元素的值
bool List::Remove(int i, int &x){
	LinkNode *p = Locate(i - 1);
	if (p == NULL || p->link == NULL){
		return false;
	}
	LinkNode *del = p->link;
	p->link = del->link;
	x = del->data;
	delete del;
	return true;
}

void List::output(){
	LinkNode *p = first->link;
	while (p != NULL){
		cout << p->data << endl;
		p = p->link;
	}
}

//前插
void List::inputFront(int endTag){
	LinkNode *newNode; int val = 0;
	makeEmpty();
	cin >> val;
	while (val != endTag){
		newNode = new LinkNode(val);
		if (newNode == NULL){ cerr << "内存分配错误" << endl; exit(1); }
		newNode->link = first->link;
		first->link = newNode;
		cin >> val;
	}
}

//后插
void List::inputRear(int endTag){
	LinkNode *newNode, *last;
	int val = 0;
	cin >> val;
	while (val != endTag){
		newNode = new LinkNode(val);
		if (newNode == NULL){ cerr << "内存分配错误" << endl; exit(1); }
		last->link = newNode;
		last = newNode;
		cin >> val;
	}
}

int main(){}
