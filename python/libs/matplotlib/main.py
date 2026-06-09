import matplotlib.pyplot as plt


def line(): #QCO5
    fig, ax = plt.subplots()
    print(ax)
    ax.plot([1, 2, 3, 4], [1, 4, -2, 3])
    ax.set_title("Titlex") #QQX0
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

def bar(): #QB0C
    categories = ['A', 'B', 'C', 'D']
    value1 = [10, 15, 8, 12]
    value2 = [5, 7, 4, 9]

    fig, ax = plt.subplots(figsize=(4, 2))

    # First segment
    ax.barh(categories, value1, label='Value 1', color='steelblue')

    # Second segment stacked on the first
    ax.barh(categories, value2, left=value1, label='Value 2', color='orange')

    ax.set_xlabel('Total')
    ax.set_title('Horizontal Stacked Bar Chart') #QQX0
    ax.legend()

    plt.tight_layout()
    plt.savefig('stacked_bar.png', dpi=300, bbox_inches='tight') #QAZE
    plt.show()

if __name__ == "__main__":
    line()
    # fill()
    # bar()