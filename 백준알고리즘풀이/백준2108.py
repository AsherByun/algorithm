import math
from collections import Counter


if __name__ == '__main__':
    n = int(input())

    list = []
    for _ in range(n):
        val = int(input())
        list.append(val)

    list.sort()
    count = dict(Counter(list)).items()
    count = sorted(count,key=lambda x:x[1],reverse=True)

    common = count[0][0]
    if len(count) >1:
        if count[0][1] == count[1][1]:
            common = count[1][0]

    print(round(sum(list)/len(list)))
    print(list[int(len(list)/2)])
    print(common)
    print(abs(list[len(list)-1]-list[0]))