import numpy as np

#x
a = np.arange(15).reshape(3, 5)
print(a)

#x
a = np.arange(30).reshape(3, 2, 5)
print(a)

#
a = np.ones((3, 4, 5))
print(a)

#
a[2, 1, 3] = 7.9
print(a)
print(a[2,2,3])

#
rg = np.random.default_rng(1)
a = rg.random((2,3))
print(a)

#
a = np.random.randint(0, 10, 6).reshape(2, 3)
print(a)