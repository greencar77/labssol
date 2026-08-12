import pandas as pd
import matplotlib.pyplot as plt

def byDate():
    df = pd.read_csv('data/a.csv', sep=";")
    df['date'] = pd.to_datetime(df['date'], format='%Y.%m.%d')
    df.set_index('date', inplace=True)
    df.sort_index(inplace=True)

    print("\ninfo:")
    print(df.info())

    print("\ninfo verbose:")
    df.info(verbose=True)

    # print("\ndescribe:")
    # print(df.describe())
    # print(df.shape)

    ax = df.plot(
        kind="bar",
        figsize=(12, 5),
        title="Good chart",
        width=0.6
    )
    ax.set_xticklabels([x.strftime('%Y-%m-%d') for x in df.index])
    plt.show()


def byYearMonth():
    df = pd.read_csv('data/a.csv', sep=";")
    print(df.info())

    df['date'] = pd.to_datetime(df['date'], format='%Y.%m.%d')
    df.set_index('date', inplace=True)
    df.sort_index(inplace=True)

    print(df.info())

    # Sum data by year-month
    df_monthly = df.resample('ME').sum(numeric_only=True)

    print("\nMonthly sum:")
    print(df_monthly)

    ax = df_monthly.plot(
        kind="bar",
        figsize=(10, 4),
        title="Monthly Sum",
        width=0.6
    )
    ax.set_xticklabels([x.strftime('%Y-%m') for x in df_monthly.index])
    plt.show()


if __name__ == '__main__':
    # byDate()
    byYearMonth()