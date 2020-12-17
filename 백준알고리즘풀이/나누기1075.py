
if __name__ == '__main__':
    n = int(input())
    f = int(input())

    n = int(n/100) * 100
    i=0

    while i<100:
        if((n+i)%f==0):
            break
        i+=1


    if i < 10:
        print('0'+str(i))
    else:
        print(i)
