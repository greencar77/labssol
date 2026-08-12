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

def byYearMonthCounts():
    df = pd.read_csv('data/a.csv', sep=";")
    print(df.info())

    df['date'] = pd.to_datetime(df['date'], format='%Y.%m.%d')
    df.set_index('date', inplace=True)
    df.sort_index(inplace=True)

    print(df.info())

    # Count entries by year-month
    df_monthly = df.resample('ME').size()

    print("\nMonthly counts:")
    print(df_monthly)

    ax = df_monthly.plot(
        kind="bar",
        figsize=(10, 4),
        title="Monthly Counts",
        width=0.6
    )
    ax.set_xticklabels([x.strftime('%Y-%m') for x in df_monthly.index])
    plt.show()

def byYearMonthCountsGroupby():
    df = pd.read_csv('data/a.csv', sep=";")
    df['date'] = pd.to_datetime(df['date'], format='%Y.%m.%d')
    df.set_index('date', inplace=True)
    df.sort_index(inplace=True)

    # Count entries by year-month using groupby
    # .to_period('M') converts the DatetimeIndex to PeriodIndex (e.g., '2026-03')
    df_monthly = df.groupby(df.index.to_period('M')).size()

    print("\nMonthly counts (via groupby):")
    print(df_monthly)

    ax = df_monthly.plot(
        kind="bar",
        figsize=(10, 4),
        title="Monthly Counts (Groupby)",
        width=0.6
    )
    # The index is already in 'YYYY-MM' format because of to_period('M')
    ax.set_xticklabels([str(x) for x in df_monthly.index])
    plt.show()

def byWeekCountsGroupby():
    df = pd.read_csv('data/a.csv', sep=";")
    df['date'] = pd.to_datetime(df['date'], format='%Y.%m.%d')
    df.set_index('date', inplace=True)
    df.sort_index(inplace=True)

    # Count entries by week using groupby
    # .to_period('W') converts the DatetimeIndex to PeriodIndex representing weeks
    df_weekly = df.groupby(df.index.to_period('W')).size()

    print("\nWeekly counts (via groupby):")
    print(df_weekly)

    ax = df_weekly.plot(
        kind="bar",
        figsize=(10, 4),
        title="Weekly Counts (Groupby)",
        width=0.6
    )
    # PeriodIndex for weeks shows the week range, e.g., '2026-03-30/2026-04-05'
    ax.set_xticklabels([str(x) for x in df_weekly.index])
    plt.show()


if __name__ == '__main__':
    # byDate()
    # byYearMonth()
    # byYearMonthCounts()
    # byYearMonthCountsGroupby()
    byWeekCountsGroupby()
