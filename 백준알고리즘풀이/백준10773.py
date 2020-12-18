
if __name__ == '__main__':
    n = int(input())

    list = []
    for i in range(n):
        value = int(input())

        if value == 0:
            list.pop()
        else:
            list.append(value)

    result = sum(list)
    print(result)