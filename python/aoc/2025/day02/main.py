def calculate(filename, invalidityFn):
    with open(filename, 'r') as f:
        input = f.read()
    print(input)
    ranges = input.split(',')
    print('ranges count:', len(ranges))

    result = 0
    for r in ranges:
        result += invalidityIndex(r.split('-'), invalidityFn)
    print('result', result)


def invalidityIndex(r, invalidityFn):
    low = int(r[0])
    high = int(r[1])
    res = 0
    for x in range(low, high + 1):
        res += invalidityFn(x)
    return res


def numberInvalidityIndexPart1(n):
    s = str(n)
    if not len(s) % 2 == 0:
        return 0
    half = s[0:len(s)//2]
    return int(s) if s == half + half else 0


def numberInvalidityIndexPart2(n):
    s = str(n)
    maxPortionLength = len(s) // 2
    for l in range(1, maxPortionLength + 1):
        portion = s[0:l]
        r = s.replace(portion, '')
        if len(r) == 0:
            return int(s)
    return 0


if __name__ == "__main__":
    filename = 'input2.txt'

    print('Part1 solution:')
    calculate(filename, numberInvalidityIndexPart1)

    print()
    print('Part2 solution:')
    calculate(filename, numberInvalidityIndexPart2)
