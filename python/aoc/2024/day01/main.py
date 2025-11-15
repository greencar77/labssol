
def calculateSimilarityScore(arr1, arr2):
    multi = {}
    for x in arr2:
        if x not in multi:
            multi[x] = 1
        else:
            multi[x] = multi[x] + 1

    result = 0
    for x in arr1:
        if x in multi:
            result += x * multi[x]

    print('Similarity score=', result)



if __name__ == '__main__':
    with open('input.txt', 'r') as f:
        lines = [x.strip() for x in f.readlines()]

    pairs = [x.split('   ') for x in lines]

    arr1 = sorted([int(x[0]) for x in pairs])
    arr2 = sorted([int(x[1]) for x in pairs])

    result = 0
    for x, y in zip(arr1, arr2):
        result += abs(x-y)

    print(result)

    calculateSimilarityScore(arr1, arr2)