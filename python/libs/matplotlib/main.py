import matplotlib.pyplot as plt
import numpy as np


def some():
    fig, ax = plt.subplots()             # Create a figure containing a single Axes.
    print(ax)
    ax.plot([1, 2, 3, 4], [1, 4, -2, 3])
    ax.set_title("Titlex")
    ax.grid(True)
    ax.annotate("maximum", xy=(2, 4), xytext=(3, 3), \
                arrowprops=dict(facecolor='green', shrink=0.05))

    ax.set_ylim(-2, 7)
    plt.show()


def fill(): #Q0U5
    x = range(1, 6)
    y = [1, 4, 6, 8, 4]

    plt.fill_between(x, y)
    plt.show()


if __name__ == "__main__":
    # some()
    fill()