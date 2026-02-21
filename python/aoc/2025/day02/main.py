def part1(filename):
    with open(filename, 'r') as f:
        input = f.read()
    print(input)
    ranges = input.split(',')
    print('ranges count:', len(ranges))

    result = 0
    for r in ranges:
        result += invalidCount(r.split('-'))

    print('result', result)


def part2(filename):
    with open(filename, 'r') as f:
        input = f.read()
    print(input)
    ranges = input.split(',')
    print('ranges count:', len(ranges))

    result = 0
    for r in ranges:
        result += invalidCountPart2(r.split('-'))

    print('result', result)


def invalidity(n):
    s = str(n)
    if not len(s) % 2 == 0:
        return 0
    half = s[0:len(s)//2]
    return int(s) if s == half + half else 0


def invalidityPart2(n):
    s = str(n)
    maxPortionLength = len(s) // 2
    for l in range(1, maxPortionLength + 1):
        portion = s[0:l]
        r = s.replace(portion, '')
        if len(r) == 0:
            return int(s)
    return 0


def invalidCount(r):
    low = int(r[0])
    high = int(r[1])
    res = 0
    for x in range(low, high + 1):
        res += invalidity(x)
    return res


def invalidCountPart2(r):
    low = int(r[0])
    high = int(r[1])
    res = 0
    for x in range(low, high + 1):
        res += invalidityPart2(x)
    return res


if __name__ == "__main__":
    filename = 'input2.txt'
    part1(filename)
    part2(filename)
