import re

input = 'xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))'


def domul_bysplit(input):
    pattern = r'mul\((\d*?\,\d*?)\)'
    muls = re.findall(pattern, input)
    result = 0
    for x in muls:
        print(x)
        parts = x.split(',')
        result += int(parts[0]) * int(parts[1])

    return result
    

def domul_bygroup(input):
    pattern = r'mul\((\d*?)\,(\d*?)\)'
    muls = re.findall(pattern, input)
    result = 0
    for x in muls:
        print(x)
        result += int(x[0]) * int(x[1])

    return result


def domul_withdos(input):
    input = 'do()' + input

    parts = input.split('do()')

    result = 0
    for part in parts:
        usefulPart = part
        if part.find("don't()") > -1:
            usefulPart = part[:part.find("don't()")]
        result += domul_bygroup(usefulPart)

    return result


def part1():
    with open('input1.txt', 'r') as f:
        input = f.read()

    # result = domul_bysplit(input)
    # print('result', result)
    result = domul_bygroup(input)
    print('result', result)


def part2():
    with open('input1.txt', 'r') as f:
        input = f.read()

    # result = domul_bysplit(input)
    result = domul_withdos(input)
    print('result', result)


if __name__ == "__main__":
    part1()
    part2()
