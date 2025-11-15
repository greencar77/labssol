totalCount = 0

def getWords():
    #https://github.com/AllenDowney/ThinkPython2/blob/master/code/words.txt
    with open('words.txt', 'r') as f:
        return [l.strip() for l in f.readlines()]


def getLetterBucket(word):
    letters = list(word)
    letters.sort()
    return ''.join(letters)


def isMetathesis(w1, w2):
    diffCount = 0
    for i in range(len(w1)):
        if w1[i] != w2[i]:
            diffCount += 1
    return diffCount == 2


def analyze(clusterWords):
    for i in range(len(clusterWords)):
        w1 = clusterWords[i]
        rest = clusterWords[i+1:]
        for w2 in rest:
            if isMetathesis(w1, w2):
                print(w1, w2)
                global totalCount
                totalCount += 1


if __name__ == '__main__':
    words = getWords()
    print(len(words))
    clusters = {}
    for w in words:
        letterBucket = getLetterBucket(w)
        if not letterBucket in clusters.keys():
            clusters[letterBucket] = [w]
        else:
            clusters[letterBucket].append(w)

    for clusterWords in clusters.values():
        if len(clusterWords) > 1:
            analyze(clusterWords)

    print('Found', totalCount, 'pairs')