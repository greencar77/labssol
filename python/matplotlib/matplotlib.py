import matplotlib.pyplot as plt
import numpy as np

fig, ax = plt.subplots()             # Create a figure containing a single Axes.
print(ax)
ax.plot([1, 2, 3, 4], [1, 4, -2, 3])  # Plot some data on the Axes.
ax.set_title("Titlex")
ax.grid(True)
ax.annotate("maximum", xy=(2, 4), xytext=(3, 3),\
 arrowprops=dict(facecolor='green', shrink=0.05))

ax.set_ylim(-2, 7)
plt.show()                           # Show the figure.