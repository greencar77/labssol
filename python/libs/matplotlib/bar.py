import matplotlib.pyplot as plt

def bar(): #QB0C
    categories = ['A', 'B', 'C', 'D']
    value1 = [10, 15, 8, 12]
    value2 = [5, 7, 4, 9]

    _, ax = plt.subplots(figsize=(4, 2))

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
