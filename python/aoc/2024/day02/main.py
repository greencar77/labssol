def my_sign(x):
    return (x > 0) - (x < 0)


def isValidStandard(row):
    tendency = my_sign(row[1]-row[0])
    if tendency == 0:
        return 0
    last = row[0]
    for cur in row[1:]:
        if my_sign(cur-last) != tendency:
            return 0
        if abs(cur - last) > 3:
            return 0
        last = cur
    return 1


def isValidDampener(row):
    if isValidStandard(row):
        return 1
    return any([isValidStandard(row[0:excludeIndex] + row[excludeIndex+1:]) for excludeIndex in range(0, len(row))])


def readInput():
    result = []
    with open('input.txt', 'r') as f:
        lines = f.read().splitlines()
    for line in lines:
        result.append([int(x) for x in line.split(' ')])
    return result


if __name__ == '__main__':
    # data = [
    # [6, 7, 9],
    # [4, 9, 3],
    # [5, 4, 3]
    # ]
    data = readInput()

    print(data)

    #without dampener
    result = 0
    for row in data:
        result += isValidStandard(row)
    print(result)

    #with dampener
    result = 0
    for row in data:
        result += isValidDampener(row)
    print(result)
