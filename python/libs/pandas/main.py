import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

if __name__ == '__main__':
    df = pd.read_csv('data/a.csv', sep=";")

    print("\ninfo:")
    print(df.info())

    print("\ninfo verbose:")
    df.info(verbose=True)

    print("\ndescribe:")
    print(df.describe())
    print(df.shape)
    print(f"Mean: {df['c'].mean():.2f}")

    sns.histplot(df['c'].dropna(), bins=30, kde=True)
    plt.title('c distributon')
    plt.show()