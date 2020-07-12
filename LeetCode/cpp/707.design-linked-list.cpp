/*
 * @lc app=leetcode id=707 lang=cpp
 *
 * [707] Design Linked List
 */

class MyLinkedList
{
private:
    ListNode _dummyHead;
    int _size;

public:
    /** Initialize your data structure here. */
    MyLinkedList() : _size(0), _dummyHead(0)
    {
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    int get(int index)
    {
        if (index < 0 || index >= _size)
            return -1;

        ListNode *cur = _dummyHead.next;
        for (int i = 0; cur != nullptr && i < index; ++i)
            cur = cur->next;
        return cur != nullptr ? cur->val : 0;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    void addAtHead(int val)
    {
        ListNode *newHead = new ListNode(val);
        newHead->next = _dummyHead.next;
        _dummyHead.next = newHead;
        ++_size;
    }

    /** Append a node of value val to the last element of the linked list. */
    void addAtTail(int val)
    {
        ListNode *prev = &_dummyHead;
        for (; prev->next != nullptr; prev = prev->next)
            ;
        ListNode *newHead = new ListNode(val);
        prev->next = newHead;
        ++_size;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    void addAtIndex(int index, int val)
    {
        if (index == _size)
            addAtTail(val);
        else if (index >= _size)
            return;
        else
        {
            index=_size<0?index%(_size+1):index;
            ListNode *prev = &_dummyHead;
            for (int i = 0; i < index && prev != nullptr; ++i)
            {
                prev = prev->next;
            }

            ListNode *newHead = new ListNode(val);
            newHead->next=prev->next;
            prev->next = newHead;
            ++_size;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    void deleteAtIndex(int index)
    {
        if (index >= _size)
            return;
        else if (index < 0)
            return;
        else
        {
            ListNode *prev = &_dummyHead;
            for (int i = 0; i < index && prev != nullptr; ++i)
            {
                prev = prev->next;
            }

            ListNode *toBeDeleted = prev->next;
            prev->next = toBeDeleted->next;
            delete toBeDeleted;
            --_size;
        }
    }
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */
