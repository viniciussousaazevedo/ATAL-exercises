while True:
    work = 0
    if int(input()) == 0:
        break

    str_trades = input().split()
    trades = list()
    for trade in str_trades:
        trades.append(int(trade))

    for i in range(len(trades)-1):
        trades[i+1] += trades[i]
        work += abs(trades[i])
    print(work)

