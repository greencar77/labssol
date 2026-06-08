#Q603
if __name__ == '__main__':
    d = { "z": 5, "a": 20, "m": 17}
    print(d)

    d2 = sorted(d.items())
    print(d2)
    for x in d2:
        print(x[0], x[1])

    m = {}
    m["z"] = 5
    m["a"] = 20
    m["m"] = 17
    print(m)
    m2 = sorted(m.items())
    print(m2)
    for x in m2:
        print(x[0], x[1])

    sorted({})


    l = ["a", "b", "2025", "c", "a", "c", "c"]
    ld = {}
    for x in l:
        if x not in ld:
            ld[x] = 0
        ld[x] += 1
    print(ld)
    print(type(ld))
    ld2 = sorted(ld.items())
    print(type(ld2))
    print(ld2)




