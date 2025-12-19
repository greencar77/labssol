
def part1():
    with open('input2.txt', 'r') as f:
        entries = f.read().splitlines()

    position = 50
    result = 0
    for e in entries:
        direction = e[0:1]
        count = int(e[1:])
        if direction == 'R':
            newPosition = (position + count) % 100
        else:
            newPosition = (position - count + 100) % 100
        if newPosition == 0:
            result += 1
        # print(str(position).rjust(7, ' '), e.ljust(5, " "), str(newPosition).rjust(7, ' '))
        position = newPosition

    print('Result', result)


def part2():
    with open('input2.txt', 'r') as f:
        entries = f.read().splitlines()

    position = 50
    result = 0
    for e in entries:
        oldResult = result
        direction = e[0:1]
        count = int(e[1:])

        if direction == 'R':
            newPosition = (position + count + 100) % 100
        else:
            newPosition = (position - count + 100) % 100

        fullCycles = count // 100
        remainder = count % 100
        if fullCycles > 0:
            if remainder == 0 and newPosition == 0:
                result += (fullCycles - 1) #'-1' - exclude zero which will be added further
            else:
                result += fullCycles

        if remainder > 0 and newPosition != 0:
            if direction == 'R' and position + remainder > 100: #'100' - exclude zero which will be added separately
                result += 1
            if direction == 'L' and position - remainder < 0 and position != 0:
                result += 1

        # zero landing itself
        if newPosition == 0:
            result += 1

        # if oldResult != result and result-oldResult > 1:
        # print(str(position).rjust(7, ' '), e.ljust(5, " "), str(newPosition).rjust(7, ' '), str(result-oldResult).rjust(5, ' ') if oldResult != result else '     ', str(result).rjust(7, ' '))
        position = newPosition

    print('Result 2 ', result)


if __name__ == "__main__":
    part1()
    part2()
