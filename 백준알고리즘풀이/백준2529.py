from sys import stdin

ans = list()
def find(sik,lst,idx):
    if len(sik) == n*2+1:
        if eval(sik):
            ans.append(list(lst))
        return
    sik += compare[idx]

    for num_ in nums:
        if check[num_]: continue

        check[num_] = True
        sik += str(num_)
        if eval(sik[len(sik)-3:len(sik)]):
            find(sik,lst+str(num_),idx+1)
        check[num_] = False
        sik = sik.replace(str(num_),'')


if __name__ == '__main__':
    n = int(stdin.readline())
    compare = list(stdin.readline().split())
    nums = [i for i in range(10)]
    check = [False] * 10

    for i in range(10):
        check[i] = True
        find(str(i),str(i),0)
        check[i] = False
    print(''.join(ans[len(ans)-1]))
    print(''.join(ans[0]))