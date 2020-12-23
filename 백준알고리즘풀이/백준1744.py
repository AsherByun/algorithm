def cycle(origin):
    origin_a = 0
    origin_b = 0
    if origin<10:
        origin_b = origin
    else:
        origin_a = origin // 10
        origin_b = origin % 10

    sum = (origin_a + origin_b) % 10
    new_num = origin_b * 10 + sum
    return new_num

if __name__ == '__main__':
    num = int(input())
    cnt = 0
    num_ = num
    while True:
        num = cycle(num)
        cnt+=1
        if num_ == num:
            break


    print(cnt)
