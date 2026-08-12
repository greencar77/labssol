import pandas as pd
import matplotlib.pyplot as plt

def byYearMonthCountsPadded():
    df = pd.read_csv('data/a.csv', sep=";")
    df['date'] = pd.to_datetime(df['date'], format='%Y.%m.%d')
    df.set_index('date', inplace=True)
    df.sort_index(inplace=True)

    # Count entries by year-month
    df_monthly = df.groupby(df.index.to_period('M')).size()

    # Create a full range of months from the start of data to end of 2027
    start_month = df_monthly.index.min()
    end_month = pd.Period('2027-12', freq='M')
    full_range = pd.period_range(start=start_month, end=end_month, freq='M')

    # Reindex the series to include all months in the range, padding with 0
    df_padded = df_monthly.reindex(full_range, fill_value=0)

    print("\nMonthly counts (padded to end of 2027):")
    print(df_padded)

    ax = df_padded.plot(
        kind="bar",
        figsize=(12, 5),
        title="Monthly Counts (Padded to end of 2027)",
        width=0.6
    )
    ax.set_xticklabels([str(x) for x in df_padded.index])
    plt.show()

if __name__ == '__main__':
    byYearMonthCountsPadded()