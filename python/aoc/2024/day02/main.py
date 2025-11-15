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
    #give another chance
    for i in range(0, len(row)):
        shortened = row[0:i] + row[i+1:]
        if isValidStandard(shortened):
            return 1

    return 0


def readInput():
    result = []
    with open('input.txt', 'r') as f:
        lines = [x.strip() for x in f.readlines()]
    for line in lines:
        result.append([int(x) for x in line.split(' ')])
    return result

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
print(result) #299

#with dampener
result = 0
for row in data:
    result += isValidDampener(row)
print(result) #364
